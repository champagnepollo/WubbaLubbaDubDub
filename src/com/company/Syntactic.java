package com.company;


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
            System.out.println("Excepctiong: <TYPE> Rick(){");

            System.exit(-1);

        }




        int simCounter = 0;
        boolean declaracion = true;
        boolean isChecked = true;
        for(int i = 0; i < Symbols.table.size(); i++){

                isChecked = true;
                if(simCounter == 0){
                    if(Symbols.table.get(i).token == TokenType.Tipo){
                        simCounter++;
                        isChecked = false;
                        System.out.println("Primero");
                    }else{
                        declaracion = false;
                        System.out.println(declaracion);
                    }
                }
                if(simCounter == 1 && isChecked){
                    if(Symbols.table.get(i).token == TokenType.Identifier ){
                        simCounter++;
                        isChecked = false;
                        System.out.println("Segundo");
                    }else{
                        declaracion = false;
                        System.out.println(declaracion);
                    }
                }
                if(simCounter == 2 && isChecked){
                    if(Symbols.table.get(i).token == TokenType.PuntoyComa){
                        simCounter = 0;
                        System.out.println("Tercero");
                        break;

                    }else{
                        declaracion = false;
                        System.out.println(declaracion);
                    }
                }

        }

        if(declaracion){
            System.out.println("Declaracion");
        }else
            {
                System.out.println("No es declaracion");
            }

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

    private int EntryAt() {

        int entryIndex = -1;

        for( int i = 0; i < Symbols.table.size(); i++){

            if( Symbols.table.get(i).lexema.equals("Rick")){
                entryIndex = i;
            }

        }

        return entryIndex;

    }

    /* ~~~~Gramática~~~~
    Esta es para la clase del martes 23 de Octubre, está Hardcodeado
    (Declaración de variables) decl °°  (Entero) Reservada + (x) Identifier + (=) Equal + (3) Constante + (;) PuntoyComa
     */
}
