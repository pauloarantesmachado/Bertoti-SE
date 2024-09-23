package com.single;

public class Singleton {
    private static Singleton iSingleton;

    private Singleton(){
    }

    public static Singleton getISingleton(){
        if(iSingleton == null){
            iSingleton = new Singleton();
        }
        return iSingleton;
    }
}
