package com.company;

public class Syntactic {

    //Este método análiza sintácticamente la lista del analizador léxico.
    public void syntacticReadFile(){

        TokenType value = Symbols.table.get("Morty");
        String revisar = value.toString();
        System.out.println(revisar);
        TokenType value2 = Symbols.table.get("x");
        revisar += ("+" + value2.toString());
        System.out.println(revisar);
        /*TokenType value3 = Symbols.table.get("=");
        revisar += ("+" + value3.toString());
        System.out.println(revisar);
        TokenType value4 = Symbols.table.get("3");
        revisar += ("+" + value4.toString());
        System.out.println(revisar);*/
        TokenType value5 = Symbols.table.get(";");
        revisar += ("+" + value5.toString());
        System.out.println(revisar);

        //Declaración
        if(revisar.equals("Tipo+Identifier+PuntoyComa")) {
            System.out.println("Declaración");
            if (revisar.equals("Tipo+Identifier+Equal+Constante+PuntoyComa")) {
                System.out.println("Declaración");
            }
        }
    }

    /* ~~~~Gramática~~~~
    Esta es para la clase del martes 23 de Octubre, está Hardcodeado
    (Declaración de variables) decl °°  (Entero) Reservada + (x) Identifier + (=) Equal + (3) Constante + (;) PuntoyComa
     */
}
