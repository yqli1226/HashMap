package 散列表;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: test
 * @description: 通过数组和ArrayList实现散列表
 * @author: Mr.Li
 * @create: 2021-02-23 09:09
 **/
public class MyMap {
    private List<Object>[] data = new ArrayList[16];
    private double loadFactor = 0.75d;
    private int notNull = 0;

    public void add(Object o){
        //计算hashCode
        int i = o.hashCode();
        int index = i % data.length;
        List<Object> datum = data[index];
        //数组为空，创建新的ArrayList
        if(datum==null){
            datum = new ArrayList<Object>();
            data[index] = datum;
            notNull++;
        }
        if(!datum.contains(o)){
            data[index].add(o);
        }
        //如果 非空桶/空桶+非空桶 >= 0.75 扩容
        if(Double.compare(notNull*1.0 / data.length, loadFactor) >= 0){
            reSzie();
        }
    }
    /*
    * 扩容 扩容至两倍
    * */
    private void reSzie() {
        List<Object> [] oldData = data;
        notNull = 0;
        data = new ArrayList[oldData.length * 2];
        for (List<Object> oldDatum : oldData) {
            if(oldDatum!=null){
                for (Object o : oldDatum) {
                    add(o);
                }
            }
        }
    }

    private Object get(Object o){
        int i = o.hashCode();
        int index = i % data.length;
        List<Object> datum = data[index];
        if(datum != null){
            for (Object o1 : datum) {
                if(o1.hashCode() == o.hashCode() && o1.equals(o)){
                    return o;
                }
            }
        }
        return null;
    }

    private boolean remove(Object o){
        int i = o.hashCode();
        int index = i % data.length;
        List<Object> datum = data[index];
        if(datum != null){
            for (Object o1 : datum) {
                if(o1.hashCode() == o.hashCode() && o1.equals(o)){
                    return datum.remove(o);
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (List<Object> datum : data) {
            if(datum != null){
                sb.append(datum.toString());
                sb.append("\n");
            }
        }

        return "MyMap{" +
                "data=" + sb.toString() +
                ", loadFactor=" + loadFactor +
                ", notNull=" + notNull +
                ", size=" + data.length +
                '}';
    }

    public static void main(String[] args) {
        Student student = new Student();
        Teacher teacher = new Teacher();
        MyMap myMap = new MyMap();
        for(int i = 0; i < 16; i++){
            Teacher teacher1 = new Teacher();
            teacher1.setAge(i+30);
            myMap.add(teacher1);
        }
        myMap.add(student);
        myMap.add(teacher);
        System.out.println(myMap);
    }
}
