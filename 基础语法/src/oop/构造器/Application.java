package oop.构造器;

public class Application {
    public static void main(String[] args) {

        //new实例化对象
        oop.构造器.Person person = new oop.构造器.Person();
        System.out.println(person.name);

        oop.构造器.Person person1 = new oop.构造器.Person("李四");
    }
}
