import java.time.LocalDate;
import java.util.ArrayList;

public class Usuario extends Persona{
    private String usuario;
    private String clave;
    private Persona propietario;

    public Usuario(int dni, boolean activo, String nombres, String apellidos, String telefono, String direccion, Provincia provincia, String localidad, LocalDate fechaNacimiento, Sexo sexo, String usuario, Persona propietario, String clave) {
        super();
        this.usuario = usuario;
        this.propietario = propietario;
        this.clave = clave;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Persona getPropietario() {
        return propietario;
    }

    public void setPropietario(Persona propietario) {
        this.propietario = propietario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    //metodos personales ususario
    public Usuario altaUsuario(){
        return null;
    }

    public void bajaUsuario(){

    }

    public void modifiacarUsuario(){

    }

    public Usuario buscarUsuario(){
        return null;
    }

    public ArrayList<Usuario> listaUsuario(){
        return null;
    }

}
