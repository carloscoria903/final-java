import java.util.ArrayList;
import java.util.Scanner;

public class Producto {
    private int codigo;
    private String detalle;
    private double precio;
    private String marca;
    private String material;
    private Categoria categoria;
    private int stock;

    public Producto(int codigo, String detalle, double precio, String marca, String material, Categoria categoria, int stock) {
        this.codigo = codigo;
        this.detalle = detalle;
        this.precio = precio;
        this.marca = marca;
        this.material = material;
        this.categoria = categoria;
        this.stock = stock;
    }

    public Producto(){

    }

    private static ArrayList<Producto> listaProducto = new ArrayList<>();

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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    //metodos personales para producto

    public Producto busquedaProducto(int codigo){
        for (Producto producto : listaProducto){
            if (producto.getCodigo() == codigo) {
                return producto;
            }
        }
        System.out.println("producto no encontrado.");
        return null;
    }

    public Producto altaProducto(){
        Scanner entrada = new Scanner(System.in);

        int codigo = Excepciones.castearEntero("ingrese el coigo del producto: ");

        Producto productoExistente = busquedaProducto(codigo);
        if (productoExistente != null){
            System.out.println("el producto " + codigo + "ya existe ");
            System.out.println(productoExistente.getDetalle());
        }

        System.out.println("detalle del producto: ");
        String detalle = entrada.nextLine();
        double precio = Excepciones.castearDecimal("ingrese el precio del producto: ");
        System.out.println("ingrese la marca del producto: ");
        String marca = entrada.nextLine();
        System.out.println("ingrese el material del producto: ");
        String material = entrada.nextLine();
        System.out.println("seleccione la categoria del producto: ");
        Categoria[] categorias = Categoria.values();
        Categoria categoria = null;
        boolean flag = false;
        do {
            for (int i = 0; i < categorias.length; i++) {
                System.out.println((i + 1) + ". " + categorias[i].obtenerCategoria());
            }
            int opcion = Excepciones.castearEntero("elija una opcion: ");
            if (opcion >= 1 && opcion <= categorias.length) {
                categoria = categorias[opcion - 1];
                flag = true;
            }
            else { System.out.println("intente nuevamente.");
            }
        } while (!flag);

        int stock = Excepciones.castearEntero("ingrese el stock del producto: ");

        Producto nuevoProducto = new Producto(codigo,detalle,precio,marca,material,categoria,stock);
        listaProducto.add(nuevoProducto);
        System.out.println("producto creado con exito");
        return nuevoProducto;
    }

    public void bajaProducto(){

        int codigo = Excepciones.castearEntero("ingrese el codigo del producto: ");
        Producto productoExistente = busquedaProducto(codigo);
        if (productoExistente == null){
            return;
        }
        listaProducto.remove(productoExistente);
        System.out.println("el producto se elimino");
    }

    public void modificarProducto(){

        int codigo = Excepciones.castearEntero("ingrese el codigo del producto: ");
        Producto productoExistente = busquedaProducto(codigo);
        if (productoExistente == null){
            return;
        }
        Scanner entrada = new Scanner(System.in);

        int opciones;
        do {
            System.out.println("producto encontrado: ");
            System.out.println("1- detalle: " + getDetalle());
            System.out.println("2- precio: " + getPrecio());
            System.out.println("3- marca: " + getMarca());
            System.out.println("4- material: " + getMaterial());
            System.out.println("5- categoria: " + getCategoria());
            System.out.println("6- stock: " + getStock());
            opciones = entrada.nextInt();
            entrada.nextLine();

            switch (opciones){

                case 1:
                    System.out.println("ingrese el nuevo detalle del producto: ");
                    String detalle = entrada.nextLine();
                    break;
                case 2:
                    double precio = Excepciones.castearDecimal("ingrese el nuevo precio: ");
                    break;
                case 3:
                    System.out.println("ingrese la nueva marca del producto: ");
                    String marca = entrada.nextLine();
                    break;
                case 4:
                    System.out.println("ingrese el material del producto: ");
                    String materia = entrada.nextLine();
                    break;
                case 5:
                    System.out.println("seleccione la categoria del producto: ");

                    Categoria[] categorias = Categoria.values();
                    Categoria categoria = null;
                    boolean flag = false;
                    do {
                        for (int i = 0; i < categorias.length; i++) {
                            System.out.println((i + 1) + ". " + categorias[i].obtenerCategoria());
                        }
                        int opcion = Excepciones.castearEntero("elija una opcion: ");
                        if (opcion >= 1 && opcion <= categorias.length) {
                            categoria = categorias[opcion - 1];
                            flag = true;
                        }
                        else { System.out.println("intente nuevamente.");
                        }
                    } while (!flag);
                    break;
                case 6:
                    int stock = Excepciones.castearEntero("ingrese el nuevo stock del producto: ");
                default:
                    System.out.println("opcion no valida.");


            }
        } while(opciones != 6);

        productoExistente.setDetalle(detalle);
        productoExistente.setPrecio(precio);
        productoExistente.setMarca(marca);
        productoExistente.setMaterial(material);
        productoExistente.setCategoria(categoria);
        productoExistente.setStock(stock);

        System.out.println("producto modificado con exito");
    }

    public void verDetalleProducto(){
        if (listaProducto.isEmpty()){
            System.out.println("no existe producto registrado");
        } else {
            System.out.println("lista de producto: ");
            for (Producto producto : listaProducto){
                System.out.println("detalle: " + producto.getDetalle());
                System.out.println("precio: " + producto.getPrecio());
                System.out.println("marca: " + producto.getMarca());
                System.out.println("material: " + producto.getMaterial());
                System.out.println("categoria: " + producto.getCategoria().obtenerCategoria());
                System.out.println("stoct: " + producto.getStock());
            }
        }
    }
}