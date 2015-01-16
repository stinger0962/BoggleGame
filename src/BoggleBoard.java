/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
/**
 *a board represents an NxN grid of cells.
 * @author Nio
 */
public class BoggleBoard {
    /**
     * size of the board
     */
    private int size;
    /**
     * collection of the board cells
     */
    private String[][] board;
    /**
     * constant indicating the default size of board
     */
    public static final int DEFAULT_SIZE = 4;
    
    /**
     * default constructor, specify to default size and generate the board with random characters
     */
    public BoggleBoard()
    {
        this.size = DEFAULT_SIZE;
        generateBoard(size);
    }
    
    /**
     * constructor with one argument to specify the NxN size
     * initialize the board with randomly generated characters
     * @param size the NxN size of board
     */
    public BoggleBoard(int size)
    {
        this.size = size;
        generateBoard(size);
    }
    
    /**
     * accessors for field: size
     * @return 
     */
    public int size()
    {
        return this.size;
    }
    
    /**
     * retrieve character in an individual cell
     * if the parameters are not in valid range, return string with zero length
     * @param x row of the cell
     * @param y column of the cell
     * @return character in the cell
     */
    public String getCell(int x, int y)
    {
        if( 0 <= x && x < this.size && 0 <= y && y < this.size)
            return board[x][y];
        else
            return "";
    }
    
    /**
     * helper method to generate the board
     * each cell contains a single uppercase "A" to "Z", or "Qu"
     * with a preset probability distribution
     * @param size the NxN size of board
     */
    private void generateBoard(int size)
    {
        board = new String[size][size];
        for(int i = 0; i < size; i++)
        {
            for(int j = 0; j < size; j ++)
            {
                board[i][j] = generateChar();
            }
        }
    }
    
    /**
     * generate a random character according to the possibility distribution
     * @return the generated random character
     */
    private String generateChar()
    {
        int possi;
        Random rand = new Random();
        possi = rand.nextInt(96); //96 is the sum of total distributions
        if(possi<8)
            return "A"; // A has a distribution of 8
        else if(possi < 11)
            return "H";
        else if(possi < 17)
            return "O";
        else if(possi < 19)
            return "V";
        else if(possi < 22)
            return "B";
        else if(possi < 29)
            return "I";
        else if(possi < 32)
            return "P";
        else if(possi < 34)
            return "W";
        else if(possi < 37)
            return "C";
        else if(possi < 38)
            return "J";
        else if(possi < 39)
            return "Qu";
        else if(possi < 40)
            return "X";
        else if(possi < 44)
            return "D";
        else if(possi < 46)
            return "K";
        else if(possi < 50)
            return "R";
        else if(possi < 53)
            return "Y";
        else if(possi < 63)
            return "E";
        else if(possi < 68)
            return "L";
        else if(possi < 73)
            return "S";
        else if(possi < 74)
            return "Z";
        else if(possi < 76)
            return "F";
        else if(possi < 79)
            return "M";
        else if(possi < 84)
            return "T";
        else if(possi < 89)
            return "G";
        else if(possi < 92)
            return "N";
        else
            assert possi < 96 : possi;
            return "U";   
    }
}
