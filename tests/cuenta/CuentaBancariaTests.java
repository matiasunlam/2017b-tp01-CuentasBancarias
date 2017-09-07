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
	
}
