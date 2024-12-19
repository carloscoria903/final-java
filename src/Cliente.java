import java.time.LocalDate;

public class Cliente extends Persona{

    private CuentaCorriente ctacte;

    public Cliente(int dni, boolean activo, String nombres, String apellidos, String telefono, String direccion, Provincia provincia, String localidad, LocalDate fechaNacimiento, Sexo sexo, CuentaCorriente ctacte) {
        super(dni, activo, nombres, apellidos, telefono, direccion,
                provincia, localidad, fechaNacimiento, sexo);
        this.ctacte = ctacte;
    }

    public CuentaCorriente getCtacte() {
        return ctacte;
    }

    public void setCtacte(CuentaCorriente ctacte) {
        this.ctacte = ctacte;
    }

    //metodos personales de clientes
    public void verCuentaCorriente(){
        if (ctacte == null){
            System.out.println("el cliente no tiene una cuenta corriente: ");
            return;
        }
        System.out.println("movimientos de la caunta corriente: ");
        for (Movimiento movimiento : ctacte.getMovimientos()){
            System.out.println("codigo: " + movimiento.getCodigo());
            System.out.println("detalle: " + movimiento.getDetalle());
            System.out.println("monto debe: " + movimiento.getMontoDebe());
            System.out.println("monto haber: " + movimiento.getMontoHaber());
            System.out.println("saldo: " + movimiento.getSaldo());
        }
        double saldoActual = ctacte.optenerSaldo();
        System.out.println("saldo actual: " + saldoActual);
    }
}
