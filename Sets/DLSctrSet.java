/*
PROYECTO FINAL ESTRUCTURA DE DATOS
Equipo: Claudia Alajbeg, Ana Sofía Ceballos, Irene Escudero y Heidi Fabián Martínez
Clase doblemente entrelazada dentro de la funcionalidad de Set
*/
package Sets;
import java.util.Iterator;
import java.util.Random;
import DblyLnkSctr.*;
import ADTsException.*;

/**
 *DLSctrqueue representa un Set implementado usando una estructura doblemente entrelazada.
 * @author emili
 */
public class DLSctrSet <T> implements SetADT<T>, Iterable<T>  {
 
    /**
     * Creamos una estructura doblemente entrelazada para almacenar  los datos de la fila.
     * También creamos un elemento aleatorio.
     */
    private static Random rand = new Random();
    private DblyLnkSctr<T> set;
    
    
    //Constructor: Crea un conjunto vacío para almacenar los datos
    public DLSctrSet() {
        set = new DblyLnkSctr<T>();
    }

    /**
     * El elemento se agregará al conjunto mientras el elemento no este repetido.
     * @param element es el elemento que se agregará al conjunto.
     * @throws ADTsException si element es null.
     */
    public void add(T element) throws ADTsException {
        if( element==null ) 
            throw new ADTsException("Sets.ArraySet.add(): element null.\n");

        if (!contains(element)) {      
            //Agrega el elemento.
            set.addLast(element);
        }
    }

    
    /**
     * Agrega todos los elementos de un conjunto a otro conjunto.
     * @param oSet es un conjunto que contiene los datos a almacenar en  otro conjunto.
     * 
     * @throws ADTsException si el conjunto es null.
     */
    public void addAll(SetADT<T> oSet) throws ADTsException {
        if( oSet==null ) 
            throw new ADTsException("Sets.ArraySet.addAll(): oSet null.\n");

        Iterator<T> iter= oSet.iterator();
        T element;

        while (iter.hasNext()) {
            element = iter.next();
            this.add(element);
        }
    }
    /**
     * Remueve un elemento de un Set/Conjunto.
     * @param element es el elemento a remover.
     * @return el elemento eliminado.
     * @throws ADTsException si el elemento es null o el conjunto esta vació.
     */
    public T remove (T element) throws ADTsException {
        if( element==null ) 
            throw new ADTsException("Sets.ArraySet.remove(): element null.\n");
        
         if (set.isEmpty())
            throw new ADTsException("Sets.ArraySet.remove(): Empty Set.\n");

        boolean found = false;   // Not found
        T result=null;
        T current;
        
        Iterator<T> iter= set.iterator();
        DblyLnkSctr<T> aux = new DblyLnkSctr<>();

       
        while (iter.hasNext()){
            current = iter.next();
            
        
            if(!found && current.equals(element)){
            found = true;
            result = current; 
            
            }else{
            aux.addLast(current); 
            } 
        }
        if (!found)
            throw new ADTsException("Sets.ArraySet.remove(): Not Found.\n");
        set  = aux;
        return result;
    }
/**
 * Remueve un elemento aleatorio del conjunto.
 * @return el elemento que se eliminó.
 * @throws ADTsException si el conjunto esta vació.
 */
    public T removeRandom() throws ADTsException {
         if (set.isEmpty())
            throw new ADTsException("Sets.ArraySet.removeRandom(): Empty Set.\n");
        
        T result = null;
        int size = set.size();
        Iterator<T> iter= set.iterator();
        DblyLnkSctr<T> aux = new DblyLnkSctr<>();
        // GENERA UN INDICE ALEATORIO 
        int index = rand.nextInt(size);
        int current = 0;
        
        while(iter.hasNext()){
            T element = iter.next();
            if(current == index){
                result = element;
            }else{
                aux.addLast(element);
            }
            current++;
        }
        set = aux;
        return result;
    }
    
