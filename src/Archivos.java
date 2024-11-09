import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Archivos {

    public static void crearArchivo_Y_Carpeta() {
        String carpeta = "C:\\Projectos en java\\Final-java-projecto-1\\CarpetaDeArchivo\\";
        String archivo = "Archivo1.txt";

        File crearCarpeta = new File(carpeta);
        File crearArchivo = new File(carpeta + archivo);

        if (crearArchivo.exists()) {
            JOptionPane.showMessageDialog(null, "El archivo ya existe.");
        } else {
            JOptionPane.showMessageDialog(null, "El archivo no existe pero será creado.");
            crearCarpeta.mkdir();
            try {
                if (!crearArchivo.createNewFile()) {
                    JOptionPane.showMessageDialog(null, "Archivo no creado.");
                } else {
                    JOptionPane.showMessageDialog(null, "Archivo creado.");
                }
            } catch (IOException ex) {
                Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}