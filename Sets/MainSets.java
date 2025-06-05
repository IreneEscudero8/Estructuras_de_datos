/*
PROYECTO FINAL ESTRUCTURA DE DATOS
Equipo: Claudia Alajbej, Ana Sofía Ceballos, Irene Escudero y Heidi Fabián Martínez
Clase prueba con estructura Doblemente entrelazada dentro de la funcionalidad de Queue
*/
package Sets;

public class MainSets {
    public static void main(String[] args) {
            // Crear conjuntos de prueba tipo: Integer y String
            DLSctrSet<Integer> set1 = new DLSctrSet<>();
            DLSctrSet<Integer> set2 = new DLSctrSet<>();

            // Probar el método add
            System.out.println("Agregando elementos a set1...");
            set1.add(1);
            set1.add(2);
            set1.add(3);
            System.out.println("Contenido de set1: " + set1.toString());

            System.out.println("Agregando elementos a set2...");
            set2.add(3);
            set2.add(4);
            set2.add(5);
            System.out.println("Contenido de set2: " + set2.toString());
            
            //Probar método addAll
            set1.addAll(set2);
            System.out.println("Contenido de set1 y set2: " + set1.toString());

            // Probar el método contains
            System.out.println("¿set1 contiene el elemento 2? " + set1.contains(2));
            System.out.println("¿set1 contiene el elemento 5? " + set1.contains(5));

            // Probar el método remove
            System.out.println("Eliminando elemento 2 de set1...");
            set1.remove(2);
            System.out.println("Contenido de set1 después de eliminar: " + set1.toString());

            // Probar el método removeRandom
            System.out.println("Eliminando un elemento aleatorio de set2...");
            int removed = set2.removeRandom();
            System.out.println("Elemento eliminado: " + removed);
            System.out.println("Contenido de set2 después de eliminar: " + set2.toString());

            // Probar el método union
            System.out.println("Realizando la unión de set1 y set2...");
            SetADT<Integer> unionSet = set1.union(set2);
            System.out.println("Resultado de la unión: " + unionSet.toString());

            // Probar el método intersection
            System.out.println("Realizando la intersección de set1 y set2...");
            SetADT<Integer> intersectionSet = set1.intersection(set2);
            System.out.println("Resultado de la intersección: " + intersectionSet.toString());

            // Probar el método difference
            System.out.println("Realizando la diferencia de set1 y set2...");
            SetADT<Integer> differenceSet = set1.difference(set2);
            System.out.println("Resultado de la diferencia (set1 - set2): " + differenceSet.toString());

            // Probar el método equals
            System.out.println("Comparando set1 y set2...");
            boolean areEqual = set1.equals(set2);
            System.out.println("¿Son iguales set1 y set2? " + areEqual);

            // Probar el método isEmpty
            System.out.println("¿set1 está vacío? " + set1.isEmpty());
            System.out.println("¿set2 está vacío? " + set2.isEmpty());

            // Probar el método size
            System.out.println("Tamaño de set1: " + set1.size());
            System.out.println("Tamaño de set2: " + set2.size());

            //PRUEBA STRING
            
               // Crear conjuntos de prueba tipo: Integer y String
            DLSctrSet<String> set3 = new DLSctrSet<>();
            DLSctrSet<String> set4 = new DLSctrSet<>();

            // Probar el método add
            System.out.println("Agregando elementos a set3...");
            set3.add("Ana");
            set3.add("Heidi");
            set3.add("Claudia");
            System.out.println("Contenido de set3: " + set3.toString());

            System.out.println("Agregando elementos a set4...");
            set4.add("Sofía");
            set4.add("Irene");
            set4.add("Emilia");
            System.out.println("Contenido de set4: " + set4.toString());
            
            //Probar método addAll
            set4.addAll(set3);
            System.out.println("Contenido de set3 y set4: " + set4.toString());

            // Probar el método contains
            System.out.println("¿set3 contiene el elemento 1? " + set3.contains("Ana"));
            System.out.println("¿set4 contiene el elemento 5? " + set4.contains("Irene"));

            // Probar el método remove
            System.out.println("Eliminando elemento 3 de set3...");
            set3.remove("Claudia");
            System.out.println("Contenido de set3 después de eliminar: " + set3.toString());

            // Probar el método removeRandom
            System.out.println("Eliminando un elemento aleatorio de set3...");
            String eliminado = set3.removeRandom();
            System.out.println("Elemento eliminado: " + eliminado);
            System.out.println("Contenido de set3 después de eliminar: " + set3.toString());
            
            // Probar el método union
            System.out.println("Realizando la unión de set3 y set4...");
            SetADT<String> unionSetStr = set3.union(set4);
            System.out.println("Resultado de la unión: " + unionSetStr.toString());

            // Probar el método intersection
            System.out.println("Realizando la intersección de set4 y set3...");
            SetADT<String> intersectionSetStr = set3.intersection(set4);
            System.out.println("Resultado de la intersección: " + intersectionSet.toString());

            // Probar el método difference
            System.out.println("Realizando la diferencia de set4 y set3...");
            SetADT<String> differenceSetStr = set3.difference(set4);
            System.out.println("Resultado de la diferencia (set3 - set4): " + differenceSet.toString());

            // Probar el método equals
            System.out.println("Comparando set3 y set4...");
            boolean equals = set1.equals(set2);
            System.out.println("¿Son iguales set3 y set4? " + equals);

            // Probar el método isEmpty
            System.out.println("¿set3 está vacío? " + set3.isEmpty());
            System.out.println("¿set4 está vacío? " + set3.isEmpty());

            // Probar el método size
            System.out.println("Tamaño de set3: " + set3.size());
            System.out.println("Tamaño de set4: " + set4.size());    
    }
}
