package com.company;

public class Semantic {

    public void Semantic(){

        //Validar tipo de datos
        //Variable exista
        //Variable duplicadaas


        //Utiliza tabla Trick para comprobar t






    }


    public boolean validate(String tipo, String d){

        switch (tipo){
            case "Morty":

                Integer.parseInt()



                break;
        }



    }

    public void analize(){


        for( int i = 0; i < Trick.trick.size(); i++ ){

            if( Trick.trick.get(i).tipo.equals("decl")){


                String tipo = Trick.trick.get(i).token.get(0).lexema;
                String id = Trick.trick.get(i).token.get(1).lexema;

                if(Variables.searchById(id)){
                    Errors.add("Variable " + id + " already declared");
                }else{


                    Variable v = new Variable();
                    v.id = id;
                    v.tipo = tipo;

                    //Si tambien hay asignacion
                    //Validar tipo de dato
                    if( Trick.trick.get(i).token.size() > 3 ){

                        String dato = Trick.trick.get(i).token.get(i).lexema;

                        if( this.validate( tipo, dato ) ){


                            Variables.add(v);

                        }else{

                            Errors.add("Type error: Variable expecting its type");

                        }



                    }else{

                    Variables.add(v);
                    //Valida tipo
                    //Add
                    }

                }

                System.out.println(Trick.trick.get(i).token.get(1).lexema);
                //Buscar identificador
                //Si existe ERROR
                //SI no existe AGREGAR

            }


        }


    }
}
