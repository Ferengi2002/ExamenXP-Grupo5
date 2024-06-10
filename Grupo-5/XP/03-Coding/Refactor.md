

 * Clase principal para el gestor de contraseñas.

```
public class Main {

    public static void main(String[] args) {

        Archivo archivo = new Archivo("Grupo-01/XP/03-Coding/demo/src/main/java/com/example/contraseña.txt");
        Scanner scanner = new Scanner(System.in);
        String sitioWeb, clave;
        int opcion;

        do {
            mostrarMenu();
            System.out.print(" Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir la nueva línea pendiente

            switch (opcion) {
                case 1:
                    Cuenta cuenta = new Cuenta();
                    System.out.println("Ingresa el sitio web: ");
                    sitioWeb = scanner.nextLine();
                    cuenta.setSitioWeb(sitioWeb);
                    System.out.println("Ingresa la contraseña: ");
                    clave = scanner.nextLine();
                    cuenta.setContraseña(clave);
                    archivo.guardarArchivo(cuenta);
                    break;
                case 2:
                    Cuenta cuenta1 = new Cuenta();
                    System.out.println("Ingresa el sitio web: ");
                    sitioWeb = scanner.nextLine();
                    cuenta1.setSitioWeb(sitioWeb);
                    clave = cuenta1.generarContraseña();
                    cuenta1.setContraseña(clave);
                    archivo.guardarArchivo(cuenta1);
                    break;
                case 3:
                    archivo.leerArchivo();
                    break;
                case 4:
                    Cuenta cuenta2 = new Cuenta();
                    System.out.println("Ingresa el sitio web: ");
                    sitioWeb = scanner.nextLine();
                    cuenta2.setSitioWeb(sitioWeb);
                    System.out.println("Ingresa la contraseña: ");
                    clave = scanner.nextLine();
                    cuenta2.setContraseña(clave);
                    archivo.actualizarArchivo(cuenta2.getSitioWeb(), clave);
                    break;
                case 5:
                    System.out.println("Ingresa el sitio web: ");
                    sitioWeb = scanner.nextLine();
                    archivo.eliminarCuenta(sitioWeb);
                    break;
                case 6:
                    System.out.println("Finalizado");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción válida.");
            }

        } while (opcion != 6);
        scanner.close();
    }

    /**
     * Muestra el menú de opciones en la consola.
     */
    public static void mostrarMenu() {
        System.out.println("========== Gestor de contraseñas =========");
        System.out.println("1. Crear contraseña personalizada");
        System.out.println("2. Crear contraseña automática");
        System.out.println("3. Mostrar todo");
        System.out.println("4. Actualizar");
        System.out.println("5. Eliminar");
        System.out.println("6. Salir");
        System.out.println("==========================================");
    }
}
```



 * Clase para manejar operaciones con el archivo de contraseñas.
 ```
public class Archivo {
    private String rutaArchivo;
    private List<Cuenta> lista = new ArrayList<>();

    public Archivo(String rutaDelArchivo) {
        this.rutaArchivo = rutaDelArchivo;
    }

    public List<Cuenta> getLista() {
        return lista;
    }

    public void leerArchivo() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            lista = new ArrayList<>();

            while ((linea = bufferedReader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void guardarArchivo(Cuenta cuenta) {
        lista.add(cuenta);
        try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(rutaArchivo, true)))) {
            printWriter.println(cuenta.getSitioWeb().toUpperCase() + ": " + cuenta.getContraseña());
            System.out.println("Contraseña guardada");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void actualizarArchivo(String sitioWeb, String nuevaContraseña) {
        boolean encontrado = false;
        File archivo = new File(rutaArchivo);
        File archivoTemporal = new File(rutaArchivo + ".tmp");

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(archivo));
             PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(archivoTemporal, true)))) {

            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                String[] partes = linea.split(": ");
                if (partes.length == 2 && partes[0].equalsIgnoreCase(sitioWeb)) {
                    encontrado = true;
                    printWriter.println(sitioWeb.toUpperCase() + ": " + nuevaContraseña);
                } else {
                    printWriter.println(linea);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!encontrado) {
            System.out.println("¡Sitio web no encontrado!");
        } else {
            archivo.delete();
            archivoTemporal.renameTo(archivo);
            System.out.println("Contraseña actualizada para el sitio web: " + sitioWeb);
        }
    }

    public void eliminarCuenta(String sitioWeb) {
        File archivo = new File(rutaArchivo);
        File archivoTemporal = new File(rutaArchivo + ".tmp");

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(archivo));
             PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(archivoTemporal, true)))) {

            boolean eliminado = false;
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                String[] partes = linea.split(": ");
                if (partes.length == 2 && partes[0].equalsIgnoreCase(sitioWeb)) {
                    eliminado = true;
                    System.out.println("Cuenta eliminada para el sitio web: " + sitioWeb);
                } else {
                    printWriter.println(linea);
                }
            }

            if (!eliminado) {
                System.out.println("No se encontró la cuenta para el sitio web: " + sitioWeb);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        archivo.delete();
        archivoTemporal.renameTo(archivo);
    }
}
```




 * Clase para representar una cuenta con un sitio web y una contraseña.
```

public class Cuenta {
    private String sitioWeb;
    private String contraseña;

    public Cuenta() {
    }

    public Cuenta(String sitioWeb, String contraseña) {
        this.sitioWeb = sitioWeb;
        this.contraseña = contraseña;
    }

    public String getSitioWeb() {
        return sitioWeb;
    }

    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String generarContraseña() {
        final int longitud = 10;
        String caracteresMayusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String caracteresMinusculas = "abcdefghijklmnopqrstuvwxyz";
        String numeros = "0123456789";
        String simbolosEspeciales = "!@#$%^&*()=+[]{}|'<>/?";

        String caracteresTotales = caracteresMayusculas + caracteresMinusculas + numeros +
```