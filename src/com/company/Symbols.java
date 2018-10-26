package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Symbols {

    //Esta es la tabla de simbolos que utiliza el analizador Sintáctico
    public static ArrayList<Lexema> table = new ArrayList<Lexema>();

    // If space or enter IGNORE
    public static void addToken(TokenType t, String lexema){

        if( t == TokenType.Enter || t == TokenType.Espacio ){
            return;
        }

        Symbols.table.add( new Lexema( t, lexema ) );

    }

}
