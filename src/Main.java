import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //String rutaCarpeta = "C:\\Projectos en java\\Final-java-projecto-1\\CarpetaDeArchivo\\";
        //String rutaArchivo = rutaCarpeta + "Archivo1.txt";
        //crear la carpeta
        //Archivos.crearCarpeta(rutaCarpeta);
        //crear el archivo dentro de esa carpeta
        //Archivos.crearArchivoTXT(rutaArchivo);

        Persona persona = new Persona();
        Empleado empleado = new Empleado();
        Usuario usuario = new Usuario();
        Producto producto = new Producto();
        Venta venta = new Venta();
        Movimiento movimiento = new Movimiento();
        Scanner entrada = new Scanner(System.in);
        boolean salir = false;
        do {
            System.out.println("menu de opciones");
            System.out.println("1- menu de persona: ");
            System.out.println("2- menu de empleado: ");
            System.out.println("3- menu de usuarios: ");
            System.out.println("4- menu de producto: ");
            System.out.println("5- menu de ventas: ");
            System.out.println("6- menu moviminetos: ");
            System.out.println("7- salir");
            int opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion){
                case 1:
                    persona.menuPersona();
                    break;
                case 2:
                    empleado.menuEmpleado();
                    break;
                case 3:
                    usuario.menuDeUsuario();
                    break;
                case 4:
                    producto.menuProducto();
                    break;
                case 5:
                    venta.menuVenta();
                    break;
                case 6:
                    movimiento.menuMovimiento();
                    break;
                case 7:
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