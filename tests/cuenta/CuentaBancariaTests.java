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
	public void queDepositaCorrectamente() {
		int primerDeposito = 100;
		cuenta1.depositarDinero(primerDeposito);
		Assert.assertEquals(primerDeposito, cuenta1.mostrarSaldo());
	}
	
}
