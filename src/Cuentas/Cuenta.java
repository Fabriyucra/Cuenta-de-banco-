package Cuentas;

public abstract class Cuenta {
	
	private Double saldo;
	private Integer numExtraccion;
	
	public Cuenta() {
		this.saldo = 0.0;
		this.numExtraccion= 0;
	}

	public abstract Boolean depositar(Double monto);
	
	public abstract Boolean extraer(Double monto);

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo+= saldo;
	}

	public Integer getNumExtraccion() {
		return numExtraccion;
	}

	public void setNumExtraccion() {
		this.numExtraccion += 1;
	}
	
}
