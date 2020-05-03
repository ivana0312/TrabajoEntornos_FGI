package proyectoEntornosGrupo;

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
	
}
