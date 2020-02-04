package com.company;

import java.util.Iterator;
import java.util.LinkedList;

public class Album {
    LinkedList<Song> album = new LinkedList<Song>();
    private String albumName;

    public Album(String albumName){
        this.albumName = albumName;
    }

    public void addSongsToAlbum(Song song){
        album.add(song);
    }

    public void printAlbum(){
        Iterator<Song> i = album.iterator();
        while(i.hasNext()){
            System.out.println(i.next().getSong());
        }
    }
}
