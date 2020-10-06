package hw03.part2;

import java.io.*;
import java.util.*;

public class ClassSimulator {

    static Random rand = new Random();
    static HashMap<String, Student> allStudents;

    static class Student {
        String firstName;
        String lastName;
        ArrayList<Integer> marks;

        Student(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
            marks = new ArrayList<>();
        }

        String getFirstName() {
            return firstName;
        }

        String getLastName() {
            return lastName;
        }

        double averageMark() {
            double average = 0;
            for (int mark : marks) {
                average += mark;
            }
            average /= marks.size();
            return average;
        }

        void addMark(int mark) {
            marks.add(mark);
        }

        @Override
        public String toString() {
            return firstName + " " + lastName + ", оценки: " + Arrays.toString(marks.toArray()) + ", средняя оценка: " + averageMark();
        }
    }

    static String key(String firstName, String lastName) {
        return firstName.toLowerCase() + "_" + lastName.toLowerCase();
    }

    static void showAllStudents() {
        for (Map.Entry<String, Student> e : allStudents.entrySet()) {
            System.out.println(e.getValue());
        }
    }

    static boolean addStudent(String firstName, String lastName) {
        String key = key(firstName, lastName);
        if (allStudents.containsKey(key)) {
            return false;
        }
        allStudents.put(key, new Student(firstName, lastName));
        return true;
    }

    static boolean removeStudent(String firstName, String lastName) {
        String key = key(firstName, lastName);
        if (!allStudents.containsKey(key)) {
            return false;
        }
        allStudents.remove(key);
        return true;
    }

    static Student getRandomStudent() {
        int ind = rand.nextInt(allStudents.size());
        for (Map.Entry<String, Student> e : allStudents.entrySet()) {
            if (ind == 0) {
                return e.getValue();
            }
            ind--;
        }
        return null;
    }

    static void markStudent(String firstName, String lastName, int mark) {
        String key = key(firstName, lastName);
        Student student = allStudents.get(key);
        student.addMark(mark);
    }







    public static void main(String[] args) {
        allStudents = new HashMap<>();

        if (args.length != 0) {
            try {
                Scanner reader = new Scanner(new File(args[0]));
                while (reader.hasNextLine()) {
                    String firstName = reader.next();
                    String lastName = reader.next();
                    addStudent(firstName, lastName);
                }
                reader.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        Scanner reader = new Scanner(System.in);
        while (true) {
            System.out.print("1 - показать всех студентов\n" +
                    "2 - добавить студента\n" +
                    "3 - отчислить студента\n" +
                    "4 - выбрать отвечающего рандомно\n" +
                    "5 - выбрать отвечающего по имени и фамилии\n" +
                    "6 - выйти\n");
            System.out.flush();

            int option = reader.nextInt();
            boolean exit = false;

            switch (option) {
                case 1:
                    showAllStudents();
                    break;
                case 2:
                    System.out.println("имя и фамилия студента:");
                    String firstName = reader.next();
                    String lastName = reader.next();
                    System.out.println(addStudent(firstName, lastName));
                    break;
                case 3:
                    System.out.println("имя и фамилия студента:");
                    firstName = reader.next();
                    lastName = reader.next();
                    System.out.println(removeStudent(firstName, lastName));
                    break;
                case 4:
                    if (allStudents.size() == 0) {
                        System.out.println("все числанулись");
                        break;
                    }
                    Student randomStudent = getRandomStudent();
                    firstName = randomStudent.getFirstName();
                    lastName = randomStudent.getLastName();
                    System.out.println("отвечает: " + firstName + " " + lastName);
                    System.out.println("*тили-тили трали-вали*");
                    System.out.println("оценка: ");
                    int mark = reader.nextInt();
                    markStudent(firstName, lastName, mark);
                    break;
                case 5:
                    System.out.println("имя и фамилия студента:");
                    firstName = reader.next();
                    lastName = reader.next();
                    if (!allStudents.containsKey(key(firstName, lastName))) {
                        System.out.println("нету тут такого");
                        break;
                    }
                    System.out.println("отвечает: " + firstName + " " + lastName);
                    System.out.println("*тили-тили трали-вали*");
                    System.out.println("оценка: ");
                    mark = reader.nextInt();
                    markStudent(firstName, lastName, mark);
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("введите целое число [1, 5]");
                    break;
            }

            if (exit) {
                break;
            }

        }
    }
}