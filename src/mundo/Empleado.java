package mundo;

public class Empleado extends Usuario {

    private String cargo;

    public Empleado(String nombre, String id, String password, String correo, String cargo) {
        super(nombre, id, password, correo);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

	@Override
	public String getTipoUsuario() {
		return "Empleado";
	}
}
