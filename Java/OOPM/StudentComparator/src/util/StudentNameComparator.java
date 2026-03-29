package util;
import java.util.*;

public class StudentNameComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return String.CASE_INSENSITIVE_ORDER.compare(o1.getName(),o2.getName());
    }

    @Override
    public String toString() {
        return "StudentNameComparator{}";
    }
}
