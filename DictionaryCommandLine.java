package dictionarys;

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
        System.out.println("Nhap tu can tim:");
        tucantim=scan.next().toLowerCase();
        for (int i = 0; i < d.list.size(); i++) {
            int j=i+1;
            if(d.list.get(i).getWord_target().startsWith(tucantim))
            {
                System.out.printf("|%-5s|%-30s|%-30s|\n",j,d.list.get(i).getWord_target(),d.list.get(i).getWord_explain());
                test++;
            }
        }
        if(test==1)
        {
            System.out.println("Khong tim thay tu!");
        }
    }
}
