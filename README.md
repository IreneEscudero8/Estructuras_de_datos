# Proyecto Final - Estructura de Datos

**Asignatura:** Estructura de Datos  
**Profesor:** José Ramón Ríos Sánchez  
**Institución:** Instituto Tecnológico Autónomo de México  
**Fecha de entrega:** 6 de diciembre de 2024

## Integrantes

- Irene Escudero Cázarez   
- Heidi Fabián Martínez  
- Claudia Emilia Alajbeg  
- Ana Sofía Ceballos Martínez  

---

## 🧩 Descripción del Proyecto

Este proyecto implementa estructuras de datos fundamentales usando listas doblemente enlazadas, tanto de forma iterativa como recursiva, para demostrar eficiencia y comprensión en su aplicación. Se reescribieron clases Set y Queue eliminando el uso de arreglos y utilizando listas dinámicas.

---

## 🗂️ Estructura del Proyecto
```
📁 src/
├── DblyLnkSctr/
│   └── DblyLnkSctr.java         # Implementación de lista doblemente enlazada con métodos recursivos
├── Sets/
│   ├── DLSctrSet.java           # Implementación del TAD Set sobre listas doblemente enlazadas
│   ├── DLSctrSetTest.java       # Pruebas unitarias JUnit 4 para DLSctrSet
│   └── MainSets.java            # Clase Main para probar funcionalidades de DLSctrSet
├── Queues/
│   ├── DLSctrQueue.java         # Implementación del TAD Queue con listas doblemente enlazadas
|   ├── DLSctrQueueTest.java     # Pruebas unitarias JUnit 4 para DLSctrQueue
│   └── MainQueues.java          # Clase Main para probar funcionalidades de DLSctrQueue
├── ADTsException/
│   └── ADTsException.java       # Clase personalizada para manejo de excepciones
```
---

## 📦 Clases y Métodos Principales

### 🔸 `DblyLnkSctr<T>`
Lista doblemente enlazada genérica.
- `addFirst(T elem)`: Agrega un nodo al frente.
- `addLast(T elem)`: Agrega un nodo al final.
- `removeFirst() / removeLast()`: Elimina el primer/último nodo.
- `findRecursivo(T elem)`: Busca un nodo con recursividad.
- `toStringRecursivo()`: Retorna una cadena con los elementos usando recursión.

### 🔸 `DLSctrSet<T>`
Implementación del TAD Set con `DblyLnkSctr`.
- `add(T element)`: Añade si no existe.
- `addAll(SetADT<T>)`: Añade todos los elementos de otro conjunto.
- `remove(T element)`: Elimina un elemento específico.
- `removeRandom()`: Elimina un elemento aleatorio.
- `union(...) / unionRv(...)`: Unión iterativa o recursiva.
- `intersection(...) / intersectionRv(...)`: Intersección.
- `difference(...) / differenceRv(...)`: Diferencia.
- `equals(SetADT<T>)`: Compara si dos sets son iguales.
- `contains(T element)`: Verifica existencia.
- `toString()`: Devuelve la representación como string.

### 🔸 `DLSctrQueue<T>`
Implementación del TAD Queue.
- `enqueue(T elem)`: Agrega al final de la cola.
- `dequeue()`: Elimina y devuelve el primer elemento.
- `first() / last()`: Devuelve el primero/último sin eliminar.
- `isEmpty() / size()`: Verifica si está vacía y su tamaño.
- `toString()`: Representación textual recursiva.

---

## 🧪 Pruebas con JUnit 4

Archivo de pruebas:
- `Sets/DLSctrSetTest.java`
- `Queues/DLSctrQueueTest.java`

Incluyen pruebas de:
- Inserción y eliminación
- Métodos con excepciones (nulls, vacíos)
- Métodos recursivos (`unionRv`, `differenceRv`, etc.)
- Comparación de estructuras (`equals`)
- Representación de texto (`toString`)
- Iteradores (`iterator`)
- Elementos aleatorios (`removeRandom`)

Para ejecutarlas:

```
javac -cp .:junit-4.13.2.jar:hamcrest-core-1.3.jar */*.java
java -cp .:junit-4.13.2.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore Sets.DLSctrSetTest
```

---

## ✅ Requisitos para correr el proyecto

- Java 8+
- JUnit 4 (`junit-4.13.2.jar`, `hamcrest-core-1.3.jar`)
- Sistema de archivos compatible con los paquetes:
  
DblyLnkSctr/
Sets/
Queues/
ADTsException/

---
## 📚 Referencia

- José Ramón Ríos Sánchez. (2024). *DL Sctr Stack* [Código fuente].

---

## 🧠 Conclusiones

- Se demostró la aplicabilidad y eficiencia de listas doblemente enlazadas.
- Las versiones recursivas ofrecen soluciones limpias y eficientes.
- Las pruebas unitarias fueron clave para validar comportamiento correcto.

