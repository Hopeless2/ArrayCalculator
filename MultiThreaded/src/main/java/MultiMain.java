import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class MultiMain {
    public static void main(String[] args){
        int[] ints = new int[10000000];
        long startTime = System.currentTimeMillis();

        Random random = new Random();
        for(int i = 0; i < ints.length; i ++){
            ints[i] = random.nextInt(2);
        }
        MyRecursiveTask myRecursiveTask = new MyRecursiveTask(ints.length, 0, ints);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        int sum = forkJoinPool.invoke(myRecursiveTask);
        double average = sum;
        average /= ints.length;
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        System.out.println("Сумма - " + sum + "\n" +
                "Среднее арифметическое - " + average + "\n" +
                "Время выполнения: " + resultTime + " миллисекунд");
    }
}
