package com.company;

import java.util.ArrayList;

public class Tokenizer {

    public ArrayList<Lexema> tokens;

    //Se crea una lista de tokens que tiene como parámetros la clase Lexema (tipo de token y string). Aquí está nuestra gramática también.
    public Tokenizer() {
            this.tokens = new ArrayList<Lexema>();
            this.tokens.add(new Lexema(TokenType.Comentario, "(//(.*?)[\r$]?\n).*"));
            this.tokens.add(new Lexema(TokenType.Espacio, "( ).*"));
            this.tokens.add(new Lexema(TokenType.AbrirParentesis, "(\\().*"));
            this.tokens.add(new Lexema(TokenType.CerrarParentesis, "(\\)).*"));
            this.tokens.add(new Lexema(TokenType.PuntoyComa, "(;).*"));
            this.tokens.add(new Lexema(TokenType.AbrirParentesis, "(\\().*"));
            this.tokens.add(new Lexema(TokenType.Coma, "(,).*"));
            this.tokens.add(new Lexema(TokenType.AbrirLlave, "(\\{).*"));
            this.tokens.add(new Lexema(TokenType.CerrarLlave, "(\\}).*"));
            this.tokens.add(new Lexema(TokenType.Spacecruiser, "\\b(\\d{1,9}\\.\\d{1,32})\\b.*"));
            this.tokens.add(new Lexema(TokenType.Reservadas, "Yes|Cake|Mahman|Summer|Spacecruiser|Jerry|Schezwan|Passthebutter|Adventure|Jellybean|Plumbus|Dead|Alive|Meeseek|Morty|Microverse|Rick"));
            this.tokens.add(new Lexema(TokenType.Identifier, "([a-zA-Z]{1}[0-9a-zA-Z_]{0,31})*"));
            this.tokens.add(new Lexema(TokenType.Spacecruiser, "\\b(Morty|Spacecrusier)\\b.*"));
            this.tokens.add(new Lexema(TokenType.Tab, "(\\t).*"));
            this.tokens.add(new Lexema(TokenType.Enter, "\\n"));
            this.tokens.add(new Lexema(TokenType.Point, "(\\.).*"));
            this.tokens.add(new Lexema(TokenType.Plus, "(\\+{1}).*"));
            this.tokens.add(new Lexema(TokenType.PlusPlus, "(\\+{2}).*"));
            this.tokens.add(new Lexema(TokenType.Minus, "(\\-{1}).*"));
            this.tokens.add(new Lexema(TokenType.MinusMinus, "(\\-{1}).*"));
            this.tokens.add(new Lexema(TokenType.Multiply, "(\\*).*"));
            this.tokens.add(new Lexema(TokenType.Divide, "(/).*"));
            this.tokens.add(new Lexema(TokenType.Module, "(\\%).*"));
            this.tokens.add(new Lexema(TokenType.EqualEqual, "(==).*"));
            this.tokens.add(new Lexema(TokenType.Equal, "(=).*"));
            this.tokens.add(new Lexema(TokenType.ExclameEqual, "(\\!=).*"));
            this.tokens.add(new Lexema(TokenType.Greater, "(>).*"));
            this.tokens.add(new Lexema(TokenType.Less, "(<).*"));
            this.tokens.add(new Lexema(TokenType.LessEqual, "(<=).*"));
            this.tokens.add(new Lexema(TokenType.GreaterEqual, "(>=).*"));
            this.tokens.add(new Lexema(TokenType.Summer, ("\"(.*?)\"")));
            this.tokens.add(new Lexema(TokenType.Constante, ("-?[0-9]+")));
    }
}