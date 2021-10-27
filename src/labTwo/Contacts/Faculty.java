package labTwo.Contacts;

import java.util.Arrays;
import java.util.Objects;

public class Faculty {
    private String name;
    Student[] students;

    public Faculty(String name, Student[] students) {
        this.name = name;
        this.students = Arrays.copyOf(students, students.length);
    }

    public String getName() {
        return name;
    }

    public int countStudentsFromCity(String cityName) {
        int count = 0;
        for (Student student : students) {
            if (Objects.equals(student.getCity(), cityName))
                count++;
        }
        return count;
    }

    public Student getStudent(long index) {
        for (Student student : students) {
            if (student.getIndex() == index) {
                return student;
            }
        }
        return null;
    }

    public double getAverageNumberOfContacts() {
        double avg = 0;
        for(Student student : students) {
            avg += student.getTotalContacts();
        }
        return avg / students.length;
    }

    public Student getStudentWithMostContacts() {
        Student myStudent = students[0];
        for (Student student : students) {
            if (student.getTotalContacts() == myStudent.getTotalContacts()) {
                if (myStudent.getIndex() < student.getIndex())
                    myStudent = student;
            }
            if (student.getTotalContacts() > myStudent.getTotalContacts())
                myStudent = student;
        }
        return myStudent;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\"fakultet\":\"").append(name).append("\", ");
        stringBuilder.append("\"studenti\":[");
        for(int i = 0; i < students.length; i++) {
                stringBuilder.append(students[i]);
                if(i != students.length - 1)
                    stringBuilder.append(", ");
        }
        stringBuilder.append("]}");


        return stringBuilder.toString();
    }
}
