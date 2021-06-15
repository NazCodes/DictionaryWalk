import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Scanner;
import java.net.*;
import java.io.*;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;

public class Solution {
    //Main driver method
    public static void main(String[] args) {
        Set<String> D = new HashSet<String>();
        D = getDictionary(D);
        //Use scanner to get starting and target word:
        String firstWord;
        String targetWord;
        Scanner firstScan = new Scanner(System.in);
        System.out.println("Enter 1st Word");
        firstWord = firstScan.next();
        Scanner secondScan = new Scanner(System.in);
        System.out.println("Enter Target Word");
        targetWord = secondScan.next();
        firstScan.close();
        secondScan.close();
        convertWord(firstWord, targetWord, D);
    }
    //Simple method to get the scrabble dictionary from url
    public static Set<String> getDictionary(Set<String> d) {
        try {
            URL url = new URL("https://www.wordgamedictionary.com/twl06/download/twl06.txt");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            int i = 0;
            while ((line = in.readLine()) != null) {
                if (i == 0 || i == 1){
                    i++;
                    continue;
                }
                else {
                    d.add(line);
                }
                i ++;
            }
            in.close();
        }
        catch (MalformedURLException e) {
            System.out.println("Malformed URL: " + e.getMessage());
        }
        catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
        }
        return d;
    }
    //Method to 
    public static int convertWord (String start, String target, Set<String> D) {
        //If the starting word is the same as the target word:
        if (start.equals(target)) {
            System.out.println("Starting word was the same as the target word.");
            return 0;
        }
        //If the dictionary does not have either the starting or target word:
        if (!D.contains(target) || !D.contains(start)) {
            System.out.println("The starting or target word does not exist in the Scrabble dictionary.");
            return 0;
        }
        //Create counter and wordLength
        int counter = 0;
        int wordLength = start.length();

        Deque deque = new LinkedList();
        //List startList = Arrays.asList(start);
        deque.add(start);

        HashMap seen = new HashMap();
        seen.put(start, null);

        while(deque.peekFirst() != null) {
            String word = deque.removeFirst().toString();
            if(word == target){
                break;
            }
        }
        return counter;
    }
}