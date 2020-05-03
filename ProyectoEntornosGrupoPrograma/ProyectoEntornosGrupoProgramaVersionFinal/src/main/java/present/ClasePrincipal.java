package present;
import java.util.*;
import javax.swing.JOptionPane;

import dominio.Administrador;
import dominio.Producto;
import dominio.Usuario;
import dominio.acceso;
import dominio.registro;

public class ClasePrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			ArrayList<Usuario> ListaUsuario = new ArrayList<Usuario>();
			ArrayList<Producto> ListaProducto = new ArrayList<Producto>();
			ArrayList comentarios = new ArrayList();
			rellenarProductos(ListaProducto);
			rellenarUsuarios(ListaUsuario);
			boolean acceso=false;
			int intentos=0;
			
			do {
				try {
					int id1=Integer.parseInt(JOptionPane.showInputDialog("*** ACCESO BBDD *** \n Introduce tu ID"));
					comprovarId(id1,ListaUsuario);
					String contrasena1=JOptionPane.showInputDialog("*** ACCESO BBDD *** \n Introduce tu contraseña");
					if (contrasena1.isEmpty()) {
						contrasena1=JOptionPane.showInputDialog("*** ACCESO BBDD *** \n Introduce tu contraseña");
					}
					for (int i=0; i<ListaUsuario.size(); i++) {
						if (ListaUsuario.get(i).getId()==id1) {
							for (int j=0; j<ListaUsuario.size(); j++) {
								if (contrasena1.contentEquals(ListaUsuario.get(i).getPassword())) {
									if (ListaUsuario.get(i) instanceof Administrador) {
										acceso=true;
										Administrador admin=(Administrador) ListaUsuario.get(i);
										intentos=4;
										int opcion=1;
										do {
											menuAdministrador();
											opcion=Integer.parseInt(JOptionPane.showInputDialog("Introduce opción del menú (número)"));
											switch (opcion) {
												case 1:
													ListaUsuario.get(i).VisualizarBBDD(ListaProducto);
													break;
												case 2:
													int opcion1=1;
													do {
														menuProductos();
														opcion1=Integer.parseInt(JOptionPane.showInputDialog("Introduce opción del menú (número)"));
														switch (opcion1) {
															case 1:
																ObtenerListaProducto(ListaProducto);
																break;
															case 2:
																admin.anadirProducto(ListaProducto);
																break;
															case 3:
																ObtenerListaProducto(ListaProducto);
																admin.eliminarProducto(ListaProducto);
																break;
															case 4:
																ObtenerListaProducto(ListaProducto);
																admin.modificarProducto(ListaProducto);
																break;
															case 5:	
																break;
															default:
																System.out.println();
																System.out.println("Has introducido una opcion no valida, por favor, introduce una opcion valida");
																System.out.println();
																break;
														}
													}while(opcion1!=5);
													break;
												case 3:
													int opcion2=1;
													do {
														menuUsuarios();
														opcion2=Integer.parseInt(JOptionPane.showInputDialog("Introduce opción del menú (número)"));
														switch (opcion2) {
															case 1:
																ObtenerListaUsuario(ListaUsuario);
																break;
															case 2:
																anadirUsuario(ListaUsuario);
																break;
															case 3:
																ObtenerListaUsuario(ListaUsuario);
																eliminarUsuario(ListaUsuario);
																break;
															case 4:
																break;
															default:
																System.out.println();
																System.out.println("Has introducido una opcion no valida, por favor, introduce una opcion valida");
																System.out.println();
																break;
														}
													}while(opcion2!=4);
													break;
												case 4:
													rellenarcomentariosaleatorios(comentarios);
													System.out.println(comentarios);	
													break;
												case 5:
													System.out.println("Hasta la próxima");	
													break;
												default:
													System.out.println();
													System.out.println("Has introducido una opcion no valida, por favor, introduce una opcion valida");
													System.out.println();
													break;
											}
										}while(opcion!=5);
										break;
									}
									else {
										acceso=true;
										Usuario usr=(Usuario)ListaUsuario.get(i);
										intentos=4;
										int opcion3=1;
										do {
											menuUsuario();
											opcion3=Integer.parseInt(JOptionPane.showInputDialog("Introduce opción del menú (número)"));
											switch (opcion3) {
												case 1:
													usr.VisualizarBBDD(ListaProducto);
													break;
												case 2:
													anadirComentario(comentarios);
													break;
												case 3:
													break;
												default:
													System.out.println();
													System.out.println("Has introducido una opcion no valida, por favor, introduce una opcion valida");
													System.out.println();
													break;
											}
										}while(opcion3!=3);
										break;
									}
								}
							}
							
						}
					}
					if (acceso==false) {
						System.out.println("acceso denegado, quedan " + (2-intentos) + " intentos");
						intentos++;
					}
				}
				catch (registro e){
					System.out.println(e.getMessage());
				}
			}while (intentos<3);
			try{
				comprovarAcceso(intentos);
			}
			catch(acceso e){
				System.out.println(e.getMessage());
			}
	}

	public static void rellenarProductos(ArrayList<Producto> ListaProducto) {
		ListaProducto.add(new Producto(1,"cama",4,33.5));
		ListaProducto.add(new Producto(2,"silla",5,12.99));
		ListaProducto.add(new Producto(3,"mesa",25,50));
		ListaProducto.add(new Producto(4,"tele",5,103.99));
		ListaProducto.add(new Producto(5,"sillon",2,256));
		ListaProducto.add(new Producto(6,"cojin",46,9.99));
		ListaProducto.add(new Producto(7,"jarron",11,16.5));
		ListaProducto.add(new Producto(8,"espejo",7,42.2));
		ListaProducto.add(new Producto(9,"maceta",25,9));
	}
	public static void comprovarAcceso(int intentos) throws acceso{
		if (intentos==3){
			acceso denegado=new acceso("Error, has alcanzado el máximo de intentos");
			throw denegado;
		}
	}
	public static void comprovarId(int id1, ArrayList<Usuario> ListaUsuario) throws registro{
		boolean reg=false;
		for (int i=0; i<ListaUsuario.size(); i++){
			if (ListaUsuario.get(i).getId()==id1){
				reg=true;
			}
		}
		if (reg==false){
			registro sinreg=new registro("Error, este id no está registrado");
			throw sinreg;
		}
	}
	public static void ObtenerListaProducto(ArrayList<Producto> ListaProducto){
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
			System.out.printf("%-10s%n", ListaProducto.get(i).getPrecio());
		}
		System.out.println();
		System.out.println();
	}
	public static void rellenarUsuarios(ArrayList<Usuario> ListaUsuario) {
		ListaUsuario.add(new Usuario(1,"pass1"));
		ListaUsuario.add(new Administrador(2,"pass2"));
		ListaUsuario.add(new Administrador(3,"pass3"));
		ListaUsuario.add(new Usuario(4,"pass4"));
		ListaUsuario.add(new Usuario(5,"pass5"));
		ListaUsuario.add(new Usuario(6,"pass6"));
		ListaUsuario.add(new Usuario(7,"pass7"));
		ListaUsuario.add(new Administrador(8,"pass8"));
		ListaUsuario.add(new Usuario(9,"pass9"));
	}
	public static void ObtenerListaUsuario (ArrayList<Usuario> ListaUsuario) {
		System.out.printf("%-5s", "ID");
		System.out.printf("%-10s%n", "CONTRASEÑA");
		System.out.println("---------------");
		System.out.println();
		for (int i=0; i<ListaUsuario.size();i++) {
			System.out.printf("%-7s",ListaUsuario.get(i).getId());
			System.out.printf("%-10s%n",ListaUsuario.get(i).getPassword());
		}
		System.out.println();
	}
	public static void anadirUsuario(ArrayList<Usuario> ListaUsuario){
		int eleccion=0;
		while(eleccion!=2&&eleccion!=1)
		{
		eleccion = Integer.parseInt(JOptionPane.showInputDialog("Pulsa 1 si quiere añadir un administrador, pulsa 2 si quieres añadir un usuario"));
		}
		int id =0;
		for(int i=0;i<ListaUsuario.size();i++)
		{
			if(ListaUsuario.get(i).getId()>id)
			{
				id=ListaUsuario.get(i).getId();
				
			}
			
		}
		id++;
		String password =JOptionPane.showInputDialog("La id de la cuenta que estas creando es " +id+", a continuacion introduce una contraseña para esta cuenta");
		
		
		if(eleccion==1)
		{
			ListaUsuario.add(new Administrador(id,password));
			
		}
		else if(eleccion==2)
		{
			ListaUsuario.add(new Usuario(id,password));
		}
	}
	public static void eliminarUsuario (ArrayList<Usuario> ListaUsuario) {
		int borrar=Integer.parseInt(JOptionPane.showInputDialog("Introduce el id del usuario a borrar"));
		for (int i=0; i<ListaUsuario.size(); i++) {
			if (borrar==ListaUsuario.get(i).getId()) {
				ListaUsuario.remove(i);
			}
		}
	}
	public static void anadirComentario(ArrayList comentarios) {
		String comentario=JOptionPane.showInputDialog("Introduce el comentario");
		comentarios.add(comentario);
	}
	public static void rellenarcomentariosaleatorios(ArrayList comentarios) {
		comentarios.add("camas agotadas");
		comentarios.add("hay 2 sillas defectuosas");
		comentarios.add("el estante de las mesas ha cambiado de lugar al pasillo 3");
	}
	public static void menuAdministrador() {
		System.out.println("____________________________");
		System.out.println("**** MENÚ ADMINISTRADOR ****");
		System.out.println("");
		System.out.println("1. Ver base de datos");
		System.out.println("2. Menú de productos");
		System.out.println("3. Menú de usuarios");
		System.out.println("4. Ver comentarios");
		System.out.println("5. Salir");
		System.out.println("____________________________");
		System.out.println("");
	}
	public static void menuProductos() {
		System.out.println("__________________________");
		System.out.println("***** MENÚ PRODUCTOS *****");
		System.out.println("");
		System.out.println("1. Ver lista de productos");
		System.out.println("2. Añadir producto");
		System.out.println("3. Eliminar producto");
		System.out.println("4. Modificar producto");
		System.out.println("5. Retroceder");
		System.out.println("__________________________");
		System.out.println("");
	}
	public static void menuUsuarios() {
		System.out.println("_________________________");
		System.out.println("***** MENÚ USUARIOS *****");
		System.out.println("");
		System.out.println("1. Ver lista de usuarios");
		System.out.println("2. Añadir usuario");
		System.out.println("3. Eliminar usuario");
		System.out.println("4. Retroceder");
		System.out.println("_________________________");
		System.out.println("");
	}
	public static void menuUsuario() {
		System.out.println("_________________________");
		System.out.println("***** MENÚ USUARIO *****");
		System.out.println("");
		System.out.println("1. Ver la base de datos");
		System.out.println("2. Añadir comentario");
		System.out.println("3. Salir");
		System.out.println("_________________________");
		System.out.println("");
	}
}
