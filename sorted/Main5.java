package sorted;

public class Main5 {
    public static void main(String[] args) {
        Integer []data = Sorted.dataSet(100);
        System.out.println("Datos generados y permutados:");
        Sorted.listAll(data);
        // Ordenar el arreglo
        Sorted.selectionSort(data);
        // Imprimir el arreglo después de ordenar
        System.out.println("Datos despues de ordenar:");
        Sorted.listAll(data);
    }
}
