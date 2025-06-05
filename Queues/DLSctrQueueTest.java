/*
 PROYECTO FINAL ESTRUCTURA DE DATOS
Equipo: Claudia Alajbeg, Ana Sofía Ceballos, Irene Escudero y Heidi Fabián Martínez 
Test de clase Doblemente entrelazada del Queue
 */
package Queues;

import ADTsException.ADTsException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DLSctrQueueTest {
    
    public DLSctrQueueTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test del metodo enqueue, de la clase DLSctrQueue.
     */
    @Test
    public void testEnqueue() {
        System.out.println("enqueue");
        DLSctrQueue<Integer> instance = new DLSctrQueue();
        instance.enqueue(10);
        instance.enqueue(20);
        assertEquals(2, instance.size()); //Probar actualización de size
        assertEquals((Integer) 10, instance.first()); //Verificar elementos
        assertEquals((Integer) 20, instance.last()); //Verificar elementos
        
        DLSctrQueue<String> instance2 = new DLSctrQueue();
        instance2.enqueue("Hola");
        instance2.enqueue("Estructuras");
        assertEquals(2, instance2.size()); //Probar actualización de size
        assertEquals((String) "Hola", instance2.first()); //Verificar elementos
        assertEquals((String) "Estructuras", instance2.last()); //Verificar elementos
        
    }
    
    
     /**
     * Test del metodo enqueue, elemento null, de la clase DLSctrQueue.
     */
    @Test(expected = ADTsException.class)
    public void testEnqueueThrowsExceptionForNullElement() {
        System.out.println("enqueue elemento null");
        DLSctrQueue instance= new DLSctrQueue();
        instance.enqueue(null); // Esto debe lanzar ADTsException
    }

    /**
     * Test del metodo dequeue, de la clase DLSctrQueue.
     */
    @Test
    public void testDequeue() {
        System.out.println("dequeue");
        DLSctrQueue<Integer> instance = new DLSctrQueue();
        instance.enqueue(10);
        instance.enqueue(20);
        Integer dequeued = instance.dequeue();
        assertEquals((Integer) 10, dequeued); //Verificar que regrese el elemento correcto
        assertEquals(1, instance.size()); ///Verificar actualización  de size
        assertEquals((Integer) 20, instance.first()); //Verificar que lo demás se mantiene igual
        
        DLSctrQueue<String> instance2 = new DLSctrQueue();
        instance2.enqueue("Hola");
        instance2.enqueue("Estructuras");
        String dequeued2 = instance2.dequeue();
        assertEquals((String) "Hola", dequeued2); //Verificar que regrese el elemento correcto
        assertEquals(1, instance2.size()); ///Verificar actualización  de size
        assertEquals((String) "Estructuras", instance2.first()); //Verificar que lo demás se mantiene igual
        
        
    }
    
    /**
     * Test del metodo dequeue, cola null, de la clase DLSctrQueue.
     */
    @Test(expected = ADTsException.class)
    public void testDequeueThrowsExceptionForNullQueue() {
        System.out.println("dequeue cola null");
        DLSctrQueue instance= new DLSctrQueue();
        instance.dequeue(); // Esto debe lanzar ADTsException
    }

    /**
     * Test del metodo first, de la clase DLSctrQueue.
     */
    @Test
    public void testFirst() {
        System.out.println("first");
        DLSctrQueue<Integer> instance = new DLSctrQueue();
        instance.enqueue(10); 
        instance.enqueue(20);
         assertEquals((Integer) 10, instance.first()); //Verificar que 10 sea el primer elemento en la cola
         
         DLSctrQueue<String> instance2 = new DLSctrQueue();
        instance2.enqueue("Hola"); 
        instance2.enqueue("Estructuras");
         assertEquals((String) "Hola", instance2.first()); //Verificar que 10 sea el primer elemento en la cola
    }
    
    /**
     * Test del metodo first, cola null, de la clase DLSctrQueue.
     */
    @Test(expected = ADTsException.class)
    public void testFirstThrowsExceptionForNullQueue() {
        System.out.println("first cola null");
        DLSctrQueue instance= new DLSctrQueue();
        instance.first(); // Esto debe lanzar ADTsException
    }

    /**
     * Test del método empty, de la clase DLSctrQueue.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        DLSctrQueue<Integer> instance = new DLSctrQueue();
        assertTrue(instance.isEmpty());
        instance.enqueue(10);
        assertFalse(instance.isEmpty());
        
        DLSctrQueue<String> instance2 = new DLSctrQueue();
        assertTrue(instance2.isEmpty());
        instance2.enqueue("Hola");
        assertFalse(instance2.isEmpty());
    }

    /**
     * Test of size method, of class DLSctrQueue.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        DLSctrQueue<Integer> instance = new DLSctrQueue();
        assertEquals(0,instance.size()); //Cuando está vacia
        instance.enqueue(10);
        instance.enqueue(20);
        assertEquals(2,instance.size()); //Cuando tiene dos elemento
        
        System.out.println("size");
        DLSctrQueue<String> instance2 = new DLSctrQueue();
        assertEquals(0,instance2.size()); //Cuando está vacia
        instance2.enqueue("Hola");
        instance2.enqueue("Estructuras");
        assertEquals(2,instance2.size()); //Cuando tiene dos elemento
    }

    /**
     * Test of toString method, of class DLSctrQueue.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        DLSctrQueue<Integer> instance = new DLSctrQueue();
        instance.enqueue(10);
        instance.enqueue(20);
        String expResult = "Queue-  {DLS: 2: 10, 20}";
        String result = instance.toString();
        assertEquals(expResult, result);
        
        DLSctrQueue<String> instance2 = new DLSctrQueue();
        instance2.enqueue("Hola");
        instance2.enqueue("Estructuras");
        String expResult2 = "Queue-  {DLS: 2: Hola, Estructuras}";
        String result2 = instance2.toString();
        assertEquals(expResult2, result2);
        
        
    }

    /**
     * Test del metodo last, de la clase DLSctrQueue.
     */
    @Test
    public void testLast() {
        System.out.println("last");
        DLSctrQueue<Integer> instance = new DLSctrQueue();
        instance.enqueue(10); 
        instance.enqueue(20);
        assertEquals((Integer) 20, instance.last()); //Verificar que 20 sea el último elemento en la cola
        
        DLSctrQueue<String> instance2 = new DLSctrQueue();
        instance2.enqueue("Hola"); 
        instance2.enqueue("Estructuras");
        assertEquals((String) "Estructuras", instance2.last()); //Verificar que Estructuras sea el último elemento en la cola
    }
    
    /**
     * Test del metodo last, cola null, de la clase DLSctrQueue.
     */
    @Test(expected = ADTsException.class)
    public void testLastThrowsExceptionForNullQueue() {
        System.out.println("last cola null");
        DLSctrQueue instance= new DLSctrQueue();
        instance.last(); // Esto debe lanzar ADTsException
    }
    
}
