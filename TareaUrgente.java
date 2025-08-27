public class TareaUrgente {
    private static int contadorId = 0;
    private int idTarea;
    private String descripcion;

    public TareaUrgente(String descripcion) {
        this.idTarea = ++contadorId;
        this.descripcion = descripcion;
    }

    public int getIdTarea() {
        return idTarea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return "Tarea Urgente #" + idTarea + ": " + descripcion;
    }
}
