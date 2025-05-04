package TestingNewThings.lambdaExpressions.alumnsList;

public class Student {
    private int id;
    private String idNumber;
    private String name;
    private String surnames;
    private String courseName;
    private double grade;
    private int age;

    public Student(int id, String idNumber, String name, String surnames, String courseName, double grade, int age) {
        this.id = id;
        this.idNumber = idNumber;
        this.name = name;
        this.surnames = surnames;
        this.courseName = courseName;
        this.grade = grade;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getName() {
        return name;
    }

    public String getSurnames() {
        return surnames;
    }

    public String getCourseName() {
        return courseName;
    }

    public double getGrade() {
        return grade;
    }

    public int getAge() {
        return age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return 
        "\n------------------------------------------------------------------------------"+
        "\n\nID : " + id + "\nID Number : " + idNumber + "\nName : " + name + "\nSurnames : " + surnames
                + "\nCourse name : " + courseName + "\nGrade : " + grade + "\nAge : " + age +
        "\n\n------------------------------------------------------------------------------";
    }

}
