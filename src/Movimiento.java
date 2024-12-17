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

    private static ArrayList<Movimiento>ListaMovimiento = new ArrayList<>();

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

    public Movimiento altaMovimiento(){
        Scanner entrada = new Scanner(System.in);
        int codigo = Excepciones.castearEntero("ingrese el codigo de movimiento: ");
        System.out.println("detalles del movimineto");
        String detalle = entrada.nextLine();
        double montoDebe = Excepciones.castearDecimal("ingrese el monto del debe: ");
        double montoHaber = Excepciones.castearDecimal("ingrese el monto del haber: ");
        double saldo = Excepciones.castearDecimal("ingrese el saldo: ");

        Movimiento nuevoMovimiento = new Movimiento(codigo,detalle,montoDebe,montoHaber,saldo);
        ListaMovimiento.add(nuevoMovimiento);
        System.out.println("movimiento creado con exito");

        return nuevoMovimiento;
    }

    public void modificarMovimiento(){
        Scanner entrada = new Scanner(System.in);
        int codigo = Excepciones.castearEntero("ingrese el codigo del movimiento: ");
        Movimiento movimientoExistente = null;
        for (Movimiento movimiento : ListaMovimiento) {
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
        System.out.println("Movimiento modificado con éxito");
    }

    public void bajaMovimiento(){
        Scanner entrada = new Scanner(System.in);
        int codigo = Excepciones.castearEntero("ingrese el codigo del movimiento a eliminar: ");
        Movimiento movimientoExistente = null;
        for (Movimiento movimiento : ListaMovimiento){
            if (movimiento.getCodigo() == codigo){
                movimientoExistente = movimiento;
                break;
            }
        }
        if (movimientoExistente == null) {
            System.out.println("no se encontro el movimiento con el codigo ingresado.");
            return;
        }
        ListaMovimiento.remove(movimientoExistente);
        System.out.println("movimiento eliminado");
    }
}