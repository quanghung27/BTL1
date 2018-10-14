package Dictionary02;

import java.util.Scanner;

public class Word {
    String word_target;
    String getWord_target() {
        return word_target;
    }

    public void setWord_target(String word_target) {
        this.word_target = word_target;
    }

    String word_plain;

    public String getWord_plain() {
        return word_plain;
    }

    public void setWord_plain(String word_plain) {
        this.word_plain = word_plain;
    }



    public Word(String word_target, String word_plain) {
        this.word_target = word_target;
        this.word_plain = word_plain;
    }

    public Word() {
    }
}

