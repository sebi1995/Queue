public class Main {

    public static void main(String[] args) {
        int size = 10;
        Queue queue = new Queue(size);


        for (int i = 0; i < size; ++i) {
            System.out.println(enqueue(queue, 5));
            System.out.println(queue.toString());
        }
        for (int i = 0; i < size; ++i) {
            System.out.println(dequeue(queue));
            System.out.println(queue.toString());
        }

    }

    private static String enqueue(Queue queue, int enQNum) {
        if (queue.enqueue(enQNum) == -404) {
            return "There are no more positions to be used, come back tomorrow!";
        } else {
            return "Number " + enQNum + " successfully added!";
        }
    }

    private static String dequeue(Queue queue) {
        int h = queue.dequeue();
        if (h == -504) {
            return "Everyone has had their turn";
        } else {
            return "Person " + h + " has had their turn.";
        }
    }
}
