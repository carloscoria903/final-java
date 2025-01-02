import java.util.ArrayList;
import java.util.Scanner;

public class Venta {
    private int codigo;
    private Cliente cliente;
    private int cantidad;
    private Producto[] producto; //limite de 10 productos
    private double total;
    private FormaDePago pago;

    private static ArrayList<Venta> listaDeVentas = new ArrayList<>();

    public Venta(int codigo, Cliente cliente, int cantidad, Producto[] producto, double total, FormaDePago pago) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.cantidad = cantidad;
        this.producto = producto;
        this.total = total;
        this.pago = pago;
    }

    public Venta(){

    }//constructor vacio.

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Producto[] getProducto() {
        return producto;
    }

    public void setProducto(Producto[] producto) {
        this.producto = producto;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public FormaDePago getPago() {
        return pago;
    }

    public void setPago(FormaDePago pago) {
        this.pago = pago;
    }

    //metodos personales de venta

    public Venta busquedaDeVentas(int codigo){
        for (Venta venta : listaDeVentas){
            if (venta.getCodigo() == codigo){
                return venta;
            }
        }
        return null;
    }

    public Venta altaVenta(){
        Scanner entrada = new Scanner(System.in);

        int codigo = Excepciones.castearEntero("ingrese el codigo de la venta: ");

        Venta ventaExistente = busquedaDeVentas(codigo);
        if (ventaExistente != null){
            System.out.println("el codigo ingresado pertenece a la venta " + codigo + " :" );
            System.out.println("quiere crear una nueva venta?? (si /no)");
            String respuesta = entrada.nextLine();
            if (respuesta.equalsIgnoreCase("no")){
                System.out.println("no se creara ninguna venta nueva");
                return null;
            }
        }

        System.out.println("datos del cliente: ");
        Cliente cliente = new Cliente();
        cliente.altaCliente();

        Producto[] productos = new Producto[10];
        int cantidad = 0;
        do {
            System.out.println("ingrese detalle del producto: ");
            productos[cantidad] = new Producto().altaProducto();

            if(cantidad < 10){
                System.out.println("quiere agregar otro producto? (si / no): ");
                String respuesta = entrada.nextLine();
                if (respuesta.equalsIgnoreCase("no")){
                    break;
                }
            }
        }while(cantidad < 10);

            double total = 0;

            for (int j = 0; j < cantidad; j ++) {
                total += productos[j].getPrecio();
            }

        System.out.println("Seleccione la forma de pago: ");
        FormaDePago[] formasDePago = FormaDePago.values();
        for (int i = 0; i < formasDePago.length; i++) {
            System.out.println((i + 1) + ". " + formasDePago[i].optenerFormaDePago());
        }
        int opcionPago = entrada.nextInt();
        entrada.nextLine();
        FormaDePago pago = formasDePago[opcionPago - 1];

        Venta nuevaVenta = new Venta(codigo,cliente,cantidad,producto,total,pago);
        listaDeVentas.add(nuevaVenta);
        System.out.println("venta creada con exito: ");

        return nuevaVenta;
    }

    public void bajaDeVenta(){
        int codigo = Excepciones.castearEntero("ingrese el codigo de la venta");
        Venta ventaExistente = busquedaDeVentas(codigo);
        if (ventaExistente == null){
            System.out.println("la venta no existe: ");
            return;
        }
        listaDeVentas.remove(ventaExistente);
        System.out.println("la venta se elimino con exito: ");
    }

    public void modificarVenta(){
        Scanner entrada = new Scanner(System.in);

        int codigo = Excepciones.castearEntero("ingrese el codigo de la venta: ");
        Venta ventaExistente = busquedaDeVentas(codigo);
        if (ventaExistente == null){
            System.out.println("la venta no existe: ");
            return;
        }

        int opcion;
        boolean salir = false;
        do {
            System.out.println("que quiere modificar de la venta: ");
            System.out.println("1- cantidad de productos (maximo de 10): ");
            System.out.println("2- producto: ");
            System.out.println("3- forma de pago: ");
            System.out.println("4- salir");
            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion){

                case 1:
                    System.out.println("ingrese la cantidad de producto: ");
                    int nuevaCantidad = entrada.nextInt();
                    entrada.nextLine();
                    if (nuevaCantidad < 10){
                        System.out.println("la cantidad permitida es 10 producto: ");
                        return;
                    }
                    ventaExistente.setCantidad(nuevaCantidad);
                    double nuevoTotal = ventaExistente.getTotal() / ventaExistente.getCantidad() * nuevaCantidad;
                    ventaExistente.setTotal(nuevoTotal);
                    break;
                case 2:
                    Producto[] nuevoProductos = new Producto[10];
                    int cantidad = 0;
                    for (int i = 0; i < 10; i++) {
                        System.out.println("ingrese los detalles del producto " + (i + 1) + ":");
                        nuevoProductos[i] = new Producto().altaProducto();
                        cantidad++;
                        System.out.println("quiere agregar otro producto? (si / no): ");
                        String respuesta = entrada.nextLine();
                        if (respuesta.equalsIgnoreCase("no")) {
                            break;
                        }
                    }
                        ventaExistente.setProducto(nuevoProductos);
                        double totalProducto = 0;
                        for (int j = 0; j < cantidad; j ++){
                            totalProducto += nuevoProductos[j].getPrecio();
                        }
                        ventaExistente.setTotal(totalProducto);
                        break;

                case 3:
                    System.out.println("elija la forma de pago: ");
                    FormaDePago[] formaDePago = FormaDePago.values();
                    for (int i = 0; i < formaDePago.length; i++){
                    System.out.println((i+1) + " ." + formaDePago[i].optenerFormaDePago());
                    }

                    int opcionPago = entrada.nextInt();
                    entrada.nextLine();
                    FormaDePago nuevaFormaDePago = formaDePago[opcionPago - 1];
                    ventaExistente.setPago(nuevaFormaDePago);
                    break;

                case 4:
                    salir = true;
                    System.out.println("saliendo del sistema: ");
                    break;

                default:
                    System.out.println("opcion invalida: ");
                    return;
            }
        }while (!salir);

        System.out.println("cambios realizados: ");
    }


    public void verDetalleDeVenta(){
        int codigo = Excepciones.castearEntero("ingrese el codigo de la venta: ");
        Venta ventaExistente = busquedaDeVentas(codigo);
        if (ventaExistente == null){
            System.out.println("no hay venta para mostrar: ");
            return;
        }
        System.out.println("detalle de la venta: ");
        System.out.println("codigo: " + ventaExistente.getCodigo());
        System.out.println("cuenta corriente: " + ventaExistente.getCliente().getNombres());
        Producto[] productos = ventaExistente.getProducto();
        if (productos != null){
            System.out.println("cantidad de producto: " + productos.length);
            for (int i = 0; i < productos.length; i++) {
                if (productos[i] != null){
                    System.out.println("Producto " + (i + 1) + ": " + productos[i].getDetalle() + " - Precio: $" + productos[i].getPrecio());
                }
            }
        }else {
            System.out.println("no hay productos a la venta: ");
        }
        System.out.println("Total: $" + ventaExistente.getTotal());
        System.out.println("Forma de Pago: " + ventaExistente.getPago().optenerFormaDePago());
    }

    public void menuVenta(){

        Scanner entrada = new Scanner(System.in);
        int opcion;
        boolean salir = false;
        do {
            System.out.println("1- crear una venta: ");
            System.out.println("2- eliminar una venta: ");
            System.out.println("3- modificar una venta: ");
            System.out.println("4- ver detalle de una venta: ");
            System.out.println("5- salir");
            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion){

                case 1:
                    altaVenta();
                    break;
                case 2:
                    bajaDeVenta();
                    break;
                case 3:
                    modificarVenta();
                    break;
                case 4:
                    verDetalleDeVenta();
                    break;
                case 5:
                    salir = true;
                    System.out.println("saliendo del sistema..");
                    break;
                default:
                    System.out.println("opcion incorrecta..");
                    return;
            }
        }while(! salir);
    }
}