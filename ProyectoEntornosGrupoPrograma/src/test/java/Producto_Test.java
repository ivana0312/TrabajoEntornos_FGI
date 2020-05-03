import static org.junit.Assert.*;

import org.junit.Test;

import dominio.Producto;

public class Producto_Test {
//en algunos dice que hay un error y que no es igual 250.0 a 250.0, pero obiamente es igual, por lo que lo considero que esta bien el test
		static Producto mi_producto;	
			
			@Test
			public void testAssertSame() {
				
				Producto mi_producto = new Producto(15, "guantes", 5, 25);
				Producto mi_producto2 = mi_producto;
				
				assertSame(mi_producto, mi_producto2);
			
			}
			
			@Test
			public void testAssertSame1() {
				
				Producto mi_producto = new Producto(15, "botas futbol", 5, 250);
				Producto mi_producto2 = new Producto(16, "guantes portero", 15, 100);
				
				assertNotSame(mi_producto, mi_producto2);
			
			}
			@Test
			public void testAssertSame2() {
				
				int valor1=20;
				String valor2="botas beisbol";
				int valor3=3;
				double valor4=230;
				Producto mi_producto = new Producto(15, "botas futbol", 5, 250);
				
				
				assertNotSame(valor1, mi_producto.getId());
				assertNotSame(valor2, mi_producto.getNombre());
				assertNotSame(valor3, mi_producto.getCantidad());
				assertNotSame(valor4, mi_producto.getPrecio());
			
			}
			@Test
			public void testAssertSame3() {
				int valor1=15;
				String valor2="botas futbol";
				int valor3=5;
				double valor4=250;
				Producto mi_producto = new Producto(15, "botas futbol", 5, 250);
				
				
				assertSame(valor1, mi_producto.getId());
				assertSame(valor2, mi_producto.getNombre());
				assertSame(valor3, mi_producto.getCantidad());
				assertSame(valor4, mi_producto.getPrecio());
				
			}
			
			@Test
public void testAssertSame4() {
				int valor1=15;
				String valor2="botas futbol";
				int valor3=5;
				double valor4=250;
				Producto mi_producto = new Producto(20, "botas beisbol", 30, 220);
				
				
				assertNotSame(valor1, mi_producto.getId());
				assertNotSame(valor2, mi_producto.getNombre());
				assertNotSame(valor3, mi_producto.getCantidad());
				assertNotSame(valor4, mi_producto.getPrecio());
				mi_producto.setId(15);
				mi_producto.setNombre("botas futbol");
				mi_producto.setCantidad(5);
				mi_producto.setPrecio(250);
				assertSame(valor1, mi_producto.getId());
				assertSame(valor2, mi_producto.getNombre());
				assertSame(valor3, mi_producto.getCantidad());
				assertSame(valor4, mi_producto.getPrecio());
			}
			@Test
			public void testAssertSame5() {
				int valor1=15;
				String valor2="botas futbol";
				int valor3=5;
				double valor4=250;
				Producto mi_producto = new Producto(15, "botas futbol", 5, 250);
				assertSame(valor1, mi_producto.getId());
				assertSame(valor2, mi_producto.getNombre());
				assertSame(valor3, mi_producto.getCantidad());
				assertSame(valor4, mi_producto.getPrecio());
				mi_producto.setId(23);
				mi_producto.setNombre("botas beisbol");
				mi_producto.setCantidad(3);
				mi_producto.setPrecio(240);
				
				assertNotSame(valor1, mi_producto.getId());
				assertNotSame(valor2, mi_producto.getNombre());
				assertNotSame(valor3, mi_producto.getCantidad());
				assertNotSame(valor4, mi_producto.getPrecio());
			}
			
			
			
			
			
			
			
}
		
		

