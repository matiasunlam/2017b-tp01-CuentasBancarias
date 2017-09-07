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

	public void extraerDinero(int montoParaExtraer) {
		
		if (montoParaExtraer > this.saldo)
			return;
		
		this.saldo -= montoParaExtraer;
	}

}
