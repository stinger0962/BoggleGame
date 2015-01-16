
import java.io.File;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * a simple test class to test utility class WordList
 * @author Nio
 */
public class TestWordList {
    /**
     * main function accepts one argument that specifies the path/name of a text file to load
     * @param args the URL of text file to load
     */
    public static void main(String[] args)
    {
        if(args.length != 1)
        {
            System.out.println("Only one argument allowed to specify the location of text file.");
            System.exit(1);
        }
        File file = new File(args[0]);
        WordList wl;
        try
        {
            wl = new WordList(file);
            System.out.println(wl.size());
        }
        catch(IOException e)
        {
            System.err.println("Load failed...can't load the file.");
        }
            
        
        
        
    }
}
