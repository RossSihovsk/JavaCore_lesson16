public class Person {

    private String name;
    private String surname;
    private int age;
    private String work;
    private  static  final String stat= "This is a human";

    public Person(String name, String surname, int age, String position) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.work = position;
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getWork() {
        return work;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person() {
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setWork(String work) {
        this.work = work;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", work='" + work + '\'' +
                '}';
    }

    private  void doSmth(){
        System.out.println(name + "do smth... For example "+ work);
    }
}
