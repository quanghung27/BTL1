package Dictionary02;

import java.util.ArrayList;

public class DictionaryComanline {

    ArrayList<Word>arrays=new ArrayList<>();
    public void showAllWords(Dictionary vd) {

        arrays = vd.getDictionarys();
        System.out.println("stt  " +"|English  "+"|Tiếng việt");
        for (int i = 1; i < arrays.size(); i++) {
            System.out.println(i + "     |" + arrays.get(i).getWord_target() + "    |"+ arrays.get(i).getWord_plain());
        }
    }
    public void dictionaryBasic()
    {  DictionaryManagement a =new DictionaryManagement();
        Dictionary b = new Dictionary();
        DictionaryComanline c = new DictionaryComanline();
        b.setDictionarys(a.insertFromcomandline());
        c.showAllWords(b);
    }
    public void dictionaryAdvanced()
    {
        DictionaryComanline c= new DictionaryComanline();
        DictionaryManagement a=new DictionaryManagement();
        Dictionary b =  new Dictionary();
        b.setDictionarys(a.insertFromfile());
        c.showAllWords(b);
        a.dictionarylookup(b.getDictionarys());
    }
}

