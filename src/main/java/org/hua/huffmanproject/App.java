/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hua.huffmanproject;

import java.io.BufferedReader;
import java.io.File;

import java.io.FileOutputStream;

import java.io.FileReader;

import java.io.ObjectOutputStream;





/**
 *
 * @author chris
 */
public class App {
    private static final String fileName = "tree.dat";//to onoma tou arxeiou gia apo8ikefsh
    public static void main(String[] args)throws Exception{
        int[] p = new int[128];//o pinakas sixnotiton
        int i = 0;
        int t = (int) '\t';//h kodikopoihsh tou \t se ascci
        
        File input = new File("frequencies.dat");//dimiourgia File object me orisma to arxeio pros diavasma
        
        BufferedReader br = new BufferedReader(new FileReader(input));//dimiourgia BufferedReader object gia anagnwsh me to filereader object
        
        String st;
        int x = 0;
        int index;
        while ((st = br.readLine()) != null) {//oso uparxoun grames
            index = st.indexOf(t) + 1;//se pio simio vriskete \t
            
            p[x] = Integer.parseInt(st.substring(index, st.length()));//xorizei to string kai epistrefei to frequency
            
            x++;
        }
        App objectIO = new App();//dimiourgia object App
        
        Huffman tree = new Huffman(p);//dimiourgia tou dentrou pernodas ton pinaka frequency
        objectIO.WriteObjectToFile(tree);//grapsimo tou adikimenou tree sto arxeio kalodas thn me8odo WriteObjectToFile
        
        
    }
    public void WriteObjectToFile(Object serObj){//ulopoihsh ths me8odou gia to grapsimo tou arxeiou
        try {
 
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
            
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
