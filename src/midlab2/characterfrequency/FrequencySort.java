package midlab2.characterfrequency;
import midlab2.priorityqueue.Comparer;
import midlab2.Tree.NarraNode;

public class FrequencySort implements Comparer<NarraNode<FrequencyOfCharacter>> {
    @Override
    public int compare(NarraNode<FrequencyOfCharacter> obj1, NarraNode<FrequencyOfCharacter> obj2) {
        return obj1.getData().getFrequency() - obj2.getData().getFrequency();
    }
}
