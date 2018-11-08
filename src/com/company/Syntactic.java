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
            //Puede ser decl o asig
        }

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

    public void analize(int startIndex, int endIndex){


        ArrayList<Token> tmp = new ArrayList<>();

        for (int i = startIndex + 1; i < endIndex; i++){


            //Los mete a pila hasta encontrar ;
            tmp.add(Symbols.table.get(i));

            if( Symbols.table.get(i).token == TokenType.PuntoyComa ){

                sent(tmp);

                tmp.clear();


            }


        }

    }

}
