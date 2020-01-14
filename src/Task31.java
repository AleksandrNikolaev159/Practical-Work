import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Task31 {
    public static void main(String[] args) {

        List<Person> persons = new Task31().setFileDataInArrayListAndGetPersonList("C:\\GitHub\\PracticalWork\\1.txt");
        Person person = new Person();

        person.printName(persons);

        System.out.println();
        System.out.println("================================================");
        System.out.println();

        person.printAgeAndNameOver18(persons);

        System.out.println();
        System.out.println("================================================");
        System.out.println();

        person.printOverAverageMark(persons);

        System.out.println();
        System.out.println("================================================");
        System.out.println();

    }

    private List<Person> setFileDataInArrayListAndGetPersonList(String filePath) {

        List<Person> persons = null;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {

            persons = new ArrayList<>();
            String line;
            int i = 0;
            while ((line = bufferedReader.readLine()) != null) {
                if (i == 0) {
                    i++;
                    continue;
                }
                String[] data = line.split(" ");
                persons.add(new Person(Integer.parseInt(data[0]),
                        data[1] + " " + data[2] + " " + data[3],
                        Integer.parseInt(data[4]),
                        Double.parseDouble(data[5])));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return persons;
    }

}
