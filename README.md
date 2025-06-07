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

**Paso 4:** En otra terminal ejecutar en la terminal donde esta el cliente.

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

 ## Muestra de resultados.


 .
