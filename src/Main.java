import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Archivos.crearArchivo_Y_Carpeta();

       System.out.print("¿Cuántas personas deseas guardar? ");
        int cantidadPersonas = scanner.nextInt();
        scanner.nextLine(); // Limpiar el salto de línea

        for (int i = 0; i < cantidadPersonas; i++) {
            System.out.println("Ingrese los datos para la persona " + (i + 1) + ":");

            Persona nuevaPersona = new Persona();
            //nuevaPersona.datosPersona();
            //nuevaPersona.listaPersonas();
            //nuevaPersona.mostrarListaPersonas();
            //Persona.guardarPersonaEnArchivo(nuevaPersona);
            nuevaPersona.encontrarPersona();

        }

    }
}
