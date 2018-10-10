package com.company;



import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.File;
import java.io.FileInputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexical {


    public void readFile(String path){
        try {
            FileInputStream fis = new FileInputStream(new File(path));
            //Lee el archivo y genera tabal de simbolos

            Tokenizer tokenizer = new Tokenizer();

            int size = fis.available();
            //System.out.print("Size of chars:" + size);
            String tmp = "";
            for(int i = 0; i < size; i++){
                char character = (char)fis.read();
                //System.out.println("Character: " + character);
                if(character != ' ' && character != ';') tmp += character;
                //System.out.println("Temp: " + tmp);
                if((character == ' ' || character == ';' ) && tmp.length() != 0){
                    //System.out.println("Entro:" + tmp);
                    for(int a = 0; a < tokenizer.tokens.size(); a++){
                        if(tmp.matches(tokenizer.tokens.get(a).r)){
                            System.out.println(tmp+" | " + tokenizer.tokens.get(a).t);
                            Symbols.table.put(tmp, tokenizer.tokens.get(a).t);
                            tmp = "";
                            break;
                        }
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
