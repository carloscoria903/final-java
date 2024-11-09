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
}
