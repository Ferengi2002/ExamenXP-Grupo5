### Caso de Prueba 5: Prueba eliminar contraseña

**Entradas:**
- Sitio web

**Pasos:**
1. El test genera un archivo temporal (`contrasena_prueba.txt`) para almacenar datos temporales para su posterior actualización.
2. Se guardan sitios web y contraseñas en el archivo temporal.
3. Se crea una nueva contraseña para un sitio web específico.
4. Se elige el sitio web para eliminar la contraseña.
5. Se verifica si la contraseña se ha eliminado correctamente.

**Resultados Esperados:**
- La unidad de prueba es exitosa si:
  - La contraseña del sitio web seleccionado se elimina correctamente en el archivo temporal.
  - Si se elimina la contraseña de manera correcta y se verifica la eliminación.
 
# Cliente

Como cliente, considero que las pruebas realizadas para esta iteración son adecuadas y apruebo su ejecución.
