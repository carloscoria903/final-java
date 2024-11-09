import java.util.ArrayList;

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
    public Producto altaProducto(){
        return null;
    }

    public void bajaProducto(){

    }

    public void modificarProducto(){

    }

    public ArrayList<Producto> listaProducto(){
        return null;
    }

    public Producto busquedaProducto(){
        return null;
    }

    public void verDetalleProducto(){
    }


}
