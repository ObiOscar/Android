package com.example.oscar.recyclerview;

public class Titular {
    protected String titulo, subtitulo;


    public Titular(String tit, String sub){
        titulo = tit;
        subtitulo = sub;
    }

    public String getTitulo(){ return titulo; }

    public String getSubtitulo(){return subtitulo; }

}
