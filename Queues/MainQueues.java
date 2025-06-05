/*
PROYECTO FINAL ESTRUCTURA DE DATOS
Equipo: Claudia Alajbej, Ana Sofía CeballoS, Irene Escudero y Heidi Fabián Martínez
Clase prueba con  estructura Doblemente entrelazada dentro de la funcionalidad de Queue
*/
package Queues;
import ADTsException.ADTsException;

public class MainQueues {

    public static void main(String[] args) {
        // Creamos elementos de DLSctrQueue.
        DLSctrQueue<Integer> cola= new DLSctrQueue<>();
        DLSctrQueue<String> colaS= new DLSctrQueue<>();
     try{
        
         //Imprimimos la cola de Integers vacia.
         System.out.println("Cola impresa"+ cola.toString());
         //Mete elementos enteros a la cola.
         cola.enqueue(10);
         cola.enqueue(20);
         cola.enqueue(30);
         cola.enqueue(40);
         cola.enqueue(50);
         //Verifica si se agregaron enteros los datos a la cola
         System.out.println("Elementos agregados "+ cola.toString());
         //Quita elementos  enteros de la cola 
         cola.dequeue();
         cola.dequeue();
         //Verifica si se quitaron correctamente los elementos enteros
         System.out.println("Cola despúes de quitar los elementos "+ cola.toString());
         
         //Imprime el primer y el último elemento de la cola de enteros
         System.out.println(" Primer elemento: " + cola.first());
         System.out.println(" Último elemento: " + cola.last());
         
         //Tamaño actual de la cola de enteros
         System.out.println("Tamaño actual de la cola "+ cola.size());
          System.out.println("Tamaño actual de la cola "+ cola.toString());
         //Probamos algunas excepciones
         //Elimina elementos de la cola y checa si marca que la cola esta vacia
         System.out.println(" Vaciando la cola ");
         cola.dequeue(); // Eliminar 30
         cola.dequeue(); // Eliminar 40
         cola.dequeue();
         //Preguntamos si la cola esta vacia.
         System.out.println("   ¿Cola vacía?: " + cola.isEmpty());
         
         System.out.println("Probar excepciones");
         //Checamos el size y el toString de la cola vacía
         System.out.println("probar los elementos de la cola "+ cola.size());
         System.out.println("Imprime los elemntos de la cola vacía "+ cola.toString());
         
         //Volvemos a agregar elementos a la cola
         cola.enqueue(20);
         cola.enqueue(30);
         System.out.println("Elementos de la cola "+ cola.size());
         System.out.println("Imprime la cola "+ cola.toString());
         //Eliminamos de nuevo elementos
         cola.dequeue();
         cola.dequeue();
         //Intentar first y dequeue en una cola vacía
         System.out.println("Devuelve el ultimo elemento "+ cola.last());
         System.out.println("Imprime el primer elemento "+cola.first());
         
         
     }catch(ADTsException e){
         System.out.println("Error" + e.getMessage());
     }  
    
     try{
     //Imprime la cola con datos tipo String
       System.out.println("Cola impresa "+ colaS.toString());
     //Mete elementos String a la cola 
         colaS.enqueue("Hola");
         colaS.enqueue("Claudia");
         colaS.enqueue("Irene");
         colaS.enqueue("Ana");
         colaS.enqueue("Heidi");
      //Verifica si se agregaron los datos String a la cola
         System.out.println("Elementos agregados "+ colaS.toString());
      //Quita elementos String de la cola 
         colaS.dequeue();
         colaS.dequeue();
       //Verifica si se quitaron los elementos String de la cola
       System.out.println("Elementos agregados "+ colaS.toString());
       
       //Imprime el primer y el último elemento de la cola de Strings
         System.out.println(" Primer elemento: " + colaS.first());
         System.out.println(" Último elemento: " + colaS.last());
         
       //Tamaño actual de la cola de Strings 
         System.out.println("Tamaño actual de la cola "+ colaS.size());
       
       //Probamos algunas excepciones
       //Elimina elementos de la cola y checa si marca que la cola esta vacia
         System.out.println("Probar excepciones");
         colaS.dequeue();
         colaS.dequeue(); 
         colaS.dequeue();
         //Preguntamos si la cola esta vacía
         System.out.println("   ¿Cola vacía?: " + colaS.isEmpty());
       
 
         System.out.println("Probar excepciones");
         //Checamos el size y el toString de la cola vacía
         System.out.println("probar los elementos de la cola "+ colaS.size());
         System.out.println("Imprime los elemntos de la cola vacía "+ colaS.toString());
         
         //Volvemos a agregar elementos a la cola
         colaS.enqueue("H");
         colaS.enqueue("C");
         System.out.println("Elementos de la cola "+ colaS.size());
         System.out.println("Imprime la cola "+ colaS.toString());
         //Eliminamos de nuevo elementos
         colaS.dequeue();
         colaS.dequeue();
          //Intentar first y dequeue en una cola vacía
         System.out.println("Devuelve el ultimo elemento "+ colaS.last());
         System.out.println("Imprime el primer elemento "+colaS.first());
         
         
       }catch(ADTsException e){
         System.out.println("Error " + e.getMessage());
     } 
   }
}
