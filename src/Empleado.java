import java.time.LocalDate;

public class Empleado extends Persona{

    private LocalDate fechaIngreso;
    private LocalDate fechaEgreso;
    private int legajo;
    private double salario;

    public Empleado(int dni, boolean activo, String nombres, String apellidos, String telefono, String direccion, Provincia provincia, String localidad, LocalDate fechaNacimiento, Sexo sexo, LocalDate fechaIngreso, LocalDate fechaEgreso, int legajo, double salario) {
        super();
        this.fechaIngreso = fechaIngreso;
        this.fechaEgreso = fechaEgreso;
        this.legajo = legajo;
        this.salario = salario;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDate getFechaEgreso() {
        return fechaEgreso;
    }

    public void setFechaEgreso(LocalDate fechaEgreso) {
        this.fechaEgreso = fechaEgreso;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    //metodos personalisadoz para empleado

    public void altaEmpleado(){

    }

    public void bajaEmpleado(){

    }

    public void buscarEmpleado(){

    }

    public void listaEmpleado(){

    }

}

