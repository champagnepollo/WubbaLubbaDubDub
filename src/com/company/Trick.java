package com.company;

import java.util.ArrayList;

public class Trick {

    public static ArrayList< TrickToken > trick = new ArrayList<>();

    public static void add(TrickToken tt){

        Trick.trick.add( tt );
        System.out.println(Trick.trick.size());
    }




}
