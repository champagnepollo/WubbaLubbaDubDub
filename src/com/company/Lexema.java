package com.company;


public class Lexema {
    public TokenType t;
    public String r;

    //Esta es la estructura de los lexemas que van en la lsita del analizador léxico (tipo de token y el string)
    public Lexema(TokenType t, String r){
        this.t = t;
        this.r = r;
    }
}
