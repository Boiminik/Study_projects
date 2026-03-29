package jcfDemos;

import java.util.Comparator;

public class Person implements Comparable<Person> {
    String name;
    int age;

    public Person (String n, int a){
        name = n;
        age = a;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String toString(){
        return String.format("{Person: name=%s, age=%d}", name, age);
    }

    @Override
    public int compareTo(Person o) {
        return String.CASE_INSENSITIVE_ORDER.compare(name, o.name);
    }
}
