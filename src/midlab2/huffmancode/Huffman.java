package midlab2.huffmancode;
import midlab2.characterfrequency.FilteringByCharacter;
import midlab2.characterfrequency.FrequencyOfCharacter;
import midlab2.characterfrequency.FrequencySort;
import midlab2.Tree.NarraNode;
import midlab2.characterfrequency.HuffmanCodeOfCharacter;
import midlab2.utilities.characterfrequency.*;
import midlab2.priorityqueue.MyPriorityQueue;
import midlab2.priorityqueue.MyQueue;
import midlab2.set.mySet;

public class Huffman {
    public StringBuilder huffmanCodeToText(NarraNode<FrequencyOfCharacter> r, String huffCode)
            throws CodeIncomplete {
        NarraNode<FrequencyOfCharacter> getter = r;
        StringBuilder finalWord = new StringBuilder();
        for(int i = 0; i < huffCode.length(); i++){
            char direction = huffCode.charAt(i);
            if (direction == '0'){
                getter = getter.getLeft();
            } else if (direction == '1'){
                getter = getter.getRight();
            }
            if (getter.getRight() == null && getter.getLeft() == null){
                finalWord.append(getter.getData().getACharacter());
                getter = r;
            }
        }
        if (getter != r){
            throw new CodeIncomplete();
        }
        return finalWord;
    }

    public mySet setOfLetters(String s){
        mySet characterFrequency = new mySet(new FilteringByCharacter());
        for(int i = 0; i < s.length(); i++) {
            NarraNode<FrequencyOfCharacter> curr = new NarraNode<>(new FrequencyOfCharacter(s.charAt(i),1));
            characterFrequency.insert(curr);
        }
        return characterFrequency;
    }

    public NarraNode<FrequencyOfCharacter> charFreqToHuffmanTree(MyPriorityQueue<NarraNode> cF){
        NarraNode <FrequencyOfCharacter> root = null;
        MyPriorityQueue<NarraNode> maker = cF;
        while(cF.size() > 1){
            NarraNode<FrequencyOfCharacter> first = cF.dequeue();
            NarraNode<FrequencyOfCharacter> second = cF.dequeue();
            NarraNode<FrequencyOfCharacter> newNode = new NarraNode<>(new FrequencyOfCharacter());
            newNode.getData().setFrequency(first.getData().getFrequency()+second.getData().getFrequency());
            newNode.getData().setACharacter('-');
            newNode.setLeft(first);
            newNode.setRight(second);
            root = newNode;
            cF.enqueue(newNode);
        }
        return root;
    }

    public MyQueue tableOfValues(NarraNode<FrequencyOfCharacter> r,
                                 mySet<NarraNode<FrequencyOfCharacter>> charac){
        MyQueue<HuffmanCodeOfCharacter> huffmanCodes = new MyQueue<>();
        for(int i = 0; i < charac.getSize(); i++){
            char a = charac.getByNo(i+1).getData().getData().getACharacter();
            huffmanCodes.enqueue(new HuffmanCodeOfCharacter(a,charToHuffmanCode(r,"",a)));
        }
        return huffmanCodes;
    }

    public String charToHuffmanCode(NarraNode<FrequencyOfCharacter> r, String s, char c){
        if (r.getLeft() == null && r.getRight() == null){
            if (r.getData().getACharacter() == c){
                return s;
            }
            return "False";
        }
        String k1 = charToHuffmanCode(r.getRight(),s+"1",c);
        if (!(k1.equals("False"))) return k1;
        return charToHuffmanCode(r.getLeft(),s+"0",c);
    }

    public double storageSavings(MyQueue<HuffmanCodeOfCharacter> vals,
                              MyPriorityQueue<NarraNode<FrequencyOfCharacter>> letr){
        double unicode = 0;
        double huffman = 0;
        while (!(letr.isEmpty())){
            FrequencyOfCharacter charFreq= letr.dequeue().getData();
            int frequency = charFreq.getFrequency();
            unicode = unicode+(frequency*8);
            char a = charFreq.getACharacter();
            while(a != vals.peek().getCharac()){
                vals.enqueue(vals.dequeue());
            }
            huffman = huffman+(frequency* vals.dequeue().getS());
        }
        double storageSavings = (huffman/unicode)*100;
        return storageSavings;
    }

    public StringBuilder textToHuffmanCode(NarraNode<FrequencyOfCharacter> r, String text) throws
            WordNotPossible {
        StringBuilder huffmanCode = new StringBuilder();
        String check;
        for(int i = 0;i < text.length();i++){
            char toFind = text.charAt(i);
            check = charToHuffmanCode(r,"",text.charAt(i));
            if (check.equals("False")){
                throw new WordNotPossible();
            }
            huffmanCode.append(charToHuffmanCode(r,"",toFind));
        }
        return huffmanCode;
    }

    public MyPriorityQueue stringToCharFreq(String s) {
        MyPriorityQueue arrangedCharFreq = new MyPriorityQueue(new FrequencySort());
        mySet characterFrequency = new mySet(new FilteringByCharacter());
        for(int i = 0; i < s.length(); i++) {
            NarraNode<FrequencyOfCharacter> curr = new NarraNode<>(new FrequencyOfCharacter(s.charAt(i),1));
            characterFrequency.insert(curr);
        }
        //Puts the Character frequencies into the priorityQueue
        for(int i = 0;i < characterFrequency.getSize();i++){
            arrangedCharFreq.enqueue(characterFrequency.getByNo(i+1).getData());
        }
        return arrangedCharFreq;
    }

}