/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author Nio
 */
public class BoggleBoardNGTest {
    
    public BoggleBoardNGTest() {
    }

    @Test
    public void testDefaultConstructor() {
        BoggleBoard bg = new BoggleBoard();
        assert bg.size() == BoggleBoard.DEFAULT_SIZE;
        checkValues(bg);
    }
    
    @Test
    public void testOneArgumentConstructor()
    {
        int size = 5;
        BoggleBoard bg = new BoggleBoard(size);
        assert bg.size()==size;
        checkValues(bg);
    }
    
    private void checkValues(BoggleBoard bg)
    {
        for(int i = 0; i < bg.size(); i++)
        {
            for(int j = 0; j < bg.size(); j++)
            {
                System.out.print(bg.getCell(i, j) + " ");
                assert !(bg.getCell(i, j) == null);
            }
            System.out.println();
        }
    }
    
}
