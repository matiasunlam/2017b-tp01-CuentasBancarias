package cuenta;

public class CuentaBancaria {
	
	private int saldo;
	
	public int mostrarSaldo() {
		return this.saldo;
	}

	public void depositarDinero(int saldoDepositado) {
		
		if (saldoDepositado < 0)
			return;
		
		this.saldo += saldoDepositado;
	}

}
