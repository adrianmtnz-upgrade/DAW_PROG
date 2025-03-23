# Ejercicio 2: Sistema de Gestión de APIs REST

## Temática
**Consumo de APIs en una aplicación web o móvil.**  

**Tiempo estimado:** 30 minutos.  
**Puntuación:** 4 puntos.  

## Enunciado
En una aplicación de desarrollo web o móvil, se necesita un sistema que permita conectarse a diferentes **APIs** para obtener información. En este caso, se deben implementar dos APIs:

- **ApiGitHub**, que devuelve una lista de repositorios.
- **ApiClima**, que devuelve la temperatura actual.

Se requiere un sistema flexible que permita cambiar entre APIs sin modificar el código principal de la aplicación.

---

## Requisitos

1. **Crea una interfaz `API`** con el método:
   ```java
   String obtenerDatos(); // Debe devolver los datos de la API.
   ```

2. **Implementa las clases `ApiGitHub` y `ApiClima`** que:
   - Implementen la interfaz `API`.
   - Devuelvan información simulada:
     - **ApiGitHub**: `"Repositorios de usuario: repo1, repo2, repo3"`
     - **ApiClima**: `"Temperatura actual: 22°C"`

3. **Crea una clase `ClienteAPI`** que:
   - Contenga un **atributo privado `API api`**.
   - Tenga un método `setAPI(API api)` para asignar la API deseada.
   - Tenga un método `mostrarDatos()`, que imprima los datos obtenidos de la API configurada.

4. **En el método `main()`**:
   - Crea un objeto `ClienteAPI`.
   - Configura primero la **ApiGitHub**, muestra los datos.
   - Cambia a la **ApiClima**, muestra los datos.

---

## Criterios de Evaluación
✔ Implementación correcta de la **interfaz `API`**.  
✔ Uso adecuado de **polimorfismo** al permitir que `ClienteAPI` use distintas APIs sin modificar su código.  
✔ Correcto manejo de **encapsulamiento** en `ClienteAPI`.  
✔ Código modular, claro y funcional.  
