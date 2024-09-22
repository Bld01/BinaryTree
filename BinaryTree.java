public class BinaryTree {
    Node raiz;

    public void insert(int value) {
        raiz = insertRec(raiz, value);
    }

    private Node insertRec(Node raiz, int value) {
        if (raiz == null) {
            raiz = new Node(value);
            return raiz;
        }
        if (value < raiz.value) {
            raiz.left = insertRec(raiz.left, value);
        } else {
            raiz.right = insertRec(raiz.right, value);
        }
        return raiz;
    }

    public void remove(int value) {
        raiz = removeRec(raiz, value);
    }

    private Node removeRec(Node raiz, int value) {
        if (raiz == null) {
            return raiz;
        }
        if (value < raiz.value) {
            raiz.left = removeRec(raiz.left, value);
        } else if (value > raiz.value) {
            raiz.right = removeRec(raiz.right, value);
        } else {
            if (raiz.left == null) {
                return raiz.right;
            } else if (raiz.right == null) {
                return raiz.left;
            }
            raiz.value = minValue(raiz.right);
            raiz.right = removeRec(raiz.right, raiz.value);
        }
        return raiz;
    }

    private int minValue(Node raiz) {
        int minValue = raiz.value;
        while (raiz.left != null) {
            minValue = raiz.left.value;
            raiz = raiz.left;
        }
        return minValue;
    }

    @Override
    public String toString() {
        return raiz == null ? "Árvore vazia" : raiz.toString();
    }
}