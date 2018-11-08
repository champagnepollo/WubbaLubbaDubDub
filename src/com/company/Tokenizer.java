package com.company;

import java.util.ArrayList;

public class Tokenizer {

    public ArrayList<Token> tokens;

    public Tokenizer() {
            this.tokens = new ArrayList<Token>();
            this.tokens.add(new Token(TokenType.Comentario, "(//(.*?)[\r$]?\n).*"));
            this.tokens.add(new Token(TokenType.Espacio, "( ).*"));
            this.tokens.add(new Token(TokenType.AbrirParentesis, "(\\().*"));
            this.tokens.add(new Token(TokenType.CerrarParentesis, "(\\)).*"));
            this.tokens.add(new Token(TokenType.PuntoyComa, "(;).*"));
            this.tokens.add(new Token(TokenType.AbrirParentesis, "(\\().*"));
            this.tokens.add(new Token(TokenType.Coma, "(,).*"));
            this.tokens.add(new Token(TokenType.AbrirLlave, "(\\{).*"));
            this.tokens.add(new Token(TokenType.CerrarLlave, "(\\}).*"));
            this.tokens.add(new Token(TokenType.Spacecruiser, "\\b(\\d{1,9}\\.\\d{1,32})\\b.*"));
            this.tokens.add(new Token(TokenType.Condition, "Yes"));
            this.tokens.add(new Token(TokenType.Reservadas, "Yes|Cake|Mahman|Jerry|Schezwan|Passthebutter|Adventure|Jellybean|Plumbus|Dead|Alive|Rick"));
            this.tokens.add(new Token(TokenType.Tipo, "Summer|Meeseek|Morty|Microverse|Spacecruiser"));
            this.tokens.add(new Token(TokenType.Identifier, "([a-zA-Z]{1}[0-9a-zA-Z_]{0,31})*"));
            this.tokens.add(new Token(TokenType.Spacecruiser, "\\b(Morty|Spacecrusier)\\b.*"));
            this.tokens.add(new Token(TokenType.Tab, "(\\t).*"));
            this.tokens.add(new Token(TokenType.Enter, "\\n"));
            this.tokens.add(new Token(TokenType.Point, "(\\.).*"));
            this.tokens.add(new Token(TokenType.Plus, "(\\+{1}).*"));
            this.tokens.add(new Token(TokenType.PlusPlus, "(\\+{2}).*"));
            this.tokens.add(new Token(TokenType.Minus, "(\\-{1}).*"));
            this.tokens.add(new Token(TokenType.MinusMinus, "(\\-{1}).*"));
            this.tokens.add(new Token(TokenType.Multiply, "(\\*).*"));
            this.tokens.add(new Token(TokenType.Divide, "(/).*"));
            this.tokens.add(new Token(TokenType.Module, "(\\%).*"));
            this.tokens.add(new Token(TokenType.EqualEqual, "(==).*"));
            this.tokens.add(new Token(TokenType.Equal, "(=).*"));
            this.tokens.add(new Token(TokenType.ExclameEqual, "(\\!=).*"));
            this.tokens.add(new Token(TokenType.Greater, "(>).*"));
            this.tokens.add(new Token(TokenType.Less, "(<).*"));
            this.tokens.add(new Token(TokenType.LessEqual, "(<=).*"));
            this.tokens.add(new Token(TokenType.GreaterEqual, "(>=).*"));
            this.tokens.add(new Token(TokenType.Summer, ("\"(.*?)\"")));
            this.tokens.add(new Token(TokenType.Constante, ("-?[0-9]+")));
    }
}