import java.time.LocalDate;

public class Proveedor extends Persona{

    private CuentaCorriente ctacte;

    public Proveedor(int dni, boolean activo, String nombres, String apellidos, String telefono, String direccion, Provincia provincia, String localidad, LocalDate fechaNacimiento, Sexo sexo, CuentaCorriente ctacte) {
        super(dni, activo, nombres, apellidos, telefono, direccion,
                provincia, localidad, fechaNacimiento, sexo);
        this.ctacte = ctacte;
    }

    public Proveedor(){

    }//constructor vacio.

    public CuentaCorriente getCtacte() {
        return ctacte;
    }

    public void setCtacte(CuentaCorriente ctacte) {
        this.ctacte = ctacte;
    }

    //metodo personal proveedor

    public void verCuentaCorriente(){
        if (ctacte == null){
            System.out.println("proveedor no tiene una cuanta corriente: ");
            return;
        }

        System.out.println("moviminetos de la cuanta corriente: ");
        for (Movimiento movimiento : ctacte.getMovimientos()){
            System.out.println("codigo: " + movimiento.getCodigo());
            System.out.println("detalle: " + movimiento.getDetalle());
            System.out.println("monto debe: " + movimiento.getMontoDebe());
            System.out.println("monto haber: " + movimiento.getMontoHaber());
            System.out.println("saldo: " + movimiento.getSaldo());
        }

        double saldoActual = ctacte.obtenerSaldo();
        System.out.println("saldo actual: " + saldoActual);
    }
}