package util;

public class Course implements Comparable<Course>{
    private String name;
    private String lecturer;
    private double ects;
    private String semester; //e.g. 22WS or 23SS
//constructor
    public Course (Course c){
        this.name = c.name;
        this.lecturer = c.lecturer;
        this.ects = c.ects;
        this.semester = c.semester;
    }
    public Course(String name, String lecturer, double ects, String semester) {
        this.name = name;
        this.lecturer = lecturer;
        this.ects = ects;
        this.semester = semester;
    }
//getter
    public String getName() {
        return name;
    }
    public String getLecturer() {
        return lecturer;
    }
    public double getEcts() {
        return ects;
    }
    public String getSemester() {
        return semester;
    }
    //setter
    public void setName(String name) {
        if(!name.isEmpty() || !name.isBlank())
            this.name = name;
    }
    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }
    public void setEcts(int ects) {
        this.ects = ects;
    }
    public void setSemester(String semester) {
        this.semester = semester;
    }
    //Comparator
    @Override
    public int compareTo(Course o) {
        return String.CASE_INSENSITIVE_ORDER.compare(semester, o.semester);
    }
    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", lecturer='" + lecturer + '\'' +
                ", ects=" + ects +
                ", semester='" + semester + '\'' +
                '}';
    }
}
