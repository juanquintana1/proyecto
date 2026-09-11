package mundo;

public class Administrador extends Usuario {

	public Administrador(String nombre, String id, String password, String correo) {
        super(nombre, id, password, correo);
    }

	@Override
	public String getTipoUsuario() {
		return "Administrador";
	}
}
