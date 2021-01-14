import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {



    public static void main(String[] args) {

        Person person = new Person();

        //Аналізуємо клас
        Class clazz = person.getClass();
        System.out.println("Імя класу: " + clazz);
        System.out.println("Поля класу: " + Arrays.toString(clazz.getDeclaredFields()));
        System.out.println("Батьківський клас: " + clazz.getSuperclass());
        System.out.println("Методи класу: " +  Arrays.toString(clazz.getDeclaredMethods()));
        System.out.println("Конструктори класу: " + Arrays.toString(clazz.getConstructors()));


        //Задаємо значеня приватному полю нейм і ворк не використовуючи конструктор чи сеттер
        try {
            Field field = person.getClass().getDeclaredField("name");
            Field field1 = person.getClass().getDeclaredField("work");
            field.setAccessible(true);
            field1.setAccessible(true);
            field.set(person, (String) "Andry ");
            field1.set(person, (String) "Works in a big IT-Company");
            System.out.println(person.getName()+" "+person.getWork());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }


        //Викликаємо приватний метод використовуючи рефлексію
        try {
            Method method = person.getClass().getDeclaredMethod("doSmth");
            method.setAccessible(true);
            method.invoke(person);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }

        //міняємо імя на Ігор
        try {
            Field field = person.getClass().getDeclaredField("name");
            field.setAccessible(true);
            field.set(person, (String)"Ігор");
            System.out.println(person.getName());
            System.out.println();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        //Викликаємо конструктор
        Person person1 = null;
        try {
            Class clazz1 = Class.forName(Person.class.getName());
            Class[] params = { String.class,int.class,};
            person1 = (Person) clazz1.getConstructor(params).newInstance("Denis", 32);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(person1);


    }

    }

