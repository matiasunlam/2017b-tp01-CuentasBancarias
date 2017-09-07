package cuenta;

public class CuentaBancaria {

	private int saldo;

	public int mostrarSaldo() {
		return this.saldo;
	}

	public void depositarDinero(int saldoDepositado) throws Exception {

		if (saldoDepositado < 0)
			throw new Exception("No se pueden depositar montos negativos.");

		this.saldo += saldoDepositado;
	}

}
