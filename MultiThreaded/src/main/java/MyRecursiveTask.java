import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

public class MyRecursiveTask extends RecursiveTask<Integer> {
    int end;
    int start;
    int[] array;

    public MyRecursiveTask(int end, int start, int[] array){
        this.end = end;
        this.start = start;
        this.array = array;
    }
    @Override
    protected Integer compute() {
        if(array.length <= 2) {
            System.out.printf("Task %s execute in thread %s%n", this, Thread.currentThread().getName());
            return Arrays.stream(array).sum();
        }
        final int diff = end - start;
        switch (diff) {
            case 0: return 0;
            case 1: return array[start];
            case 2: return array[start] + array[start+1];
            default: return forkTasksAndGetResult();
        }
    }

    private int forkTasksAndGetResult() {
        final int middle = (end - start) / 2 + start;

        MyRecursiveTask task1 = new MyRecursiveTask(start, middle, array);

        MyRecursiveTask task2 = new MyRecursiveTask(middle, end, array);

        task1.fork();
        task2.fork();

        return task1.join() + task2.join();
    }
}
