/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionarys;

/**
 *
 * @author MANH HOANG
 */
public class DictionaryCommandLine extends DictionaryManagement {
    DictionaryManagement e = new DictionaryManagement();
    //hàm thừa kế
    public DictionaryCommandLine() {
        super();
    }
    //hàm in tất cả ra màn hình
    public void showAllWords(Dictionary d) {
        System.out.printf("|%-5s|%-30s|%-30s|\n","No","English","Vietnamese");
        for (int i = 0; i < d.list.size(); i++) {
            int j=i+1;
            System.out.printf("|%-5d|%-30s|%-30s|\n",j,d.list.get(i).getWord_target(),d.list.get(i).getWord_explain());
        }
    }
    //gọi hàm
    public void dictionaryBasic(Dictionary d) {
        e.insertFromCommandline(d);
        showAllWords(d);
    }
    //gọi hàm
    public void dictionaryAdvanced(Dictionary d) {
        e.insertFromFile(d);
        showAllWords(d);
    }
    
    //tìm từ gần giống
    public void dictionarySearcher(Dictionary d) {
        String tucantim;
        int ab;
        int test=1;
        System.out.println("nhap tu can tim:");
        tucantim=scan.next().toLowerCase();
        ab=tucantim.length();
        for (int i = 0; i < d.list.size(); i++) {
            int j=i+1;
            if(tucantim.equalsIgnoreCase(d.list.get(i).getWord_target().substring(0,ab)))
            {
                System.out.printf("|%-5s|%-30s|%-30s|\n",j,d.list.get(i).getWord_target(),d.list.get(i).getWord_explain());
                test++;
            }
        }
        if(test==1)
        {
            System.out.println("khong tim thay tu.");
        }
    }
}
