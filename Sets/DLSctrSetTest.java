/*
PROYECTO FINAL ESTRUCTURA DE DATOS
Equipo: Claudia Alajbeg, Ana Sofía Ceballos, Irene Escudero y Heidi Fabián Martínez 
Test de clase Doblemente entrelazada del Set}
 */
package Sets;

import ADTsException.ADTsException;
import java.util.Iterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author irene
 */
public class DLSctrSetTest {
    
    public DLSctrSetTest() {
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
     * Test del metodo add, de la clase DLSctrSet.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        DLSctrSet<Integer> instance = new DLSctrSet();
        instance.add(10);
        instance.add(10); //probar que no añada repetidos
        assertEquals(1,instance.size()); //Verificar que solo añadió uno y que modificó size
        
        DLSctrSet<String> instance2 = new DLSctrSet();
        instance2.add("Hola");
        instance2.add("Hola"); //probar que no añada repetidos
        assertEquals(1,instance2.size()); //Verificar que solo añadió uno y que modificó size
    }
    
     /**
     * Test del metodo Add, elemento null, de la clase DLSctrSet.
     */
    @Test(expected = ADTsException.class)
    public void testAddThrowsExceptionForNullElement() {
        System.out.println("add elemento null");
        DLSctrSet instance= new DLSctrSet();
        instance.add(null); // Esto debe lanzar ADTsException
    }

    /**
     * Test del metodo addAll, de la clase DLSctrSet.
     */
    @Test
    public void testAddAll() {
        System.out.println("addAll");
        DLSctrSet<Integer> instance = new DLSctrSet();
        DLSctrSet<Integer> instance2 = new DLSctrSet();
        instance.add(10);
        instance.addAll((SetADT)instance2);//Add un set vacio
        assertEquals(1,instance.size());
        instance.add(20);//Probar un set con elementos previos
        instance2.add(20);//Agregerle repetidos
        instance2.add(30);
        instance.addAll((SetADT)instance2);
        assertEquals(3,instance.size());
        
        DLSctrSet<String> instance3 = new DLSctrSet();
        DLSctrSet<String> instance4 = new DLSctrSet();
        instance3.add("Hola");
        instance3.addAll((SetADT)instance4);//Add un set vacio
        assertEquals(1,instance3.size());
        instance3.add("Estructuras");//Probar un set con elementos previos
        instance4.add("Estructuras");//Agregerle repetidos
        instance4.add("Datos");
        instance3.addAll((SetADT)instance4);
        assertEquals(3,instance3.size());
    }
    
     /**
     * Test del metodo AddAll, Set null, de la clase DLSctrSet.
     */
    @Test(expected = ADTsException.class)
    public void testAddAllThrowsExceptionForNullSet() {
        System.out.println("addAll Set null");
        DLSctrSet instance= new DLSctrSet();
        instance.addAll(null); // Esto debe lanzar ADTsException
    }

    /**
     * Test del metodo Remove, de la clase DLSctrSet.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        DLSctrSet<Integer> instance = new DLSctrSet();
        instance.add(10);
        Object expResult = 10;
        Object result = instance.remove(10);//Eliminar un elemento en el set
        assertEquals(expResult, result); //Verificar que regresó el elemento eliminado
        assertEquals(0,instance.size());//verificar que cambió el size
        
        DLSctrSet<String> instance2= new DLSctrSet();
        instance2.add("Hola");
        Object expResult2 = "Hola";
        Object result2 = instance2.remove("Hola");//Eliminar un elemento en el set
        assertEquals(expResult2, result2); //Verificar que regresó el elemento eliminado
        assertEquals(0,instance2.size());//verificar que cambió el size
    }
    
     /**
     * Test del metodo remove, elemento null, de la clase DLSctrSet.
     */
    @Test(expected = ADTsException.class)
    public void testRemoveThrowsExceptionForNullElement() {
        System.out.println("remove elemento null");
        DLSctrSet<Integer> instance= new DLSctrSet();
        instance.add(10);
        instance.remove(null); // Esto debe lanzar ADTsException
        
        DLSctrSet<String> instance2= new DLSctrSet();
        instance2.add("Hola");
        instance2.remove(null); // Esto debe lanzar ADTsException
    }
    
