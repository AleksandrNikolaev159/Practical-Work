import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Sort {

    public static void main(String[] args) {
        new Sort().inputData();
    }

    private void inputData(){
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Введи колличество чисел");
            String countNumber = bufferedReader.readLine();

            System.out.println("Введи диапазон чисел");
            String  maxNumber = bufferedReader.readLine();

            System.out.println("Введи метод сортировки чисел: \n 1 - Сортировка выбором \n 2 - Сортировка пузырьком");
            String  methodSort = bufferedReader.readLine();

            int[] numbers = new int[Integer.parseInt(countNumber)];
            Random random = new Random();

            for (int i = 0; i < numbers.length-1; i++) {
                numbers[i] = random.nextInt(Integer.parseInt(maxNumber));
            }

            switch (methodSort){
                case "1" :
                    new Sort().selectionSort(numbers);
                    break;
                case "2" :
                    new Sort().bubbleSort(numbers);
                    break;
                default:
                    System.out.println("Вы выбрали неверный метод сортировки, пожалуйста попробуйте ещё раз.");;
                    return;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void selectionSort(int[] numbers) {
        Long startTime;
        Long summWorkTime = 0L;
        for (int i = 0; i < 10 ; i++) {
            startTime = System.currentTimeMillis();

            int min, temp;

            for (int index = 0; index < numbers.length - 1; index++) {
                min = index;
                for (int scan = index + 1; scan < numbers.length; scan++) {
                    if (numbers[scan] < numbers[min])
                        min = scan;
                }

                // Swap the values
                temp = numbers[min];
                numbers[min] = numbers[index];
                numbers[index] = temp;
            }

            //Вывод в консоль
            for (int q = 0; q < numbers.length; q++) {
                System.out.print(numbers[q] + " ");
            }

            summWorkTime += System.currentTimeMillis() - startTime;

            System.out.println();
            System.out.println("Время работы программы: " + (System.currentTimeMillis() - startTime) + " миллисекунд");
        }

        long averageTime = summWorkTime / 10;

        System.out.print("Среднее время работы программы: " + averageTime + " миллисекунд");
        System.out.println();
        System.out.println("================================================");
        System.out.println();
    }

    public static void bubbleSort(int[] numbers) {

        Long startTime;
        Long summWorkTime = 0L;
        for (int t = 0; t < 10 ; t++) {
            startTime = System.currentTimeMillis();
            /*Внешний цикл каждый раз сокращает фрагмент массива,
      так как внутренний цикл каждый раз ставит в конец
      фрагмента максимальный элемент*/
            for (int i = numbers.length - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    /*Сравниваем элементы попарно,
              если они имеют неправильный порядок,
              то меняем местами */
                    if (numbers[j] > numbers[j + 1]) {
                        int tmp = numbers[j];
                        numbers[j] = numbers[j + 1];
                        numbers[j + 1] = tmp;
                    }
                }
            }

            //Вывод в консоль
            for (int q = 0; q < numbers.length; q++) {
                System.out.print(numbers[q] + " ");
            }

            summWorkTime += System.currentTimeMillis() - startTime;

            System.out.println();
            System.out.println("Время работы программы: " + (System.currentTimeMillis() - startTime) + " миллисекунд");
        }

        long averageTime = summWorkTime / 10;

        System.out.print("Среднее время работы программы: " + averageTime + " миллисекунд");
        System.out.println();
        System.out.println("================================================");
        System.out.println();
    }
}
