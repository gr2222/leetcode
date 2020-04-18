/**
 * @author maitentai
 * @version 1.0
 * @date 2020/4/18 3:10 下午
 */
public class TestExtend {
    public static void main(String[] args) {
        College per = new College();
        per.name = "高锐";
        per.age = 22;
        per.weight = 150;
        per.height = 1.70;
        per.ech();
        per.collegeName = "重庆大学城市科技学院";
        String sey = per.sey();
        System.out.println(sey);
        College per2 = new College();
        per2.name = "高鹏";
        per2.collegeName = "广西航空学院";
        per2.height = 1.65;
        per2.weight = 80;
        per2.age = 30;
        per2.ech();
        String sey1 = per2.sey();
        System.out.println(sey1);
        per.sociality(per2);
        per.sleep();
        per2.sleep();
    }
}

interface dosamethiong{
     void ech();
     void sleep();
     void sociality(person per);
}

class person implements dosamethiong{
    String name;
    int age;
    double weight;
    double height;
    @Override
    public void ech() {
        System.out.println(name+"吃了点东西");
    }

    @Override
    public void sleep() {
        System.out.println(name+"睡了一会");
    }

    @Override
    public void sociality(person per) {
        System.out.println(name+"和"+per.name+"正在社交");
    }
}

class College extends person{
    String collegeName;
    public String sey(){
        return name+"是一个"+age+"岁身高"+height+"米体重"+weight+"千克的"+collegeName+"大学生";
    }
}