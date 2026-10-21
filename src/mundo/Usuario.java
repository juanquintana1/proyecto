package mundo;

import java.util.Objects;

/**
 * Clase abstracta que representa la entidad base de un usuario en el sistema AutoGest.
 * Define los atributos comunes, validaciones de seguridad y métodos requeridos
 * para el manejo en tablas Hash y autenticación.
 */
public abstract class Usuario {

    private String nombre;
    private String id;
    private String password;
    private String correo;
    private boolean activo;

    /**
     * Constructor base con validaciones integradas.
     * 
     * @param nombre   Nombre completo del usuario.
     * @param id       Identificador único / Documento de identidad.
     * @param password Contraseña de acceso.
     * @param correo   Correo electrónico de contacto.
     */
    public Usuario(String nombre, String id, String password, String correo) {
        validarDatos(nombre, id, password, correo);
        this.nombre = nombre.trim();
        this.id = id.trim();
        this.password = password;
        this.correo = correo.trim().toLowerCase();
        this.activo = true;
    }

    /**
     * Valida que los datos obligatorios del usuario no sean nulos ni vacíos.
     */
    private void validarDatos(String nombre, String id, String password, String correo) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID/Documento no puede estar vacío.");
        }
        if (password == null || password.length() < 4) {
            throw new IllegalArgumentException("La contraseña debe tener al menos 4 caracteres.");
        }
        if (correo == null || !correo.contains("@")) {
            throw new IllegalArgumentException("El correo electrónico no tiene un formato válido.");
        }
    }

    // --- Métodos de Autenticación y Seguridad ---

    /**
     * Verifica si la contraseña ingresada coincide con la del usuario.
     * @param passwordIngresada Contraseña a validar.
     * @return true si la contraseña es correcta y el usuario está activo.
     */
    public boolean autenticar(String passwordIngresada) {
        return this.activo && this.password.equals(passwordIngresada);
    }

    // --- Getters y Setters ---

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre.trim();
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id != null && !id.trim().isEmpty()) {
            this.id = id.trim();
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password != null && password.length() >= 4) {
            this.password = password;
        } else {
            throw new IllegalArgumentException("La contraseña debe tener al menos 4 caracteres.");
        }
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        if (correo != null && correo.contains("@")) {
            this.correo = correo.trim().toLowerCase();
        } else {
            throw new IllegalArgumentException("Correo electrónico inválido.");
        }
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    // --- Método Abstracto (Polimorfismo) ---

    /**
     * Retorna el tipo o rol específico del usuario (ej: "Administrador", "Empleado").
     */
    public abstract String getTipoUsuario();

    // --- Métodos Sobrescritos (Soporte para TablaHash) ---

    /**
     * Garantiza el correcto funcionamiento como clave en la TablaHash.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return String.format("[%s] %s (%s)", id, nombre, getTipoUsuario());
    }
}
