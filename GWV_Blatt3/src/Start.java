import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
// Chris hat Stack Import gelöscht
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 3dibbern
 */
public class Start {
//neueste sachen der sachen
    public static final int LINE_COUNT = 10;
    public static final int LINE_LENGTH = 20;

    public static char[][] copy2DCharArray(char[][] original) {
        int sizeY = original.length;
        char[][] copy = new char[sizeY][];

        for (int y = 0; y < sizeY; ++y) {
            copy[y] = original[y].clone();
        }
        return copy;
    }

    public static void print2DCharArray(char[][] array) {

    }

    public Start() {
        // DeepFirstSearch();
        BreadthFirstSearch();
    }

    /**
     * Sets up the search environment and initiates the search process.
     */
    public final void BreadthFirstSearch() {
        URL statespace = getClass().getResource("resources/blatt3_environment.txt");

        EnvironmentReader reader = null;
        try {
            reader = new EnvironmentReader("blatt3_environment.txt", LINE_COUNT, LINE_LENGTH);
        } catch (IOException ex) {
            Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
        }
        char[][] environment = reader.getEnvironment();

        for (int y = 0; y < 10; ++y) {
            String line = "";
            for (int x = 0; x < 20; ++x) {
                line = line + environment[y][x];
            }

            System.out.println(line);
        }

        System.out.println("X: " + reader.getStartPosX() + ", Y: " + reader.getStartPosY());
        
        Node goalNode = new Node(reader.getGoalPosX(), reader.getGoalPosY(), reader.getGoalChar());

//        Search dfs = new Search(environment, LINE_LENGTH, LINE_COUNT, reader.getStartPosX(), reader.getStartPosY());
//        List<Character> goalPath = Search.dfs(environment, reader.getStartPosX(), reader.getStartPosY());
        Search search = new Search(environment, reader.getStartPosX(), reader.getStartPosY(), goalNode);
        
        List<Character> goalPath = search.startBFS();

        System.out.println(goalPath.toString());
    }

    public final void DepthFirstSearch() {

        URL statespace = getClass().getResource("resources/blatt3_environment.txt");

        EnvironmentReader reader = null;
        try {
            reader = new EnvironmentReader("blatt3_environment.txt", LINE_COUNT, LINE_LENGTH);
        } catch (IOException ex) {
            Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
        }
        char[][] environment = reader.getEnvironment();

        for (int y = 0; y < 10; ++y) {
            String line = "";
            for (int x = 0; x < 20; ++x) {
                line = line + environment[y][x];
            }

            System.out.println(line);
        }

        System.out.println("X: " + reader.getStartPosX() + ", Y: " + reader.getStartPosY());
        
        Node goalNode = new Node(reader.getGoalPosX(), reader.getGoalPosY(), reader.getGoalChar());

//        Search dfs = new Search(environment, LINE_LENGTH, LINE_COUNT, reader.getStartPosX(), reader.getStartPosY());
//        List<Character> goalPath = Search.dfs(environment, reader.getStartPosX(), reader.getStartPosY());
        Search search = new Search(environment, reader.getStartPosX(), reader.getStartPosY(), goalNode);
        List<Character> goalPath = search.startDFS();

        System.out.println(goalPath.toString());

    }

    

    
    
}