     /**
     * Test del metodo remove, set vacio, de la clase DLSctrSet.
     */
    @Test(expected = ADTsException.class)
    public void testRemoveThrowsExceptionForEmptySet() {
        System.out.println("remove set vacio");
        DLSctrSet<Integer> instance= new DLSctrSet();
        instance.remove(10); // Esto debe lanzar ADTsException
        
        DLSctrSet<String> instance2= new DLSctrSet();
        instance2.remove("Hola"); // Esto debe lanzar ADTsException
    }
    
    /**
     * Test del metodo remove, elemento no encontrado, de la clase DLSctrSet.
     */
    @Test(expected = ADTsException.class)
    public void testRemoveThrowsExceptionForNotFoundElement() {
        System.out.println("remove elemento no encontrado");
        DLSctrSet<Integer> instance= new DLSctrSet();
        instance.add(10);
        instance.remove(40); // Esto debe lanzar ADTsException
        
        DLSctrSet<String> instance2= new DLSctrSet();
        instance2.add("Hola");
        instance2.remove("Hello"); // Esto debe lanzar ADTsException
    }
    

    /**
     * Test del metodo RemoveRamndom, de la clase DLSctrSet.
     */
    @Test
    public void testRemoveRandom() {
        System.out.println("removeRandom");
        DLSctrSet<Integer> instance = new DLSctrSet();
        instance.add(10);
        instance.add(20);
        Integer result=instance.removeRandom();
        assertEquals(1,instance.size());// Verificar que se modifique size
        assertTrue(10==result||20==result); //Verificar que el resultado sea uno de los anteriores
        
        DLSctrSet<String> instance2 = new DLSctrSet();
        instance2.add("Hola");
        instance2.add("Estructuras");
        String result2=instance2.removeRandom();
        assertEquals(1,instance2.size());// Verificar que se modifique size
        assertTrue("Hola".equals(result2)||"Estructuras".equals(result2)); //Verificar que el resultado sea uno de los anteriores
                
    }
    
    /**
     * Test del metodo removeRandom, set vacio, de la clase DLSctrSet.
     */
    @Test(expected = ADTsException.class)
    public void testRemoveRandomThrowsExceptionForEmptySet() {
        System.out.println("removeRandom set vacio");
        DLSctrSet instance= new DLSctrSet();
        instance.removeRandom(); // Esto debe lanzar ADTsException
    }

    /**
     * Test del metodo Union, de la clase DLSctrSet.
     */
    @Test
    public void testUnion() {
        System.out.println("union");
        DLSctrSet<Integer> instance = new DLSctrSet();
        instance.add(10);
        instance.add(20);
        DLSctrSet<Integer> instance2 = new DLSctrSet();
        instance2.add(30);
        instance2.add(20); //Verificar que no repita elementos
        DLSctrSet<Integer> union=(DLSctrSet<Integer>)instance.union(instance2);
        assertTrue(union.contains(10));//Verificar que tenga todos los elementos
        assertTrue(union.contains(20));
        assertTrue(union.contains(30));
        assertEquals(3,union.size());//Verificar que size se modifique
        
        DLSctrSet<String> instance3 = new DLSctrSet();
        instance3.add("Hola");
        instance3.add("Estructuras");
        DLSctrSet<String> instance4 = new DLSctrSet();
        instance4.add("Datos");
        instance4.add("Estructuras"); //Verificar que no repita elementos
        DLSctrSet<String> union2=(DLSctrSet<String>)instance3.union(instance4);
        assertTrue(union2.contains("Hola"));//Verificar que tenga todos los elementos
        assertTrue(union2.contains("Estructuras"));
        assertTrue(union2.contains("Datos"));
        assertEquals(3,union2.size());//Verificar que size se modifique
    }
    
