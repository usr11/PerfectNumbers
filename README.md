# Tarea final de numeros perfectos.

**Integrantes:**
- _Manuel Arias_
- _Luis Cadena_
- _Sebastian Jimenez_
- _Juan Pablo Zambrano_

## Descripcion:
En este programa 

## Instrucciones de ejecucion.

**Paso 1:** Construir el proyecto de Gradle con el siguiente comando en la terminal. 

`
./gradlew build
`

**Paso 2:** En otra terminal ejecutar en la terminal donde esta el servidor de los workers.

`
java -jar serverWorker/build/libs/serverWorker.jar  
`

**Paso 3:** En otra terminal ejecutar en la terminal donde esta el servidor del master.

`
java -jar serverMaster/build/libs/serverMaster.jar  
`


**Paso 4:** En otra terminal, ejecutar el cliente con la interfaz gráfica (GUI).

./gradlew :client:run

Una vez abierta la interfaz gráfica:

1. Ingresa el rango de búsqueda:
   - "Start of range": número inicial del rango (ejemplo: 1)
   - "End of range": número final del rango (ejemplo: 10000)

2. (Opcional) Ingresa el número de workers (entre 1 y 20).
   - Si se deja vacío, el sistema asigna los workers automáticamente.

3. Presiona el botón "Find Perfect Numbers".

4. Una vez presionado el boton y si no sale ningun error espere el resultado.

5. En la sección de resultados se mostrará:
   - Los números perfectos encontrados por cada worker.
   - El rango procesado por cada uno.
   - El tiempo individual y total de ejecución.

Si los servidores no están activos o hay error de conexión, se mostrará el mensaje:
"Communication error with ICE: java.net.ConnectException: Connection refused"

Recuerda que todos los servidores deben estar activos antes de iniciar el cliente GUI.

**Paso 5: (Opcional interaccion por consola)** En otra terminal ejecutar en la terminal donde esta el cliente.

`
java -jar client/build/libs/client.jar
`

### Ahora estas en el menu.

**Nuestras opciones son:**

> 1. Para ingresar un rango y que el numero de workers se establezcan.
> 2. Para ingresar un rango y un numero de trabajadores especifico (De 1 a 20).
> 3. Para salir.

- **Opcion 1:**
  - Aqui podras ingresar un rango de numeros enteros para buscar los numeros perfectos en ese rango, el numero de workers sera asignado automaticamente (entre 1 y 10 workers).
- **Opcion 2:**
  - Aqui podras ingresar un rango de numeros enteros para buscar los numeros perfectos en ese rango, ademas tambien podras asignar un numero de workers de manera manual (entre 1 y 20 workers).
- **Opcion 3:**
  - Saldras de nuestro programa.

