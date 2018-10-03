package com.company;

import com.sun.tools.corba.se.idl.ExceptionEntry;

import java.io.File;
import java.io.FileInputStream;

public class Lexical {


    public void readFile(String path){
        try {
            FileInputStream fis = new FileInputStream(new File(path));
            //Lee el archivo y genera tabal de simbolos
            Tokenizer tokenizer = new Tokenizer();

            int size = fis.available();
            String tmp = "";
            for(int i = 0; i < size; i++){
                char character = (char)fis.read();
                tmp += character;
                while(character != ' '){

                    if(tokenizer.contains(tmp)){
                        continue;
                    }else{
                        System.out.print("Token no reconocido");
                        System.exit(1);
                    }


                }

            }

        }catch (Exception e) {

        }finally{

        }
        /*
        * Aqui va suceder la magia
        *  - Michael Joseph Gregory Jackson
        * */
    }





}