    /**
     * Test del metodo union, set null, de la clase DLSctrSet.
     */
    @Test(expected = ADTsException.class)
    public void testUnionThrowsExceptionForNullSet() {
        System.out.println("union set null");
        DLSctrSet instance= new DLSctrSet();
        instance.union(null); // Esto debe lanzar ADTsException
    }
    
    /**
     * Test del metodo UnionRv, de la clase DLSctrSet.
     */
    @Test
    public void testUnionRv() {
        System.out.println("unionRv");
        DLSctrSet<Integer> instance = new DLSctrSet();
        instance.add(10);
        instance.add(20);
        DLSctrSet<Integer> instance2 = new DLSctrSet();
        instance2.add(30);
        instance2.add(20); //Verificar que no repita elementos
        DLSctrSet<Integer> union=(DLSctrSet<Integer>)instance.unionRv(instance2);
        assertTrue(union.contains(10));//Verificar que tenga todos los elementos
        assertTrue(union.contains(20));
        assertTrue(union.contains(30));
        assertEquals(3,union.size());//Verificar que size se modifique
        
        DLSctrSet<String> instance3 = new DLSctrSet();
        instance3.add("Hola");
        instance3.add("Estructuras");
        DLSctrSet<String> instance4 = new DLSctrSet();
        instance4.add("Datos");
        instance4.add("Estructuras"); //Verificar que no repita elementos
        DLSctrSet<String> union2=(DLSctrSet<String>)instance3.unionRv(instance4);
        assertTrue(union2.contains("Hola"));//Verificar que tenga todos los elementos
        assertTrue(union2.contains("Estructuras"));
        assertTrue(union2.contains("Datos"));
        assertEquals(3,union2.size());//Verificar que size se modifique
    }
    
    /**
     * Test del metodo unionRv, set null, de la clase DLSctrSet.
     */
    @Test(expected = ADTsException.class)
    public void testUnionRvThrowsExceptionForNullSet() {
        System.out.println("unionRv set null");
        DLSctrSet instance= new DLSctrSet();
        instance.unionRv(null); // Esto debe lanzar ADTsException
    }
    
    /**
     * Test del metodo Intersection, de la clase DLSctrSet.
     */
    @Test
    public void testIntersection() {
        System.out.println("intersection");
        DLSctrSet<Integer> instance = new DLSctrSet();
        instance.add(10);
        instance.add(20);
        DLSctrSet<Integer> instance2 = new DLSctrSet<>();
        instance2.add(20);
        instance2.add(30);
        DLSctrSet<Integer> result = (DLSctrSet<Integer>)instance.intersection(instance2);
        assertTrue(result.contains(20)); //Verificar que tenga los elementos
        assertFalse(result.contains(10)); //Verificar que no tenga los elementros que no se repitan en ambos
        assertFalse(result.contains(30));
        assertEquals(1, result.size()); //Verificar que size se modifique
        
        DLSctrSet<String> instance3 = new DLSctrSet();
        instance3.add("Hola");
        instance3.add("Estructuras");
        DLSctrSet<String> instance4 = new DLSctrSet<>();
        instance4.add("Estructuras");
        instance4.add("Datos");
        DLSctrSet<String> result2 = (DLSctrSet<String>)instance3.intersection(instance4);
        assertTrue(result2.contains("Estructuras")); //Verificar que tenga los elementos
        assertFalse(result2.contains("Hola")); //Verificar que no tenga los elementros que no se repitan en ambos
        assertFalse(result2.contains("Datos"));
        assertEquals(1, result2.size()); //Verificar que size se modifique
    }
    
    /**
     * Test del metodo Intersection, set null, de la clase DLSctrSet.
     */
    @Test(expected = ADTsException.class)
    public void testIntersectionThrowsExceptionForNullSet() {
        System.out.println("intersection set null");
        DLSctrSet instance= new DLSctrSet();
        instance.intersection(null); // Esto debe lanzar ADTsException
    }

