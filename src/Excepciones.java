import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class Excepciones extends Exception {
    public Excepciones(String mensaje) {
        super(mensaje);
    }

    public static boolean verificarEntero(String numero) {
        try {
            Integer.parseInt(numero);
            return true;
        } catch (NumberFormatException error) {
            System.out.println("error: " + error.getMessage());
            return false;
        }
    }

    public static boolean verificarDecimal(String numero) {
        try {
            Double.parseDouble(numero);
            return true;
        } catch (NumberFormatException error) {
            System.out.println("error: " + error.getMessage());
            return false;
        }
    }

    public static LocalDate crearFecha(String mensaje) {
        System.out.println(mensaje);
        int diaAux = castearEntero("ingrese el dia: ");
        int mesAux = castearEntero("ingrese el mes: ");
        int anioAux = castearEntero("ingrese el año: ");

        try {
            return LocalDate.of(anioAux, mesAux, diaAux);
        } catch (DateTimeException e) {
            System.out.println("se usara fecha actual por defecto.");
            return LocalDate.now();
        }
    }

    public static int castearEntero(String mensaje) {
        int num = 0;
        boolean flag = true;
        Scanner entrada = new Scanner(System.in);

        do {
            System.out.print(mensaje);
            String dato = entrada.nextLine();
            if (verificarEntero(dato)) {
                num = Integer.parseInt(dato);
                flag = true;
            } else {
                flag = false;
                System.out.println("verifique el dato ingresado.");
            }
        } while (!flag);

        return num;
    }

    public static double castearDecimal(String mensaje) {
        double num = 0;
        boolean flag = true;
        Scanner entradaTeclado = new Scanner(System.in);

        do {
            System.out.print(mensaje);
            String dato = entradaTeclado.nextLine();
            if (verificarDecimal(dato)) {
                num = Double.parseDouble(dato);
                flag = true;
            } else {
                flag = false;
                System.out.println("verifique el dato ingresado.");
            }
        } while (!flag);

        return num;
    }

    public static boolean verificarClave(String clave){
        if (clave.length() < 8){
            System.out.println("error, la clave debe tener al menos 8 caracteres: ");
            return false;
        }
        boolean tieneMayuscula = false;
        for (char c: clave.toCharArray()){
            if (Character.isUpperCase(c)){
                tieneMayuscula = true;
                break;
            }
        }
        if (!tieneMayuscula){
            System.out.println("error, la clave debe tener una mayuscula por lo menos: ");
            return false;
        }
        return true;
    }

    public static boolean verificarUsuario(String usuario){
        if (usuario.length() < 8){
            System.out.println("error, el usuario debe tener al menos 8 caracteres: ");
            return false;
        }
        return true;
    }
}