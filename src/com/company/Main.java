package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String [] arg) {

        // Declaracion de variables
        File file = null;
        FileReader fr = null;
        Map<String,String> sendMap = new TreeMap<>();
        Node<Asociacion<String,String>> nuevoNodo;
        BinaryTree<Node<Asociacion<String, String>>> bst = new BinaryTree<>(); //se crea nuevo arbol null
        FileReader frr = null;
        BufferedReader br = null;
        BufferedReader brr = null;

        // Fichero
        try {
            fr= new FileReader("diccionario.txt");
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            String Key;
            String Value;
            int posicion;
            while((linea=br.readLine())!=null){
                posicion=linea.indexOf(",");
                Key=linea.substring(1, posicion);
                Value=linea.substring(posicion+2, linea.length()-1);

                nuevoNodo = new Node<>(Key.toUpperCase(), Value.toUpperCase()); //se crea el "nodo" que se pondrá en el tree
                bst.insert(nuevoNodo);

            }

            System.out.println("Imprimiendo diccionario - InOrder: \n");
            bst.inorder();

            //Se inicia la segunda lectura del texto

            frr= new FileReader("texto.txt");
            brr = new BufferedReader(frr);
            Scanner scr = new Scanner(brr);

            String linea2="";
            String string="";

            while (scr.hasNextLine()) {
                linea2 += scr.nextLine();
            }

            string = linea2.replaceAll("\n", " ");
            System.out.println(string);

            String WordList[] = string.split(" ");

            String resultado = "";

            String palabra;

            for(String p: WordList){
                palabra = p.toUpperCase();
                resultado += bst.search(palabra) + " ";
            }

            BinaryTree<Node<Asociacion<String, String>>> BinaryTree = new BinaryTree<>();

            System.out.println("\n Traduccion:\n");
            System.out.println(resultado);

        }
        catch(IOException e){
        }finally{
            try{
                if( null != fr ){
                    fr.close();
                }
            }catch (IOException e2){
            }
        }
    }
}

