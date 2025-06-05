/*
PROYECTO FINAL ESTRUCTURA DE DATOS
Equipo: Claudia Alajbeg, Ana Sofía Ceballos, Irene Escudero y Heidi Fabián Martínez
Clase con  estructura Doblemente entrelazada dentro de la funcionalidad de Queue
*/
package Queues;
import ADTsException.ADTsException;
import DblyLnkSctr.DblyLnkSctr;

/** DLSctrQueue representa una cola implementada usando una estructura doblemente entrelazada.
  */
public class DLSctrQueue<T> implements QueueADT<T> {
   
  
     /**Creamos una estructura doblemente entrelazada para almacenar los datos de la cola.
       */
     private DblyLnkSctr<T> queue;
     
    
     /**Constructor: Crea una cola vacía para almacenar los datos. 
      * 
      */
    public DLSctrQueue() {
        queue=new DblyLnkSctr<T>();
        
    }
  
    /**Element se agregará al final de la  cola. 
     * 
     * @param element pide el elemento a encolar.
     * @throws ADTsException si el elemento es null
     */
    public void enqueue(T element) {
    if ( element == null )
        throw new ADTsException("(enqueue) element null.\n");
        queue.addLast(element);
    }
  
    /**Remueve y regresa el elemento al inicio de la cola. 
     * 
     * @return regresa el primer elemento de la cola 
     * @throws ADTsException si la cola esta vacía,
     */               
    public T dequeue() throws ADTsException {
        if ( isEmpty() )
            throw new ADTsException("Q-VACIA-dequeue.\n");
        
        return  queue.removeFirst();
    }
  
    /**Regresa el primer elemento al inicio de la cola sin removerlo.
     * 
     * @return regresa el primer elemento de la cola.
     * @throws ADTsException si la cola esta vacía.
     */
    public T first() throws ADTsException {
        if ( this.isEmpty() )
            throw new ADTsException("Q-VACIA-first.\n");

        return queue.first();
    }
  
    /** Regresa verdadero si la cola esta vacía y falso si tiene algún elemento.
     */
    public boolean isEmpty() {
        return queue.isEmpty();
    }
   
    /**  Regresa el número de elementos en la cola.
     */
    public int size() {
        return queue.size();
    }
  
    /**  Regresa una representación de la cola en forma String.
     *   Regresa isEmpty si la cola esta vacía.
     */
    public String toString() {
        String cade="Queue-"+ queue.toStringRecursivo();
        return cade;
    }
    
    /**  Regresa el último elemento agregado a la cola sin removerlo.
     * 
     */
    public T last() {
        if ( this.isEmpty() )
            throw new ADTsException("Q-VACIA-last().\n");
        return queue.last();
             
    }
}//class
