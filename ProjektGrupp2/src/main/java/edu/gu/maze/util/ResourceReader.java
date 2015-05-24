package edu.gu.maze.util;

import edu.gu.maze.model.FinalDoor;
import edu.gu.maze.model.ISquare;
import edu.gu.maze.model.Match;
import edu.gu.maze.model.Road;
import edu.gu.maze.model.Wall;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author omega
 */
public class ResourceReader {
    //for usage, see test file
    public static Match readMapForModel(String filename){
        Scanner s;
        try {
        s = new Scanner(new File(filename));
        } catch (FileNotFoundException e){
            throw new RuntimeException ("Couldn't find file " + filename);
        }
        //The first line in the file should contain the starting x and y positions
        int x = Integer.parseInt(s.next());
        int y = Integer.parseInt(s.next());
        ArrayList<ISquare[]> list = new ArrayList();
        while(s.hasNext()){
            ArrayList<ISquare> snd = new ArrayList();
            for (char c : s.next().toCharArray()){
                if (c=='W') snd.add(new Wall());
                  
                else if (c=='F')snd.add(new FinalDoor());
                else snd.add(new Road());
            }
            list.add(snd.toArray(new ISquare[1]));
        }
        return new Match (list.toArray(new ISquare[1][1]), x, y);
    }
}
