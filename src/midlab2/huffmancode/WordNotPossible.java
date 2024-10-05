package midlab2.huffmancode;

public class WordNotPossible extends Exception {
    WordNotPossible(){
        super("A letter within the word is not found in the huffman tree!");
    }
}
