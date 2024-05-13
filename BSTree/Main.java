package BSTree;
public class Main {
    public static void main(String[] args) {
        // Crear un arbol binario de búsqueda de enteros
        BSTree<Integer> bst = new BSTree<>();

        // Insertar elementos en el arbol
        try {
            bst.insert(50);
            bst.insert(30);
            bst.insert(70);
            bst.insert(20);
            bst.insert(40);
            bst.insert(60);
            bst.insert(80);
        } catch (ItemDuplicated e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Imprimir el arbol en postorden
        System.out.println("\nArbol en postorden:");
        System.out.println(bst.postOrden());

        // Buscar un elemento en el arbol
        int searchKey = 40;
        System.out.println("\nBuscando el elemento " + searchKey + ":");
        try {
            System.out.println("Encontrado: " + bst.search(searchKey));
        } catch (ItemNotFound e) {
            System.out.println(e.getMessage());
        }

        // Eliminar el elemento minimo del arbol
        System.out.println("\nEliminando el elemento minimo:");
        System.out.println("Elemento minimo eliminado: " + bst.minRemove());

        // Imprimir el arbol en postorden despues de eliminar el elemento minimo
        System.out.println("\nArbol en postorden despues de eliminar el minimo:");
        System.out.println(bst.postOrden());

        // Eliminar un elemento del arbol
        int removeKey = 70;
        System.out.println("\nEliminando el elemento " + removeKey + ":");
        try {
            bst.remove(removeKey);
            System.out.println("Elemento " + removeKey + " eliminado.");
        } catch (ItemNotFound e) {
            System.out.println(e.getMessage());
        }

        // Imprimir el arbol en postorden despues de eliminar un elemento
        System.out.println("\nArbol en postorden despues de eliminar un elemento:");
        System.out.println(bst.postOrden());

        // Verificar si el arbol esta vacio
        System.out.println("\nEl arbol esta vacio? " + bst.isEmpty());
    }
}
