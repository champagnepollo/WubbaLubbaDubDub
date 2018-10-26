package com.company;


public class Token {
    public TokenType t;
    public String r;

    //Esta es la estructura de los lexemas que van en la lsita del analizador léxico (tipo de token y el string)
    public Token(TokenType t, String r){
        this.t = t;
        this.r = r;
    }
}
