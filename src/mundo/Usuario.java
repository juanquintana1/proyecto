package mundo;

public abstract class Usuario {
	private String nombre;
	private String usuario;
	private String password;
	private String correo;
	public Usuario(String nombre, String usuario, String password, String correo) {
		super();
		this.nombre = nombre;
		this.usuario = usuario;
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
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
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
