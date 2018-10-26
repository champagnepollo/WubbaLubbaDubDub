package com.company;


public class Syntactic {

    //Este método análiza sintácticamente la lista del analizador léxico.
    public void analize(){
        int simCounter = 0;
        boolean declaracion = true;
        boolean isChecked = true;
        for(int i = 0; i < Symbols.table.size(); i++){

                isChecked = true;
                if(simCounter == 0){
                    if(Symbols.table.get(i).t == TokenType.Tipo){
                        simCounter++;
                        isChecked = false;
                        System.out.println("Primero");
                    }else{
                        declaracion = false;
                        System.out.println(declaracion);
                    }
                }
                if(simCounter == 1 && isChecked){
                    if(Symbols.table.get(i).t == TokenType.Identifier ){
                        simCounter++;
                        isChecked = false;
                        System.out.println("Segundo");
                    }else{
                        declaracion = false;
                        System.out.println(declaracion);
                    }
                }
                if(simCounter == 2 && isChecked){
                    if(Symbols.table.get(i).t == TokenType.PuntoyComa){
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

    /* ~~~~Gramática~~~~
    Esta es para la clase del martes 23 de Octubre, está Hardcodeado
    (Declaración de variables) decl °°  (Entero) Reservada + (x) Identifier + (=) Equal + (3) Constante + (;) PuntoyComa
     */
}
