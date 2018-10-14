/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionarys;

import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        int test=1;
        for (int i=0;i<d.list.size();i++)
        {
            if (d.list.get(i).getWord_target().equalsIgnoreCase(tucamtim)) {
                System.out.println(d.list.get(i).getWord_target()+'\t'+d.list.get(i).getWord_explain());
                test++;
            }
        }
        if (test==1) {
            System.out.println("Khong tim thay tu.");
        }
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
    //xóa từ
    public void deleteWord(Dictionary d) {
        String tucanxoa;
        int test=1;
        System.out.println("nhap tu can xoa:");
        tucanxoa=scan.next().toLowerCase();
        for(int i=0;i<d.list.size();i++) {
            if(d.list.get(i).getWord_target().equalsIgnoreCase(tucanxoa))
            {
                d.list.remove(d.list.get(i));
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
    public void dictionaryExportToFile(Dictionary d) {
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
            System.out.println("xuat du lieu thanh cong");
        }
        catch(Exception e)
        {
            System.out.println("loi:"+e);
        }
    }
}
