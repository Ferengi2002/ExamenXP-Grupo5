
### Caso de Prueba 3: Prueba mostrar todas las contraseñas

**Entradas:**
- Ninguna

**Pasos:**
1. El test genera un archivo temporal (`contrasena_prueba.txt`) para almacenar las contraseñas de prueba.
2. Se guardan algunas contraseñas de prueba en el archivo temporal.
3. Se lee el archivo para obtener la lista de todas las contraseñas.
4. Se imprime la lista de contraseñas en la consola para verificar visualmente si se ha creado correctamente.

**Resultados Esperados:**
- La unidad de prueba es exitosa si:
  - Se pueden crear contraseñas en el archivo temporal.
  - La lista de contraseñas obtenida coincide con las contraseñas guardadas.
  - Se imprime correctamente la lista de contraseñas en la consola.

### Caso de Prueba 4: Prueba actualizar contraseña

**Entradas:**
- Sitio Web

**Pasos:**
1. El test genera un archivo temporal (`contrasena_prueba.txt`) para almacenar datos temporales para su posterior actualización.
2. Se guardan sitios web y contraseñas en el archivo temporal.
3. Se crea una nueva contraseña para un sitio web específico.
4. Se elige el sitio web para cambiar la contraseña.
5. Se verifica si la contraseña se ha cambiado correctamente.

**Resultados Esperados:**
- La unidad de prueba es exitosa si:
  - La contraseña del sitio web seleccionado se cambia correctamente en el archivo temporal.
  - Si se actualiza la contraseña de manera correcta y se verifica el cambio.
 
# Cliente

Como cliente, considero que las pruebas realizadas para esta iteración son adecuadas y apruebo su ejecución.