    /**
     * Test del metodo IntersectionRv, de la clase DLSctrSet.
     */
    @Test
    public void testIntersectionRv() {
        System.out.println("intersectionRv");
        DLSctrSet<Integer> instance = new DLSctrSet();
        instance.add(10);
        instance.add(20);
        DLSctrSet<Integer> instance2 = new DLSctrSet<>();
        instance2.add(20);
        instance2.add(30);
        DLSctrSet<Integer> result = (DLSctrSet<Integer>)instance.intersectionRv(instance2);
        assertTrue(result.contains(20)); //Verificar que tenga los elementos
        assertFalse(result.contains(10)); //Verificar que no tenga los elementos que no se repitan en ambos
        assertFalse(result.contains(30));
        assertEquals(1, result.size()); //Verificar que size se modifique
        
        DLSctrSet<String> instance3 = new DLSctrSet();
        instance3.add("Hola");
        instance3.add("Estructuras");
        DLSctrSet<String> instance4 = new DLSctrSet<>();
        instance4.add("Estructuras");
        instance4.add("Datos");
        DLSctrSet<String> result2 = (DLSctrSet<String>)instance3.intersectionRv(instance4);
        assertTrue(result2.contains("Estructuras")); //Verificar que tenga los elementos
        assertFalse(result2.contains("Hola")); //Verificar que no tenga los elementos que no se repitan en ambos
        assertFalse(result2.contains("Datos"));
        assertEquals(1, result2.size()); //Verificar que size se modifique
    }
    
     /**
     * Test del metodo IntersectionRv, set null, de la clase DLSctrSet.
     */
    @Test(expected = ADTsException.class)
    public void testIntersectionRvThrowsExceptionForNullSet() {
        System.out.println("intersectionRv set null");
        DLSctrSet instance= new DLSctrSet();
        instance.intersectionRv(null); // Esto debe lanzar ADTsException
    }

    /**
     * Test del metodo Difference, de la clase DLSctrSet.
     */
    @Test
    public void testDifference() {
        System.out.println("difference");
        DLSctrSet<Integer> instance = new DLSctrSet();
        instance.add(10);
        instance.add(20);
        DLSctrSet<Integer> instance2 = new DLSctrSet<>();
        instance2.add(20);
        instance2.add(30);
        DLSctrSet<Integer> result = (DLSctrSet<Integer>)instance.difference(instance2);
        assertTrue(result.contains(10)); //Verificar que tenga los elementos
        assertFalse(result.contains(20)); //Verificar que no tenga los elementos en la interseccion
        assertFalse(result.contains(30));//Verificar que no tenga los elementos de instance2 no contenidos en instance
        assertEquals(1, result.size()); //Verificar que size se modifique
        
        DLSctrSet<String> instance3 = new DLSctrSet();
        instance3.add("Hola");
        instance3.add("Estructuras");
        DLSctrSet<String> instance4 = new DLSctrSet<>();
        instance4.add("Estructuras");
        instance4.add("Datos");
        DLSctrSet<String> result2 = (DLSctrSet<String>)instance3.difference(instance4);
        assertTrue(result2.contains("Hola")); //Verificar que tenga los elementos
        assertFalse(result2.contains("Estructuras")); //Verificar que no tenga los elementos que no se repitan en ambos
        assertFalse(result2.contains("Datos"));
        assertEquals(1, result2.size()); //Verificar que size se modifique

     }
    
    /**
     * Test del metodo Difference, set null, de la clase DLSctrSet.
     */
    @Test(expected = ADTsException.class)
    public void testDifferenceThrowsExceptionForNullSet() {
        System.out.println("difference set null");
        DLSctrSet instance= new DLSctrSet();
        instance.difference(null); // Esto debe lanzar ADTsException
    }

