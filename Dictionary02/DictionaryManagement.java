package Dictionary02;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
public class DictionaryManagement {

    public Word insertWord() {
        Word array = new Word();
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập từ tiếng anh");
        String a;
        a = sc.nextLine();
        array.setWord_target(a);
        System.out.println("giải nghĩa");
        String b;
        b = sc.nextLine();
        array.setWord_plain(b);
        return array;
    }

    public int nhapso() {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập số lượng từ vựng");
        n = sc.nextInt();
        return n;
    }

    public ArrayList<Word> insertFromcomandline() {
        DictionaryManagement b = new DictionaryManagement();
        ArrayList<Word> a = new ArrayList<>();
        Dictionary s = new Dictionary();
        int k;
        k = b.nhapso();
        for (int i = 0; i < k; i++) {
            a.add(i, b.insertWord());
        }
        return a;
    }

    public ArrayList<Word> insertFromfile() {
        ArrayList filearray = new ArrayList();
        File file = new File("dictionary.txt");
        try (Scanner sc = new Scanner(file)) {

            for (int i = 0; i < 30000; i++) {
                Word fileWord = new Word();
                String str = new String();
                str = sc.next();
                fileWord.setWord_target(str);
                str = sc.nextLine();
                fileWord.setWord_plain(str);
                filearray.add(i, fileWord);
            }
        } catch (Exception e) {
        }


        return filearray;
    }

    public void dictionarylookup(ArrayList<Word> a) {
        Scanner sc = new Scanner(System.in);
        String b;
        System.out.print("seach targer : ");
        b =sc.next() ;
        for (int i = 0; i < a.size(); i++) {
            Word swap = new Word();
            swap = a.get(i);
            if (swap.word_target.equals(b)) {
                System.out.println("planin:"+swap.getWord_plain());
            }
        }
    }
}

