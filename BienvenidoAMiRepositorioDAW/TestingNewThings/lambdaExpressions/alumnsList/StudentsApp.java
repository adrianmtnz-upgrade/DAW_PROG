package TestingNewThings.lambdaExpressions.alumnsList;

import java.util.ArrayList;
import java.util.List;

public class StudentsApp {
    public static void main(String[] args) {
        
        List<Student> studentsList = new ArrayList<>();
        
        studentsList.add(new Student(1, "A123456", "Lucas", "Green", "Java Programming", 89.5, 20));
        studentsList.add(new Student(2, "B789012", "Grace", "Lopez", "Java Programming", 75.0, 22));
        studentsList.add(new Student(3, "C345678", "Luna", "Brown", "Java Programming", 92.3, 19));
        studentsList.add(new Student(4, "D901234", "Gabriel", "Smith", "Java Programming", 84.7, 23));
        studentsList.add(new Student(5, "E567890", "Linda", "Johnson", "Java Programming", 67.8, 21));

        studentsList.add(new Student(6, "F112233", "Emma", "Williams", "Object-Oriented Programming", 95.0, 18));
        studentsList.add(new Student(7, "G445566", "Liam", "Taylor", "Object-Oriented Programming", 72.5, 24));
        studentsList.add(new Student(8, "H778899", "Olivia", "Anderson", "Object-Oriented Programming", 88.9, 20));
        studentsList.add(new Student(9, "I334455", "Noah", "Davis", "Object-Oriented Programming", 79.3, 22));
        studentsList.add(new Student(10, "J667788", "Leah", "Martin", "Object-Oriented Programming", 90.4, 19));

        studentsList.add(new Student(11, "K123456", "Mason", "Clark", "Software Development", 81.2, 20));
        studentsList.add(new Student(12, "L789012", "Sophia", "White", "Software Development", 87.0, 21));
        studentsList.add(new Student(13, "M345678", "Logan", "Hall", "Software Development", 90.0, 22));
        studentsList.add(new Student(14, "N901234", "Ava", "Young", "Software Development", 78.3, 23));
        studentsList.add(new Student(15, "O567890", "Ethan", "King", "Software Development", 85.1, 18));

        studentsList.add(new Student(16, "P112233", "Isabella", "Scott", "Spring Framework", 88.0, 19));
        studentsList.add(new Student(17, "Q445566", "Benjamin", "Wright", "Spring Framework", 73.5, 20));
        studentsList.add(new Student(18, "R778899", "Amelia", "Baker", "Spring Framework", 91.2, 21));
        studentsList.add(new Student(19, "S334455", "Gavin", "Mitchell", "Spring Framework", 76.9, 24));
        studentsList.add(new Student(20, "T667788", "Chloe", "Perez", "Spring Framework", 82.6, 22));
    
        System.out.println("\n------------------------------------------------------------------------------");
        System.out.println("\nStudents list:");
        studentsList.stream().forEach(s -> System.out.println(s.toString()));

        System.out.println("\n------------------------------------------------------------------------------");
        System.out.println("\nStudents whose name starts with L or G:");
        studentsList.stream().filter(s -> s.getName().toLowerCase().charAt(0) == 'l' || s.getName().toLowerCase().charAt(0) == 'g')
        .forEach(s -> System.out.println(s.toString()));

        System.out.println("\n------------------------------------------------------------------------------");
        System.out.print("\nTotal number of students: ");
        System.out.println(studentsList.stream().count());
        System.out.println("\n------------------------------------------------------------------------------");
        
        System.out.println("\n------------------------------------------------------------------------------");
        System.out.println("\nYoungest student:");
        studentsList.stream().min((a1,a2) -> a1.getAge() - a2.getAge()).ifPresent(System.out::println);
    
        System.out.println("\n------------------------------------------------------------------------------");
        System.out.println("\nOldest student:");
        studentsList.stream().max((a1,a2) -> a1.getAge() - a2.getAge()).ifPresent(System.out::println);
    
        System.out.println("\n------------------------------------------------------------------------------");
        System.out.println("\nFirst student of the list:");
        System.out.println(studentsList.stream().findFirst());

        System.out.println("\n------------------------------------------------------------------------------");
        System.out.println("\nStudents who are enrolled to a course which name ends with 'T':");
        studentsList.stream().filter(s -> s.getCourseName().toLowerCase().endsWith("t"))
        .forEach(System.out::println);
        
        System.out.println("\n------------------------------------------------------------------------------");
        System.out.println("\nStudents who are enrolled to a course which name contains letter 'V'");
        studentsList.stream().filter(s -> s.getCourseName().toLowerCase().contains("v"))
        .forEach(System.out::println);

        System.out.println("\n------------------------------------------------------------------------------");
        System.out.println("\nStudents whose name has more than 5 characters");
        studentsList.stream().filter(s -> s.getName().length() > 5).forEach(System.out::println);
    }
}
