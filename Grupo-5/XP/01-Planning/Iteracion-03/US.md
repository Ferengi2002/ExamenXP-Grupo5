# Historias de Usuario 

<br>

| Campo | Descripción |
|-------|-------------|
| **ID de Historia** | US001 |
| **Nombre de la Historia** | Creacion de contraseñas |
| **Descripción** | Como usuario, quiero poder agregar nuevas contraseñas asociadas a sitios específicos, permitiendo la generacion automática de contraseñas seguras o la creacion de contraseñas personalizadas |
| **Rol del Usuario** | Usario |
| **Objetivo** | Permitir a los usuarios generar y guardar nuevas contraseñas asociadas a sitios especificos |
| **Iteración Asignada** | 1 |
| **Prioridad en Negocio** | Alta |
| **Riesgo en Desarrollo** | Media |
| **Puntos Estimados** | 1 hora |
| **Puntos Reales** | 1 hora 30 minutos |
| **Beneficio Comercial** | Facilitar a los usuarios la gestion segura de sus contraseñas |
| **Requisitos Previos** | Ninguno |
| **Criterios de Aceptación** | Los usuarios pueden agregar contraseñas asociadas a sitios. <br> - La aplicación ofrece la opción de generar contraseñas seguras automáticamente o permite al usuario crear una personalizada. <br> -Las contraseñas deben tener un mínimo de 8 caracteres de longitud. |
| **Notas Técnicas** | La generación automática de contraseñas debe seguir estándares de seguridad robustos. |
| **Historial de Cambios** | Fecha: 2024-06-09 <br> Autor: Lenin Rodriguez |

| Campo | Descripción |
|-------|-------------|
| **ID de Historia** | US002 |
| **Nombre de la Historia** | Visualización de Contraseñas |
| **Descripción** | Como usuario, deseo ver una lista organizada de sitios y contraseñas almacenadas de manera clara y sencilla. |
| **Rol del Usuario** | Usuario |
| **Objetivo** | Facilitar a los usuarios la visualización de sus contraseñas almacenadas de forma legible. |
| **Iteración Asignada** | 2 |
| **Prioridad en Negocio** | Alta |
| **Riesgo en Desarrollo** | Baja |
| **Puntos Estimados** | 30 minutos |
| **Puntos Reales** | 30 minutos |
| **Beneficio Comercial** | Mejorar la usabilidad del gestor de contraseñas. |
| **Requisitos Previos** |  Creación de contraseñas implementada |
| **Criterios de Aceptación** |  Los usuarios pueden ver una lista organizada de sitios y contraseñas almacenadas. <br> - La visualización de contraseñas es clara y fácil de entender. |
| **Notas Técnicas** | No perder la seguridad de las contraseñas en ningun momento |
| **Historial de Cambios** | Fecha: 2024-06-09 <br> Autor: Lenin Rodriguez |

| Campo | Descripción |
|-------|-------------|
| **ID de Historia** | US003 |
| **Nombre de la Historia** | Actualización de Contraseñas |
| **Descripción** | Como usuario, quiero poder actualizar mis contraseñas existentes, ya sea generando nuevas contraseñas automáticamente o ingresando actualizaciones personalizadas. |
| **Rol del Usuario** | Usuario |
| **Objetivo** | Permitir a los usuarios modificar sus contraseñas existentes según sus necesidades. |
| **Iteración Asignada** | 2 |
| **Prioridad en Negocio** | Alta |
| **Riesgo en Desarrollo** | Medio |
| **Puntos Estimados** | 1 hora |
| **Puntos Reales** | 3 horas |
| **Beneficio Comercial** | Mejorar la seguridad y flexibilidad de las contraseñas almacenadas. |
| **Requisitos Previos** | Creación de contraseñas implementada |
| **Criterios de Aceptación** |  Los usuarios pueden actualizar sus contraseñas existentes. <br> - La actualización puede ser automática o personalizada. |
| **Notas Técnicas** | La actualización debe ser sencilla y falcil de entender para el usuario |
| **Historial de Cambios** | Fecha: 2024-06-09 <br> Autor: Lenin Rodriguez |

| Campo | Descripción |
|-------|-------------|
| **ID de Historia** | US004 |
| **Nombre de la Historia** | Borrado de Contraseñas |
| **Descripción** | Como usuario, necesito la opción de eliminar contraseñas cuando ya no sean necesarias, evitando eliminaciones accidentales. |
| **Rol del Usuario** | Usuario |
| **Objetivo** | Proporcionar a los usuarios una forma segura de eliminar contraseñas obsoletas o innecesarias. |
| **Iteración Asignada** | 3 |
| **Prioridad en Negocio** | Media |
| **Riesgo en Desarrollo** | Baja |
| **Puntos Estimados** | 30 minutos |
| **Puntos Reales** | |
| **Beneficio Comercial** | Mejorar la gestión y seguridad de las contraseñas almacenadas. |
| **Requisitos Previos** | Mejorar la gestión y seguridad de las contraseñas almacenadas. |
| **Criterios de Aceptación** | - Los usuarios pueden eliminar contraseñas de la lista. <br> - Se requiere confirmación antes de la eliminación para prevenir accidentes. |
| **Notas Técnicas** | Ninguna |
| **Historial de Cambios** | Fecha: 2024-06-09 <br> Autor: Lenin Rodriguez |

| Campo | Descripción |
|-------|-------------|
| **ID de Historia** | US005 |
| **Nombre de la Historia** | Persistencia y formato de almacenamiento |
| **Descripción** | Como usuario, deseo que las contraseñas se almacenen de manera segura en archivos locales utilizando un sistema de cifrado para proteger la información sensible. Además, quiero que cada entrada en el gestor de contraseñas se guarde en un formato claro y legible, facilitando la lectura y búsqueda de contraseñas. |
| **Rol del Usuario** | Usuario |
| **Objetivo** | Asegurar la integridad y seguridad de las contraseñas almacenadas y optimizar la accesibilidad y búsqueda de las mismas. |
| **Iteración Asignada** | 1 |
| **Prioridad en Negocio** | Alta |
| **Riesgo en Desarrollo** | Alto |
| **Puntos Estimados** | 1 hora |
| **Puntos Reales** | 1 hora 30 minutos |
| **Beneficio Comercial** | Incrementar la confianza de los usuarios en la seguridad de la aplicación y mejorar la usabilidad y eficiencia del gestor de contraseñas. |
| **Requisitos Previos** | Actualización y Borrado de contraseñas implementados |
| **Criterios de Aceptación** | - Las contraseñas se almacenan de manera segura en archivos locales con un sistema de cifrado. <br> - Cada entrada se guarda en el formato "SITIO DE CONTRASEÑA: CONTRASEÑA" para facilitar su lectura y búsqueda. |
| **Notas Técnicas** | La información de las contraseñas debe ser segura, legible y fácil de entender para el usuario. |
| **Historial de Cambios** | Fecha: 2024-06-09 <br> Autor: Lenin Rodriguez |
