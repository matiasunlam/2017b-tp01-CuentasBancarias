package cuenta;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CuentaBancariaTests {

	CuentaBancaria cuenta1;
	CuentaBancaria cuenta2;

	@Before
	public void setUp() {
		cuenta1 = new CuentaBancaria();
		cuenta2 = new CuentaBancaria();
	}

	@Test
	public void queSaldoIniciaEnCero() {
		Assert.assertEquals(0, cuenta1.mostrarSaldo());
	}

	@Test
	public void primerDeposito() throws Exception {
		int primerDeposito = 100;
		cuenta1.depositarDinero(primerDeposito);
		Assert.assertEquals(primerDeposito, cuenta1.mostrarSaldo());
	}

	@Test
	public void queAcumulaDepositos() throws Exception {
		int primerDeposito = 100;
		cuenta1.depositarDinero(primerDeposito);
		int nuevoDeposito = 500;
		cuenta1.depositarDinero(nuevoDeposito);
		Assert.assertEquals(primerDeposito + nuevoDeposito, cuenta1.mostrarSaldo());
	}

	@Test
	public void siRecibeDepositoNegativo() throws Exception {
		// El método depositarDinero no debería aceptar montos negativos.
		int primerDeposito = 500;
		int depositoNegativo = -100;
		cuenta1.depositarDinero(primerDeposito);
		try {
			cuenta1.depositarDinero(depositoNegativo);
		} catch (Exception exceptionEsperada) {
		}
		Assert.assertEquals(primerDeposito, cuenta1.mostrarSaldo());
	}

	@Test
	public void primeraExtraccion() throws Exception {
		int primerDeposito = 500;
		cuenta1.depositarDinero(primerDeposito);
		int primeraExtraccion = 400;
		cuenta1.extraerDinero(primeraExtraccion);
		Assert.assertEquals(primerDeposito - primeraExtraccion, cuenta1.mostrarSaldo());
	}

	@Test
	public void siExtraccionSuperaSaldo() throws Exception {
		// El método extraerDinero no debería permitir que se extraiga más dinero que el disponible.
		int primerDeposito = 500;
		cuenta1.depositarDinero(primerDeposito);
		int primeraExtraccion = 600;
		try {
			cuenta1.extraerDinero(primeraExtraccion);
		} catch (Exception exceptionEsperada) {
		}
		Assert.assertEquals(primerDeposito, cuenta1.mostrarSaldo());
	}

	@Test
	public void transferirEntreCuentas() throws Exception {
		int depositoParaCuenta1 = 500;
		int transferenciaParaCuenta2 = 200;
		cuenta1.depositarDinero(depositoParaCuenta1);
		cuenta1.transferirHacia(transferenciaParaCuenta2,cuenta2);
		Assert.assertEquals(depositoParaCuenta1-transferenciaParaCuenta2, cuenta1.mostrarSaldo());
		Assert.assertEquals(transferenciaParaCuenta2, cuenta2.mostrarSaldo());
	}
}
