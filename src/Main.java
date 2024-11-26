import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String rutaCarpeta = "C:\\Projectos en java\\Final-java-projecto-1\\CarpetaDeArchivo\\";
        String rutaArchivo = rutaCarpeta + "Archivo1.txt";
        //crear la carpeta
        Archivos.crearCarpeta(rutaCarpeta);
        //crear el archivo dentro de esa carpeta
        Archivos.crearArchivoTXT(rutaArchivo);

        Persona persona = new Persona();
        Scanner entrada = new Scanner(System.in);
        boolean salir = false;

        do {

            System.out.println("menu de opciones");
            System.out.println("1- cargar datos");
            System.out.println("2- ver los datos");
            System.out.println("3- salir");

            int opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion){
                case 1:
                    persona.altaPersona();
                    break;
                case 2:

                    break;

                case 3:
                    salir = true;
                    System.out.println("saliendo del sistema");
                    break;

                case 4:
                    System.out.println("opcion invalida");
                    return;
            }

        } while (! salir);

    }
}
