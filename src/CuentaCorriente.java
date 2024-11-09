import java.util.ArrayList;

public class CuentaCorriente {

    private ArrayList<Movimiento> movimientos = new ArrayList<>();

    public CuentaCorriente(ArrayList<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }

    public ArrayList<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMobimientos(ArrayList<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }

    //metodos personales de ctacte
    public void agregarMobimientos (Movimiento movimiento){
        movimientos.add(movimiento);
    }

    public void actualizarSaldo(Movimiento movimientos){

    }

    public double optenerSaldo(){
        double saldo = 0.0;

        return saldo;
    }

}
