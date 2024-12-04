import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //String rutaCarpeta = "C:\\Projectos en java\\Final-java-projecto-1\\CarpetaDeArchivo\\";
        //String rutaArchivo = rutaCarpeta + "Archivo1.txt";
        //crear la carpeta
        //Archivos.crearCarpeta(rutaCarpeta);
        //crear el archivo dentro de esa carpeta
        //Archivos.crearArchivoTXT(rutaArchivo);

        Persona persona = new Persona();
        Empleado empleado = new Empleado();
        Scanner entrada = new Scanner(System.in);
        boolean salir = false;

        do {

            System.out.println("menu de opciones");
            System.out.println("1- cargar datos");
            System.out.println("2- ver los datos");
            System.out.println("3- ver datos de una persona");
            System.out.println("4- modificar datos");
            System.out.println("5- dar de baja a una persona");
            System.out.println("6- alta empleado");
            System.out.println("7- baja empleado");
            System.out.println("8- buscar empleado");
            System.out.println("9- mostrar lista de empleados");
            System.out.println("10- salir");

            int opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion){
                case 1:
                    persona.altaPersona();
                    break;
                case 2:
                    persona.mostrarListaPersonas();
                    break;
                case 3:
                    persona.datosPersona();
                    break;
                case 4:
                   persona.modificarPersona();
                   break;
                case 5:
                    persona.bajaPersona();
                    break;
                case 6:
                    empleado.altaEmpleado();
                    break;
                case 7:
                    empleado.bajaEmpleado();
                    break;
                case 8:
                    empleado.buscarEmpleado();
                    break;
                case 9:
                    empleado.mostrarListaEmpleado();
                    break;
                case 10:
                    salir = true;
                    System.out.println("saliendo del sistema");
                    break;
                default:
                    System.out.println("opcion invalida");
                    return;
            }

        } while (! salir);

    }
}
