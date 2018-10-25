package com.company;


public class Main {

    //Se arranca el programa.
    public static void main(String[] args) {
        //Aquí se lee el archivo a analizar.
        Lexical l = new Lexical();

        //Aquí se corre el análisis sintáctico
        Syntactic si = new Syntactic();

        l.analize(System.getProperty("user.dir") + "/src/com/company/mortyn.ry");
        si.syntacticReadFile();
    }
}
