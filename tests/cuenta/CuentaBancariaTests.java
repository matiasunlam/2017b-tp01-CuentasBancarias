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
	}
	
	@Test
	public void queSaldoIniciaEnCero() {
		Assert.assertEquals(0, cuenta1.mostrarSaldo());
	}
	
	@Test
	public void primerDeposito() {
		int primerDeposito = 100;
		cuenta1.depositarDinero(primerDeposito);
		Assert.assertEquals(primerDeposito, cuenta1.mostrarSaldo());
	}
	
	@Test
	public void queAcumulaDepositos() {
		int primerDeposito = 100;
		cuenta1.depositarDinero(primerDeposito);
		int nuevoDeposito = 500;
		cuenta1.depositarDinero(nuevoDeposito);
		Assert.assertEquals(primerDeposito+nuevoDeposito, cuenta1.mostrarSaldo());
	}
	
	@Test
	public void siRecibeDepositoNegativo() {
		// El método depositarDinero no debería aceptar valores negativos.
		int primerDeposito = 500;
		int depositoNegativo = -100;
		cuenta1.depositarDinero(primerDeposito);
		cuenta1.depositarDinero(depositoNegativo);
		Assert.assertEquals(primerDeposito, cuenta1.mostrarSaldo());
	}
	
}
