package midlab2;
import midlab2.huffmancode.Huffman;
import midlab2.Tree.NarraNode;
import midlab2.characterfrequency.FrequencyOfCharacter;
import midlab2.huffmancode.CodeIncomplete;
import midlab2.huffmancode.WordNotPossible;
import midlab2.priorityqueue.MyPriorityQueue;
import midlab2.priorityqueue.MyQueue;
import midlab2.set.mySet;

import java.util.Scanner;

public class Test {
    static Huffman hC = new Huffman();
    static Scanner kbd = new Scanner(System.in);
    public static void main(String[] args) throws CodeIncomplete, WordNotPossible {
        System.out.println("""
                ---------------------------------------------------------------------
                                       HUFFMAN CODE GENERATOR
                ---------------------------------------------------------------------
                Please input a sentence to get started:""");
        String initialSentence = kbd.nextLine();
        NarraNode root = setHuffmanTree(initialSentence);
        int choice = 0;
        while (choice != 5){
            System.out.println("""
                    ---------------------------------------------------------------------
                    1) Show Table of Values
                    2) Convert Huffman to Text
                    3) Convert Text to Huffman
                    4) Make a New Huffman Tree
                    5) Exit
                    Please choose your desired action: """);
        choice = kbd.nextInt();
        kbd.nextLine();
        switch (choice){
            case 1:
                MyPriorityQueue charFreq = hC.stringToCharFreq(initialSentence);
                mySet setOfLetters = hC.setOfLetters(initialSentence);
                System.out.printf("%-10s|%-15s|%s","Character","Huffman Code","Size");
                System.out.println();
                MyQueue tableOfValues = hC.tableOfValues(root,setOfLetters);
                tableOfValues.showQueue();
                System.out.printf("Storage savings: %.2f percent", hC.storageSavings(tableOfValues,charFreq));
                System.out.println();
                break;
            case 2:
                System.out.print("Please enter the huffman code:");
                System.out.println(hC.huffmanCodeToText(root,kbd.nextLine()));
                break;
            case 3:
                System.out.print("Please enter the text:");
                System.out.println(hC.textToHuffmanCode(root,kbd.nextLine()));
                break;
            case 4:
                System.out.println("Please enter the initial sentence:");
                initialSentence = kbd.nextLine();
                root = setHuffmanTree(initialSentence);
                break;
            case 5:
                System.out.println("Bye");
                return;
            default:
                System.out.println("Invalid input detected");
            }
        }
    }

    public static NarraNode setHuffmanTree(String initSent){
        MyPriorityQueue charFreq = hC.stringToCharFreq(initSent);
        NarraNode<FrequencyOfCharacter> huffmanRoot = hC.charFreqToHuffmanTree(charFreq);
        return huffmanRoot;
    }
}
