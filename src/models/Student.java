package models;
import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private static int id;
    private final ArrayList<Integer> grades = new ArrayList<>();
    private double gpa;
    private static int id_gen = 1;

    public Student(String name, String surname, int age, boolean gender, List<Integer> grades) {
        super(name, surname, age, gender);
        this.grades.addAll(grades);
        id = id_gen;
        id_gen++;
    }

    private void generateId() { id = id_gen++; }

    public int getStudentID() {
        generateId();
        return id;
    }

    public void addGrade(int grade) {
        if (grade > 0 && grade < 100) {
            grades.add(grade);
        } else {
            System.out.println("Error: grade must be between 0 and 100");
        }
    }

    public double calculateGPA() {
        if (grades.isEmpty()) {
            System.out.println("Error: grade list is empty");
        }
        double total = 0.0;
        for (Integer grade : grades) {
            if (grade >= 90) {
                total += 4.0;
            } else if (grade >= 80) {
                total += 3.0;
            } else if (grade >= 70) {
                total += 2.0;
            } else if (grade >= 60) {
                total += 1.0;
            } else {
                total += 0.0;
            }
        }
        gpa = total / grades.size();
        return gpa;
        }

    @Override
    public String toString() { return "I am a student with ID" + ' ' + getStudentID() + " " + "GPA" + ' ' + calculateGPA(); }
}


