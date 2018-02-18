import java.util.Arrays;

public class Queue {

    private int[] vector;
    private int H;//head - beginning
    private int T;//tail - end

    Queue(int size) {
        vector = new int[size];
        H = 0;
        T = 0;
    }

    public int enqueue(int input) { //insert
        if (T == vector.length-1){
            return -404;
        } else {
            vector[T] = input;
            return vector[T];
        }
    }

    public int dequeue() { //delete
        if (H == vector.length){
            return 504;
        } else {
            H++;
            return H;
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(vector);
    }
}
