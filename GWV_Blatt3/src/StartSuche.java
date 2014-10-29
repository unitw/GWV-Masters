
import java.io.IOException;
import java.net.URL;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 3dibbern
 */
public class StartSuche {

    public static final int LINE_COUNT = 10;
    public static final int LINE_LENGTH = 20;

     public StartSuche(){
        ReadStateSpace();
    }
    
    public final void ReadStateSpace() {

        URL statespace = getClass().getResource("resources/blatt3_environment.txt");

        EnvironmentReader reader = null;
        try {
            reader = new EnvironmentReader("blatt3_environment.txt", LINE_COUNT, LINE_LENGTH);
        } catch (IOException ex) {
            Logger.getLogger(StartSuche.class.getName()).log(Level.SEVERE, null, ex);
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

        Search dfs = new Search(environment, LINE_LENGTH, LINE_COUNT, reader.getStartPosX(), reader.getStartPosY());
        Stack<Character> goalPath = dfs.startDFS();

        System.out.println(goalPath.toString());
    }

}
