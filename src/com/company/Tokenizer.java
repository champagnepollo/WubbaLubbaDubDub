package com.company;

import java.util.ArrayList;

public class Tokenizer {

    private ArrayList<Token> tokens;

    public boolean contains(String c) {
        boolean contain = false;
        for (int i = 0; i < tokens.size(); i++) {
            String v = tokens.get(i).getPalabra();
            if (v.contains(c)) {
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
            return equal;
        }
    }

    public Tokenizer() {

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
//                            this.tokens.add(new Token("Plumbus", 12),
//                                    this.tokens.add(new Token("Dead", 13),
//                                            this.tokens.add(new Token("Alive", 14),
//                                                    this.tokens.add(new Token("//", 15),
//                                                            this.tokens.add(new Token("&&", 16),
//                                                                    this.tokens.add(new Token("||", 17),
//                                                                            this.tokens.add(new Token("Microverse", 18),
//                                                                            this.tokens.add(new Token("Rick", 19),
//                                                                                    this.tokens.add(new Token("+", 20),
//            new Token("++", 21),
//            new Token("-", 22),
//            new Token("--", 23),
//            new Token("*", 24),
//            new Token("/", 25),
//            new Token("%", 26),
//            new Token("=", 27),
//            new Token(">", 28),
//            new Token("<", 29),
//            new Token(">=", 30),
//            new Token("<=", 31),
//            new Token("!=", 32),
//            new Token("==", 33),
//            new Token("{", 34),
//            new Token("}", 35),
//            new Token("(", 36),
//            new Token(")", 37),
//            new Token(",", 38),
//            new Token(".", 39)
//            };

    }


}