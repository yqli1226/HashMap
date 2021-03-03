package 散列表;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @program: test
 * @description: 教师类
 * @author: Mr.Li
 * @create: 2021-02-23 09:37
 **/
public class Teacher {
    private String name;
    private int age;
    private int id;
    private int count = 1000;

    public Teacher(){
        this.id = ++count;
        Map<String,String> map = new HashMap<String, String>();
    }

    public Teacher(String name, int age){
        this.id = ++count;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return age == teacher.age &&
                id == teacher.id &&
                count == teacher.count &&
                Objects.equals(name, teacher.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, id, count);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                ", count=" + count +
                '}';
    }
}
