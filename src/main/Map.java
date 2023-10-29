package main;

import GameObjects.*;

public class Map {
    char[][] map;
    Game game;
    Player player;
    Handler handler;
    public Map(Game game){
        this.handler = game.getHandler();
        System.out.println(handler);
        this.game = game;
        this.map = setNewMap();
        setMap(map);
        Player p = new Player(1 * 50, 1 * 50, ID.Player, handler, game);
        handler.addObject(p);
        this.player=p;
    }
    public void setMap(char[][] map){
        // create object for each element in the newly produced map and add to handler
        int i = 0, j = 0;

        for (char[] row: map){

            j=0;
            for (char obj : row){
                if (obj=='p') {  //pumpkin
                    Pumpkin p = new Pumpkin((j*50),(i*50), ID.Pumpkin);
                    handler.addObject(p);
                } else if (obj=='h') {
                    Hedge h = new Hedge((j*50),(i*50), ID.Hedge);
                    handler.addObject(h);
                } else if (obj=='G') { //Golden pumpkin
                    Chest c = new Chest((j*50), i*50, ID.Chest);
                    handler.addObject(c);
                } else if (obj=='g') {   //goo
                    Goo g = new Goo((j*50),(i*50), ID.Goo);
                    handler.addObject(g);
                } else if (obj=='c') {
                    Chest c = new Chest((j*50),(i*50), ID.Chest);
                    handler.addObject(c);
                } else if (obj=='E') { // exit
                    Exit e = new Exit((j*50),(i*50), ID.Exit);
                    handler.addObject(e);
                }
                j++;
            }
            i++;
        }

        //adding the player last so it apears above all of the other entities


    }

    public Player getPlayer() {
        return player;
    }

    public char[][] setNewMap() {
//        MazeGenerator mazeGenerator = new MazeGenerator(10);
//        mazeGenerator.generateMaze();
//        return mazeGenerator.getRawMaze();
        char[][] maze;
        if (game.getLevel() == 0) {
            System.out.println("map1");
            return new char[][]{
                    {'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h'},
                    {'h', 'e', 'h', 'c', 'h', 'e', 'e', 'e', 'e', 'e', 'h', 'e', 'h', 'e', 'p', 'c', 'e', 'e', 'e', 'h'},
                    {'h', 'e', 'h', 'g', 'h', 'g', 'h', 'h', 'h', 'e', 'h', 'e', 'h', 'e', 'h', 'h', 'h', 'e', 'h', 'h'},
                    {'h', 'g', 'h', 'e', 'g', 'e', 'h', 'e', 'e', 'e', 'h', 'e', 'e', 'e', 'h', 'e', 'h', 'e', 'e', 'h'},
                    {'h', 'e', 'h', 'h', 'h', 'h', 'h', 'e', 'h', 'h', 'h', 'e', 'h', 'h', 'h', 'e', 'h', 'h', 'e', 'h'},
                    {'h', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'q', 'e', 'e', 'e', 'e', 'h', 'e', 'e', 'e', 'e', 'h'},
                    {'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'e', 'h', 'h', 'h', 'h', 'E', 'h'},
                    {'h', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'h', 'e', 'e', 'e', 'e', 'h'},
                    {'h', 'e', 'h', 'h', 'h', 'e', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'e', 'h', 'h', 'h', 'e', 'h', 'h'},
                    {'h', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'h'},
                    {'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h'},
                    {'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h'}
            };
        } else if (game.getLevel() == 1) {
            System.out.println("map2");

            return new char[][]{
                    {'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h'},
                    {'h', 'P', 'e', 'c', 'e', 'h', 'e', 'h', 'e', 'e', 'e', 'h', 'e', 'h', 'e', 'e', 'e', 'h', 'c', 'h'},
                    {'h', 'h', 'e', 'h', 'e', 'h', 'e', 'h', 'h', 'h', 'h', 'h', 'e', 'h', 'h', 'h', 'e', 'e', 'e', 'h'},
                    {'h', 'e', 'e', 'e', 'g', 'h', 'e', 'e', 'g', 'h', 'e', 'e', 'e', 'h', 'e', 'e', 'e', 'e', 'h', 'h'},
                    {'h', 'e', 'h', 'h', 'h', 'h', 'e', 'h', 'h', 'h', 'e', 'h', 'e', 'h', 'h', 'h', 'e', 'h', 'e', 'h'},
                    {'h', 'e', 'h', 'e', 'e', 'e', 'e', 'e', 'e', 'h', 'e', 'h', 'e', 'h', 'e', 'h', 'e', 'h', 'e', 'h'},
                    {'h', 'e', 'e', 'e', 'h', 'e', 'e', 'h', 'e', 'h', 'e', 'h', 'e', 'h', 'e', 'h', 'e', 'h', 'e', 'h'},
                    {'h', 'e', 'h', 'e', 'h', 'h', 'e', 'h', 'e', 'h', 'e', 'e', 'e', 'h', 'e', 'h', 'e', 'h', 'e', 'h'},
                    {'h', 'e', 'e', 'e', 'e', 'e', 'e', 'h', 'e', 'e', 'e', 'h', 'h', 'h', 'e', 'h', 'e', 'e', 'e', 'h'},
                    {'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'E', 'h', 'h', 'h', 'h', 'h', 'h'},
                    {'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h'}
            };
        }
        return null;
    }
}
