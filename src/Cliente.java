import java.time.LocalDate;

public class Cliente extends Persona{

    private CuentaCorriente ctacte;

    public Cliente(int dni, boolean activo, String nombres, String apellidos, String telefono, String direccion, Provincia provincia, String localidad, LocalDate fechaNacimiento, Sexo sexo, CuentaCorriente ctacte) {
        super();
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

    }
}
