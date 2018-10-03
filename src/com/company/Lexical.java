package com.company;


import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.File;
import java.io.FileInputStream;

public class Lexical {


    public void readFile(String path){
        try {
            FileInputStream fis = new FileInputStream(new File(path));
            //Lee el archivo y genera tabal de simbolos

            Tokenizer tokenizer = new Tokenizer();

            int size = fis.available();
            System.out.print("Size of chars:" + size);
            String tmp = "";
            for(int i = 0; i < size; i++){
                char character = (char)fis.read();
                System.out.println("Character: " + character);
                if(character != ' ') tmp += character;
                System.out.println("Temp: " + tmp);

                if(character == ' '){
                    if(tokenizer.contains(tmp)){
                        //Agregarlo a la lista de simbolos
                        System.out.println("Token identificado");
                        tmp = "";
                        continue;
                    }else{
                        System.out.println("Token no definido");

                    }
                }



            }

        }catch (Exception e) {
            System.out.print(e.toString());
        }finally{

        }
        /*
        * Aqui va suceder la magia
        *  - Michael Joseph Gregory Jackson
        * */
    }





}
