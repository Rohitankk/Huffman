package midlab2.characterfrequency;

public class HuffmanCodeOfCharacter {
    private char charac;

    private String huffCode;

    int s;

    public HuffmanCodeOfCharacter(char character, String huffmanCode){
        this.huffCode = huffmanCode;
        this.charac = character;
        this.s = huffmanCode.length();
    }

    public HuffmanCodeOfCharacter(){
        this.huffCode = "";
        this.charac = 'a';
        this.s = huffCode.length();
    }

    public char getCharac() {
        return charac;
    }

    public void setCharac(char charac) {
        this.charac = charac;
    }

    public String getHuffCode() {
        return huffCode;
    }

    public void setHuffCode(String huffCode) {
        this.huffCode = huffCode;
    }
    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return String.format("%-10c|%-15s|%d", charac, huffCode, s);
    }
}
