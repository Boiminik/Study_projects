package jcfDemos;
import util.ConsoleScanable;

import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class ListDemo {
    public static void main(String[] args) {
        List<Integer> myList = new LinkedList<Integer>();
        myList.add(30);
        myList.add(14);
        myList.add(100213);
        myList.add(666);
        myList.add(0, 1);

        System.out.println(myList);
        System.out.println(myList.contains(7));
        System.out.println(myList.size());
        System.out.println(myList.get(0));
        System.out.println(myList.get(myList.size() - 1));
        myList.remove(0);
        System.out.println(myList);
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }
        for (Integer n : myList) {
            System.out.println(n);
        }
        List<Integer> evenList = new LinkedList <Integer>();
        for (Iterator<Integer> it = myList.iterator(); it.hasNext(); ) {
            Integer n = it.next();
            if (n % 2 == 0) {
                it.remove();
                evenList.add(n);
            }
        }
        // myList.sort(1);
        System.out.println(myList);
        Collections.sort(myList);
        System.out.println(myList);

        List<Person> pList = new LinkedList<Person>();
        pList.add(new Person("guenther", 54));
        pList.add(new Person("frederike", 43));
        pList.add(new Person("maximilian", 12));
        pList.add(new Person("gertrude", 65));
        System.out.println(pList);
        export(pList, "personen.csv");
        Collections.sort(pList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.name.compareTo(o2.name);
            }
        });
      //  Collections.sort(pList);
        System.out.println(pList);
        List<Person> importList = importPerson("personen.csv");
        System.out.println(importList);

    }

    public static List<Person> importPerson(String filename){
        List<Person> list = new LinkedList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
           String line;
            while ((line = br.readLine())!=null){
                System.out.println("read: " + line);
                String[] data = line.split(";");
                //System.out.println(data[0]);
                //System.out.println(Integer.parseInt(data[1]));
                list.add(
                new Person(data[0], Integer.parseInt(data[1])));
            }
            br.close();
        } catch (Exception e) {

        }
        return list;
    }
    private static void export(List<Person> List, String s) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(s)); //no access to C:\\
            for (Person p : List){
                bw.write(p.getName() + ";" + p.getAge());
                bw.newLine();
            }
            bw.close();

        } catch (IOException ex) {
            System.err.println("could not open file");
        }
    }
}