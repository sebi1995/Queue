import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean programRunning = true;
        while (programRunning) {
            System.out.print("How big do you wish the queue to be today?\nQueue size: ");
            int size = scanner.nextInt();
            Queue queue = new Queue(size);

            boolean queueRunning = true;
            while (queueRunning) {
                System.out.print("> ");
                String input = new Scanner(System.in).nextLine();

                try {
                    switch (input.substring(0, 1)) {
                        case "+":
                            String s = input.substring(2, input.length());
                            s = s.replace(" ", "");
                            System.out.println(enqueue(queue, Integer.parseInt(s)));
                            System.out.println(queue.toString());
                            break;
                        case "-":
                            if (queue.isEmpty() == -604){
                                System.out.println("List is empty, add first!");
                            } else {
                                System.out.println(dequeue(queue));
                                System.out.println(queue.toString());
                            }
                            break;
                        case "e":
                            System.out.println("Goodbye.");
                            queueRunning = programRunning = false;
                            break;
                        case "r":
                            queueRunning = false;
                            break;
                        case "h":
                            System.out.println("+ <int arg>  => to enqueue numbers to the list.");
                            System.out.println("-            => to dequeue numbers from the list.");
                            System.out.println("r            => to start again with a new queue.");
                            System.out.println("e            => to exit.");
                            break;
                        default:
                            System.out.println("Enter \"h\" for help.");
                            break;
                    }
                } catch (NumberFormatException x) {
                    System.out.println(input.substring(0, 1) + " " + "\"" + input.substring(2, input.length()) + "\" --: INVALID INPUT");
                } catch (StringIndexOutOfBoundsException sioobe) {
                    System.out.println("List is empty. Add first in order to dequeue.");
                }
            }
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
