package mundo;

import java.util.Objects;

/**
 * Clase que representa a un Empleado en el sistema AutoGest.
 * Hereda de la clase abstracta Usuario.
 */
public class Empleado extends Usuario {

    // --- Atributos de Negocio ---
    private Cargo cargo;
    private double totalVentasAcumuladas;
    private int clientesAtendidos;
    private boolean activo;

    // --- Enum Interno para los Cargos del Concesionario ---
    public enum Cargo {
        VENDEDOR("Vendedor de Salón"),
        ASESOR_FINANCIERO("Asesor Financiero y Seguros"),
        GERENTE_VENTAS("Gerente de Ventas"),
        RECEPCIONISTA("Atención al Cliente / Recepción");

        private final String descripcion;

        Cargo(String descripcion) {
            this.descripcion = descripcion;
        }

        public String getDescripcion() {
            return descripcion;
        }

        @Override
        public String toString() {
            return descripcion;
        }
    }

    // --- Constructor Principal ---
    public Empleado(String nombre, String id, String password, String correo, Cargo cargo) {
        super(nombre, id, password, correo);
        
        validarDatos(nombre, id, password, correo, cargo);

        this.cargo = cargo;
        this.totalVentasAcumuladas = 0.0;
        this.clientesAtendidos = 0;
        this.activo = true;
    }

    // --- Validaciones de Seguridad y Robustez ---
    private void validarDatos(String nombre, String id, String password, String correo, Cargo cargo) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del empleado no puede estar vacío.");
        }
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID/Documento no puede estar vacío.");
        }
        if (password == null || password.length() < 4) {
            throw new IllegalArgumentException("La contraseña debe tener al menos 4 caracteres.");
        }
        if (correo == null || !correo.contains("@")) {
            throw new IllegalArgumentException("Debe ingresar un correo electrónico válido.");
        }
        if (cargo == null) {
            throw new IllegalArgumentException("El cargo asignado no puede ser nulo.");
        }
    }

    // --- Métodos de Operación (Integración con Cola y Ventas) ---

    /**
     * Incrementa el contador cuando el empleado atiende a un cliente en la Cola de Turnos.
     */
    public void registrarAtencionCliente() {
        this.clientesAtendidos++;
    }

    /**
     * Suma una nueva venta al historial acumulado del empleado.
     * @param monto Valor de la venta realizada.
     */
    public void registrarVenta(double monto) {
        if (monto > 0) {
            this.totalVentasAcumuladas += monto;
        }
    }

    // --- Getters y Setters ---

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        if (cargo == null) {
            throw new IllegalArgumentException("El cargo no puede ser nulo.");
        }
        this.cargo = cargo;
    }

    public double getTotalVentasAcumuladas() {
        return totalVentasAcumuladas;
    }

    public int getClientesAtendidos() {
        return clientesAtendidos;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    // --- Métodos Sobrescritos ---

    @Override
    public String getTipoUsuario() {
        return "Empleado";
    }

    /**
     * Formateado para mostrar directamente en componentes de Swing (JTable, JComboBox, etc.).
     */
    @Override
    public String toString() {
        return String.format("[%s] %s - %s", getId(), getNombre(), cargo.getDescripcion());
    }

    /**
     * Necesario para realizar búsquedas rápidas $O(1)$ en la TablaHash por ID.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return Objects.equals(getId(), empleado.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
