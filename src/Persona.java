import java.time.LocalDate;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Persona {

    private static final ArrayList<Persona> listaPersonas = new ArrayList<>();

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

    public Persona(int dni, boolean activo, String nombres, String apellidos, String telefono, String direccion,
                   Provincia provincia, String localidad, LocalDate fechaNacimiento, Sexo sexo) {
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

    public Persona(){

    }//constructor vacio.


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

        Persona nuevaPersona = new Persona();

        System.out.print("cuantas personas deseas guardar ");
        int cantidadPersonas = entrada.nextInt();
        entrada.nextLine();

        for (int i = 0; i < cantidadPersonas; i++) {
            System.out.println("ingrese los datos para la persona " + (i + 1) + ":");

            System.out.println("ingrese DNI: ");
            this.dni = entrada.nextInt();
            entrada.nextLine();

            Persona personaExistente = buscarPersona(dni);
            if (personaExistente != null) {
                System.out.println("la persona con DNI " + dni + " ya existe:");
                continue;
            }

            System.out.println("ingrese nombre: ");
            nuevaPersona.setNombres(entrada.nextLine());

            System.out.println("ingrese apellido: ");
            nuevaPersona.setApellidos(entrada.nextLine());

            do {
                try {
                    System.out.println("seleccione el sexo:");
                    Sexo[] sexos = Sexo.values();
                    for (int j = 0; j < sexos.length; j++) {
                        System.out.println((j + 1) + ". " + sexos[j].optenerSexo());
                    }
                    System.out.print("elija una opcion (1-" + sexos.length + "): ");
                    int opcionSexo = entrada.nextInt();
                    nuevaPersona.setSexo(Sexo.fromInt(opcionSexo));
                    break; // salir del bucle si la entrada es valida
                } catch (InputMismatchException e) {
                    System.out.println("error: debes ingresar un numero. intente otra vez");
                    entrada.nextLine(); // limpiar entrada
                } catch (Excepciones e) {
                    System.out.println(e.getMessage());
                }
            } while(true);
            entrada.nextLine();

            System.out.println("ingrese numero de telefo: ");
            nuevaPersona.setTelefono(entrada.nextLine());

            System.out.println("ingrese direccion: ");
            nuevaPersona.setDireccion(entrada.nextLine());

            System.out.println("ingrese localidad: ");
            nuevaPersona.setLocalidad(entrada.nextLine());

            do {
                try {
                    System.out.println("seleccione la provincia:");
                    Provincia[] provincias = Provincia.values();
                    for (int k = 0; k < provincias.length; k++) {
                        System.out.println((k + 1) + ". " + provincias[k]);
                    }
                    System.out.print("elija una opcion (1-" + provincias.length + "): ");
                    int opcionProvincia = entrada.nextInt();
                    nuevaPersona.setProvincia(Provincia.fromInt(opcionProvincia));
                    break; // salir del bucle si la entrada es valida
                } catch (InputMismatchException e) {
                    System.out.println("error ");
                    entrada.nextLine();
                } catch (Excepciones e) {
                    System.out.println(e.getMessage());
                }
            } while (true);
            entrada.nextLine();

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

            nuevaPersona.setDni(dni);
            nuevaPersona.setNombres(nombres);
            nuevaPersona.setApellidos(apellidos);
            nuevaPersona.setSexo(sexo);
            nuevaPersona.setTelefono(telefono);
            nuevaPersona.setDireccion(direccion);
            nuevaPersona.setLocalidad(localidad);
            nuevaPersona.setProvincia(provincia);
            nuevaPersona.setFechaNacimiento(fechaNacimiento);
            nuevaPersona.setActivo(true);

            listaPersonas.add(nuevaPersona);
            System.out.println("persona crada con exito");
        }

    }

    public static void datosPersona(){

    }

    /*public static void mostrarListaPersonas() {
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
    }*/


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

}
