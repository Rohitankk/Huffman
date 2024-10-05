package midlab2.characterfrequency;

public class FrequencyOfCharacter {
    private int freq;

    private char aC;

    public FrequencyOfCharacter(){
        this.freq = 0;
        this.aC = '\0';
    }

    public FrequencyOfCharacter(char aChar, int frequency){
        this.aC = aChar;
        this.freq = frequency;
    }

    public void setFrequency(int freq) {
        this.freq = freq;
    }

    public int getFrequency() {
        return freq;
    }
    public void setACharacter(char aC) {
        this.aC = aC;
    }

    public char getACharacter() {
        return aC;
    }

    @Override
    public String toString() {
        return "Char: "+ aC +" Frequency: "+ freq;
    }
}