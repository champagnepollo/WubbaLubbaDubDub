package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.util.StringTokenizer;

public class Lexical {
    private String file;
    private void readFile(String path) {
        try {
            FileInputStream fis = new FileInputStream(new File(path));

            int size = fis.available();
            this.file = "";
            for (int i = 0; i < size; i++) {
                char character = (char) fis.read();
                this.file += character;
            }
        } catch (Exception e) {
            System.out.print(e.toString());
        } finally {
        }
    }

    public void analize(String path){

        this.readFile(path);

        StringTokenizer t = new StringTokenizer(this.file, ";(){}\n ", true);
        Tokenizer tokenizer = new Tokenizer();

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
    }
}