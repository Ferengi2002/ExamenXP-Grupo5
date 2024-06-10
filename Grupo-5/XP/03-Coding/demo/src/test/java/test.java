
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import com.example.Archivo;
import com.example.Cuenta;

public class test {

    // Iteración 1
    @Test
    public void testCreatePasswordAuto() {

        Cuenta cuenta1 = new Cuenta("Facebook", "1234");
        String passwordInicial = cuenta1.getContraseña();
        String passwordGenerada = cuenta1.generarContraseña();
        assertNotEquals(passwordInicial, passwordGenerada);
    }

    @Test
    public void testCreatePasswordManually() {
        Cuenta cuenta1 = new Cuenta("Facebook", "contrasena123");
        String passwordInicial = cuenta1.getContraseña();
        assertEquals("contrasena123", passwordInicial);
    }

    // Iteracion 2
    @Test
    public void testShowAllPasswords() {
        // Ruta temporal para el archivo de prueba
        String rutaArchivoPrueba = "src/test/java/contrasena_prueba.txt";
        // Obtener la ruta absoluta del archivo de prueba
        String rutaAbsoluta = Paths.get(rutaArchivoPrueba).toAbsolutePath().toString();

        try {
            // Crear un gestor de contraseñas con el archivo de prueba
            Archivo manager = new Archivo(rutaAbsoluta);

            // Crear algunas contraseñas para el gestor (solo para propósitos de prueba)
            Cuenta cuenta1 = new Cuenta("Sitio1", "Password1");
            Cuenta cuenta2 = new Cuenta("Sitio2", "Password2");
            Cuenta cuenta3 = new Cuenta("Sitio3", "Password3");

            // Guardar las contraseñas en el archivo
            manager.guardarArchivo(cuenta1);
            manager.guardarArchivo(cuenta2);
            manager.guardarArchivo(cuenta3);

            // Obtener la lista de todas las contraseñas leyendo el archivo
            List<Cuenta> allPasswords = manager.getLista();
            manager.leerArchivo();
            // Verificar que la lista contiene las contraseñas esperadas
            assertTrue(allPasswords.contains(cuenta1));
            assertTrue(allPasswords.contains(cuenta2));
            assertTrue(allPasswords.contains(cuenta3));
            // Eliminar el archivo de prueba después de la prueba
            File archivoPrueba = new File(rutaArchivoPrueba);
            archivoPrueba.delete();

        } catch (Exception e) {
            e.printStackTrace();
            fail("Excepción inesperada: " + e.getMessage());
        }
    }

    @Test
    public void testActualizarArchivo() throws IOException {
        // Ruta temporal para el archivo de prueba
        String rutaArchivoPrueba = "src/test/java/contrasena_prueba.txt";

        // Obtener la ruta absoluta del archivo de prueba
        String rutaAbsoluta = Paths.get(rutaArchivoPrueba).toAbsolutePath().toString();

        // Crear un gestor de contraseñas con el archivo de prueba
        Archivo manager = new Archivo(rutaAbsoluta);

        // Crear algunas contraseñas para el gestor (solo para propósitos de prueba)
        Cuenta cuenta1 = new Cuenta("Sitio1", "Password1");
        Cuenta cuenta2 = new Cuenta("Sitio2", "Password2");
        Cuenta cuenta3 = new Cuenta("Sitio3", "Password3");

        // Guardar las contraseñas en el archivo
        manager.guardarArchivo(cuenta1);
        manager.guardarArchivo(cuenta2);
        manager.guardarArchivo(cuenta3);

        // Actualizar la contraseña para el Sitio2
        String nuevoPasswordSitio2 = "NuevaPassword2";
        manager.actualizarArchivo("Sitio2", nuevoPasswordSitio2);
        manager.leerArchivo();
        // Verificar que la contraseña se haya actualizado correctamente
        assertTrue(contraseñaActualizadaCorrectamente(rutaAbsoluta, "Sitio2", nuevoPasswordSitio2));
        // Eliminar el archivo de prueba después de la prueba
        File archivoPrueba = new File(rutaArchivoPrueba);
        archivoPrueba.delete();
    }

    // Método para verificar que la contraseña se haya actualizado correctamente
    private boolean contraseñaActualizadaCorrectamente(String rutaArchivo, String sitioWeb, String nuevaContraseña)
            throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(": ");
                if (partes.length == 2 && partes[0].equalsIgnoreCase(sitioWeb)) {
                    return partes[1].equals(nuevaContraseña);
                }
            }
        }
        return false;
    }
    
     //Iteracion 3
    @Test
    public void testDeletePassword() throws IOException{
        // Ruta temporal para el archivo de prueba
        String rutaArchivoPrueba = "src/test/java/contrasena_prueba.txt";

        // Obtener la ruta absoluta del archivo de prueba
        String rutaAbsoluta = Paths.get(rutaArchivoPrueba).toAbsolutePath().toString();

        // Crear un gestor de contraseñas con el archivo de prueba
        Archivo manager = new Archivo(rutaAbsoluta);

         // Crear algunas contraseñas para el gestor (solo para propósitos de prueba)
         Cuenta cuenta1 = new Cuenta("Sitio1", "Password1");
         Cuenta cuenta2 = new Cuenta("Sitio2", "Password2");
         Cuenta cuenta3 = new Cuenta("Sitio3", "Password3");
         // Guardar las contraseñas en el archivo
        manager.guardarArchivo(cuenta1);
        manager.guardarArchivo(cuenta2);
        manager.guardarArchivo(cuenta3);

        // Eliminar la cuenta para el Sitio2
        manager.eliminarCuenta("Sitio2");
        manager.leerArchivo();
        // Verificar que la cuenta se haya eliminado correctamente
        assertFalse(contieneCuenta(rutaAbsoluta, "Sitio2"));

        // Eliminar el archivo de prueba después de la prueba
        File archivoPrueba = new File(rutaArchivoPrueba);
        archivoPrueba.delete();
    }
     // Método para verificar si el archivo contiene una cuenta específica
     private boolean contieneCuenta(String rutaArchivo, String sitioWeb) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(": ");
                if (partes.length == 2 && partes[0].equalsIgnoreCase(sitioWeb)) {
                    return true;
                }
            }
        }
        return false;
    }
}
