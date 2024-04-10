package sorted;

public class Main {
//PARTE 2 - PRUEBAS
    public static void main(String[] args) throws ItemNotFound {
        Integer[] intArray = {12, 34, 54, 2, 3};
        
        Persona p1 = new Persona(3, "Juan", 70.5f);
        Persona p2 = new Persona(1, "Pedro", 65.2f);
        Persona p3 = new Persona(2, "Ana", 60.8f);
        Persona[] personas = {p1,p2,p3};
        
        
        
        System.out.println("int - antes de ordenar:");
        Sorted.listAll(intArray);
        Sorted.shellSort(intArray);
        System.out.println("int - despues de ordenar:");
        Sorted.listAll(intArray);
        System.out.println("Persona - antes de ordenar:");
        Sorted.listAll(personas);
        Sorted.shellSort(personas);
        System.out.println("Persona - despues de ordenar:");
        Sorted.listAll(personas);
        System.out.println(Sorted.searchItem(intArray,2));
        System.out.println(Sorted.searchItem(personas,p1));
        
    }
}


