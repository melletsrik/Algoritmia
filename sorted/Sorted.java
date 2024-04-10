package sorted;

import java.util.Arrays;
import java.util.Random;

public class Sorted {

//PARTE 1 - SORTS
    //1. SelectionSort - Ricardo Charahua Sánchez
	public static <T extends Comparable<T>> void selectionSort(T arreglo[]) {
        int indiceMenor, i, j;
        int n = arreglo.length;
        for(i = 0; i < n - 1; i++) {
            indiceMenor = i;
            for(j = i + 1; j < n; j++) {
                if(arreglo[j].compareTo(arreglo[indiceMenor]) < 0) {
                    indiceMenor = j;
                }
            }
            if(i != indiceMenor) {
                T aux = arreglo[i];
                arreglo[i] = arreglo[indiceMenor];
                arreglo[indiceMenor] = aux;
            }
        }
    }
        
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
    
    //3. MergeSort - Keny Guerra Huanaco
        public static <T extends Comparable<T>> void mergeSort(T[] arr) {
        if (arr.length <= 1) {
            return;
        }

        int mitad = arr.length / 2;
        T[] izquierdaArray = Arrays.copyOfRange(arr, 0, mitad);
        T[] derechaArray = Arrays.copyOfRange(arr, mitad, arr.length);

        mergeSort(izquierdaArray);
        mergeSort(derechaArray);

        merge(arr, izquierdaArray, derechaArray);
    }

    private static <T extends Comparable<T>> void merge(T[] arr, T[] izquierdaArray, T[] derechaArray) {
        int i = 0, j = 0, k = 0;

        while (i < izquierdaArray.length && j < derechaArray.length) {
            if (izquierdaArray[i].compareTo(derechaArray[j]) < 0) {
                arr[k++] = izquierdaArray[i++];
            } else {
                arr[k++] = derechaArray[j++];
            }
        }

        while (i < izquierdaArray.length) {
            arr[k++] = izquierdaArray[i++];
        }

        while (j < derechaArray.length) {
            arr[k++] = derechaArray[j++];
        }
    }
    

    //4. BucketSort - Fernando Apaza
    public static <E extends Comparable<E>> void bucketSort(E[] array, int bucketSize) {
        if (array.length == 0) {
            return;
        }

        // Encuentra el valor máximo y mínimo del array
        E minValue = array[0];
        E maxValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(minValue) < 0) {
                minValue = array[i];
            } else if (array[i].compareTo(maxValue) > 0) {
                maxValue = array[i];
            }
        }

        // Calcula el número de buckets
        int bucketCount = ((Comparable<E>) maxValue).compareTo(minValue) / bucketSize + 1;
        E[][] buckets = (E[][]) new Comparable[bucketCount][bucketSize];
        int[] bucketIndexCount = new int[bucketCount];

        // Asigna cada elemento al bucket correspondiente
        for (int i = 0; i < array.length; i++) {
            int bucketIndex = ((Comparable<E>) array[i]).compareTo(minValue) / bucketSize;
            if (bucketIndexCount[bucketIndex] == buckets[bucketIndex].length) {
                // Si el bucket está lleno, aumenta su tamaño
                buckets[bucketIndex] = resizeArray(buckets[bucketIndex]);
            }
            buckets[bucketIndex][bucketIndexCount[bucketIndex]++] = array[i];
        }

        // Ordena cada bucket e inserta los elementos ordenados de nuevo en el array original
        int currentIndex = 0;
        for (int i = 0; i < bucketCount; i++) {
            if (bucketIndexCount[i] == 0) {
                continue; // El bucket está vacío, pasa al siguiente
            }
            sortBucket(buckets[i], bucketIndexCount[i]);
            for (int j = 0; j < bucketIndexCount[i]; j++) {
                array[currentIndex++] = buckets[i][j];
            }
        }
    }
    
    private static <E extends Comparable<E>> E[] resizeArray(E[] array) {
        int newSize = array.length * 2;
        E[] newArray = (E[]) new Comparable[newSize];
        System.arraycopy(array, 0, newArray, 0, array.length);
        return newArray;
    }

    private static <E extends Comparable<E>> void sortBucket(E[] bucket, int length) {
        for (int i = 1; i < length; i++) {
            E temp = bucket[i];
            int j = i - 1;
            while (j >= 0 && bucket[j].compareTo(temp) > 0) {
                bucket[j + 1] = bucket[j];
                j--;
            }
            bucket[j + 1] = temp;
        }
    }

    
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
    public static Integer[] dataSet(int n) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        permute(arr);
        return arr;
    }

    private static void permute(Integer[] A) {
        Random rand = new Random();
        for (int i = A.length - 1; i >= 1; i--) {
            int j = rand.nextInt(i + 1);
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
    }

}