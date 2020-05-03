import static org.junit.Assert.*;

import org.junit.Test;

import dominio.Usuario;

public class Usuario_Test {
	
	static Usuario mi_usuario;
	
	@Test
	public void testAssertSame() {
		
		Usuario mi_usuario = new Usuario(5, "cuarentena");
		Usuario mi_usuario2 = mi_usuario;
		
		assertSame(mi_usuario, mi_usuario2);
	
	}
	
	@Test
	public void testAssertSame1() {
		
		Usuario mi_usuario = new Usuario(27, "rayovallecano");
		Usuario mi_usuario2 = new Usuario(35, "atleticodemadrid");
		
		assertNotSame(mi_usuario, mi_usuario2);
	
	}
	@Test
	public void testAssertSame2() {
		String contrasena ="rayovallecano";
		int id=27;
		Usuario mi_usuario2 = new Usuario(35, "atleticodemadrid");
		
		
		assertNotSame(contrasena, mi_usuario2.getPassword());
		assertNotSame(id, mi_usuario2.getId());

	
	}
	@Test
	public void testAssertSame3() {
		String contrasena ="rayovallecano";
		int id=27;
		Usuario mi_usuario = new Usuario(27, "rayovallecano");
		
		
		assertSame(contrasena, mi_usuario.getPassword());
		assertSame(id, mi_usuario.getId());
	
	}
	@Test
	public void testAssertSame4() {
		String contrasena ="rayovallecano";
		int id=27;
		Usuario mi_usuario = new Usuario(27, "rayovallecano");
		
		
		assertSame(contrasena, mi_usuario.getPassword());
		assertSame(id, mi_usuario.getId());
	
	}
	@Test
	public void testAssertSame5() {
		String contrasena ="rayovallecano";
		int id=27;
		Usuario mi_usuario = new Usuario(27, "rayovallecano");
		
		assertSame(contrasena, mi_usuario.getPassword());
		assertSame(id, mi_usuario.getId());
		mi_usuario.setId(5);
		mi_usuario.setPassword("algo");
		assertNotSame(contrasena, mi_usuario.getPassword());
		assertNotSame(id, mi_usuario.getId());
		
		
	
	}
	@Test
	public void testAssertSame6() {
		String contrasena ="rayo";
		int id=34;
		Usuario mi_usuario = new Usuario(27, "rayovallecano");
		
		assertNotSame(contrasena, mi_usuario.getPassword());
		assertNotSame(id, mi_usuario.getId());
		mi_usuario.setId(34);
		mi_usuario.setPassword("rayo");
		assertSame(contrasena, mi_usuario.getPassword());
		assertSame(id, mi_usuario.getId());
		
		
	
	}
	
	
	
	


}