    /**
     * Test del metodo DifferenceRv, de la clase DLSctrSet.
     */
    @Test
    public void testDifferenceRv() {
        System.out.println("differenceRv");
        DLSctrSet<Integer> instance = new DLSctrSet();
        instance.add(10);
        instance.add(20);
        DLSctrSet<Integer> instance2 = new DLSctrSet<>();
        instance2.add(20);
        instance2.add(30);
        DLSctrSet<Integer> result = (DLSctrSet<Integer>)instance.differenceRv(instance2);
        assertTrue(result.contains(10)); //Verificar que tenga los elementos
        assertFalse(result.contains(20)); //Verificar que no tenga los elementos en la interseccion
        assertFalse(result.contains(30));//Verificar que no tenga los elementos de instance2 no contenidos en instance
        assertEquals(1, result.size()); //Verificar que size se modifique
        
        DLSctrSet<String> instance3 = new DLSctrSet();
        instance3.add("Hola");
        instance3.add("Estructuras");
        DLSctrSet<String> instance4 = new DLSctrSet<>();
        instance4.add("Estructuras");
        instance4.add("Datos");
        DLSctrSet<String> result2 = (DLSctrSet<String>)instance3.differenceRv(instance4);
        assertTrue(result2.contains("Hola")); //Verificar que tenga los elementos
        assertFalse(result2.contains("Estructuras")); //Verificar que no tenga los elementos que no se repitan en ambos
        assertFalse(result2.contains("Datos"));
        assertEquals(1, result2.size()); //Verificar que size se modifique

     }
    
    /**
     * Test del metodo DifferenceRv, set null, de la clase DLSctrSet.
     */
    @Test(expected = ADTsException.class)
    public void testDifferenceRvThrowsExceptionForNullSet() {
        System.out.println("differenceRv set null");
        DLSctrSet<Integer> instance= new DLSctrSet();
        instance.differenceRv(null); // Esto debe lanzar ADTsException
        
        DLSctrSet<String> instance2= new DLSctrSet();
        instance2.differenceRv(null); // Esto debe lanzar ADTsException
    }

    /**
     * Test del metodo Contains, de la clase DLSctrSet.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        DLSctrSet<Integer> instance = new DLSctrSet();
        assertFalse(instance.contains(20)); // Debe devolver false
        instance.add(10);
        assertTrue(instance.contains(10)); // Debe devolver true
        assertFalse(instance.contains(20)); // Debe devolver false
        
        DLSctrSet<String> instance2 = new DLSctrSet();
        assertFalse(instance2.contains("Estructuras")); // Debe devolver false
        instance2.add("Hola");
        assertTrue(instance2.contains("Hola")); // Debe devolver true
        assertFalse(instance2.contains("Estructuras")); // Debe devolver false
     }
    
    /**
     * Test del metodo contains, elemento null, de la clase DLSctrSet.
     */
    @Test(expected = ADTsException.class)
    public void testContainsThrowsExceptionForNullElement() {
        System.out.println("contains elemento null");
        DLSctrSet instance= new DLSctrSet();
        instance.contains(null); // Esto debe lanzar ADTsException
    }

