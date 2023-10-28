package main;

import GameObjects.*;

import java.lang.ref.PhantomReference;

public class Map {
    char[][] map;
    public Map(Game game){
        Handler handler = game.getHandler();
        this.map = setNewMap();
        // create object for each element in the newly produced map and add to handler
        int i = 0, j = 0;

        for (char[] row: map){
            for (char obj : row){
                
                if (obj=='P'){  //Player
                    Player p = new Player((i*50),(j*50), ID.Player, handler);
                    handler.addObject(p);
                } else if (obj=='p') {  //pumpkin
                    Pumpkin p = new Pumpkin((i*50),(j*50), ID.Pumpkin);
                    handler.addObject(p);
                } else if (obj=='h') {
                    Hedge h = new Hedge((i*50),(j*50), ID.Hedge);
                    handler.addObject(h);
                } else if (obj=='G') { //Golden pumpkin
                    GoldenPumpkin g = new GoldenPumpkin((i*50),(j*50), ID.GoldenPumpkin);
                    handler.addObject(g);
                } else if (obj=='g') {   //goo
                    Goo g = new Goo((i*50),(j*50), ID.Goo);
                    handler.addObject(g);
                } else if (obj=='q') {   // question sheet
                    QuestionSheet q = new QuestionSheet((i*50),(j*50), ID.QuestionSheet);
                    handler.addObject(q);
                } else if (obj=='E') { // exit
                    Exit e = new Exit((i*50),(j*50), ID.Exit);
                    handler.addObject(e);
                }
            }
        }


    }

    private char[][] setNewMap(){
        // example map derived from chat gpt
        // hopefully connect this to ChatGPT to produce a new map every time

        return  new char[][]  {
                {'P', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h'},
                {'e', 'e', 'h', 'e', 'h', 'e', 'e', 'e', 'e', 'e', 'h', 'e', 'h', 'e', 'e', 'e', 'e', 'e', 'e', 'h'},
                {'h', 'e', 'h', 'e', 'h', 'e', 'h', 'h', 'h', 'e', 'h', 'e', 'h', 'e', 'h', 'h', 'h', 'e', 'h', 'h'},
                {'h', 'e', 'h', 'e', 'e', 'e', 'h', 'e', 'e', 'e', 'h', 'e', 'e', 'e', 'h', 'e', 'h', 'e', 'e', 'h'},
                {'h', 'e', 'h', 'h', 'h', 'h', 'h', 'e', 'h', 'h', 'h', 'e', 'h', 'h', 'h', 'e', 'h', 'h', 'e', 'h'},
                {'h', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'h', 'e', 'e', 'e', 'e', 'h'},
                {'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'e', 'h', 'h', 'h', 'h', 'h', 'E'},
                {'h', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'h', 'e', 'e', 'e', 'e', 'h'},
                {'h', 'e', 'h', 'h', 'h', 'e', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'e', 'h', 'h', 'h', 'h', 'h', 'h'},
                {'h', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'h'}
        };
    }
}
