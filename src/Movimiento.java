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
        return null;
    }

    public void modificarMovimiento(){

    }

    public void bajaMovimiento(){

    }

}
