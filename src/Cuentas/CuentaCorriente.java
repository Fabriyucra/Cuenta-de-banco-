package Cuentas;

public class CuentaCorriente extends Cuenta {
	
	private Double montoDescubierto=200.0;
	private Double montoAdeudado = 0.0;

	public CuentaCorriente() {
		super();
	}

	@Override
	public Boolean depositar(Double monto) {
		if (monto > 0 && this.getMontoAdeudado()==0) {
			super.setSaldo(monto);
			return true;
		} else if (monto > 0) {
			super.setSaldo(monto - this.getMontoAdeudado());
			return true;
		}
		return false;
	}

	@Override
	public Boolean extraer(Double monto) {
		
		if (monto <=this.getSaldo()) {
			this.setSaldo(-monto);
			return true;
		}else if (monto <=(this.getSaldo() + montoDescubierto)) {
			this.setSaldo(-monto);
			this.montoAdeudado += this.getSaldo()*-0.05;
			return true;
		}		
		return false;	
		
	}

	public Double getMontoDescubierto() {
		return montoDescubierto;
	}

	public void setMontoDescubierto(Double montoDescubierto) {
		this.montoDescubierto = montoDescubierto;
	}

	public Double getMontoAdeudado() {
		return montoAdeudado;
	}

	public void setMontoAdeudado(Double montoAdeudado) {
		this.montoAdeudado = montoAdeudado;
	}
	
}
