import java.util.Arrays;

public class Queue {

    private int[] vector;
    private int H;//head - beginning
    private int T;//tail - end

    Queue(int size) {
        vector = new int[size];
        H = 0;
        T = 0;
        System.out.println("thisislen"+vector.length);
    }

    public int enqueue(int input) { //insert
        if (T == vector.length){
            return -404;
        } else {
            vector[T] = input;
            return vector[T++];
        }
    }

    public int dequeue() { //delete
        if (H == T){
            return -504;
        } else {
            H++;
            return H;
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(vector).substring((H*3)+1, (T*3)+1);
    }
}
