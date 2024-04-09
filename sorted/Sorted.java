package sorted;

import java.util.Random;

/**
 *
 * @author
 */
public class Sorted {

//PARTE 1 - SORTS
    //1. SelectionSort 
    
    //2. ShellSort - Melissa Chambi Flores
    public static <E extends Comparable<E>> void shellSort(E[] arr) {
        int n = arr.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                E temp = arr[i];
                int j;
                // mover los elementos mayores que temp hacia adelante
                for (j = i; j >= gap && arr[j - gap].compareTo(temp) > 0; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }
    
    //3. MergeSort
    
    //4. BucketSort
   
    
//PARTE 3 - LISTALL
    public static <E> void listAll(E[] arr) {
        for (E t : arr) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

//PARTE 4 - SEARCHITEM
    public static <E extends Comparable<E>> E searchItem(E[] arr, E ele) throws ItemNotFound {
        return searchItemRec(arr, ele, 0, arr.length - 1);
    }

    //Recursivo  el array tiene que estar ordenado
    private static <E extends Comparable<E>> E searchItemRec(E[] arr, E ele, int start, int end) throws ItemNotFound {
        if (start > end) {
            throw new ItemNotFound("Elemento no encontrado");
        }

        int mid = start + (end - start) / 2;
        int cmp = arr[mid].compareTo(ele);

        if (cmp == 0) {
            return arr[mid];
        } else if (cmp < 0) {
            return searchItemRec(arr, ele, mid + 1, end);
        } else {
            return searchItemRec(arr, ele, start, mid - 1);
        }
    }
    
//PARTE 5
    public static int[] dataSet(int n) {
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = i;
        }
        permute(A);
        return A;
    }
    
    private static void permute(int[] A) {
        Random rand = new Random();
        for (int i = A.length - 1; i >= 1; i--) {
            int j = rand.nextInt(i + 1);
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
    }

    public static void main(String[] args) {
        
        int[] data = dataSet(100);
        System.out.println("Datos generados y permutados:");
        for (int num : data) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}