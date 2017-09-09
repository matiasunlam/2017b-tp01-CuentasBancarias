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
		Assert.assertEquals(0, cuenta1.mostrarSaldo(), 0.0f);
	}

	@Test
	public void primerDeposito() throws Exception {
		double primerDeposito = 100;
		cuenta1.depositarDinero(primerDeposito);
		Assert.assertEquals(primerDeposito, cuenta1.mostrarSaldo(), 0.0f);
	}

	@Test
	public void queAcumulaDepositos() throws Exception {
		double primerDeposito = 100;
		cuenta1.depositarDinero(primerDeposito);
		double nuevoDeposito = 500;
		cuenta1.depositarDinero(nuevoDeposito);
		Assert.assertEquals(primerDeposito + nuevoDeposito, cuenta1.mostrarSaldo(), 0.0f);
	}

	@Test
	public void siRecibeDepositoNegativo() throws Exception {
		// El método depositarDinero no debería aceptar montos negativos.
		double primerDeposito = 500;
		double depositoNegativo = -100;
		cuenta1.depositarDinero(primerDeposito);
		try {
			cuenta1.depositarDinero(depositoNegativo);
		} catch (Exception exceptionEsperada) {
		}
		Assert.assertEquals(primerDeposito, cuenta1.mostrarSaldo(), 0.0f);
	}

	@Test
	public void primeraExtraccion() throws Exception {
		double primerDeposito = 500;
		cuenta1.depositarDinero(primerDeposito);
		double primeraExtraccion = 400;
		cuenta1.extraerDinero(primeraExtraccion);
		Assert.assertEquals(primerDeposito - primeraExtraccion, cuenta1.mostrarSaldo(), 0.0f);
	}

	@Test
	public void siExtraccionSuperaSaldo() throws Exception {
		// El método extraerDinero no debería permitir que se extraiga más dinero que el disponible.
		double primerDeposito = 500;
		cuenta1.depositarDinero(primerDeposito);
		double primeraExtraccion = 600;
		try {
			cuenta1.extraerDinero(primeraExtraccion);
		} catch (Exception exceptionEsperada) {
		}
		Assert.assertEquals(primerDeposito, cuenta1.mostrarSaldo(), 0.0f);
	}

	@Test
	public void transferirEntreCuentas() throws Exception {
		double depositoParaCuenta1 = 500;
		double transferenciaParaCuenta2 = 200;
		cuenta1.depositarDinero(depositoParaCuenta1);
		cuenta1.transferirMontoHacia(transferenciaParaCuenta2, cuenta2);
		Assert.assertEquals(depositoParaCuenta1 - transferenciaParaCuenta2, cuenta1.mostrarSaldo(), 0.0f);
		Assert.assertEquals(transferenciaParaCuenta2, cuenta2.mostrarSaldo(), 0.0f);
	}

	@Test
	public void transferirConCentavos() throws Exception {
		double depositoParaCuenta1 = 500.40;
		double transferenciaParaCuenta2 = 0.40;
		cuenta1.depositarDinero(depositoParaCuenta1);
		cuenta1.transferirMontoHacia(transferenciaParaCuenta2, cuenta2);
		Assert.assertEquals(depositoParaCuenta1 - transferenciaParaCuenta2, cuenta1.mostrarSaldo(), 0.0f);
		Assert.assertEquals(transferenciaParaCuenta2, cuenta2.mostrarSaldo(), 0.0f);
		Assert.assertNotEquals(0, cuenta2.mostrarSaldo(), 0.0f);
	}
	
	@Test
	public void siTransferenciaSuperaDepositos() throws Exception {
		double depositoParaCuenta1 = 500;
		double transferenciaParaCuenta2 = 2000;
		cuenta1.depositarDinero(depositoParaCuenta1);
		try {
			cuenta1.transferirMontoHacia(transferenciaParaCuenta2, cuenta2);
		} catch (Exception exceptionEsperada) {}
		Assert.assertEquals(depositoParaCuenta1, cuenta1.mostrarSaldo(), 0.0f);
		Assert.assertEquals(0, cuenta2.mostrarSaldo(), 0.0f);
	}
}
