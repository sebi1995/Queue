import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static final String RED = "\033[0;91m";
    private static final String BLUE = "\033[0;94m";
    private static final String RESET = "\033[0m";
    private static final String GREEN = "\033[0;32m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean programRunning = true;
        while (programRunning) {
            System.out.print("How big do you wish the queue to be today?\nQueue size: ");
            Integer size = 0;

            while (size == 0) {
                try {
                    size = scanner.nextInt();
                } catch (InputMismatchException ime) {
                    System.out.print("Invalid input, try again: ");
                    scanner.next();
                }
            }

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
                            if (queue.isEmpty()) {
                                System.out.println(RED + "List is empty, add first!" + RESET);
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
                            System.out.println(BLUE + "+ <int arg>  => to enqueue numbers to the list.");
                            System.out.println("-            => to dequeue numbers from the list.");
                            System.out.println("r            => to start again with a new queue.");
                            System.out.println("e            => to exit." + RESET);
                            break;
                        default:
                            System.out.println("Enter \"h\" for help.");
                            break;
                    }
                } catch (NumberFormatException x) {
                    System.out.println(RED + input.substring(0, 1) + " " + "\"" + input.substring(2, input.length()) + "\" --: INVALID INPUT" + RESET);
                } catch (StringIndexOutOfBoundsException sioobe) {
                    System.out.println("Queue is empty. Add first in order to dequeue.");
                }
            }

        }
    }

    private static String enqueue(Queue queue, int enQNum) {
        if (queue.enqueue(enQNum) == -404) {
            return RED + "There are no more positions to be used, come back tomorrow!" + RESET;
        } else {
            return BLUE + enQNum + " successfully added!" + RESET;
        }
    }

    private static String dequeue(Queue queue) {
        int h = queue.dequeue();
        if (h == -504) {
            return RED + "Everyone has had their turn" + RESET;
        } else {
            return GREEN + h + " has had their turn." + RESET;
        }
    }
}
