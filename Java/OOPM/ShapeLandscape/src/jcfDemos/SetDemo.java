package jcfDemos;
import java.util.*;

public class SetDemo {
    public static void main(String[] args) {
        Set<Person> hSet = new HashSet<>();
        hSet.add(new Person("hans", 30));
        hSet.add(new Person("franz", 35));
        hSet.add(new Person("peppi", 10));
        hSet.add(new Person("otto", 27));
        System.out.println(hSet);

        Set<Person> lhSet = new LinkedHashSet<>();
        lhSet.add(new Person("hans", 30));
        lhSet.add(new Person("franz", 35));
        lhSet.add(new Person("peppi", 10));
        lhSet.add(new Person("otto", 27));
        System.out.println(lhSet);

        Set<Person> tSet = new TreeSet<>();
        tSet.add(new Person("hans", 30));
        tSet.add(new Person("franz", 35));
        tSet.add(new Person("peppi", 10));
        tSet.add(new Person("otto", 27));
        System.out.println(tSet);

        Set<Person> tSet2 = new TreeSet<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return Integer.compare(o1.age,o2.age);
            }
        });
        tSet2.add(new Person("hans", 30));
        tSet2.add(new Person("franz", 35));
        tSet2.add(new Person("peppi", 10));
        tSet2.add(new Person("otto", 27));
        tSet2.add(new Person("otto", 28));

        System.out.println(tSet2);

        tSet.addAll(hSet);                      //Set union
        tSet.retainAll(hSet);               //Set intersection

        /*for (Iterator<Person> pIt =  tSet.iterator(); pIt.hasNext();) {
            Integer n = pIt.next();
            if (n % 2 == 0) {
                pIt.remove();
                tSet2.add(n);
            }
        }*/

    }
}
