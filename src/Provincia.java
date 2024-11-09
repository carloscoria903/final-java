public enum Provincia {
 BUENOS_AIRES ("BUENOS AIRES"),
 CATAMARCA("CATAMARCA"),
 CHACO("CHACO"),
 CHUBUT("CHUBUT"),
 CORDOBA("CORDOBA"),
 CORRIENTES("CORRIENTE"),
 ENTRE_RIOS("ENTRE_RIOS"),
 FORMOSA("FORMOSA"),
 JUJUY("JUJUY"),
 LA_PAMPA("LA PAMPA"),
 LA_RIOJA("LA RIOJA"),
 MENDOZA("MENDOZA"),
 NEUQUEN("NEUQUEN"),
 RIO_NEGRO("RIO NEGRO"),
 SALTA("SALTA"),
 SAN_JUAN("SAN JUAN"),
 SAN_LUIS("SAN LUIS"),
 SANTA_FE("SANTA FE"),
 SANTIAGO_DEL_ESTERO("SANTIAGO DEL ESTERO"),
 TIERRA_DEL_FUEGO("TIERRA DEL FUEGO"),
 TUCUMAN("TUCUMAN");


 private String descripcionProvincia;

       Provincia(String descripcionProvincia){
          this.descripcionProvincia = descripcionProvincia;
       }

      public String optenerProvincia(){
        return descripcionProvincia;
       }
}

