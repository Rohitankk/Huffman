package midlab2.huffmancode;

public class CodeIncomplete extends Exception{
    CodeIncomplete(){
        super("The huffman code is invalid!");
    }
}
