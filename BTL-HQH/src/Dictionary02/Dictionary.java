package Dictionary02;

import java.util.ArrayList;
        import java.util.Scanner;

public class Dictionary {
    ArrayList<Word>Dictionarys= new ArrayList<>();

    public void setDictionarys(ArrayList<Word> dictionarys) {
        Dictionarys = dictionarys;
    }

    public ArrayList<Word> getDictionarys() {
        return Dictionarys;
    }

    public void push(Word word) {
        this.Dictionarys.add(word);
    }
}
