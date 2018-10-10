package com.company;


import javax.sound.midi.SysexMessage;
import java.io.File;
import java.io.FileInputStream;
import java.util.StringTokenizer;
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
                tmp += character;

            }
            StringTokenizer t = new StringTokenizer(tmp);

            while(t.hasMoreTokens()){
                String token = t.nextToken();
                Boolean found = false;
                for(int a = 0; a < tokenizer.tokens.size(); a++){

                    if(token.matches(tokenizer.tokens.get(a).r)){
                        System.out.println(token + " | " + tokenizer.tokens.get(a).t);
                        Symbols.table.put(token, tokenizer.tokens.get(a).t);
                        found = true;
                        break;
                    }
                }
                if(!found) System.out.println("Error lexico: '" + token + "' no reconocido");

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
