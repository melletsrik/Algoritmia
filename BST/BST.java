package BST;

public class BST <E extends Comparable <E>> {
    
    class Node<E> {

        private E data;
        private Node<E> left;
        private Node<E> right;

        public Node(E data, Node<E> left, Node<E> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public Node(E data) {
            this(data, null, null);
        }
        //getters y setters
        @Override
        public String toString() {
            return this.data.toString();
        }
    }    

    private Node root;
    
    public BST(){
        this.root = null;
    }
    
    public E search(E x) throws ItemNotFound {
        Node<E> res = searchRec(x, this.root);
        if (res == null) {
            throw new ItemNotFound("El dato " + x + "no esta");
        }
        return res.data;
    }

    protected Node<E> searchRec(E x, Node<E> n) {
        if (n == null) {
            return null;
        } else {
            int resC = n.data.compareTo(x);
            if (resC < 0) {
                return searchRec(x, n.right);
            } else if (resC > 0) {
                return searchRec(x, n.left);
            } else {
                return n;
            }
        }
    }
    
    public void insert(E x) throws ItemDuplicated {
        this.root = insertRec(x, this.root);
    }

    protected Node<E> insertRec(E x, Node<E> actual) throws ItemDuplicated {
        Node<E> res = actual;
        if (actual == null) {
            res = new Node<E>(x);
        } else { //buscamos	el	lugar	para inserción
            int resC = actual.data.compareTo(x);
            if (resC == 0) {
                throw new ItemDuplicated(x + "esta duplcado");
            }
            if (resC < 0) {
                res.right = insertRec(x, actual.right);
            } else {
                res.left = insertRec(x, actual.left);
            }
        }
        return res;
    }
    
    // Modificamos minRecover para que devuelva el nodo mínimo y lo eliminamos en un solo método
protected Node<E> minRecoverAndRemove(Node<E> actual) {
    if (actual.left != null) {
        actual.left = minRecoverAndRemove(actual.left);
        return actual;
    } else {
        return actual.right; // El nodo actual es el mínimo, lo eliminamos y devolvemos su hijo derecho
    }
}

// Actualizamos minRemove para utilizar el nuevo método
public E minRemove() throws ItemNotFound {
    if (this.root == null) {
        throw new ItemNotFound("El árbol está vacío");
    }
    Node<E> minNode = minRecoverAndRemove(this.root);
    return minNode.data;
}


    protected Node<E> minRecover(Node<E> actual) {
        while (actual.left != null) {
            actual = actual.left;
        }
        return actual;
    }

    public void remove(E x) throws ItemNotFound {
        this.root = removeRec(x, this.root);
    }

    protected Node<E> removeRec(E x, Node<E> actual) throws ItemNotFound {
        Node<E> res = actual;
        if (actual == null) {
            throw new ItemNotFound(x + "no esta");
        }
        int resC = actual.data.compareTo(x);
        if (resC < 0) {
            res.right = removeRec(x, actual.right);
        } else if (resC > 0) {
            res.left = removeRec(x, actual.left);
        } else if (actual.left != null && actual.right != null) { //dos hijos
            res.data = minRecover(actual.right).data;
            res.right = minRecoverAndRemove(actual.right);
        } else { //1 hijo o ninguno
            res = (actual.left != null) ? actual.left : actual.right;
        }
        return res;
    }
    
    
    public boolean isEmpty() {
        return this.root == null;
    }

    public String postOrden() {
        if (this.root != null) {
            return postOrden(this.root);
        } else {
            return "*";
        }
    }

    protected String postOrden(Node<E> actual) {
        String res = "";
        if (actual.left != null) {
            res += postOrden(actual.left);
        }
        if (actual.right != null) {
            res += postOrden(actual.right);
        }
        return res + actual.data.toString() + ", ";
    }
}
