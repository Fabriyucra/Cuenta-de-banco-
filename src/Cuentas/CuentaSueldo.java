package Cuentas;

public class CuentaSueldo extends Cuenta {

	
	public CuentaSueldo() {
		super();
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
		
		if (monto <=this.getSaldo()) {
			this.setSaldo(-monto);
			return true;
		}
		return false;	
		
	}

}
