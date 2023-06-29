/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hua.excersize4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.RandomAccessFile;
import java.util.BitSet;

/**
 *
 * @author chris
 */
public class App {

    public static void main(String[] args) throws Exception {
        String fileName1 = args[0];//ta onomata gia ta arxeia
        String fileName2 = args[1];//
        
        String codes[] = new String[128];//o pinakas me tis kodikopoihseis pou 8a diavasoume apo to codes.dat
        
        //diavazei tous kodikous apo to codes.dat(olo afto akrivos to eixame kanei kai sthn defterh ergasia gia na diavasoume ta frequencies)
        int t = (int) '\t';
        File file = new File("codes.dat");
        
        BufferedReader br = new BufferedReader(new FileReader(file));
       
        String st;
        int i = 0;
        int index;
        while ((st = br.readLine()) != null) {//oso uparxoun grames
            index = st.indexOf(t) + 1;
            
            codes[i] = st.substring(index, st.length());//xorizei to string kai epistrefei to frequency
            
            i++;
        }
        //mexri edw
        
        
        
        File file1 = new File(fileName1);
        FileReader reader = new FileReader(file1);//anigoume to arxeio gia na diavasoume tous xaraktires ascii

        
        BitSet bt = new BitSet();
        //einai counter gia tous xarakthres tou String twn kodikopoihsewn ka8e fora pou 8a diavazoume enan xarakthra ascii apo to file
        int allTheWay = 0;//einai o counter gia olous tous xarakthres, dhladh o ari8mos twn bits
        int stringWay = 0;

        int x = reader.read();//to x einai o ka8e xarakthras se ascii pou diavazoume apo to arxeio
        while (x != -1) {//oso uparxei xarakthras
            while (stringWay < codes[x].length()) {//oso den exeis kseperasei to mege8os tou string ths kodikopoihshs

                if (codes[x].charAt(stringWay) == '1') {//an einai 1 o xarakthras kane bitset alliws den kanei bitset opote menei to 0 os bit
                    bt.set(allTheWay);
                }
                stringWay++;
                allTheWay++;
            }
            stringWay = 0;
            //to allTheWay den to midenizoume gt einai o ari8mos twn bits

            x = reader.read();
        }
        reader.close();
        //telos diavasmatos
        
        
        
        
        //anigoume to arxeio gia na grapsoume ta bytes
        RandomAccessFile raf = new RandomAccessFile(fileName2,"rw");
        raf.setLength(0);//gia na kanei override
        raf.writeInt(allTheWay);//grafoume sthn arxh ton ari8mo twn bits diladi to allTheWay
        raf.seek(4);//kanoume seek meta to tetarto byte gia na grapsoume ta bits epidi o int desmevei 4 bytes
        raf.write(bt.toByteArray());//grafoume ta bits
        raf.close();
        
        
        
        
        

        

    }
}
