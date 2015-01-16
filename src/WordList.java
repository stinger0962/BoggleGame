/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import java.io.*;
/**
 * utility class to to manage word list
 * provide various functions regarding words
 * such as load, merge,subtract,check validation and so on.
 * @author Nio
 */
public class WordList {
    //use set to store word list since it doesn't allow duplicate elements
    private HashSet<String> wordList;
    
    
    public WordList()
    {
        wordList = new HashSet<>();
    }
    /**
     * another constructor accept a File object, reading all words in the File.
     * @param file the file to read
     * @throws IOException throws exception if the file cannot be opened, or other issues occur
     */
    public WordList(File file) throws IOException
    {
        wordList = new HashSet<>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while((line = br.readLine()) != null)
        {
            wordList.add(preprocessWord(line));
        }
    }
    
    
    /**
     * accessors for size()
     * @return number of words in the list
     */
    public int size()
    {
        return wordList.size();
    }
    /**
     * a helper method to preprocess a word, trim spaces and transform to lowercase
     * @param word: the word to preprocess
     * @return a lowercase word with spaces before and after the word trimmed
     */
    public String preprocessWord(String word)
    {
        word = word.trim();
        word = word.toLowerCase();
        return word;
    }
    
    /**
     * add a preprocessed word to word list
     * @param word the word to be added
     * @return true if successfully added, otherwise false
     */
    public boolean addWord(String word)
    {
        boolean added = false;
        word = preprocessWord(word);
        if(!word.isEmpty())
        {
            wordList.add(word);
            added = true;
        }
        return added;
    }
    /**
     * to find is a specific word is contained in the list
     * @param word the word to search
     * @return true if found, otherwise false
     */
    public boolean containWord(String word)
    {
        boolean has = false;
        if(wordList.contains(preprocessWord(word)))
        {
            has = true;
        }
        return has;
    }
    
    /**
     * add another word list into a word list
     * @param wl another word list to be merged
     */
    public void addWordList(WordList wl)
    {
        if(wl != null)
        {
            this.wordList.addAll(wl.wordList);
        }
    }
    
    /**
     * compute the difference between two word list, 
     * removing all words that appear in the parameter word list
     * @param wl the word list to compare with
     */
    public void subtractWordList(WordList wl)
    {
        if(wl != null)
        {
            for(String word : wl.wordList)
            {
                if(this.wordList.contains(word))
                {
                    this.wordList.remove(word);
                }
            }
        }
    }
}
