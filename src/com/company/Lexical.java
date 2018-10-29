package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.util.StringTokenizer;

public class Lexical {
    private String file;

    //Función para leer el archivo a analizar por cada una de las letras colocándolas en un arreglo llamado "file".
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
    }//"file" se utiliza para el analizador léxico en la función analize.

    //Esta función manda llamar a readFile y con "file" comienza el análisis utilizando StringTokenizer.
    public void analize(String path){

        this.readFile(path);
        StringTokenizer t = new StringTokenizer(this.file, "*+-/=;(){}\n ", true);

        Tokenizer tokenizer = new Tokenizer();

        while(t.hasMoreTokens()){
                String lexema = t.nextToken();
                Boolean found = false;

                //Ciclará hasta tener un token que coincida.
                for(int a = 0; a < tokenizer.tokens.size(); a++){

                    //Compara para ver si algo coincide.
                    if(lexema.matches(tokenizer.tokens.get(a).lexema)){
                        System.out.println(lexema + " | " + tokenizer.tokens.get(a).token);


                        Symbols.addToken( tokenizer.tokens.get(a).token, lexema );

                        found = true;
                        break;
                    }
                }
                if(!found) System.out.println("Error lexico: '" + lexema + "' no reconocido");
        }
    }//Este método devuelve la tabla de símbolos para el analizador sintáctico.
}