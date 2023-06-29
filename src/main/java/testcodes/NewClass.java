/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testcodes;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.RandomAccessFile;

/**
 *
 * @author chris
 */
public class NewClass {
    public static void main(String[] args) throws Exception{
        String codes[] = new String[128];
        int t = (int) '\t';
        File file = new File("codes.dat");
        
        BufferedReader br = new BufferedReader(new FileReader(file));
       
        String st;
        int x = 0;
        int index;
        while ((st = br.readLine()) != null) {//oso uparxoun grames
            index = st.indexOf(t) + 1;
            
            codes[x] = st.substring(index, st.length());//xorizei to string kai epistrefei to frequency
            
            x++;
        }
        for(int i=0;i<codes.length;i++){
            System.out.println(codes[i]);
        }
        
    }
}
