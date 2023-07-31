package com.example.tamagotchi;

public class PetException extends Exception{
    private String msg;
    @Override
    public String toString() {
        return msg;
    }

    public PetException(String msg) {
        this.msg = msg;
    }
}
