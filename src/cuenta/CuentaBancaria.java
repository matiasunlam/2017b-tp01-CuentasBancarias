package cuenta;

public class CuentaBancaria {

	private double saldo;

	public double mostrarSaldo() {
		return this.saldo;
	}

	public void depositarDinero(double montoParaDepositar) throws Exception {

		if (montoParaDepositar < 0)
			throw new Exception("No se pueden depositar montos negativos.");

		this.saldo += montoParaDepositar;
	}

	public void extraerDinero(double montoParaExtraer) throws Exception {

		if (montoParaExtraer > this.saldo)
			throw new Exception("No se pueden extraer montos mayores al saldo.");

		this.saldo -= montoParaExtraer;
	}

	public void transferirMontoHacia(double montoParaTransferir, CuentaBancaria cuentaDestino) throws Exception {
		this.extraerDinero(montoParaTransferir);
		cuentaDestino.depositarDinero(montoParaTransferir);
	}

}
