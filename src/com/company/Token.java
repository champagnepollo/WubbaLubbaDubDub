package com.company;



public class Token {

    private String palabra;
    private int token;
    public Token(String palabra, int token){
        this.palabra = palabra;
        this.token = token;

    }

    public String getPalabra(){
        return this.palabra;
    }
}
