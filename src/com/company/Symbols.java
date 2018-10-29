package com.company;

import java.util.ArrayList;

public class Symbols {

    public static ArrayList<Token> table = new ArrayList<>();

    // If space or enter IGNORE
    public static void addToken( TokenType t, String lexema ){

        if( t == TokenType.Enter || t == TokenType.Espacio ){
            return;
        }

        Symbols.table.add( new Token( t, lexema ) );

    }

}
