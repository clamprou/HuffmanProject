/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hua.arrayfrequency;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author chris
 */
public class App {
     public static void main(String[] args) throws IOException {
        
        File file = new File("frequencies.dat");
        file.createNewFile(); //ftiaxnw to arxeio frequencies.dat
        int[] freq = new int[128];//arxikopoio ton pinaka
        
        for(int i=0;i<freq.length;i++){
            freq[i] = 0;//ton midenizw
        }
             
        
        try {//petaw exception
            File txt1 = new File("1o link.txt"); //diavazw to prwto link
            FileReader reader1 = new FileReader(txt1);//ftiaxnw adikimeno tupou file reader gia to prwto link
            
            
            File txt2 = new File("2o link.txt");// to idio
            FileReader reader2 = new FileReader(txt2);
            
            
            File txt3 = new File("3o link.txt");
            FileReader reader3 = new FileReader(txt3);

           
            
            int x=reader1.read();//metavliti gia na apo8ikevw to next char
            
            while (x!= -1) {
                if(x<=127 && x>=0){  //oso vriskei ascci mpenei kai afksanei ka8e keli freq tou pinaka
                    
                    freq[x]++;
                
                    
                }
                x=reader1.read();
            }
            reader1.close();
            
            x=reader2.read();//gia to 2o arxeio ta idia
            while (x!= -1) {
                if(x<=127 && x>=0){
                    
                    freq[x]++;
                
                    
                }
                x=reader2.read();
            }
            reader2.close();
            
            x=reader3.read();//gia to 3o arxeio ta idia
            while (x!= -1) {
                if(x<=127 && x>=0){
                    
                    freq[x]++;
                
                    
                }
                x=reader3.read();
            }
            reader3.close();
            
            
        } catch (FileNotFoundException e) {// gia na petaei exception
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
        FileWriter dat = new FileWriter(file);//ftiaxnw filewriter adikimeno gia to .dat arxeio gia na to grapsw
        
        
        for(int i=0; i<freq.length;i++){
            
            dat.write(i + "\t" + freq[i] + "\n");//gia na grafei ta ascii tab to freq
            
        }
        dat.close();
    }
}
