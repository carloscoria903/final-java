import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Usuario extends Persona{
    private String usuario;
    private String clave;
    private Persona propietario;

    public Usuario(int dni, boolean activo, String nombres, String apellidos, String telefono, String direccion, Provincia provincia, String localidad, LocalDate fechaNacimiento, Sexo sexo, String usuario, Persona propietario, String clave) {
        super(dni, activo, nombres, apellidos, telefono, direccion, provincia, localidad, fechaNacimiento, sexo);
        this.usuario = usuario;
        this.propietario = propietario;
        this.clave = clave;
    }

    public Usuario(){

    }

    private static ArrayList<Usuario>listaDeusuarios = new ArrayList<>();

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

    public Usuario buscarUsuario(int dni){
        for (Usuario usuario : listaDeusuarios){
            if (usuario.getDni() == dni){
                return usuario;
            }
        }
        System.out.println("usuario no encontrado");
        return null;
    }

    public Usuario altaUsuario(){

        Scanner entrada = new Scanner(System.in);

        int dni = Excepciones.castearEntero("ingrese el dni: ");
        Persona propietario = buscarPersona(dni);
        if (propietario == null){
            System.out.println("no se encontro el dni, debes crear una persona primero: ");
            return null;
        }

        String nombreUsuario;
        boolean flag = false;
        do {
            System.out.println("ingrese el nombre de ususario: ");
            nombreUsuario = entrada.nextLine();
            if (Excepciones.verificarUsuario(nombreUsuario)){
                flag = true;
            }
        }while (!flag);

        String clave;
        flag = false;
        do {
            System.out.println("ingrese la contraseña: ");
            clave = entrada.nextLine();
            if (Excepciones.verificarClave(clave)){
                flag = true;
            }
        }while (!flag);

        Usuario nuevoUsuario = new Usuario(propietario.getDni(),
                propietario.isActivo(),
                propietario.getNombres(),
                propietario.getApellidos(),
                propietario.getTelefono(),
                propietario.getDireccion(),
                propietario.getProvincia(),
                propietario.getLocalidad(),
                propietario.getFechaNacimiento(),
                propietario.getSexo(),
                nombreUsuario,
                propietario,
                clave);
        listaDeusuarios.add(nuevoUsuario);
        System.out.println("usuario creado con exito: ");
        return nuevoUsuario;
    }

    public void bajaUsuario(){

        int dni = Excepciones.castearEntero("ingrese el dni: ");
        Usuario usuarioExistente = buscarUsuario(dni);
        if (usuarioExistente == null){
            System.out.println("no se encontro el ususrio: ");
            return;
        }
        listaDeusuarios.remove(usuarioExistente);
        System.out.println("usuario eliminado: ");
    }

    public void modifiacarUsuario(){
        Scanner entrada = new Scanner(System.in);
        int opcion;
        boolean salir = false;

        int dni = Excepciones.castearEntero("ingrese el dni: ");
        Usuario usuarioExistente = buscarUsuario(dni);
        if (usuarioExistente == null){
            System.out.println("no se encontro el usuario: ");
            return;
        }
        do {
            System.out.println("usuario encontrado: ");
            System.out.println("1- usuario: ");
            System.out.println("2- clave: ");
            System.out.println("3- salir");
            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion){
                case 1:
                    String usuarioNuevo;
                    boolean flag = false;
                    do {
                        System.out.println("ingrese el nombre de ususario nuevo: ");
                        usuarioNuevo = entrada.nextLine();
                        if (Excepciones.verificarUsuario(usuarioNuevo)){
                            flag = true;
                        }
                    }while (! flag);

                    break;

                case 2:
                    String claveNueva;
                    flag = false;
                    do {
                        System.out.println("ingrese la contraseña: ");
                        claveNueva = entrada.nextLine();
                        if (Excepciones.verificarClave(claveNueva)){
                            flag = true;
                        }
                    }while (! flag);

                    break;

                case 3:
                    salir = true;
                    System.out.println("saliendo del sistema");
                    break;

                default:
                    System.out.println("opcion incorrecta: ");
                    return;
            }
        }while (! salir);
    }

    public void mostrarUsuario(){
        if (listaDeusuarios.isEmpty()){
            System.out.println("no hay usuario para mostrar: ");
        } else {
            for (Usuario usuario : listaDeusuarios){
                System.out.println("nombre: " + usuario.getNombres());
                System.out.println("apellido: " + usuario.getApellidos());
                System.out.println("nombre de usuario: " + usuario.getUsuario());
            }
        }
    }

    public void menuDeUsuario(){

        Scanner entrada = new Scanner(System.in);
        int opcion;
        boolean salir = false;
        do {
            System.out.println("1- crear un usuario: ");
            System.out.println("2- baja de usuario: ");
            System.out.println("3- modificar usuario:");
            System.out.println("4- ver usuario: ");
            System.out.println("5- salir: ");
            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion){

                case 1:
                    altaUsuario();
                    break;
                case 2:
                    bajaUsuario();
                    break;
                case 3:
                    modifiacarUsuario();
                    break;
                case 4:
                     mostrarUsuario();
                     break;
                case 5:
                    salir = true;
                    System.out.println("saliendo del sistema");
                    break;
                default:
                    System.out.println("opcion incorrecta");
                    return;
            }

        }while (! salir);
    }
}
