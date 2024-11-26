public enum Sexo {
    MASCULINO("Masculino"),
    FEMENINO("Femenino"),
    OTRO("Otro");

    private final String descripcionSexo;

    Sexo(String descripcionSexo){
        this.descripcionSexo = descripcionSexo;
    }

    public String optenerSexo(){
        return descripcionSexo;
    }

    public static Sexo fromInt(int opcion) throws Excepciones {
        if (opcion < 1 || opcion > values().length) {
            throw new Excepciones("opcion invalida. elija un numero entre 1 y " + values().length + ".");
        }
        return values()[opcion - 1];
    }

}
