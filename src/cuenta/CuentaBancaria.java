package cuenta;

public class CuentaBancaria {
	
	private int saldo;
	
	public int mostrarSaldo() {
		return this.saldo;
	}

	public void depositarDinero(int n) {
		this.saldo = this.saldo + n;
	}

}