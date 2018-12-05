package com.company;


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
        System.out.println(p);
        System.out.println(Symbols.table.size());
        analize( p, Symbols.table.size() );

    }

    private int EntryBracketAt( int mainIndex ){
        for(int i = mainIndex; i < Symbols.table.size(); i++){
            if( Symbols.table.get(i).token == TokenType.AbrirLlave ){

                return i;

            }
        }
        return -1;
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
        if( tokens.get(0).token == TokenType.Tipo ){

            this.assign(tokens);
            this.decl(tokens);

        }else if( tokens.get(0).token == TokenType.Condition ){
            this.cond(tokens);
        }else{

            this.loop(tokens);

        }

    }

    private void cond(ArrayList<Token> tokens) {

        if( tokens.get(0).token == TokenType.Condition ){

            if( tokens.get(1).token == TokenType.AbrirParentesis ){

                ArrayList<Token> tmp = new ArrayList<>();
                tmp.add( tokens.get(2) );
                tmp.add( tokens.get(3) );
                tmp.add( tokens.get(4) );

                if( oper_l(tmp) ){

                    tmp.clear();

                    if( tokens.get(5).token == TokenType.CerrarParentesis ){

                        if(tokens.get(6).token == TokenType.AbrirLlave){

                            for( int i = 7; i < tokens.size(); i++ ){

                                tmp.add(tokens.get(i));
                            }
                            System.out.println("cond");
                            sent(tmp);
                            tmp.clear();

                        }

                    }

                }else{
                    System.out.println("Expecting Logical Operation");
                    System.exit(-1);

                }

            }

        }

    }

    private boolean oper_l(ArrayList<Token> tokens) {

        if( var(tokens.get(0)) ){
            if( oper_rel( tokens.get(1) ) ){
                if( var( tokens.get(2) ) ){
                    System.out.println("oper_l");
                    return true;
                }
            }
        }else{
            System.out.println("expecting logial operation");
            System.exit(-1);
        }
        return false;

    }

    private boolean oper_rel( Token t){

        if(t.token == TokenType.Greater || t.token == TokenType.Less || t.token == TokenType.GreaterEqual || t.token == TokenType.LessEqual ||
        t.token == TokenType.EqualEqual || t.token == TokenType.ExclameEqual) return true;

        return false;

    }

    private boolean var( Token t ){

        if( t.token == TokenType.Identifier || t.token == TokenType.Constante || t.token == TokenType.Boolean ){
            return true;
        }
        return false;
    }

    private boolean loop(ArrayList<Token> tokens) {

        if(tokens.get(0).lexema.equals("Passthebutter")){

            if( tokens.get(1).token == TokenType.AbrirParentesis ){

                ArrayList<Token> tmp = new ArrayList<>();
                tmp.add( tokens.get(2) );
                tmp.add( tokens.get(3) );
                tmp.add( tokens.get(4) );

                if(oper_l( tmp )){

                    tmp.clear();

                    if( tokens.get(5).token == TokenType.CerrarParentesis ){

                        if(tokens.get(6).token == TokenType.AbrirLlave){

                            for( int i = 7; i < tokens.size(); i++ ){

                                tmp.add(tokens.get(i));
                            }
                            System.out.println("loop");
                            sent(tmp);
                            tmp.clear();

                        }

                    }

                }else{

                    Errors.add("Expecting Logical Operation");

                }


            }



        }else if( tokens.get(0).lexema.equals("Adventure") ){
            //Adventure
            if( tokens.get(1).token == TokenType.AbrirParentesis ) {

                ArrayList<Token> tmp = new ArrayList<>();

                tmp.add( tokens.get(2) );
                tmp.add( tokens.get(3) );
                tmp.add( tokens.get(4) );

                if( tokens.get(5).token == TokenType.Coma )
                    tokens.get(5).token = TokenType.PuntoyComa;

                tmp.add( tokens.get(5) );

                if(!assign(tmp)){
                    Errors.add("expecting assign in loop");

                }
                tmp.clear();
                int count = 6;

                while( tokens.get(count).token != TokenType.Coma ){

                    tmp.add(tokens.get(count));
                    count++;
                }
                if(!oper_l(tmp)) {
                    Errors.add("expecitng logical operation in loop");

                }


                tmp.clear();
                count++;
                while( tokens.get(count).token != TokenType.CerrarParentesis ) {

                    tmp.add(tokens.get(count));
                    count++;
                }
                tmp.add( tokens.get(5) );

                if(!assign(tmp)){
                    Errors.add("expecting assign in the loop");

                }
                tmp.clear();


                count+=2;

                for( int i = count; i < tokens.size(); i++ ){

                    tmp.add(tokens.get(i));
                }
                System.out.println("loop");
                sent(tmp);
                tmp.clear();



            }
            //Si es cierre de linea debe ignorar
        }else if( !tokens.get(0).lexema.equals("}") ){
            Errors.add("Syntax error: '" + tokens.get(0).lexema + "' not expected" );

        }

        return false;
    }

    private void printArray(ArrayList<Token> t){

        for(int i = 0; i < t.size(); i++){

            System.out.println(t.get(i).token);
        }
    }

    private boolean decl(ArrayList<Token> tokens) {
        if( tokens.get(0).token == TokenType.Tipo ){

            if( tokens.get(1).token == TokenType.Identifier ){

                if( tokens.get(2).token == TokenType.PuntoyComa ){
                    System.out.println("decl");
                    return true;
                }
            }

            // Si no fue una declaracion de primer tipo, se intentara segundo tipo
            // decl:: <type> <assign>

            this.assign( new ArrayList<Token>(tokens.subList(1, tokens.size())) );


        }
        return false;
    }

    private boolean assign(ArrayList<Token> tokens) {

            if( tokens.get(0).token == TokenType.Identifier ){
                if( tokens.get(1).token == TokenType.Equal ){
                    if(tokens.get(2).token == TokenType.Constante){


                        if( tokens.get(3).token == TokenType.PuntoyComa ){
                            System.out.println("assign");
                            return true;
                         }

                    }

                }else{
                    Errors.add("Expecting equal lexema");

                }

        }
        return false;
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

            else if( Symbols.table.get(i).token == TokenType.CerrarLlave ){

                sent(tmp);
                tmp.clear();

            }

        }

    }

}
