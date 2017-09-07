package cuenta;

public class CuentaBancaria {
	
	private int saldo;
	
	public int mostrarSaldo() {
		return this.saldo;
	}

	public void depositarDinero(int primerDeposito) {
		this.saldo = primerDeposito;
	}

}
