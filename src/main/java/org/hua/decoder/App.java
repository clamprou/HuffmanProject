/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hua.decoder;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.BitSet;
import org.hua.huffmanproject.Huffman;



/**
 *
 * @author Ifigeneia
 */
public class App {
    public static void main(String[] args) throws Exception{
        String fileName1 = args[0];//ta onomata twn arxeiwn apo thn gramh edolwn
        String fileName2 = args[1];//
        
        /////////////////////////////////////////////////////////diavasma tou arxeiou tree.dat apo EDW
        FileInputStream fileIn = new  FileInputStream("tree.dat");
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
        Object obj = objectIn.readObject();
        Huffman tree = (Huffman) obj;
        //////////////////////////////////////////////////////////mexri EDW
        
        
        //////////////////////////////////////////////////////////Diavasma tou arxeiou pou einai grameno se Huffman kodikopoihsh
        RandomAccessFile raf = new RandomAccessFile(fileName1,"rw");
        int allTheWay = raf.readInt();//diavazoume ton ari8mo twn bits pou einai gramena sto arxeio ta prota 4 bytes
        raf.seek(0);//kanoume rewind ton pointer
        byte[] b = new byte[(int)(raf.length() -4)];//to mege8os tou pinaka einai iso me ton ari8mo twn bytes pou einai gramena sto arxeio -4 bytes pou einai to allTheWay
        raf.seek(4);//metakinoume ton pointer 4 bytes
        for(int i=0;i<b.length;i++){
            b[i] = raf.readByte();//diavazoume ka8e byte apo to arxeio
        }
        
        BitSet bt = BitSet.valueOf(b);//ftiaxnoume to bitset me orisma ton pinaka me ta bytes
        tree.makeAsciiFile(bt, allTheWay,fileName2);//kaloume thn me8odo makeAsciiFile pou ftiaksame gia na upologisei tous ascii xarakthres kai na tous grapsei sto arxeio
    }
}
