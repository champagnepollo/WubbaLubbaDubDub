package com.company;

import java.util.ArrayList;

public class Errors {

    public static ArrayList<String> errors = new ArrayList<>();

    public static void add(String error){
        Errors.errors.add(error);
    }

}
