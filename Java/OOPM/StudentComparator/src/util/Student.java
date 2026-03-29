package util;
import java.util.*;

public class Student implements Comparable<Student>{
    private int uid;               //
    private String name; //non empty
    private int program; //Studiengang, 0...BWI, 1...MWI, ...
    private double gpa; //Notendurchschnitt, 1. - 5.
    private List<Course> courses = new LinkedList<Course>();

    public boolean enrol(Course c){
        return courses.add(c);
    }

//constructor
    public Student(Student s){
        this.uid = s.uid;
        this.name = s.name;
        this.program = s.program;
        this.gpa = s.gpa;
    }
    public Student(int uid, String name, int program, double gpa) {
        this.uid = uid;
        this.name = name;
        this.program = program;
        this.gpa = gpa;
    }
    //getter
    public int getUid() {
        return uid;
    }
    public String getName() {
        return name;
    }
    public int getProgram() {
        return program;
    }
    private String getProgramString(){
        String[] programs ={"BWI", "MWI"};
        return programs[this.program];
    }
    public double getGpa() {
        return gpa;
    }
//setter
    public void setUid(int uid) {
        if (uid < 99999999 && uid >= 10000000)
            this.uid = uid;
    }
    public void setName(String name) {
        if (!name.isEmpty() || !name.isBlank())
            this.name = name;
    }
    public void setProgram(int program) {
        this.program = program;
    }
    public void setGpa(double gpa) {
        if (gpa <= 5 && gpa >=1)
            this.gpa = gpa;
    }
//comparator
    @Override
    public int compareTo(Student o) {
        return Integer.compare(uid, o.uid);
    }

    @Override
    public String toString() {
        return "Student{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", program=" + program +
                ", gpa=" + gpa +
                ", courses=" + courses +
                '}';
    }
}
