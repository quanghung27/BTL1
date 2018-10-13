/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionarys;

import java.util.Scanner;

/**
 *
 * @author MANH HOANG
 */
public class Dictionarys {

    public void menu() {
        System.out.printf("\n DICTIONARY");
	System.out.printf("\n- 1. them tu va in ket qua");
	System.out.printf("\n- 2. tim 1 tu");
        System.out.printf("\n- 3. tim nhieu tu lien quan");
	System.out.printf("\n- 4. xoa tu");
	System.out.printf("\n- 5. in tat ca tu trong file");
	System.out.printf("\n- 6. xuất du lieu ra file");
        System.out.printf("\n- 7. sua tu");
	System.out.printf("\n nhap lua chon:");
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Dictionarys r = new Dictionarys();
        Dictionary d = new Dictionary();
        DictionaryManagement e = new DictionaryManagement();
        DictionaryCommandLine f = new DictionaryCommandLine();
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
                    f.dictionaryAdvanced(d);
                    break;
                case 6 :
                    e.dictionaryExportToFile(d);
                    break;
                case 7 :
                    e.suatu(d);
                    break;
            }
        }
    }
}
