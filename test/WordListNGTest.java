/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import static org.testng.Assert.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 *
 * @author Nio
 */
public class WordListNGTest {
    
    public WordListNGTest() {
    }

    @Test
    public void testDefaultConstructor() {
        WordList wl = new WordList();
        assert wl.size()==0 : wl.size();
    }
    
    @Test
    public void testAddWord()
    {
        WordList wl = new WordList();
        wl.addWord("apple");
        wl.addWord("bee");
        wl.addWord("cell");
        
        assert wl.size()==3;
        assert wl.containWord("apple");
        assert wl.containWord("bee");
        assert wl.containWord("cell");
        assert !wl.containWord("Arthus");
    }
    
    @Test
    public void testPreprocessWord()
    {
        WordList wl = new WordList();
        wl.addWord("  dungeon  ");
        wl.addWord("Archmage");
        
        assert wl.containWord("dungeon");
        assert wl.containWord("archmage");
    }
    
    @Test
    public void testAddWordList()
    {
        WordList wla = new WordList();
        wla.addWord("apple");
        wla.addWord("bee");
        wla.addWord("cell");
        
        WordList wlb = new WordList();
        wlb.addWord("  dungeon  ");
        wlb.addWord("Archmage");
        
        wla.addWordList(wlb);
        assert wla.size()==5;
        
        wla.subtractWordList(wlb);
        assert wla.size()==3;
    }
    
    @Test(expectedExceptions = IOException.class)
    public void testExceptions() throws IOException
    {
        File file = new File("not_existed.txt");
        WordList wl = new WordList(file);
        
    }
}
