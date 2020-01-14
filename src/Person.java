import java.util.List;
import java.util.OptionalDouble;

public class Person {
    Integer id;
    String name;
    Integer age;
    Double averageMark;

    public Person() {
    }

    public Person(Integer id, String name, Integer age, Double averageMark) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.averageMark = averageMark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(Double averageMark) {
        this.averageMark = averageMark;
    }

    /**1. Вывести в столбик на экран Фамилии и Инициалы студентов в виде*/
    public void printName(List<Person> persons) {
        persons.stream().forEach(x -> System.out.println("ФИО: " + x.getName()));
    }

    /**Вывести на экран в столбик Возраст и, через пробел, Фамилии и Инициалы совершеннолетних студентов*/
    public void printAgeAndNameOver18(List<Person> persons) {
        persons.stream().filter(x -> x.getAge() >= 18).forEach(x -> System.out.println("Возраст: " + x.getAge() + " ФИО: " + x.getName()));
    }

    /**Вывести на экран в столбик Возраст, Средний балл и Фамилии и Инициалы студентов, у которых Средний балл выше, чем средний балл
     в группе, отсортировав (можно использовать любой метод сортировки) их по возрасту*/
    public void printOverAverageMark(List<Person> persons) {
        Double averageMark = persons.stream().mapToDouble(x -> x.getAverageMark()).average().getAsDouble();
        persons.stream().filter(x -> x.getAverageMark() >= averageMark).forEach(x -> System.out.println("Возраст: " + x.getAge() + " Средний балл: " + x.getAverageMark() + " ФИО: " + x.getName()));
    }
}
//Коментарий