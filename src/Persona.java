import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.Scanner;

public class Persona {

    private static ArrayList<Persona> listaPersonas = new ArrayList<>();

    private int dni;
    private boolean activo;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String direccion;
    private Provincia provincia;
    private String localidad;
    private LocalDate fechaNacimiento;
    private Sexo sexo;

    public Persona() {
        this.dni = dni;
        this.activo = activo;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.direccion = direccion;
        this.provincia = provincia;
        this.localidad = localidad;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }



    //metodos personalizados para persona

    public Persona buscarPersona(int dni) {
        for (Persona persona : listaPersonas) {
            if (persona.getDni() == dni) {
                return persona;
            }
        }
        return null;
    }


    public void altaPersona(){
        Scanner entrada = new Scanner(System.in);

        System.out.println("ingrese nombre: ");
        this.nombres = entrada.nextLine();

        System.out.println("ingrese apellido: ");
        this.apellidos = entrada.nextLine();

        System.out.println("ingrese DNI: ");
        this.dni = entrada.nextInt();
        entrada.nextLine();

        System.out.println("elija el sexo:");
        Sexo[] sexos = Sexo.values();
        for (int i = 0; i < sexos.length; i++) {
            System.out.println((i + 1) + ". " + sexos[i]);
        }
        int opcionSexo = entrada.nextInt();
        this.sexo = (opcionSexo >= 1 && opcionSexo <= sexos.length) ? sexos[opcionSexo - 1] : Sexo.OTRO;
        entrada.nextLine();

        System.out.println("ingrese numero de telefo: ");
        this.telefono = entrada.nextLine();

        System.out.println("ingrese direccion: ");
        this.direccion = entrada.nextLine();

        System.out.println("ingrese localidad: ");
        this.localidad = entrada.nextLine();

        System.out.println("Seleccione la provincia:");
        Provincia[] provincias = Provincia.values();
        for (int i = 0; i < provincias.length; i++) {
            System.out.println((i + 1) + ". " + provincias[i]);
        }
        int opcionProvincia = entrada.nextInt();
        this.provincia = (opcionProvincia >= 1 && opcionProvincia <= provincias.length) ? provincias[opcionProvincia - 1] : null;

        System.out.println("ingrese el dia, de nacimiento: ");
        int dia = entrada.nextInt();

        System.out.println("ingrese el mes de nacimiento (1-12)");
        int mes = entrada.nextInt();

        System.out.println("ingrese el año de nacimiento: ");
        int anio = entrada.nextInt();
        try {
            LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
            setFechaNacimiento(fechaNacimiento);
        } catch (DateTimeException e) {
            System.out.println("fecha no valida. se usara la fecha actual por defecto.");
            setFechaNacimiento(LocalDate.now());
        }

        System.out.println("se encuntra activo: ");
        this.activo = entrada.nextBoolean();
        entrada.nextLine();
        listaPersonas.add(this);
    }


    public static ArrayList<Persona> listaPersonas(){
        return listaPersonas;
    }

    public static void datosPersona(){

    }

    public static void mostrarListaPersonas() {
        if (listaPersonas.isEmpty()) {
            System.out.println("No hay personas registradas.");
        } else {
            System.out.println("Lista de Personas:");
            for (Persona persona : listaPersonas) {
                System.out.println("DNI: " + persona.getDni());
                System.out.println("Nombre: " + persona.getNombres());
                System.out.println("Apellido: " + persona.getApellidos());
                System.out.println("Teléfono: " + persona.getTelefono());
                System.out.println("Dirección: " + persona.getDireccion());
                System.out.println("Provincia: " + persona.getProvincia());
                System.out.println("Localidad: " + persona.getLocalidad());
                System.out.println("Fecha de Nacimiento: " + persona.getFechaNacimiento());
                System.out.println("Sexo: " + persona.getSexo());
                System.out.println("Activo: " + persona.isActivo());
                System.out.println("--------------------------");
            }
        }
    }


    public void modificarPersona(){

    }

    public void bajaPersona(){

    }

    public void encontrarPersona(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("**********************************");
        System.out.print("ingrese el DNI de la persona a buscar: ");
        int dni = entrada.nextInt();

        Persona personaEncontrada = buscarPersona(dni);

        if (personaEncontrada != null) {
            System.out.println("persona encontrada:");
            System.out.println("------------------------------------");
            System.out.println("nombre: " + personaEncontrada.getNombres());
            System.out.println("apellido: " + personaEncontrada.getApellidos());
            System.out.println("direccion: " + personaEncontrada.getDireccion());
        } else {
            System.out.println("Persona no encontrada.");
        }

    }

    public static void guardarPersonaEnArchivo(Persona persona) {
        String archivo = "C:\\Projectos en java\\Final-java-projecto-1\\CarpetaDeArchivo\\Archivo1.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true))) {
            writer.write("DNI: " + persona.getDni() + "\n");
            writer.write("Nombre: " + persona.getNombres() + "\n");
            writer.write("Apellido: " + persona.getApellidos() + "\n");
            writer.write("Teléfono: " + persona.getTelefono() + "\n");
            writer.write("Dirección: " + persona.getDireccion() + "\n");
            writer.write("Provincia: " + persona.getProvincia() + "\n");
            writer.write("Localidad: " + persona.getLocalidad() + "\n");
            writer.write("Fecha de Nacimiento: " + persona.getFechaNacimiento() + "\n");
            writer.write("Sexo: " + persona.getSexo() + "\n");
            writer.write("Activo: " + persona.isActivo() + "\n");
            writer.write("---------------------------\n");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }




}
