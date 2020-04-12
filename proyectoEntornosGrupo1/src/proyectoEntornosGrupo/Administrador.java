package proyectoEntornosGrupo;
import java.util.*;
import javax.swing.JOptionPane;

public class Administrador  extends Usuario{
	public Administrador(int id, String password) {
		super(id, password);
		
	}
	
	public void anadirProducto(ArrayList<Producto> ListaProducto) {
		boolean repetido=true;
		int id;
		do {
			id=Integer.parseInt(JOptionPane.showInputDialog("Introduce el ID del nuevo producto"));
			for (int i=0; i<ListaProducto.size();i++) {
				if (ListaProducto.get(i).getId()==id) {
					repetido=true;
					System.out.println("ID repetido, introduzca otro diferente");
					break;
				}
				else {repetido=false;}
			}
		}while(repetido==true);
		String nombre=JOptionPane.showInputDialog("Introduce el nombre del nuevo producto");
		if (nombre.isEmpty()) {
			nombre=JOptionPane.showInputDialog("Introduce el nombre del nuevo producto");
		}
		int cantidad=Integer.parseInt(JOptionPane.showInputDialog("Introduce la cantidad del nuevo producto"));
		double precio=Double.parseDouble(JOptionPane.showInputDialog("Introduce el precio del nuevo producto"));
		ListaProducto.add(new Producto(id,nombre,cantidad,precio));
	}
	public void eliminarProducto(ArrayList<Producto> ListaProducto) {
		int id=Integer.parseInt(JOptionPane.showInputDialog("Introduce el ID del producto a eliminar"));
		for (int j=0; j<ListaProducto.size(); j++) {
			if (ListaProducto.get(j).getId()==id) {
				ListaProducto.remove(j);
			}
		}
	}
	public void modificarProducto(ArrayList<Producto> ListaProducto) {
		int id=Integer.parseInt(JOptionPane.showInputDialog("Introduce el ID del producto a midificar"));
		for (int j=0; j<ListaProducto.size(); j++) {
			if (ListaProducto.get(j).getId()==id) {
				int opcion=1;
				do {
					System.out.println();
					System.out.println("_______________________");
					System.out.println("¿Qué quieres modificar?");
					System.out.println();
					System.out.println("1. ID");
					System.out.println("2. Nombre");
					System.out.println("3. Cantidad");
					System.out.println("4. Precio");
					System.out.println("5. Retroceder");
					System.out.println("_______________________");
					System.out.println();
					opcion=Integer.parseInt(JOptionPane.showInputDialog("Introduce opción del menú (número)"));
					switch(opcion) {
						case 1:
							int id1=Integer.parseInt(JOptionPane.showInputDialog("Introduce el nuevo ID"));
							ListaProducto.get(j).setId(id1);
							break;
						case 2:
							String nombre=JOptionPane.showInputDialog("Introduce el nuevo nombre");
							if (nombre.isEmpty()) {
								nombre=JOptionPane.showInputDialog("Introduce el nuevo nombre");
							}
							ListaProducto.get(j).setNombre(nombre);
							break;
						case 3:
							int cantidad=Integer.parseInt(JOptionPane.showInputDialog("Introduce la nueva cantidad"));
							ListaProducto.get(j).setCantidad(cantidad);
							break;
						case 4:
							double precio=Double.parseDouble(JOptionPane.showInputDialog("Introduce el nuevo precio"));
							ListaProducto.get(j).setPrecio(precio);
							break;
						case 5:
							break;
						default:
							System.out.println();
							System.out.println("Has introducido una opcion no valida, por favor, introduce una opcion valida");
							System.out.println();
							break;
					}
				}while(opcion!=5);
			}
		}
	}
}


