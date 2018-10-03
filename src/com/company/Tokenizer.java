package com.company;

import java.util.ArrayList;

public class Tokenizer {

    private ArrayList<Token> tokens;

    public boolean contains(String c) {
        boolean contain = false;
        for (int i = 0; i < tokens.size(); i++) {
            String v = tokens.get(i).getPalabra();
            if (v.contains(c) || v.equals(c)) {
                contain = true;
                break;
            }
        }
        return contain;
    }

    public boolean equal(String c) {
        boolean equal = false;
        for (int i = 0; i < tokens.size(); i++) {
            String v = tokens.get(i).getPalabra();
            if (v.equals(c)) {
                equal = true;
                break;
            }
        }

        return equal;
    }

    public Tokenizer() {
            this.tokens = new ArrayList<Token>();
            this.tokens.add(new Token("Morty", 1));
            this.tokens.add(new Token("Summer", 2));
            this.tokens.add(new Token("Spacecruiser", 3));
            this.tokens.add(new Token("Meeseek", 3));
            this.tokens.add(new Token("Yes", 4));
            this.tokens.add(new Token("Cake", 5));
            this.tokens.add(new Token("Mahmen", 6));
            this.tokens.add(new Token("Jerry", 7));
            this.tokens.add(new Token("Schezwan", 8));
            this.tokens.add(new Token("Passthebutter", 9));
            this.tokens.add(new Token("Adventure", 10));
            this.tokens.add(new Token("Jellybean", 11));
            this.tokens.add(new Token("Plumbus", 12));
            this.tokens.add(new Token("Dead", 13));
            this.tokens.add(new Token("Alive", 14));
            this.tokens.add(new Token("//", 15));
            this.tokens.add(new Token("&&", 16));
            this.tokens.add(new Token("||", 17));
            this.tokens.add(new Token("Microverse", 18));
            this.tokens.add(new Token("Rick", 19));
            this.tokens.add(new Token("+", 20));
            this.tokens.add(new Token("++", 21));
            this.tokens.add(new Token("-", 22));
            this.tokens.add(new Token("--", 23));
            this.tokens.add(new Token("*", 24));
            this.tokens.add(new Token("/", 25));
            this.tokens.add(new Token("%", 26));
            this.tokens.add(new Token("=", 27));
            this.tokens.add(new Token(">", 28));
            this.tokens.add(new Token("<", 29));
            this.tokens.add(new Token(">=", 30));
            this.tokens.add(new Token("<=", 31));
            this.tokens.add(new Token("!=", 32));
            this.tokens.add(new Token("==", 33));
            this.tokens.add(new Token("{", 34));
            this.tokens.add(new Token("}", 35));
            this.tokens.add(new Token("(", 36));
            this.tokens.add(new Token(")", 37));
            this.tokens.add(new Token(",", 38));
            this.tokens.add(new Token(".", 39));


    }


}