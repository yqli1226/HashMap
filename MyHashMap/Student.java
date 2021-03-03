package 散列表;

import java.util.Objects;

/**
 * @program: test
 * @description: 学生类
 * @author: Mr.Li
 * @create: 2021-02-23 09:33
 **/
public class Student {
    private String name;
    private int age;
    private int id;
    private int count = 1000;

    public Student(){
        this.id = ++count;
    }

    public Student(String name, int age){
        this.id = ++count;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                id == student.id &&
                count == student.count &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, id, count);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                ", count=" + count +
                '}';
    }
}
