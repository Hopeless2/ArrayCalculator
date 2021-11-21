import java.util.Random;

public class Main {

    public static void main(String[] args){
        int[] ints = new int[10000000];
        long start = System.currentTimeMillis();

        Random random = new Random();
        for(int i = 0; i < ints.length; i ++){
            ints[i] = random.nextInt(2);
        }

        System.out.println("Сумма " + sum(ints));
        System.out.println("Среднее арифметическое " + average(ints));
        System.currentTimeMillis();
        long end = System.currentTimeMillis();
        long result = end - start;
        System.out.println("Выполнение в однопоточном режиме заняло: " + result + " миллисекунд");
    }

    public static int sum(int[] ints){
        int result = 0;
        for (int anInt : ints) {
            result += anInt;
        }
        return result;
    }

    public static double average(int[] ints){
        double result = sum(ints);
        result /= ints.length;
        return result;
    }
}