   /**
    * Realiza una unión entre 2 conjuntos de forma iterativa.
    * @param oSet es el conjunto con el cual vamos a realizar
    * la unión con el conjunto this/actual.
    * @return el conjunto resultante de la unión.
    * @throws ADTsException si el otro conjunto (el que pide el método) es null.
    */
    public SetADT<T> union (SetADT<T> oSet) throws ADTsException {
        if( oSet==null ) throw new
                ADTsException("Sets.ArraySet.union(): oSet null.\n");

        DLSctrSet<T> result= new DLSctrSet<T>();    
        Iterator<T> iter= this.iterator();
        T element;
        while ( iter.hasNext() ) {
            element = iter.next();
            result.add(element);
        }

        iter= oSet.iterator();
        while( iter.hasNext() ) {
            element = iter.next();
            result.add(element);
        }
        
        return result;
    }

    /**
     * El método combina los elementos de 2 conjuntos de manera recursiva.
     * @param oSet es el conjunto con el cual vamos a realizar
     * la unión con el conjunto this/actual.
     * @return el conjunto resultante de la unión.
     */
    public SetADT<T> unionRv(SetADT<T> oSet) {
        if( oSet==null ) throw new
                ADTsException("Sets.ArraySet.unionRv(): oSet null.\n");
        DLSctrSet<T> unionSet = new DLSctrSet();
    
        unionRv( this.iterator(), oSet.iterator(), unionSet );
        
        return unionSet;
    }
  
   /**Metodo privado que realiza la unión de 2 conjuntos de manera recursiva.
    * 
    * @param iterth Ierador que recorre los elementos del conjunto principal.
    * @param iteros Iterador que recorre los elementos del conjunto externo(oSet).
    * @param unse Conjunto resultante en donde se alamcenan los elementos combinados de ambos conjuntos.
    */
    private void unionRv(Iterator<T> iterth, Iterator<T> iteros, DLSctrSet<T> unse) {

        if ( iterth.hasNext() || iteros.hasNext() ) {
            if ( iterth.hasNext() )
                unse.add( iterth.next() );
            if ( iteros.hasNext() )
                unse.add( iteros.next() );
            unionRv( iterth, iteros, unse );
        }
    }

    /**
     * Realiza una intersección de 2 conjuntos de manera iterativa.
     * Es decir, regresa solo los elementos comunes a ambos conjuntos.
     * @param oSet es el conjunto externo(oSet) con el que se 
     * realizará la intersección.
     * @return conjunto resultante de la intersección.
     * @throws ADTsException si el conjunto externo(oSet) es null.
     */
    public SetADT<T> intersection(SetADT<T> oSet) throws ADTsException {
        if( oSet==null ) 
            throw new ADTsException("Sets.ArraySet.intersection(): oSet null.\n");

        DLSctrSet<T> result= new DLSctrSet<T>();
        //TO-DO
        Iterator<T> iter= this.iterator();
        T element;

        while (iter.hasNext()) {
            element= iter.next();
            if ( oSet.contains(element) )
                result.add(element);
        }

        return result;
    }

    /**Resulta la intersección de 2 conjuntos de manera recursiva
     * Es decir, regresa solo los elementos comunes a ambos conjuntos
     * @param oSet es el conjunto con el cual vamos a realizar
     * la intersección con el conjunto this/actual.
     * @return regresa el conjunto resultante de la intersección.
     */ 
    public SetADT<T> intersectionRv(SetADT<T> oSet) {
        if( oSet==null ) 
            throw new ADTsException("Sets.ArraySet.intersectionRv(): oSet null.\n");

        DLSctrSet<T> result= new DLSctrSet();
    
        intersectionRv(this.iterator(), oSet, result);

        return result;
    }

    /**
     * Metodo privado que realiza la intersección de 2 conjuntos de manera recursiva.
     * @param thisIter Iterador del conjunto actual this que 
     * permite recorrer los elementos.
     * @param oSet Conjunto contra el que se compara para realizar la intersección.
     * @param interSet Conjunto en el que se almacenan los elementos 
     * comunes entre los 2 conjuntos.
     */
    private void intersectionRv(Iterator<T> thisIter, SetADT<T> oSet, 
            DLSctrSet<T> interSet) {
        T temp;
    
        if (thisIter.hasNext()) {
            temp= thisIter.next();
            if (oSet.contains(temp))
                interSet.add(temp);
            intersectionRv(thisIter, oSet, interSet);
        }
    }
  
