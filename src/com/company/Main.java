package com.company;


public class Main {

    public static void main(String[] args) {

        Compiler.AtLeastTry();

        for(int i = 0; i < Errors.errors.size(); i++){
            System.out.println(Errors.errors.get(i));
        }


//        for(int i = 0; i < Symbols.table.size(); i++){
//
//            System.out.println(Symbols.table.get(i).lexema);
//        }
    }
}