    /**
     * Test del metodo Equals, de la clase DLSctrSet.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        DLSctrSet<Integer> instance = new DLSctrSet();
        instance.add(10);
        instance.add(20);
        DLSctrSet<Integer> instance2 = new DLSctrSet();
        instance2.add(10);
        instance2.add(20);
        DLSctrSet<Integer> instance3 = new DLSctrSet();
        instance3.add(10);
        instance3.add(20);
        
        assertTrue(instance.equals(instance));//Debe ser igual a si mismo
        assertTrue(instance.equals(instance2));//Simetria
        assertTrue(instance2.equals(instance));
        assertTrue(instance2.equals(instance3));//Transitividad
        assertTrue(instance.equals(instance3));
        instance.add(40);
        assertFalse(instance.equals(instance2));//Debe ser diferentes
        
        DLSctrSet<String> instance4 = new DLSctrSet();
        instance4.add("Hola");
        instance4.add("Estructuras");
        DLSctrSet<String> instance5 = new DLSctrSet();
        instance5.add("Hola");
        instance5.add("Estructuras");
        DLSctrSet<String> instance6 = new DLSctrSet();
        instance6.add("Hola");
        instance6.add("Estructuras");
        
        assertTrue(instance4.equals(instance4));//Debe ser igual a si mismo
        assertTrue(instance4.equals(instance5));//Simetria
        assertTrue(instance5.equals(instance4));
        assertTrue(instance5.equals(instance6));//Transitividad
        assertTrue(instance4.equals(instance6));
        instance4.add("Datos");
        assertFalse(instance4.equals(instance5));//Debe ser diferentes
    }
    
    /**
     * Test del metodo equals, objeto null, de la clase DLSctrSet.
     */
    @Test(expected = ADTsException.class)
    public void testEqualsThrowsExceptionForNullObject() {
        System.out.println("equals objeto null");
        DLSctrSet instance= new DLSctrSet();
        instance.equals(null); // Esto debe lanzar ADTsException
    }

    /**
     * Test del metodo IsEmpty, de la clase DLSctrSet.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        DLSctrSet<Integer> instance = new DLSctrSet();
        assertTrue(instance.isEmpty());
        instance.add(10);
        assertFalse(instance.isEmpty());
        
        DLSctrSet<String> instance2 = new DLSctrSet();
        assertTrue(instance2.isEmpty());
        instance2.add("Hola");
        assertFalse(instance2.isEmpty());
    }

    /**
     * Test del metodo Size, de la clase DLSctrSet.
     */
    @Test
    public void testSize() {
         System.out.println("size");
        DLSctrSet<Integer> instance = new DLSctrSet();
        assertEquals(0,instance.size()); //Cuando está vacia
        instance.add(10);
        instance.add(20);
        assertEquals(2,instance.size()); //Cuando tiene dos elemento
        
        DLSctrSet<String> instance2 = new DLSctrSet();
        assertEquals(0,instance2.size()); //Cuando está vacia
        instance2.add("Hola");
        instance2.add("Estructuras");
        assertEquals(2,instance2.size()); //Cuando tiene dos elemento
    }

    /**
     * Test del metodo Iterator, de la clase DLSctrSet.
     * 
     */
    @Test
    public void testIterator() {
        System.out.println("iterator");
        DLSctrSet<Integer> instance = new DLSctrSet();
        instance.add(10);
        Iterator<Integer> it=instance.iterator();
        assertTrue(it.hasNext());//Verificar el hasNext
        int next=it.next();
        assertEquals(next,10);//Verificar que sacara el valor correcto
        assertFalse(it.hasNext());//Verificar que este vacio
        assertEquals(1,instance.size());//Verificar que instance queda igual
        
        DLSctrSet<String> instance2 = new DLSctrSet();
        instance2.add("Hola");
        Iterator<String> it2=instance2.iterator();
        assertTrue(it2.hasNext());//Verificar el hasNext
        String next2=it2.next();
        assertEquals(next2,"Hola");//Verificar que sacara el valor correcto
        assertFalse(it2.hasNext());//Verificar que este vacio
        assertEquals(1,instance2.size());//Verificar que instance queda igual
    }

    /**
     * Test del metodo ToString, de la clase DLSctrSet.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        DLSctrSet<Integer> instance = new DLSctrSet();
        instance.add(10);
        instance.add(20);
        String expResult = "SET-  {DLS: 2: 10, 20}";
        String result = instance.toString();
        assertEquals(expResult, result);
        
        DLSctrSet<String> instance2 = new DLSctrSet();
        instance2.add("Hola");
        instance2.add("Estructuras");
        String expResult2 = "SET-  {DLS: 2: Hola, Estructuras}";
        String result2 = instance2.toString();
        assertEquals(expResult2, result2);
    }
    
}
}
