package Cuentas;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCuentas {

	@Test
	public void queSePuedaCrearUnaCuentaAhorro() {
		
		Cuenta cuenta = new CuentaAhorro();		
		assertNotNull(cuenta);
	}

	@Test
	public void queSePuedaConsultarElSaldoDeUnaCuentaAhorro() {

		Cuenta cuenta = new CuentaAhorro();	
		Double saldo = 0.0;		
		assertEquals(saldo, cuenta.getSaldo());
	}

	@Test
	public void queSePuedaCrearUnaCuentaSueldo() {
		
		Cuenta cuenta = new CuentaSueldo();			
		assertNotNull(cuenta);
	}


	@Test
	public void queSePuedaCrearUnaCuentaCorriente() {

		Cuenta cuenta = new CuentaCorriente();	
		assertNotNull(cuenta);
	}

	@Test
	public void queSePuedaDepositarDineroEnUnaCuentaSueldo() {

		Cuenta cuenta = new CuentaSueldo();			
		cuenta.depositar(100.0);
		Double saldo = 100.0;
		assertEquals(saldo, cuenta.getSaldo());

	}

	@Test
	public void queSePuedaExtraerDeUnaCuentaSueldoUnImporteMenorAlSaldo() {

		Cuenta cuenta = new CuentaSueldo();			
		cuenta.depositar(100.0);
		cuenta.extraer(50.0);
		
		Double extrarSaldo = 50.0;
		assertEquals(extrarSaldo, cuenta.getSaldo());
		
	}

	@Test
	public void queSePuedaExtraerDeUnaCuentaSueldoUnImporteIgualAlSaldo() {

		Cuenta cuenta = new CuentaSueldo();			
		cuenta.depositar(100.0);
		cuenta.extraer(100.0);
		
		Double extrarSaldo = 0.0;
		assertEquals(extrarSaldo, cuenta.getSaldo());

	}

	@Test
	public void queNoSePuedaExtraerDeUnaCuentaSueldoUnImporteMayorAlSaldo() {

		Cuenta cuenta = new CuentaSueldo();			
		cuenta.depositar(100.0);
				
		assertFalse(cuenta.extraer(150.0));
	}

	@Test
	public void queNoSeCobreAdicionalLuegoDeLaQuintaExtraccionDeUnaCuentaSueldo() {
		
		Cuenta cuenta = new CuentaSueldo();			
		cuenta.depositar(700.0);
		cuenta.extraer(100.0); //1
		cuenta.extraer(100.0); //2
		cuenta.extraer(100.0); //3
		cuenta.extraer(100.0); //4
		cuenta.extraer(100.0); //5
		
		cuenta.extraer(100.0); //6
		
		Double saldo = 100.0;
		assertEquals(saldo, cuenta.getSaldo());

	}

	@Test
	public void queSePuedaDepositarDineroEnUnaCuentaDeAhorro() {

		Cuenta cuenta = new CuentaAhorro();			
		cuenta.depositar(100.0);
		Double saldo= 100.0;
		
		assertEquals(saldo, cuenta.getSaldo());
	}

	@Test
	public void queSePuedaExtraerDeUnaCuentaDeAhorroUnImporteMenorAlSaldo() {

		Cuenta cuenta = new CuentaAhorro();			
		cuenta.depositar(100.0);
		cuenta.extraer(50.0);
		Double saldo = 50.0;
		
		assertEquals(saldo, cuenta.getSaldo());
	}

	@Test
	public void queSePuedaExtraerDeUnaCuentaDeAhorroUnImporteIgualAlSaldo() {

		Cuenta cuenta = new CuentaAhorro();			
		cuenta.depositar(100.0);
		cuenta.extraer(100.0);
		Double saldo = 0.0;
		
		assertEquals(saldo, cuenta.getSaldo());

	}

	@Test
	public void queNoSePuedaExtraerDeUnaCuentaDeAhorroUnImporteMayorAlSaldo() {

		Cuenta cuenta = new CuentaAhorro();			
		cuenta.depositar(100.0);
		
		assertFalse(cuenta.extraer(150.0));

	}

	@Test
	public void queSeCobreSeisPesosAdicionalesLuegoDeLaQuintaExtraccionDeUnaCuentaDeAhorro() {

		Cuenta cuenta = new CuentaAhorro();			
		cuenta.depositar(700.0);
		cuenta.extraer(100.0); //1
		cuenta.extraer(100.0); //2
		cuenta.extraer(100.0); //3
		cuenta.extraer(100.0); //4
		cuenta.extraer(100.0); //5
		
		cuenta.extraer(100.0); //6 Extraccion -> Cuenta: 700 - 606 = $94
		
		System.out.println(cuenta.getNumExtraccion());
		
		Double saldo = 94.0;
		assertEquals(saldo, cuenta.getSaldo());

	}

	@Test
	public void queNoSeCobreNingunAdicionalAntesDeLaQuintaExtraccionDeUnaCuentaDeAhorro() {

		Cuenta cuenta = new CuentaAhorro();			
		cuenta.depositar(700.0);
		cuenta.extraer(100.0); //1
		cuenta.extraer(100.0); //2
		cuenta.extraer(100.0); //3
		cuenta.extraer(100.0); //4 Extraccion -> Cuenta: 700 - 400 = $300
		
		System.out.println(cuenta.getNumExtraccion());
		
		Double saldo = 300.0;
		assertEquals(saldo, cuenta.getSaldo());

	}

	@Test
	public void queNoSeCobreNingunAdicionalEnLaQuintaExtraccionDeUnaCuentaDeAhorro() {

		Cuenta cuenta = new CuentaAhorro();			
		cuenta.depositar(700.0);
		cuenta.extraer(100.0); //1
		cuenta.extraer(100.0); //2
		cuenta.extraer(100.0); //3
		cuenta.extraer(100.0); //4 
		cuenta.extraer(100.0); //5 Extraccion -> Cuenta: 700 - 500 = $200
		
//		System.out.println(cuenta.getNumExtraccion());
		
		Double saldo = 200.0;
		assertEquals(saldo, cuenta.getSaldo());

	}

	@Test
	public void queSePuedaDepositarDineroEnUnaCuentaCorriente() {

		Cuenta cuenta = new CuentaCorriente();			
		cuenta.depositar(100.0);
		Double saldo = 100.0;
		
		assertEquals(saldo, cuenta.getSaldo());
	}

	@Test
	public void queSePuedaExtraerDeUnaCuentaCorrienteUnImporteMenorAlSaldo() {

		Cuenta cuenta = new CuentaCorriente();			
		cuenta.depositar(100.0);
		cuenta.extraer(50.0);
		Double saldo = 50.0;
		
		assertEquals(saldo, cuenta.getSaldo());
	}

	@Test
	public void queSePuedaExtraerDeUnaCuentaCorrienteoUnImporteIgualAlSaldo() {

		Cuenta cuenta = new CuentaCorriente();			
		cuenta.depositar(100.0);
		cuenta.extraer(100.0);
		Double saldo = 0.0;
		
		assertEquals(saldo, cuenta.getSaldo());
	}

	@Test
	public void queSePuedaExtraerDeUnaCuentaCorrienteoUnImporteIgualAlSaldoMasElDescubierto() {

		Cuenta cuenta = new CuentaCorriente();			
		cuenta.depositar(100.0);
		cuenta.extraer(199.0);
		Double saldo = -99.0;
		
		assertEquals(saldo, cuenta.getSaldo());
	}

	@Test
	public void queNoSePuedaExtraerDeUnaCuentaCorrienteUnImporteMayorAlSaldoMasElDescubierto() {

		Cuenta cuenta = new CuentaCorriente();			
		cuenta.depositar(100.0);
	
		assertFalse(cuenta.extraer(301.0));
//		System.out.println(cuenta.getSaldo());
	}

	@Test
	public void queSeCobreCincoPorcientoDeComisionAlDepositarDineroLuegoDeHaberRealizadoUnaExtraccionMayorAlSaldo() {

		Cuenta cuenta = new CuentaCorriente();			
		cuenta.depositar(100.0); 
		cuenta.extraer(200.0); // Saldo: -100 -> Interes sobre el descubierto = 5 pesos
		
		cuenta.depositar(200.0); // Saldo - Interes por Sobregiro = 195
		Double saldo = 95.0;
		
		assertEquals(saldo, cuenta.getSaldo());
	}

}
