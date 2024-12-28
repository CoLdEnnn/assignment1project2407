import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Paths;

import models.Person;
import models.School;
import models.Student;
import models.Teacher;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        String studentFile = "src/input.txt";
        String teachersFile = "src/teachers.txt";

        School school = new School();
        Person person = new Person();
        try {
            List<String> studentLines = Files.readAllLines(Paths.get(studentFile));
            for (String line : studentLines) {
                String[] parts = line.split(" ");
                String name = parts[0];
                String surname = parts[1];
                int age = Integer.parseInt(parts[2]);
                boolean gender = parts[3].equalsIgnoreCase("Male");
                List<Integer> grades = new ArrayList<>();
                for (int i = 4; i < parts.length; i++) {
                    grades.add(Integer.parseInt(parts[i]));
                }
                Student student = new Student(name, surname, age, gender, grades);
                school.addMember(student);
            }

            List<String> teacherLines = Files.readAllLines(Paths.get(teachersFile));
            for (String line : teacherLines) {
                String[] parts = line.split(" ");
                String name = parts[0];
                String surname = parts[1];
                int age = Integer.parseInt(parts[2]);
                boolean gender = parts[3].equalsIgnoreCase("Male");
                String subject = parts[4];
                int yearsOfWork = Integer.parseInt(parts[5]);
                int salary = Integer.parseInt(parts[6]);
                Teacher teacher = new Teacher(name, surname, age, gender, subject, yearsOfWork, salary);

                if (yearsOfWork > 10) {
                    teacher.giveRaise(10);
                }
                school.addMember(teacher);
            }

            System.out.println("Task 3: Class Relationships");
            System.out.println(school);

        } catch (IOException e) {
            System.err.println("Error reading files: " + e.getMessage());
        }
    }
}