public enum Categoria {
    INDUMENTARIA("indumentaria"),
    CALZADO("calzado"),
    ACCESORIO("accesorio");

    private final String descripcionCategoria;

    Categoria(String descripcionCategoria) {
        this.descripcionCategoria = descripcionCategoria;
    }

    public String obtenerCategoria() {
        return descripcionCategoria;
    }

    public static Categoria fromInt(int opcion) throws Excepciones {
        if (opcion < 1 || opcion > values().length) {
            throw new Excepciones("opcion invalida. elija un numero entre 1 y " + values().length + ".");
        }
        return values()[opcion - 1];
    }
}