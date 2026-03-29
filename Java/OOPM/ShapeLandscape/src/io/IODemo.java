package io;

import java.io.*;

public class IODemo {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("data.txt"));
            System.out.println(br.read());
           /* int c;
            while((c=br.read())!=-1){
                System.out.printf("%d: %c\n", c,c);
            }*/
            String line = br.readLine();
            System.out.println(line);
            String nextLine = br.readLine();
            System.out.println(nextLine);
            int linenr=1;
            while ((line=br.readLine())!=null){
                System.out.printf("line " + "%02d \"%s\"\n", linenr++, line);
            }

            br.close();
        } catch (FileNotFoundException e) {
            System.err.println("could not open file");
        } catch (IOException e){
            System.err.println("could not write to file");
        }
    }
    public static void exportDemo(){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("data.txt")); //no access to C:\\
            bw.write('a');
            for (int i = 'A'; i <= 'Z'; i++) {
                bw.write(i);
            }
            bw.write('\n');
            for (char c = 'a'; c < 'z' ; c++) {
                bw.write(c + " ");
            }
            bw.close();

        } catch (IOException ex) {
            System.err.println("could not open file");
        }
    }
}
