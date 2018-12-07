package com.company;

public class Compiler {

    public static void AtLeastTry(){

       Lexical l = new Lexical();
       Syntactic si = new Syntactic();
       Semantic se = new Semantic();
       l.analize(System.getProperty("user.dir") + "/src/com/company/mortyn.ry");
       si.analize();
       se.analize();
    }
}
