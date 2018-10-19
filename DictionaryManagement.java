/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionarys;

import com.sun.speech.freetts.Voice;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.sun.speech.freetts.VoiceManager;

/**
 *
 * @author MANH HOANG
 */
public class DictionaryManagement {
    Dictionary d = new Dictionary();
    Scanner scan = new Scanner(System.in);
    //hàm thêm từ
    public void insertFromCommandline(Dictionary d) {
        System.out.println("nhap so tu can them:");
        int s1 = scan.nextInt();
        scan.nextLine();
        for(int i=0;i<s1;i++) {
            String tu;
            String nghia;
            System.out.println("nhap tu moi:");
            tu= scan.nextLine().toLowerCase();           
            System.out.println("Nhap nghia moi:");
            nghia= scan.nextLine().toLowerCase();          
            Word words = new Word(tu,nghia);
            d.list.add(words);
        }
    }
    //hàm tìm 1 từ
    public void dictionaryLookup(Dictionary d) {
        System.out.println("nhap tu can tim:");
        String tucamtim =scan.next().toLowerCase();
        System.out.println(dictionaryLookup(d, tucamtim));
    }
    
    public String dictionaryLookup(Dictionary d,String str) {
        int test=1;
        for (int i=0;i<d.list.size();i++)
        {
            if (d.list.get(i).getWord_target().equalsIgnoreCase(str)) {
                test++;
                return d.list.get(i).getWord_target()+'\t'+d.list.get(i).getWord_explain();
                
            }
        }
        if (test==1) {
            return "Khong tim thay tu.";
        }
        return null;
    }
    //đọc dữ liệu từ file
    public void insertFromFile(Dictionary d) {      
        String line;
        InputStream stream = Dictionarys.class.getResourceAsStream("/dictionarys/dictionaries.txt");
        try(Scanner sc = new Scanner(stream)) {
            while (sc.hasNext()){
                line=sc.nextLine();
                String [] a= line.split("\t");
                Word words = new Word(a[0],a[1]);
                d.list.add(words);
            }
        } catch (Exception e) {
            System.out.println("loi:"+e);
        }
    }
    
    public int tu(String str) {
        for(int i=0;i<d.list.size();i++)
        {
            if(str.equalsIgnoreCase(d.list.get(i).getWord_target()))
                return i;
        }
        return 0;
    }
    
    //xóa từ
    public void deleteWord(Dictionary d) {
        String tucanxoa;
        int test=1;
        System.out.println("nhap tu can xoa:");
        tucanxoa=scan.next().toLowerCase();
        for(int i=0;i<d.list.size();i++) {
            if(d.list.get(i).getWord_target().equalsIgnoreCase(tucanxoa))
            {
                d.list.remove(d.list.get(tu(tucanxoa)));
                System.out.println("xoa thanh cong.");
                test++;
            }
        }
        if(test==1)
        {
            System.out.println("khong tim thay tu can xoa.");
        }
    }
    //sửa từ
    public void suatu(Dictionary d) {
        String tucansua;
        String tu;
        String nghia;
        int test=1;
        System.out.println("nhap tu can sua:");
        tucansua=scan.next().toLowerCase();
        for(int i=0;i<d.list.size();i++){
            if(d.list.get(i).getWord_target().equalsIgnoreCase(tucansua))
            {
                System.out.println("sua tu.");
                System.out.println("tu moi:");
                tu=scan.next().toLowerCase();
                System.out.println("nghia moi:");
                nghia=scan.next().toLowerCase();
                Word words = new Word(tu,nghia);
                d.list.add(words);
                System.out.println("sua thanh cong.");
                test++;
            }
        }
        if(test==1)
        {
            System.out.println("khong tim thay tu can sua.");
        }
    }
    //hàm xuất dữ liệu ra file
    public String dictionaryExportToFile(Dictionary d) {
        File f = new File("Dictionariescoppy.txt");
        if(!f.exists()){
        try
        {
            f.createNewFile();
        }
        catch (IOException ex) {
                Logger.getLogger(DictionaryManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try(PrintWriter pw = new PrintWriter(f)) {
            BufferedWriter bf = new BufferedWriter(pw);
            for(int i=0;i<d.list.size();i++)
            {
                pw.println(d.list.get(i).getWord_target()+"\t"+d.list.get(i).getWord_explain());
            }
            return "xuat du lieu thanh cong";
        }
        catch(Exception e)
        {
            return "loi:"+e;
        }
    }
    Voice voice;
    VoiceManager voicemanager;
    public void speaks(String str) {
        System.setProperty("mbrola.base","mbrola");
        voicemanager = VoiceManager.getInstance();
        voice= voicemanager.getVoice("mbrola_us1");
        voice.allocate();
        voice.speak(str);
    }
    public void Speaks() {
        System.out.println("moi nhap tu can phat am:");
        String str = scan.nextLine().toLowerCase();
        speaks(str);
    }
}