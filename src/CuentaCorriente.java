import java.util.ArrayList;

public class CuentaCorriente {

    private ArrayList<Movimiento> movimientos;

    public CuentaCorriente(ArrayList<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }

    //metodos personales de ctacte

    public void agregarMovimientos (Movimiento movimiento){
        movimientos.add(movimiento);
    }

    public void actualizarSaldo(){
        double saldo = 0.0;
        for (Movimiento movimiento : movimientos){
            saldo += movimiento.getMontoHaber();
            saldo -= movimiento.getMontoDebe();
            movimiento.setSaldo(saldo);
        }
    }

    public double obtenerSaldo(){
        if (movimientos.isEmpty()){
            return 0.0;
        }
        Movimiento ultimoMovimiento = movimientos.get(movimientos.size() - 1);
        return ultimoMovimiento.getSaldo();
    }

    public ArrayList<Movimiento> getMovimientos() {
        return movimientos;
    }
}