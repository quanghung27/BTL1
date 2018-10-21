
package dictionarys;

import java.util.Scanner;

public class Dictionarys {

    public void menu() {
        System.out.printf("\n DICTIONARY");
	System.out.printf("\n- 1. Them tu va in ket qua");
	System.out.printf("\n- 2. Tim 1 tu");
        System.out.printf("\n- 3. Tim nhieu tu lien quan");
	System.out.printf("\n- 4. Xoa tu");
	System.out.printf("\n- 5. Lay du lieu tu trong file");
	System.out.printf("\n- 6. Xuat du lieu ra file");
        System.out.printf("\n- 7. Sua tu");
        System.out.printf("\n- 8. Phat am tu");
        System.out.printf("\n- 9. In tat ca cac tu");
	System.out.printf("\n Nhap lua chon:");
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Dictionarys r = new Dictionarys();
        Dictionary d = new Dictionary();
        DictionaryManagement e = new DictionaryManagement();
        DictionaryCommandLine f = new DictionaryCommandLine();
//        NewJFrame h = new NewJFrame();
//        h.setVisible(true);
        while(true)
        {
            r.menu();
            Scanner scan = new Scanner(System.in);
            int chon;
            System.out.println("chon chuc nang:");
            chon=scan.nextInt();
            switch(chon)
            {
                case 1 :
                    f.dictionaryBasic(d);
                    break;
                case 2 :
                    e.dictionaryLookup(d);
                    break;
                case 3 :
                    f.dictionarySearcher(d);
                    break;
                case 4 :
                    e.deleteWord(d);
                    break;
                case 5 :
                    e.insertFromFile(d);
                    break;
                case 6 :
                    e.dictionaryExportToFile(d);
                    break;
                case 7 :
                    e.suatu(d);
                    break;
                case 8 :
                    e.Speaks();
                    break;
                case 9 :
                    f.showAllWords(d);
                    break;
            }
        }
    }
}
