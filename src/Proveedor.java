import java.time.LocalDate;

public class Proveedor extends Persona{

    private CuentaCorriente ctacte;

    public Proveedor(int dni, boolean activo, String nombres, String apellidos, String telefono, String direccion, Provincia provincia, String localidad, LocalDate fechaNacimiento, Sexo sexo, CuentaCorriente ctacte) {
        super();
        this.ctacte = ctacte;
    }

    public CuentaCorriente getCtacte() {
        return ctacte;
    }

    public void setCtacte(CuentaCorriente ctacte) {
        this.ctacte = ctacte;
    }

    //metodo personal proveedor
    public void verCuentaCorriente(){

    }

}
