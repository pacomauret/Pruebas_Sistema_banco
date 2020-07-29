package pruebas;

import static org.junit.jupiter.api.Assertions.*;
//import java.util.ArrayList;
//import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.junit.Before;

class UsuarioTest {
	private Usuario usuario;
	@Before
	public void setUp() throws Exception{
		usuario = new Usuario();
	}
	@Test
	void testGetSaldo_clp() {
		usuario = new Usuario();
		int saldo_clp = usuario.getSaldo_clp();
		System.out.println(saldo_clp);
		assertEquals(1000000,saldo_clp);
	}

	@Test
	void testGetSaldo_usd() {
		usuario = new Usuario();
		int saldo_usd = usuario.getSaldo_usd();
		assertEquals(1000,saldo_usd);
		System.out.println(saldo_usd);
	}

	@Test
	void testGetSesion_us() {
		usuario = new Usuario();
		int sesion = usuario.getSesion_us();
		assertEquals(1,sesion);
		System.out.println(sesion);
	}


	@Test
	void testGetMov() {
		usuario = new Usuario();
		int mov = usuario.getMov();
		assertEquals(1,mov);
		System.out.println(mov);
	}





}
