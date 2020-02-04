package com.company;
import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	// write your code here
        Album everglow = new Album("everglow");
        Song dundun = new Song("Dun Dun Dun", 3.54);
        Song salute = new Song("Salute",2.55);
        Song adios = new Song("Adios",3.30);
        everglow.addSongsToAlbum(dundun);
        everglow.addSongsToAlbum(salute);
        everglow.addSongsToAlbum(adios);

        Album twice = new Album("twice");
        Song feelspecial = new Song("Feel Special", 3.54);
        Song what_is_love = new Song("What is Love",2.55);
        Song fancy = new Song("fancy",3.30);
        twice.addSongsToAlbum(feelspecial);
        twice.addSongsToAlbum(what_is_love);
        twice.addSongsToAlbum(fancy);

//        everglow.printAlbum();
//        twice.printAlbum();

        PlayList myPlayList = new PlayList("myPlayList");
        myPlayList.addSong(feelspecial);
        myPlayList.addSong(dundun);
        myPlayList.addSong(what_is_love);
        myPlayList.addSong(adios);

        myPlayList.printList();
        playSong(myPlayList);
    }

    private static void printMenu(){
        System.out.println("Available actions: \npress ");
        System.out.println("0 - to quit\n" +
                "1 - go to next song\n" +
                "2 - go to previous song\n" +
                "3 - replay song\n" +
                "4 - delete song\n" +
                "5 - print menu options");;
    }
    private static void playSong(PlayList myPlayList){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<Song> listIterator = myPlayList.getPlayList().listIterator();

        if(myPlayList.getPlayList().isEmpty()){
            System.out.println("Playlist is empty");
            return;
        }else{
            System.out.println("Now playing "+ listIterator.next().getSong());
            printMenu();
        }

        while(!quit){
            int action = scanner.nextInt();
            scanner.nextLine();
            switch(action){
                case 0:
                    System.out.println("Quitting Playlist :)");
                    quit = true;
                    break;
                case 1:
                    if(!goingForward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now playing: "+ listIterator.next().getTitle());
                    }else{
                        System.out.println("Reached end of playlist!");
                        goingForward = false;
                    }
                    break;
                case 2:
                    if(goingForward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now playing: "+ listIterator.previous().getTitle());
                    }else{
                        System.out.println("Reached the start of the playlist!");
                        goingForward = true;
                    }
                    break;
                case 3:
                    if(goingForward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now playing: "+ listIterator.previous().getTitle());
                            listIterator.next();
                        }else{
                            System.out.println("Cannot replay start of the playlist!");
                        }
                    }else if (!goingForward){
                        if(listIterator.hasNext()){
                            System.out.println("Now playing: "+ listIterator.next().getTitle());
                            listIterator.previous();
                        }else{
                            System.out.println("Cannot replay end of the playlist!");
                        }
                    }
                    break;
                case 4:
                    if(goingForward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Deleted: "+ listIterator.previous().getTitle());
                            listIterator.next();
                            listIterator.remove();
                        }else{
                            System.out.println("Cannot delete start of the playlist!");
                        }
                    }else if (!goingForward){
                        if(listIterator.hasNext()){
                            System.out.println("Deleted: "+ listIterator.next().getTitle());
                            listIterator.previous();
                            listIterator.remove();
                        }else{
                            System.out.println("Cannot delete end of the playlist!");
                        }
                    }
                    break;
                case 5:
                    printMenu();
                    break;
            }
        }
    }
}
