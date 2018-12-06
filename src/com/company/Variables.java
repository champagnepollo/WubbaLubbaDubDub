package com.company;

import java.util.ArrayList;

public class Variables {



    public static ArrayList<Variable> v = new ArrayList<Variable>();

    public static void add(Variable v){
        Variables.v.add(v);
    }

    public static boolean searchById(String id){

        for(int i = 0; i < v.size(); i++){

            if(v.get(i).id.equals(id))
                return true;

        }
        return false;
    }
}
