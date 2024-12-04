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
                System.out.println("nombre: " + getNombres());
                System.out.println("apellido " + getApellidos());
                continue;
            }

            System.out.println("ingrese nombre: ");
            String nombre = entrada.nextLine();

            System.out.println("ingrese apellido: ");
            String apellido = entrada.nextLine();

            Sexo sexo = null;
            do {
                try {
                    System.out.println("seleccione el sexo:");
                    Sexo[] sexos = Sexo.values();
                    for (int j = 0; j < sexos.length; j++) {
                        System.out.println((j + 1) + ". " + sexos[j].optenerSexo());
                    }
                    System.out.print("elija una opcion (1-" + sexos.length + "): ");
                    int opcionSexo = entrada.nextInt();
                    sexo = Sexo.fromInt(opcionSexo);
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("error: intente otra vez.");
                    entrada.nextLine();
                } catch (Excepciones e) {
                    System.out.println(e.getMessage());
                }
            } while (true);
            entrada.nextLine();

            System.out.println("ingrese numero de telefo: ");
            String telefono = entrada.nextLine();

            System.out.println("ingrese direccion: ");
            String direccion = entrada.nextLine();

            System.out.println("ingrese localidad: ");
            String localidad = entrada.nextLine();

            Provincia provincia = null;
            do {
                try {
                    System.out.println("seleccione la provincia:");
                    Provincia[] provincias = Provincia.values();
                    for (int k = 0; k < provincias.length; k++) {
                        System.out.println((k + 1) + ". " + provincias[k].optenerProvincia());
                    }
                    System.out.print("elija una opcion (1-" + provincias.length + "): ");
                    int opcionProvincia = entrada.nextInt();
                    provincia = Provincia.fromInt(opcionProvincia);
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("error. ");
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


            Persona nuevaPersona = new Persona(dni,true,nombre,apellido,telefono,direccion,provincia,localidad,fechaNacimiento,sexo);
            nuevaPersona.setActivo(true);
            listaPersonas.add(nuevaPersona);
            System.out.println("persona crada con exito");
        }

    }

    public void datosPersona(){
        Scanner entrada = new Scanner(System.in);

        System.out.println("ingrese DNI: ");
        int buscarDni = entrada.nextInt();

        Persona personaEncontrada = buscarPersona(buscarDni);
        if (personaEncontrada != null) {
            System.out.println("persona encontrada:");
            System.out.println("--------------------------");
            System.out.println("dni: " + personaEncontrada.getDni());
            System.out.println("nombre: " + personaEncontrada.getNombres());
            System.out.println("apellido: " + personaEncontrada.getApellidos());
            System.out.println("teléfono: " + personaEncontrada.getTelefono());
            System.out.println("dirección: " + personaEncontrada.getDireccion());
            System.out.println("provincia: " + personaEncontrada.getProvincia());
            System.out.println("localidad: " + personaEncontrada.getLocalidad());
            System.out.println("fecha de nacimiento: " + personaEncontrada.getFechaNacimiento());
            System.out.println("sexo: " + personaEncontrada.getSexo());
            System.out.println("activo: " + (personaEncontrada.isActivo() ? "Sí" : "No"));
        } else {
            System.out.println("no se encontro el DNI ingresado.");
        }
    }

    public static void mostrarListaPersonas() {
        if (listaPersonas.isEmpty()) {
            System.out.println("No hay personas registradas.");
        } else {
            System.out.println("Lista de Personas:");
            for (Persona persona : listaPersonas) {
                System.out.println("DNI: " + persona.getDni());
                System.out.println("nombre: " + persona.getNombres());
                System.out.println("apellido: " + persona.getApellidos());
                System.out.println("telefono: " + persona.getTelefono());
                System.out.println("direccion: " + persona.getDireccion());
                System.out.println("provincia: " + persona.getProvincia());
                System.out.println("localidad: " + persona.getLocalidad());
                System.out.println("fecha de nacimiento: " + persona.getFechaNacimiento());
                System.out.println("sexo: " + persona.getSexo());
                System.out.println("activo: " + persona.isActivo());
                System.out.println("--------------------------");
            }
        }
    }

    public void modificarPersona(){
            Scanner entrada = new Scanner(System.in);

            System.out.print("ingrese el dni: ");
            int dniBuscado = entrada.nextInt();
            entrada.nextLine();

            Persona personaEncontrada = buscarPersona(dniBuscado);

            if (personaEncontrada == null) {
                System.out.println("no se encontro el dni");
                return;
            }

            int opcion;
            do {
                System.out.println("persona encontrada: ");
                System.out.println("1. nombre: " + personaEncontrada.getNombres());
                System.out.println("2. apellido: " + personaEncontrada.getApellidos());
                System.out.println("3. telefono: " + personaEncontrada.getTelefono());
                System.out.println("4. direccion: " + personaEncontrada.getDireccion());
                System.out.println("5. provincia: " + personaEncontrada.getProvincia());
                System.out.println("6. localidad: " + personaEncontrada.getLocalidad());
                System.out.println("7. fecha de nacimiento: " + personaEncontrada.getFechaNacimiento());
                System.out.println("8. sexo: " + personaEncontrada.getSexo());
                System.out.println("9. salir");
                System.out.print("que desea modificar (1-8): ");
                opcion = entrada.nextInt();
                entrada.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.print("ingrese el nuevo nombre: ");
                        String nuevoNombre = entrada.nextLine();
                        personaEncontrada.setNombres(nuevoNombre);
                        break;
                    case 2:
                        System.out.print("ingrese el nuevo apellido: ");
                        String nuevoApellido = entrada.nextLine();
                        personaEncontrada.setApellidos(nuevoApellido);
                        break;
                    case 3:
                        System.out.print("ingrese el nuevo telefono: ");
                        String nuevoTelefono = entrada.nextLine();
                        personaEncontrada.setTelefono(nuevoTelefono);
                        break;
                    case 4:
                        System.out.print("ingrese la nueva direccion: ");
                        String nuevaDireccion = entrada.nextLine();
                        personaEncontrada.setDireccion(nuevaDireccion);
                        break;
                    case 5:
                        System.out.println("seleccione la provincia: ");
                        Provincia[] provincias = Provincia.values();
                        for (int i = 0; i < provincias.length; i++) {
                            System.out.println((i + 1) + ". " + provincias[i].optenerProvincia());
                        }
                        System.out.print("Ingrese la provincia: ");
                        int opcionProvincia = entrada.nextInt();
                        entrada.nextLine();
                        try {
                            Provincia nuevaProvincia = Provincia.fromInt(opcionProvincia);
                            personaEncontrada.setProvincia(nuevaProvincia);
                        } catch (Excepciones e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 6:
                        System.out.print("ingrese la nueva localidad: ");
                        String nuevaLocalidad = entrada.nextLine();
                        personaEncontrada.setLocalidad(nuevaLocalidad);
                        break;
                    case 7:
                        System.out.print("ingrese el nuevo día de nacimiento: ");
                        int dia = entrada.nextInt();
                        System.out.print("ingrese el nuevo mes de nacimiento: ");
                        int mes = entrada.nextInt();
                        System.out.print("ingrese el nuevo año de nacimiento: ");
                        int anio = entrada.nextInt();
                        try {
                            LocalDate nuevaFechaNacimiento = LocalDate.of(anio, mes, dia);
                            personaEncontrada.setFechaNacimiento(nuevaFechaNacimiento);
                        } catch (DateTimeException e) {
                            System.out.println("fecha no valida.");
                        }
                        entrada.nextLine();
                        break;
                    case 8:
                        System.out.println("seleccione el nuevo sexo: ");
                        Sexo[] sexos = Sexo.values();
                        for (int i = 0; i < sexos.length; i++) {
                            System.out.println((i + 1) + ". " + sexos[i].optenerSexo());
                        }
                        System.out.print("ingrese el sexo: ");
                        int opcionSexo = entrada.nextInt();
                        entrada.nextLine();
                        try {
                            Sexo nuevoSexo = Sexo.fromInt(opcionSexo);
                            personaEncontrada.setSexo(nuevoSexo);
                        } catch (Excepciones e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 9:
                        System.out.println("saliendo del menu de modificacion...");
                        break;
                    default:
                        System.out.println("opcion no valida.");
                }
            } while (opcion != 9);

            System.out.println("cambios completados.");
    }


    public void bajaPersona(){
        Scanner entrada = new Scanner(System.in);

        System.out.print("ingrese el dni: ");
        int dniBuscado = entrada.nextInt();
        entrada.nextLine();

        Persona personaEncontrada = buscarPersona(dniBuscado);

        if (personaEncontrada == null) {
            System.out.println("no se encontro el dni ingresado.");
            return;
        }

        if (!personaEncontrada.isActivo()) {
            System.out.println("la persona ya esta dada de baja.");
            return;
        }

        personaEncontrada.setActivo(false);
        System.out.println("la persona ha sido dada de baja exitosamente.");
    }
}