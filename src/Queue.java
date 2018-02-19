import java.util.Arrays;

public class Queue {

    private static final String RED = "\033[0;91m";
    private static final String BLUE = "\033[0;94m";
    private static final String GREEN = "\033[0;32m";
    private static final String RESET = "\033[0m";

    private int[] vector;
    private int H;//head - beginning
    private int T;//tail - end

    Queue(int size) {
        vector = new int[size];
        H = 0;
        T = 0;
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

    public int isEmpty(){
        boolean empty = true;
        int veclen = vector.length;
        for (int i = 0; i < veclen; ++i) {
            if (vector[i] != 0) empty = false;
        }
        return empty ? -604 : 0;
    }

    @Override
    public String toString() {
        String array = Arrays.toString(vector);
        array = array.replace("[", "");
        array = array.replace("]", "");
        array = array.replace(",", "");
        return array;
    }
}
