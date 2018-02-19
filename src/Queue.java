import java.util.Arrays;

public class Queue {

    private int[] vector;
    private int H;//head - beginning
    private int T;//tail - end
    private StringBuilder qS;

    Queue(int size) {
        vector = new int[size];
        qS = new StringBuilder();
        H = 0;
        T = 0;
    }

    public int enqueue(int input) { //insert
        if (T == vector.length) {
            return -404;
        } else {
            vector[T] = input;
            return vector[T++];
        }
    }

    public int dequeue() { //delete
        if (H == T) {
            return -504;
        } else {
            H++;
            return H;
        }
    }

    public boolean isEmpty() {
        for (int v : vector) if (v != 0) return false;
        return true;
    }

    @Override
    public String toString() {
        qS.delete(0, qS.length());

        if ((H - 1) >= 0) {
            for (int i = 0; i < H; ++i) qS.append("\033[0;32m").append(vector[i]).append("\033[0m").append(" ");//green - reset
            for (int i = H; i < vector.length; ++i) qS.append("\033[0;91m").append(vector[i]).append("\033[0m").append(" ");//red - reset
        } else {
            for (int aVector : vector) qS.append("\033[0;91m").append(aVector).append(" ");//red
        }

        return qS.toString();
    }
}
