package com.company;


import javax.sound.midi.SysexMessage;
import java.util.ArrayList;

public class Syntactic {

    //Este método análiza sintácticamente la lista del analizador léxico.
    public void analize(){


        int mainIndex = EntryAt();

        if( mainIndex == -1 ){
            System.out.println("No Rick function found!");
            System.exit(-1);
        }

        if( !checkEntry( mainIndex ) ){
            System.out.println("Rick function error in definition!");
            System.out.println("Excepctiong: <TYPE> Rick(){}");
            System.exit(-1);
        }

        if( countBrackets() != 0 ){
            System.out.println("Missing Brackets!");
            System.exit(-1);
        }


        int p = EntryBracketAt( mainIndex );

        analize( p, Symbols.table.size() );


    }

    private int EntryBracketAt( int mainIndex ){
        int e = 0;
        for(int i = mainIndex; i < Symbols.table.size(); i++){
            if( Symbols.table.get(i).token == TokenType.AbrirLlave ){
                e = i;
            }
        }
        return e;
    }

    private boolean checkEntry(int mainIndex) {

        boolean entry = true;

        if(Symbols.table.get(mainIndex - 1).token != TokenType.Tipo){

            entry = false;
        }else if(Symbols.table.get(mainIndex + 1).token != TokenType.AbrirParentesis){

            entry = false;
        }else if(Symbols.table.get(mainIndex + 2).token != TokenType.CerrarParentesis){

            entry = false;
        }else if(Symbols.table.get(mainIndex + 3).token != TokenType.AbrirLlave){

            entry = false;
        }

        return entry;

    }

    private int countBrackets( ){

        int counter = 0;

        for( int i = 0; i < Symbols.table.size(); i++ ){

            if( Symbols.table.get(i).token == TokenType.AbrirLlave )
                counter++;
            else if( Symbols.table.get( i ).token == TokenType.CerrarLlave )
                counter--;
        }
        return counter;
    }
    private int EntryAt() {

        int entryIndex = -1;

        for( int i = 0; i < Symbols.table.size(); i++){

            if( Symbols.table.get(i).lexema.equals("Rick")){
                entryIndex = i;
            }

        }

        return entryIndex;

    }




    private void sent(ArrayList<Token> tokens) {
        //Debe checar todas la reglas gramaticales y ver cuales aplican
        if( tokens.get(0).token == TokenType.Tipo ){

            this.decl(tokens);
            this.asign(tokens);
            
        }else if( tokens.get(0).token == TokenType.Condition ){
            this.cond(tokens);
        }

    }

    private void cond(ArrayList<Token> tokens) {

    }

    private void oper_l(ArrayList<Token> tokens) {


    }


    private void loop(ArrayList<Token> tokens) {
    }
    private void decl(ArrayList<Token> tokens) {
        if( tokens.get(0).token == TokenType.Tipo ){

            if( tokens.get(1).token == TokenType.Identifier ){

                if( tokens.get(2).token == TokenType.PuntoyComa ){
                    System.out.println("Declaracion");
                }
            }
        }
    }

    private void asign(ArrayList<Token> tokens) {
        if( tokens.get(0).token == TokenType.Tipo ){

            if( tokens.get(1).token == TokenType.Identifier ){
                if( tokens.get(2).token == TokenType.Equal ){
                    if(tokens.get(3).token == TokenType.Constante){


                        if( tokens.get(4).token == TokenType.PuntoyComa ){
                            System.out.println("Asignacion");
                        }

                    }

                }

            }
        }
    }

    public void analize(int startIndex, int endIndex){

        ArrayList<Token> tmp = new ArrayList<>();

        for (int i = startIndex + 1; i < endIndex; i++){

            //Los mete a pila hasta encontrar ;
            tmp.add(Symbols.table.get(i));

            if( Symbols.table.get(i).token == TokenType.PuntoyComa ){

                sent(tmp);

                tmp.clear();

            }

            if( Symbols.table.get(i).token == TokenType.CerrarLlave ){

                sent(tmp);

                tmp.clear();

            }



        }

    }

}
