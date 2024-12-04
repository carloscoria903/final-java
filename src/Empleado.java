import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Empleado extends Persona{

    private LocalDate fechaIngreso;
    private LocalDate fechaEgreso;
    private int legajo;
    private double salario;

    private static final ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();

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
        System.out.println("ingrese el numero de DNI");
        int dni = entrada.nextInt();
        entrada.nextLine();

        Persona personaExistente = buscarPersona(dni);
        if (personaExistente != null) {
            System.out.println("la persona con DNI " + dni + " ya existe:");
            System.out.println("nombre: " + getNombres());
            System.out.println("apellido " + getApellidos());
        }else {
            System.out.println("debe crear una persona");
            altaPersona();
            personaExistente = buscarPersona(dni);
        }

        System.out.println("ingrese el numero de legajo del empleado");
        int legajo = entrada.nextInt();
        entrada.nextLine();

        System.out.println("ingrese el sueldo del empleado");
        double salario = entrada.nextDouble();
        entrada.nextLine();

        System.out.println("fecha de ingreso " + LocalDate.now());
        LocalDate fechaIngreso = LocalDate.now();

        Empleado nuevoEmpleado = new Empleado(
                personaExistente.getDni(), personaExistente.isActivo(), personaExistente.getNombres(),
                personaExistente.getApellidos(),
                personaExistente.getTelefono(), personaExistente.getDireccion(), personaExistente.getProvincia(),
                personaExistente.getLocalidad(),
                personaExistente.getFechaNacimiento(),personaExistente.getSexo(),
                fechaIngreso,null,legajo,salario);
        nuevoEmpleado.setActivo(true);
        listaEmpleados.add(nuevoEmpleado);
        System.out.println("empleado creado con exito");

    }

    public void bajaEmpleado(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("ingrese el dni");
        int dniBuscado = entrada.nextInt();
        entrada.nextLine();

        Persona personaEncontrada = buscarPersona(dniBuscado);

        if (personaEncontrada == null) {
            System.out.println("no se encontro el dni ingresado.");
            return;
        }

        if (!personaEncontrada.isActivo()) {
            System.out.println("el empleado ya esta dada de baja.");
            return;
        }

        personaEncontrada.setActivo(false);
        System.out.println("ingrese la fecha de egreso del empleado");
        System.out.println("ingrese el dia: ");
        int dia = entrada.nextInt();

        System.out.println("ingrese el mes (1-12)");
        int mes = entrada.nextInt();

        System.out.println("ingrese el año: ");
        int anio = entrada.nextInt();
        try {
            LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
            setFechaNacimiento(fechaNacimiento);
        } catch (DateTimeException e) {
            System.out.println("fecha no valida. se usara la fecha actual por defecto.");
            setFechaNacimiento(LocalDate.now());
        }

        System.out.println("empleado ha sido dada de baja exitosamente.");

    }

    public void buscarEmpleado(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("ingrese el dni");
        int buscarDni = entrada.nextInt();
        entrada.nextLine();
        Persona empleadoExistente = buscarPersona(buscarDni);

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
            System.out.println("No se encontró el empleado");
        }

    }

    public void mostrarListaEmpleado(){
        if (listaEmpleados.isEmpty()) {
            System.out.println("No hay personas registradas.");
        } else {
            System.out.println("Lista de Personas:");
            for (Persona persona : listaEmpleados) {
                System.out.println("DNI: " + persona.getDni());
                System.out.println("nombre: " + persona.getNombres());
                System.out.println("apellido: " + persona.getApellidos());
                System.out.println("telefono: " + persona.getTelefono());
                System.out.println("direccion: " + persona.getDireccion());
                System.out.println("provincia: " + persona.getProvincia());
                System.out.println("localidad: " + persona.getLocalidad());
                System.out.println("fecha de nacimiento: " + persona.getFechaNacimiento());
                System.out.println("sexo: " + persona.getSexo());
                System.out.println("fecha de ingreso: " + this.fechaIngreso);
                System.out.println("activo: " + persona.isActivo());
                System.out.println("--------------------------");
            }
        }
    }

}

