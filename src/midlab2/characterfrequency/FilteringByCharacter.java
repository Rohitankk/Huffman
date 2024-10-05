package midlab2.characterfrequency;

import midlab2.Tree.NarraNode;
import midlab2.set.Filter;

public class FilteringByCharacter implements Filter<NarraNode<FrequencyOfCharacter>> {

    public boolean whatToFilter(NarraNode<FrequencyOfCharacter> data1, NarraNode<FrequencyOfCharacter> data2) {
        return data1.getData().getACharacter() == data2.getData().getACharacter();
    }

    public void whenFiltered(NarraNode<FrequencyOfCharacter> data) {
        data.getData().setFrequency(data.getData().getFrequency()+1);
    }
}
