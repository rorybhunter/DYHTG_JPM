package main;
import MazeGenerator.MazeGenerator;

import GameObjects.*;

public class Map {
    int[][] map;
    public Map(Game game){
        Handler handler = game.getHandler();
        this.map = setNewMap();
        // create object for each element in the newly produced map and add to handler
        int i = 0, j = 0;

        for (int[] row: map){

            j=0;
            for (int obj : row){
                if (obj=='2') {  //pumpkin
                    Pumpkin p = new Pumpkin((j*50),(i*50), ID.Pumpkin);
                    handler.addObject(p);
                } else if (obj=='1') {
                    Hedge h = new Hedge((j*50),(i*50), ID.Hedge);
                    handler.addObject(h);
                } else if (obj=='G') { //Golden pumpkin
                    Chest c = new Chest((j*50), i*50, ID.Chest);
                    handler.addObject(c);
                } else if (obj=='g') {   //goo
                    Goo g = new Goo((j*50),(i*50), ID.Goo);
                    handler.addObject(g);
                } else if (obj=='q') {   // question sheet
                    QuestionSheet q = new QuestionSheet((i*50),(j*50), ID.QuestionSheet);
                    handler.addObject(q);
                } else if (obj=='E') { // exit
                    Exit e = new Exit((j*50),(i*50), ID.Exit);
                    handler.addObject(e);
                }
                j++;
            }
            i++;
        }

        //adding the player last, so it appears above all the other entities
        Player p = new Player(50,50, ID.Player, handler);
        handler.addObject(p);
    for (GameObject g: handler.object.stream().toList()){
        System.out.println(g.getX());
    }
    }

    private int[][] setNewMap() {
        // example map derived from chat gpt
        // hopefully connect this to ChatGPT to produce a new map every time

//        return  new char[][]  {
//                {'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h'},
//                {'h', 'e', 'h', 'g', 'h', 'e', 'e', 'e', 'e', 'e', 'h', 'e', 'h', 'e', 'p', 'e', 'e', 'e', 'e', 'h'},
//                {'h', 'e', 'h', 'e', 'h', 'e', 'h', 'h', 'h', 'e', 'h', 'e', 'h', 'e', 'h', 'h', 'h', 'e', 'h', 'h'},
//                {'h', 'g', 'h', 'e', 'e', 'e', 'h', 'e', 'e', 'e', 'h', 'e', 'e', 'e', 'h', 'e', 'h', 'e', 'e', 'h'},
//                {'h', 'e', 'h', 'h', 'h', 'h', 'h', 'e', 'h', 'h', 'h', 'e', 'h', 'h', 'h', 'e', 'h', 'h', 'e', 'h'},
//                {'h', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'q', 'e', 'e', 'e', 'e', 'h', 'e', 'e', 'e', 'e', 'h'},
//                {'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'e', 'h', 'h', 'h', 'h', 'E', 'h'},
//                {'h', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'h', 'e', 'e', 'e', 'e', 'h'},
//                {'h', 'e', 'h', 'h', 'h', 'e', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'e', 'h', 'h', 'h', 'e', 'h', 'h'},
//                {'h', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'h'},
//                {'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h'}
//
//        };
//        return new char[][] {
//                {'P', 'h', 'e', 'e', 'e', 'h', 'e', 'e', 'e', 'e', 'h', 'e', 'e', 'e', 'e', 'h', 'e', 'e', 'e', 'E'},
//                {'e', 'h', 'e', 'h', 'e', 'e', 'e', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'e', 'e', 'h', 'e', 'e', 'e'},
//                {'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e'},
//                {'h', 'h', 'h', 'e', 'h', 'h', 'h', 'e', 'h', 'h', 'h', 'h', 'h', 'h', 'e', 'h', 'h', 'h', 'h', 'h'},
//                {'e', 'e', 'e', 'e', 'h', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e'},
//                {'e', 'h', 'h', 'h', 'h', 'e', 'e', 'h', 'h', 'h', 'e', 'h', 'h', 'e', 'h', 'h', 'e', 'e', 'h', 'e'},
//                {'e', 'e', 'e', 'e', 'e', 'e', 'e', 'h', 'e', 'e', 'e', 'h', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e'},
//                {'h', 'h', 'h', 'e', 'h', 'h', 'e', 'h', 'e', 'h', 'h', 'h', 'e', 'h', 'e', 'h', 'h', 'h', 'h', 'h'},
//                {'e', 'e', 'e', 'e', 'h', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e'},
//                {'h', 'h', 'e', 'h', 'h', 'h', 'h', 'e', 'h', 'h', 'h', 'h', 'h', 'h', 'e', 'e', 'e', 'e', 'h', 'e'}
//        };
//        return new char[][] {
//                {'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h'},
//                {'h', 'P', 'e', 'h', 'h', 'e', 'e', 'h', 'h', 'e', 'e', 'e', 'e', 'h', 'h', 'e', 'e', 'e', 'e', 'h'},
//                {'h', 'e', 'h', 'h', 'e', 'h', 'e', 'h', 'h', 'e', 'h', 'h', 'e', 'h', 'h', 'h', 'h', 'e', 'h', 'h'},
//                {'h', 'e', 'h', 'h', 'e', 'h', 'e', 'e', 'e', 'e', 'h', 'h', 'e', 'e', 'e', 'h', 'h', 'e', 'h', 'h'},
//                {'h', 'e', 'h', 'h', 'e', 'e', 'h', 'h', 'h', 'h', 'e', 'e', 'e', 'h', 'e', 'h', 'h', 'e', 'h', 'h'},
//                {'h', 'e', 'e', 'e', 'e', 'h', 'h', 'e', 'h', 'h', 'e', 'h', 'e', 'h', 'e', 'e', 'e', 'e', 'e', 'h'},
//                {'h', 'h', 'h', 'h', 'h', 'e', 'h', 'e', 'h', 'h', 'e', 'e', 'e', 'e', 'e', 'h', 'h', 'h', 'h', 'h'},
//                {'h', 'e', 'e', 'h', 'e', 'h', 'h', 'e', 'h', 'e', 'e', 'h', 'h', 'h', 'e', 'e', 'e', 'e', 'h', 'h'},
//                {'h', 'h', 'e', 'h', 'e', 'e', 'e', 'e', 'e', 'h', 'e', 'e', 'h', 'e', 'e', 'h', 'h', 'e', 'h', 'h'},
//                {'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'E', 'h', 'h'}
//        };

        MazeGenerator mazeGenerator = new MazeGenerator(15);
        return mazeGenerator.getRawMaze();
    }
}
