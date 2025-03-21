package binary;

import java.io.Serializable;

public class Person implements Serializable{

    private int age;
    private String name;

    public Person(int age, String name){
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void showData(){
        System.out.println("Name: " + name);
        System.out.println("Age:  " + age);
        System.out.println();
    }
}
