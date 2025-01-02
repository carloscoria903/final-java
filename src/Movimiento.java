import java.util.ArrayList;
import java.util.Scanner;

public class Movimiento {
    private int codigo;
    private String detalle;
    private double montoDebe;
    private double montoHaber;
    private double saldo;

    public Movimiento(int codigo, String detalle, double montoDebe, double montoHaber, double saldo) {
        this.codigo = codigo;
        this.detalle = detalle;
        this.montoDebe = montoDebe;
        this.montoHaber = montoHaber;
        this.saldo = saldo;
    }

    public Movimiento(){

    }

    private static ArrayList<Movimiento>listaMovimiento = new ArrayList<>();

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public double getMontoDebe() {
        return montoDebe;
    }

    public void setMontoDebe(double montoDebe) {
        this.montoDebe = montoDebe;
    }

    public double getMontoHaber() {
        return montoHaber;
    }

    public void setMontoHaber(double montoHaber) {
        this.montoHaber = montoHaber;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    //metodos personales de movimiento

    public Movimiento busquedaMovimiento(int codigo){
        for (Movimiento movimiento : listaMovimiento){
            if (movimiento.getCodigo() == codigo){
                return movimiento;
            }
        }
        return null;
    }

    public Movimiento altaMovimiento(){
        Scanner entrada = new Scanner(System.in);

        int codigo = Excepciones.castearEntero("ingrese el codigo de movimiento: ");

        Movimiento movimientoExistente = busquedaMovimiento(codigo);
        if (movimientoExistente != null){
            System.out.println("el movimineto " + codigo + "ya existe: ");
            System.out.println("desea crear un nuevo movimiento?? (si / no): ");
            String respuesta = entrada.nextLine();
            if (respuesta.equalsIgnoreCase("no")){
                System.out.println("movimiento no creado: ");
                return null;
            }
        }

        System.out.println("detalles del movimineto");
        String detalle = entrada.nextLine();
        double montoDebe = Excepciones.castearDecimal("ingrese el monto del debe: ");
        double montoHaber = Excepciones.castearDecimal("ingrese el monto del haber: ");
        double saldo = Excepciones.castearDecimal("ingrese el saldo: ");

        Movimiento nuevoMovimiento = new Movimiento(codigo,detalle,montoDebe,montoHaber,saldo);
        listaMovimiento.add(nuevoMovimiento);
        System.out.println("movimiento creado con exito");

        return nuevoMovimiento;
    }

    public void modificarMovimiento(){
        Scanner entrada = new Scanner(System.in);
        int codigo = Excepciones.castearEntero("ingrese el codigo del movimiento: ");
        Movimiento movimientoExistente = null;
        for (Movimiento movimiento : listaMovimiento) {
            if (movimiento.getCodigo() == codigo) {
                movimientoExistente = movimiento;
                break;
            }
        }
        if (movimientoExistente == null) {
            System.out.println("no se encontro el movimiento con el codigo ingresado ");
            return;
        } System.out.print("ingrese el nuevo detalle del movimiento: ");
        String detalle = entrada.nextLine();
        double montoDebe = Excepciones.castearDecimal("ingrese el nuevo monto debe: ");
        double montoHaber = Excepciones.castearDecimal("ingrese el nuevo monto haber: ");
        double saldo = Excepciones.castearDecimal("ingrese el nuevo saldo: ");
        movimientoExistente.setDetalle(detalle);
        movimientoExistente.setMontoDebe(montoDebe);
        movimientoExistente.setMontoHaber(montoHaber);
        movimientoExistente.setSaldo(saldo);
        System.out.println("movimiento modificado con exito");
    }

    public void bajaMovimiento(){
        Scanner entrada = new Scanner(System.in);
        int codigo = Excepciones.castearEntero("ingrese el codigo del movimiento a eliminar: ");
        Movimiento movimientoExistente = null;
        for (Movimiento movimiento : listaMovimiento){
            if (movimiento.getCodigo() == codigo){
                movimientoExistente = movimiento;
                break;
            }
        }
        if (movimientoExistente == null) {
            System.out.println("no se encontro el movimiento con el codigo ingresado.");
            return;
        }
        listaMovimiento.remove(movimientoExistente);
        System.out.println("movimiento eliminado");
    }

    public void menuMovimiento(){
        Scanner entrada = new Scanner(System.in);
        int opcion;
        boolean salir = false;

        do {
            System.out.println("1- crear un movimiento: ");
            System.out.println("2- modificar un movimiento: ");
            System.out.println("3- dar de baja un movimiento: ");
            System.out.println("4- salir");
            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion){
                case 1:
                    altaMovimiento();
                    break;
                case 2:
                    modificarMovimiento();
                    break;
                case 3:
                    bajaMovimiento();
                    break;
                case 4:
                    salir = true;
                    System.out.println("saliendo del sistema");
                    break;
                default:
                    System.out.println("opcion incorrecta");
                    return;
            }

        }while(! salir);

    }
}