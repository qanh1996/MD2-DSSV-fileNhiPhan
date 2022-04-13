import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Quoc Anh", "Ha Noi"));
        students.add(new Student(2, "Tuan Anh", "Thanh Hoa"));
        students.add(new Student(3, "Quynh Anh", "Nghe An"));
        students.add(new Student(4, "The Anh", "Hai Phong"));
        students.add(new Student(5, "Duc Anh", "Quang Tri"));
        writeToFile("student.txt", students);
        List<Student> studentDataFromFile = readDataFromFile("student.txt");
        for (Student student: studentDataFromFile){
            System.out.println(student);
        }

    }

    public static void writeToFile(String path, List<Student> students) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(students);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> readDataFromFile(String path) {
        List<Student> students = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            students = (List<Student>) objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return students;
    }
}
