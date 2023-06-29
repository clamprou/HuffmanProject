/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hua.huffmanproject;


import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.BitSet;

/**
 *
 * @author chris
 */
public class Huffman implements Serializable {//kanoume impliment thn clash gia na mporoume na thn apo8ikefsoume
    public String[] p = new String[128];//o pinakas me tous kodikopoihseis
    private ArrayDeque<Node> deque = new ArrayDeque<>();//h stoiva
    private static final long serialVersionUID = 1L;
    private Node root;//o protos komvos  panw panw
    private ArrayList<Node> arrayTree = new ArrayList<>();//o pinakas pou apo8ikevoume ta nodes gia na vriskoume ka8e fora ta duo mikrotera
    
    public Huffman(){
        
    }
    
    public Huffman(int[] arrayFreq) {
        for (int x = 0; x < arrayFreq.length; x++) {//ftiaxnw ena node gia ka8e stoixeio tou pinaka sixnotiton kai to vazw sto arraylist
            Node n = new Node();
            n.freq = arrayFreq[x];
            n.leaf = x;
            arrayTree.add(n);
        }
        //se afto to simio exw ftiaksei ton pinaka arrayTree o opoios exei mesa ta dentra
        
        
        int k1,k2;//oi diktes gia na kserw pou vriskode oi duo mikroteroi ston pinaka arraylist
        int min1,min2;//kanoun store tis duo mikroteres sixnotites twn nodes pou vriskode sto arraylist
        
        while (arrayTree.size() != 1) {//kanei epanalipsei mexri na minei ena mono node sto arraylist pou simenei oti ftiaxtike to tree
            k1=0;
            k2=0;
            min1=2147483647;//arxikopoihsh oso to dinaton pio polu
            min2=2147483647;
            
            for (int i = 0; i < arrayTree.size(); i++) {//h klasikh anazhthsh twn duo mikroterwn
                
                if (arrayTree.get(i).freq < min1) {
                    min2 = min1;
                    k2 = k1;
                    min1 = arrayTree.get(i).freq;
                    k1 = i;
                    
                }else if(arrayTree.get(i).freq < min2){
                    min2 = arrayTree.get(i).freq;
                    k2 = i;
                }
               
                

            }
            // se afto to simio exw vrei toys dyo mikroterous se reference
            
            
            Node newNode = new Node();//dimiourgia kainouriou node
            newNode.freq = min1 + min2;//to frequency tou node aftou ginetai to a8risma twn duo mikroterwn sixnotitwn
            newNode.left = arrayTree.get(k1);//to newNode plewn exei paidia, afta me to mikrotero frequency
            newNode.right = arrayTree.get(k2);//~
            arrayTree.remove(newNode.left);//diagrafw ta duo nodes me to mikrotero frequency apo to arraylist
            arrayTree.remove(newNode.right);
            arrayTree.add(newNode);//vazw to kainourio node sto arraylist
            
        
            
        
        }
        root = arrayTree.get(0);//to root einai o telefteos komvos pou menei
    }
    
    public void makeAsciiFile(BitSet bt,int allTheWay,String fileNameOutput) throws Exception{
        RandomAccessFile raf = new RandomAccessFile(fileNameOutput,"rw");//anigoume to arxeio gia thn eksodo
        raf.setLength(0);//kanoume overide etsi gia na min xriazete na svinei o xristis to arxeio an 8elei na to treksei me allh isodo
        Node cur = this.root;//reference gia thn diasxish tou dentrou
        for(int i=0;i<allTheWay+1;i++){//allTheWay+1 giati xriazotan allh mia epanalipsh gia na elenksei an einai filo
            if(cur.leaf == -1){//den einai filo
                if(bt.get(i)){//bit=1
                    cur = cur.right;
                }else{//bit=0
                    cur = cur.left;
                }
            }else{//filo
                raf.write(cur.leaf);//grapse sto arxeio ton xarakthra
                if(bt.get(i)){//bit=1
                    cur = this.root.right;
                }else{//bit=0
                    cur = this.root.left;
                }
              
            } 
        }
    }
    
    public void getCodes(Node cur, String s){//anadromikh sunartish
        
        if(cur.left == null && cur.right == null && cur.leaf != -1){//edw mpainei mono otan exw ftasei se filo
            p[cur.leaf] = s;//apo8ikevoume ston pinaka me tous kodikous to String me thn kodikopoihsh
            return;
        }
        getCodes(cur.left, s + "0");//otan pigenei aristera pros8etei sto sring to 0
        getCodes(cur.right, s + "1");//otan pigenei de3ia pros8etei sto string to 1
        
    }
    
    

    private static class Node implements Serializable{//ta nodes

        private int freq;
        private int leaf;
        private Node right;
        private Node left;
        
    private Node(){
        freq = -1;
        leaf = -1;
        right = null;
        left = null;
    }    
    }

    public Node getRoot() {
        return root;
    }
    
        
}
