public enum Provincia {
 BUENOS_AIRES ("Buenos Aires"),
 CATAMARCA("Catamarca"),
 CHACO("Chaco"),
 CHUBUT("Chubut"),
 CORDOBA("Cordoba"),
 CORRIENTES("Corriente"),
 ENTRE_RIOS("Entre Rios"),
 FORMOSA("Formosa"),
 JUJUY("Jujuy"),
 LA_PAMPA("La Pampa"),
 LA_RIOJA("La Rioja"),
 MENDOZA("Mendoza"),
 NEUQUEN("Neuquen"),
 RIO_NEGRO("Rio Negro"),
 SALTA("Salta"),
 SAN_JUAN("San Juan"),
 SAN_LUIS("San Luis"),
 SANTA_FE("Santa Fe"),
 SANTIAGO_DEL_ESTERO("Santiago Del Estero"),
 TIERRA_DEL_FUEGO("Tierra Del Fego"),
 TUCUMAN("Tucuman");

 private String descripcionProvincia;

       Provincia(String descripcionProvincia){
          this.descripcionProvincia = descripcionProvincia;
       }

      public String obtenerProvincia(){
        return descripcionProvincia;
       }

      public static Provincia fromInt(int opcion) throws Excepciones {

       if (opcion < 1 || opcion > values().length) {
        throw new Excepciones("opcion invalida. por favor elija un numero entre 1 y " + values().length + ".");
       }
       return values()[opcion - 1];
      }
      
}