   /**Realiza la diferencia entre 2 conjuntos.
    * La diferencia es una operación que regresa los elementos que están
    * en el primer conjunto pero no en el segundo.
    * @param oSet es el conjunto con el cual se calculará la diferencia
    * @return el resultado de la diferencia entre 2 conjuntos.
    * @throws ADTsException si Oset es null.
    */
    public SetADT<T> difference(SetADT<T> oSet) throws ADTsException {
        if( oSet==null ) 
            throw new ADTsException("Sets.ArraySet.difference(): oSet null.\n");

        DLSctrSet<T> result= new DLSctrSet<T>();
        //TO-DO
        Iterator<T> iter = this.iterator();
        T element;

        while (iter.hasNext()) {
            element = iter.next();
            if ( !oSet.contains(element) )
                result.add(element);
        }

        return result;    
    }


    /**
     * Regresa la diferencia de los 2 conjuntos de manera recursiva.
     * La diferencia es una operación que regresa los elementos que están
     * en el primer conjunto pero no en el segundo.
     * @param oSet es el conjunto con el cual se calculará la diferencia.
     * @return el resultado de la diferencia entre ambos conjuntos.
     */
    public SetADT<T> differenceRv(SetADT<T> oSet) {
        if( oSet==null ) 
            throw new ADTsException("Sets.ArraySet.intersectionRv(): oSet null.\n");

        DLSctrSet<T> result= new DLSctrSet();
    
        differenceRv(this.iterator(), oSet, result);

        return result;
    }

    /**
     * Método privado que realiza la diferencia de 2 conjuntos de manera recursiva.
     * @param thisIter es iterador del conjunto actual.
     * @param oSet es el conjunto , cuyos elementos serán excluidos de la diferencia.
     * @param interSet es el conjunto que almacenará los elementos resultantes de la diferencia.
     */
    private void differenceRv(Iterator<T> thisIter, SetADT<T> oSet, 
        DLSctrSet<T> interSet) {
        T temp;
    
        if (thisIter.hasNext()) {
            temp= thisIter.next();
            if (!oSet.contains(temp))
                interSet.add(temp);
            differenceRv(thisIter, oSet, interSet);
        }
    }
      
    /**
     * Verifica si el conjunto contiene un elemento específico
     * @param element es el elemento a buscar.
     * @return un boolean que regresa true si se encontró el elemento y false si no.
     * @throws ADTsException si elemento a buscar es null.
     */
    public boolean contains (T element) throws ADTsException {
        if( element==null ) 
            throw new ADTsException("Sets.ArraySet.contains(): element null.\n");
       return set.contains(element); 
    }
    
    /**
     * Método que verifica s 2 conjuntos son iguales.
     * @param oSet es el conjunto que se va a comparar con el conjunto actual(this).
     * @return un boolean, si ambos conjuntos son iguales, 
     * false si sucede lo contrario.
     * @throws ADTsException si el Oset es null.
     */
    public boolean equals (SetADT<T> oSet) throws ADTsException {
        if( oSet==null ) 
            throw new ADTsException("Sets.ArraySet.equals(): oSet null.\n");

        boolean identical= false;
        DLSctrSet<T> thisSet= new DLSctrSet<T>();
        T elem;
        
        
        if ( this.size() == oSet.size() )  {
            thisSet.addAll(this);    
            Iterator<T> oIter= oSet.iterator();    
            while ( oIter.hasNext() ) {
                elem= oIter.next();   
                if ( thisSet.contains(elem) ) {
                    thisSet.remove(elem);
                }
            }
            identical = thisSet.isEmpty();
        }
        return identical;  
    }
    /**
     * Método que verfica si un conjunto es vació.
     * @return un boolean, true si el conjunto es vacío  y false si el conjunto no es vacío.
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }
    /**
     * Método que regresa el tamaño del  conjunto.
     * @return el tamaño del conjunto.
     */
    public int size() {
        return set.size();
    }
    /**
     * EL método permite la instancia de un iterador que permite acceder a cada elemento almacenado.
     * @return devuelve un iterador para recorrer los elementos del conjunto.
     */
    public Iterator<T> iterator() {
        return set.iterator();
    }
    /**
     * Regresa una representación de la cola en forma String.
     * @return la representación de la cola.
     */
    public String toString() {
        String result = "SET-" + set.toStringRecursivo();
        return result;
    }
}
