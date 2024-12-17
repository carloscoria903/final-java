import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Empleado extends Persona{

    private LocalDate fechaIngreso;
    private LocalDate fechaEgreso;
    private  int legajo;
    private double salario;

    private static  ArrayList<Empleado> listaEmpleados = new ArrayList<>();

    public Empleado(int dni, boolean activo, String nombres, String apellidos, String telefono, String direccion, Provincia provincia, String localidad, LocalDate fechaNacimiento, Sexo sexo, LocalDate fechaIngreso, LocalDate fechaEgreso, int legajo, double salario) {
        super(dni, activo, nombres, apellidos, telefono, direccion,
                provincia, localidad, fechaNacimiento, sexo);
        this.fechaIngreso = fechaIngreso;
        this.fechaEgreso = fechaEgreso;
        this.legajo = legajo;
        this.salario = salario;
    }

    public Empleado(){

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
        Scanner entrada = new Scanner(System.in);
        int dni = Excepciones.castearEntero("ingrese el dni: ");

        Persona personaExistente = buscarPersona(dni);
        if (personaExistente != null) {
            System.out.println("la persona con DNI " + dni + " ya existe:");
            System.out.println("nombre: " + personaExistente.getNombres());
            System.out.println("apellido: " + personaExistente.getApellidos());
        }else {
            System.out.println("debe crear una persona");
            altaPersona();
            personaExistente = buscarPersona(dni);
        }

        int legajo = Excepciones.castearEntero("ingrese el legajo del empleado: ");

        double salario = Excepciones.castearDecimal("ingrese el sueldo del empleado: ");

        System.out.println("fecha de ingreso " + LocalDate.now());
        LocalDate fechaIngreso = LocalDate.now();

        Empleado nuevoEmpleado = new Empleado(
                personaExistente.getDni(),
                personaExistente.isActivo(),
                personaExistente.getNombres(),
                personaExistente.getApellidos(),
                personaExistente.getTelefono(),
                personaExistente.getDireccion(),
                personaExistente.getProvincia(),
                personaExistente.getLocalidad(),
                personaExistente.getFechaNacimiento(),
                personaExistente.getSexo(),
                fechaIngreso,
                null,
                legajo,
                salario);
        nuevoEmpleado.setActivo(true);
        listaEmpleados.add(nuevoEmpleado);
        System.out.println("empleado creado con exito");

    }

    public void bajaEmpleado() {
        Scanner entrada = new Scanner(System.in);
        int dniBuscado = Excepciones.castearEntero("ingrese el dni: ");

        Empleado empleadoEncontrado = null;
        for (Empleado empleado : listaEmpleados) {
            if (empleado.getDni() == dniBuscado) {
                empleadoEncontrado = empleado;
                break;
            }
        }

        if (empleadoEncontrado == null) {
            System.out.println("no se encontro el dni ingresado.");
            return;
        }

        if (!empleadoEncontrado.isActivo()) {
            System.out.println("el empleado ya esta dado de baja.");
            return;
        }

        LocalDate fechaEgreso = Excepciones.crearFecha("ingrese la fecha de egreso del empleado:");

        empleadoEncontrado.setActivo(false);
        empleadoEncontrado.setFechaEgreso(fechaEgreso);
        System.out.println("empleado ha sido dado de baja exitosamente.");
    }


    public void buscarEmpleado(){
        Scanner entrada = new Scanner(System.in);

        int buscarDni = Excepciones.castearEntero("ingrese el dni: ");

        Empleado empleadoEncontrado = null;
        for (Empleado empleado : listaEmpleados) {
            if (empleado.getDni() == buscarDni) {
                empleadoEncontrado = empleado;
                break;
            }
        }

        if (empleadoEncontrado != null) {
            System.out.println("Empleado encontrado: ");
            System.out.println("Nombre: " + empleadoEncontrado.getNombres());
            System.out.println("Apellido: " + empleadoEncontrado.getApellidos());
            System.out.println("Legajo: " + empleadoEncontrado.getLegajo());
            System.out.println("Fecha de ingreso: " + empleadoEncontrado.getFechaIngreso());
            System.out.println("Activo: " + empleadoEncontrado.isActivo());
        } else {
            System.out.println("No se encontro el empleado");
        }

    }

    public void mostrarListaEmpleado() {
        if (listaEmpleados.isEmpty()) {
            System.out.println("No hay personas registradas.");
        } else {
            for (Empleado empleado : listaEmpleados) {
                System.out.println("DNI: " + empleado.getDni());
                System.out.println("nombre: " + empleado.getNombres());
                System.out.println("apellido: " + empleado.getApellidos());
                System.out.println("legajo: " + empleado.getLegajo());
                System.out.println("telefono: " + empleado.getTelefono());
                System.out.println("direccion: " + empleado.getDireccion());
                System.out.println("provincia: " + empleado.getProvincia().obtenerProvincia());
                System.out.println("localidad: " + empleado.getLocalidad());
                System.out.println("fecha de nacimiento: " + empleado.getFechaNacimiento());
                System.out.println("sexo: " + empleado.getSexo().obtenerSexo());
                System.out.println("fecha de ingreso: " + empleado.getFechaIngreso());
                System.out.println("sueldo del empleado: " + empleado.getSalario());
                System.out.println("activo: " + (empleado.isActivo() ? "si" : "no"));
                if (!empleado.isActivo()) {
                    System.out.println("Fecha de egreso: " + empleado.getFechaEgreso());}
                    System.out.println("--------------------------");
                }
            }
        }
    }