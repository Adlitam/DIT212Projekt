package edu.gu.maze.util;

import edu.gu.maze.model.*;
import edu.gu.maze.view.*;
import javafx.scene.image.ImageView;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author omega
 */
public class ResourceReader {
    //for usage, see test file
    @SuppressFBWarnings("DM_DEFAULT_ENCODING")
    public static Match readMapForModel(String filename){
        Scanner s;
        try {
        s = new Scanner(new File(filename));
        } catch (FileNotFoundException e){
            throw new RuntimeException ("Couldn't find Question file");
        }
        //The first line in the file should contain the starting x and y positions
        int x = Integer.parseInt(s.next());
        int y = Integer.parseInt(s.next());
        ArrayList<ISquare[]> list = new ArrayList<ISquare[]>();
        while(s.hasNext()){
            ArrayList<ISquare> snd = new ArrayList<ISquare>();
            for (char c : s.next().toCharArray()){
                if (c=='W') snd.add(new Wall());   
                else if (c=='F')snd.add(new FinalDoor());
                else if (c=='D')snd.add(new Door());
                else if (c=='Q')snd.add(new Questioner());
                else if (c=='M')snd.add(new Monster());
                else if (c=='C')snd.add(new Chest());
                else snd.add(new Road());
            }
            list.add(snd.toArray(new ISquare[1]));
        }
        return new Match (list.toArray(new ISquare[1][1]), x, y);
    }
    
    @SuppressFBWarnings("DM_DEFAULT_ENCODING")
    public static Question[] readQuestions(){
        Scanner s;
        try {
            
        s = new Scanner(new File("src/main/resources/edu/gu/maze/util/Questions.txt"));
        } catch (FileNotFoundException e){
            throw new RuntimeException ("Couldn't find Question file");
        }
        ArrayList<Question> list = new ArrayList();
        while (s.hasNextLine()){
            String question;
            do {
                question = s.nextLine();
            } while (question.isEmpty());
            String[] answers = new String[3];
            answers[0]= "A. " + s.nextLine();
            answers[1]= "S. " + s.nextLine();
            answers[2]= "D. " + s.nextLine();
            int right = Integer.parseInt(s.next());
            list.add(new Question(question, answers, right));
        }
        return list.toArray(new Question[1]);
    }

    public static ImageView[][] readMapForView(String filename){
        Scanner s = null;
        try{
            s = new Scanner(new File(filename));
        }catch(IOException e){
            System.out.println("could not read the file: " + filename + " while trying to initialize mapView.");
            System.exit(0);
        }
        s.next();
        s.next();
        ArrayList<ImageView[]> temp1 = new ArrayList();
        int i = 0;
        while(s.hasNext()){
            int j = 0;
            ArrayList<ImageView> temp2 = new ArrayList();
            for(char c : s.next().toCharArray()){
                switch(c){
                    case 'W':
                        temp2.add(new WallView(i,j));
                        break;
                    case 'R':
                        temp2.add(new RoadView(i,j));
                        break;
                    case 'F':
                        temp2.add(new FinalDoorView(i,j));
                        break;
                    case 'D':
                        temp2.add(new DoorView(i,j));
                        break;
                    case 'M':
                        temp2.add(new MonsterView(i,j));
                        break;
                    case 'Q':
                        temp2.add(new QuestionerView(i,j));
                        break;
                    case 'C':
                        temp2.add(new ChestView(i,j));
                        break;
                    default:
                        System.out.println("Arrggghhh! Something went wrong when reading the level map for the view.");
                        System.exit(0);
                }
                j++;
            }
            temp1.add(temp2.toArray(new ImageView[temp2.size()]));
            i++;
        }
        ImageView[][] map = temp1.toArray(new ImageView[i][temp1.size()]);
        return map;
    }
}
