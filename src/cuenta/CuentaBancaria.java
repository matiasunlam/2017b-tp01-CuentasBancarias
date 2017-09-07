package cuenta;

public class CuentaBancaria {

	private int saldo;

	public int mostrarSaldo() {
		return this.saldo;
	}

	public void depositarDinero(int montoParaDepositar) throws Exception {

		if (montoParaDepositar < 0)
			throw new Exception("No se pueden depositar montos negativos.");

		this.saldo += montoParaDepositar;
	}

	public void extraerDinero(int montoParaExtraer) throws Exception {

		if (montoParaExtraer > this.saldo)
			throw new Exception("No se pueden extraer montos mayores al saldo.");

		this.saldo -= montoParaExtraer;
	}

	public void transferirHacia(int transferenciaParaCuenta2, CuentaBancaria cuenta2) throws Exception {
		
		cuenta2.depositarDinero(transferenciaParaCuenta2);
	}

}
