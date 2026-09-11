package mundo;

public abstract class Usuario {
	private String nombre;
	private String id;
	private String password;
	private String correo;
	public Usuario(String nombre, String id, String password, String correo) {
		super();
		this.nombre = nombre;
		this.id = id;
		this.password = password;
		this.correo = correo;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUsuario() {
		return id;
	}
	public void setUsuario(String usuario) {
		this.id = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public abstract String getTipoUsuario();
	
}
