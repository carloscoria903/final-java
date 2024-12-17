public enum FormaDePago {
    EFECTIVO("Efectivo"),
    TARJETA_DEBITO("Tarjeta De Debito"),
    TARJETA_CREDITO("Tarjeta De Credito"),
    TRANSFERENCIA("Transferencia"),
    CUENTA_CORRIENTE("Cuenta Corriente");

    private final String descripcion;

    FormaDePago(String descripcion){
        this.descripcion = descripcion;
    }

    private String  optenerFormaDePago(){
        return descripcion;
    }
    public static FormaDePago fromInt(int opcion) throws Excepciones {
        if (opcion < 1 || opcion > values().length) {
            throw new Excepciones("opcion invalida. elija un numero entre 1 y " + values().length + ".");
        }
        return values()[opcion - 1];
    }
}