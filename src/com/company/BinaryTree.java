package com.company;

// Clase del arbol binario.


public class BinaryTree<E> {

    // Definicion del nodo r --> raiz
    private Node r;

    // Constructor
    // Nodo vacio
    public BinaryTree() {
        this.r = null;
    }

    // Busca la palabra en el nodo
    public String search(String palabra) {

        if (r == null) {

            return "*" + palabra + "*";

        } else {

            palabra = r.buscar(palabra);
        }

        return palabra;
    }

    // Inserta nodo en la posicion deseada
    public Node insertRec(Node r, Node node)
    {

        if (r == null) {
            r = node;
            return r;
        }

        else if ((r.getKey()).compareTo(node.getKey()) > 0){
            r.setIzquierda(insertRec(r.getIzquierda(), node));
            r.getIzquierda().setPadre(r);
        }

        else {
            r.setDerecha(insertRec(r.getDerecha(), node));
            r.getDerecha().setPadre(r);
        }

        return r;
    }

    // Imprime el arbol en orden L-N-R
    public void print(Node r) {
        if (r != null) {

            print(r.getIzquierda());
            System.out.println(r.toString());
            print(r.getDerecha());
        }
    }

    // Inserta un nodo
    public void insert(Node newNode) {

        r = insertRec(r, newNode);

    }

    // Imprime el arbol
    public void inorder()  {
        print(r);
    }

}
