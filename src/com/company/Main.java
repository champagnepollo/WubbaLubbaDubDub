package com.company;


import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Compiler.AtLeastTry();


        for( int i = 0; i < Trick.trick.size(); i++){

            for(int a = 0; a < Trick.trick.get(i).token.size(); a++){

                System.out.print(Trick.trick.get(i).token.get(a).lexema + ' ' );


            }
            System.out.println( Trick.trick.get(i).tipo);
        }


        for(int i = 0; i < Errors.errors.size(); i++){
            System.out.println(Errors.errors.get(i));
        }


//        for(int i = 0; i < Symbols.table.size(); i++){
//
//            System.out.println(Symbols.table.get(i).lexema);
//        }
    }
}
