package Demos;
import util.*;

import java.sql.SQLOutput;
import java.util.*;

public class UniversityDemo {
    public static void main(String[] args) {
        Course oopm = new Course("OOPM", "Mandl", 5, "23SS");
        Course macs1 = new Course ("MACS1", "Simeonov", 3, "22WS");
        Course macs2 = new Course ("MACS2", "Simeonov", 3, "23SS");
        Course apm = new Course ("APM", "Molzer", 2, "23SS");
        Course pm = new Course ("PM", "Wala", 2, "23SS");
        Course beng = new Course ("BENG", "Adams", 3,"23SS");
       // Course kreko = new Course ("KREKO", "Moshammer", 3, "23SS");

        List<Course> courses = new ArrayList<Course>();
        courses.add(oopm);
        courses.add(macs1);
        courses.add(macs2);
        courses.add(apm);
        courses.add(pm);
        courses.add(beng);

        display(courses);
        Collections.sort(courses);
        display(courses);

        List<Comparator<Course>> cCmp = new LinkedList<>();
        cCmp.add(new CourseECTSComparator());
        cCmp.add(new CourseNameComparator());

        display(cCmp);

        Collections.sort(courses, new CourseECTSComparator());
        Collections.sort(courses, new CourseECTSComparator().reversed());
        Collections.sort(courses, new CourseECTSComparator().thenComparing(new CourseNameComparator()));

        System.out.print(oopm.compareTo(macs2));

        List<Student> students = new ArrayList<>();

        students.add(new Student(12345678, "Andrew Garfield", 0, 2.4));
        students.add(new Student(12334567, "Doug Dimmadome", 0, 1.0));
        students.add(new Student(12335567, "Eren Yaeger", 0, 3.0));
        students.add(new Student(12334567, "Eugene Krabs", 0, 2.8));

        students.get(0).enrol(courses.get(0));
        students.get(0).enrol(courses.get(1));


        List<Comparator<Student>> sCmp = new LinkedList<>();
        sCmp.add(new StudentGPAComparator());
        sCmp.add(new StudentNameComparator());

        display(sCmp);
        display(students);
        Collections.sort(students);
        display(students);
        students.sort(sCmp.get(1));
        display(students);



    }

    private static <T> void display(List<T> coll) {
        System.out.println("---");
        for (T c: coll){
            System.out.println(c);
        }
        System.out.println("---" + coll.size() + " element(s)");
    }
}
