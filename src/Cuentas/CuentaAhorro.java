package Cuentas;

public class CuentaAhorro extends Cuenta {

	private Double recargo = 6.0;

	public CuentaAhorro() {
		super();
		this.recargo = getRecargo();
	}

	@Override
	public Boolean depositar(Double monto) {
		if (monto > 0) {
			super.setSaldo(monto);
			return true;
		}
		return false;

	}

	@Override
	public Boolean extraer(Double monto) {

		if (monto <= this.getSaldo() && this.getNumExtraccion() < 5) {
			this.setSaldo(-monto);
			this.setNumExtraccion();
			return true;
		} else if ((monto + getRecargo()) <= this.getSaldo()) {
			Double montoConRecargo = getRecargo() + monto;
			this.setSaldo(-montoConRecargo);
			this.setNumExtraccion();
			return true;
		}
		return false;

	};

	public Double getRecargo() {
		return recargo;
	}

	public void setRecargo(Double recargo) {
		this.recargo = recargo;
	}

}
