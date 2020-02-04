package com.company;

import java.util.Iterator;
import java.util.LinkedList;

public class PlayList {
    LinkedList<Song> playList = new LinkedList<Song>();
    private String playListName;

    public PlayList(String playListName){
        this.playListName = playListName;
    }

    public LinkedList getPlayList(){
        return playList;
    }

    public void addSong(Song song){
        playList.add(song);
    }
    public void printList(){
        System.out.println("========= "+this.playListName+" ==========");
        Iterator<Song> i = playList.iterator();
        while(i.hasNext()){
            System.out.println(i.next().getSong());
        }
    }
}
