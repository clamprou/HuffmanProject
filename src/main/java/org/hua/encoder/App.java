/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hua.encoder;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import org.hua.huffmanproject.Huffman;

/**
 *
 * @author chris
 */
public class App {
    private static final String fileName = "tree.dat";//to onoma tou arxeiou pou 8a diavasoume to adikeimeno dentro
    
    public static void main(String[] args){
        App objectIO = new App();//ftiaxnw ena adikimeno ths kalis App gia na kalesw ReadObjectFromeFile kai na diavasw to file tree.dat
        Huffman tree = (Huffman) objectIO.ReadObjectFromeFile(fileName);//diavazw to adikeimeno tree apo to tree.dat
        tree.getCodes(tree.getRoot(),"");//kalw thn me8odo getCodes me parametrous to root node
        //o pinakas me tous kodikous exei ftiaxtei
        
        //dimiourgoume ena arxeio gia apo8ikefsei tou pinaka me tous kodikous
        try{
            FileWriter myWriter = new FileWriter("codes.dat");//dimiourgw to file codes.dat
            for(int i=0;i<128;i++){
                myWriter.write(i+"\t"+tree.p[i]+"\n");//grafw sto arxeio gia ka8e i ascii xaraktira thn tree.p[i] kodikopoihsh
            }
            myWriter.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
    }
    
    
    
    public Object ReadObjectFromeFile(String fileName){
        try{
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            Object obj = objectIn.readObject();
            objectIn.close();
            return obj;
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
}
