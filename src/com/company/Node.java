package com.company;

public class Node<E> {

    private Asociacion<String, String> valor;
    private Node<E> padre;
    private Node<E> izquierda, derecha;

    public Node(String palabraI, String palabraE){

        valor = new Asociacion<>(palabraI, palabraE);
        padre = null;
        izquierda = null;
        derecha = null;

    }
    public Asociacion<String, String> getValor() {
        return valor;
    }

    public Node(){}

    public String getKey(){
        return valor.key;
    }

    public String getValue(){
        return valor.valor;
    }

    public Node<E> getPadre() {
        return padre;
    }

    public Node<E> getIzquierda() {
        return izquierda;
    }

    public Node<E> getDerecha() {
        return derecha;
    }


    public void setPadre(Node padre) {
        this.padre = padre;
    }


    public void setDerecha(Node derecha) {
        this.derecha = derecha;
    }

    public void setIzquierda(Node izquierda) {
        this.izquierda = izquierda;
    }


    public String buscar(String palabra) {

        String palabraIngles = this.valor.getKey();
        String palabraEspanol = this.valor.getValue();

        if (palabra.equals(palabraIngles)) {
            return palabraEspanol;

        } else if (palabra.compareTo(palabraIngles) < 0) {

            if (izquierda == null){
                return "*" + palabra + "*";

            }else{
                return izquierda.buscar(palabra);

            }

        } else if(palabra.compareTo(palabraIngles) > 0) {

            if (derecha == null){

                return "*" + palabra + "*";

            } else {

                return derecha.buscar(palabra);

            }
        }
        return "*" + palabra + "*";
    }

}
