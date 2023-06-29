
# Lab excersise

This code is part of the lab exercises for the Data Structures course at Harokopio
University of Athens, Dept. of Informatics and Telematics.It reads from the comand
line two name files.The first file is the input file and containce the Huffman code
representation and the second file is the output file that the program makes witch
containce the ascii characters from the previus program file.



## Usage

Compile using maven

```
mvn compile using 'mvn package' in directory HuffmanProject

```

Run main using 

```
java -cp target/HuffmanProject-1.0-SNAPSHOT.jar org.hua.decoder.App dsa.txt ascii.txt
```
the dsa.txt is the file that containce the Huffman code representation and the ascii.txt is an example for the output file which will compressed (you can put whatever you want)
