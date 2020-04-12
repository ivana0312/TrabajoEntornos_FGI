package proyectoEntornosGrupo;
import java.util.ArrayList;
public class Usuario {
	
	private int id;
	private String password;
	
	public Usuario(int id, String password)
	{
		this.id=id;
		this.password=password;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public static void VisualizarBBDD(ArrayList<Producto> ListaProducto){
		System.out.println();
			System.out.printf("%-10s", "ID");
			System.out.printf("%-20s", "NOMBRE");
			System.out.printf("%-25s", "CANTIDAD STOCK");
			System.out.printf("%-10s%n", "PRECIO");
			System.out.println("----------------------------------------------------------------");
			System.out.println();
			for(int i=0;i<ListaProducto.size();i++)
			{
				System.out.printf("%-10s", ListaProducto.get(i).getId());
				System.out.printf("%-20s", ListaProducto.get(i).getNombre());
				System.out.printf("%-25s", ListaProducto.get(i).getCantidad() + " Unidades");
				System.out.printf("%-10s%n", ListaProducto.get(i).getPrecio()+" €");
			}
			System.out.println();
			System.out.println();
		}
}
