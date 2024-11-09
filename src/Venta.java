import java.util.ArrayList;

public class Venta {
    private int codigo;
    private Cliente cliente;
    private int cantidad;
    private Producto producto; //limite de 10 productos
    private double total;
    private FormaDePago pago;

    public Venta(int codigo, Cliente cliente, int cantidad, Producto producto, double total, FormaDePago pago) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.cantidad = cantidad;
        this.producto = producto;
        this.total = total;
        this.pago = pago;
    }

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

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
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
    public Venta altaVenta(){
        return null;
    }

    public void bajaDeVenta(){

    }

    public void modificarVenta(){

    }

    public ArrayList<Venta> listaDeVentas(){
        return null;
    }

    public Venta busquedaDeVentas(){
        return null;
    }

    public void verDetalleDeVenta(){

    }


}
