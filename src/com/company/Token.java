package com.company;


public class Token {
    public TokenType token;
    public String lexema;

    //Esta es la estructura de los lexemas que van en la lsita del analizador léxico (tipo de token y el string)
    public Token(TokenType token, String lexema){
        this.token = token;
        this.lexema = lexema;
    }
}
