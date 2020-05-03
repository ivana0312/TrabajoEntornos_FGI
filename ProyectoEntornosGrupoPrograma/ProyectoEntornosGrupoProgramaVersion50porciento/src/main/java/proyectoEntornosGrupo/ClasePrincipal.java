package proyectoEntornosGrupo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ClasePrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			ArrayList<Usuario> ListaUsuario = new ArrayList<Usuario>();
			ArrayList<Producto> ListaProducto = new ArrayList<Producto>();
rellenarProductos(ListaProducto);
rellenarUsuarios(ListaUsuario);
//anadir y modificar case al añadir nuevas funcionalidades
		
int eleccion=0;
//Cambiar while encaso de que se cambie el case al que este relacionado
while(eleccion!=3)
{
	System.out.println("********** MENU **********");
	System.out.println("--------------------------");
	System.out.println("1. Mostras productos");
	System.out.println("2. Añada un usuario");
	System.out.println("3. Salir");
	eleccion=Integer.parseInt(JOptionPane.showInputDialog("Elige la option del 1 al 3"));
	switch(eleccion){
	case 1:
		ObtenerListaProducto(ListaProducto);
		break;
	case 2:
		anadirUsuario(ListaUsuario);
		break;
	case 3:
		System.out.println("Hasta la proxima");	
		break;
	default:
		System.out.println();
		System.out.println("Has introducido una opcion no valida, por favor, introduce una opcion valida");
		System.out.println();
		break;
	}
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
}
