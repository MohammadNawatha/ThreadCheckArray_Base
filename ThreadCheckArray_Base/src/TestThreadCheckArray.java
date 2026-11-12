import java.util.ArrayList;
import java.util.Scanner;

/**
 * A test class that drives the multi-threaded array checking application.
 * It takes user input for an integer list and a target value, initializes the
 * {@link SharedData} object, runs two threads to process the data, and displays
 * the solution results if found.
 */
public class TestThreadCheckArray {

    /**
     * The main method that executes the program workflow, managing user input,
     * thread execution, and formatted output reporting.
     *
     * @param args command line arguments {@code String[]} passed to the application
     */
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            Thread thread1, thread2;
            System.out.println("Enter array size");
            int num = input.nextInt();

            // Refactored array to an ArrayList<Integer>
            ArrayList<Integer> array = new ArrayList<>(num);
            System.out.println("Enter numbers for array");

            for (int index = 0; index < num; index++) {
                array.add(input.nextInt());
            }

            System.out.println("Enter number");
            num = input.nextInt();

            SharedData sd = new SharedData(array, num);

            thread1 = new Thread(new ThreadCheckArray(sd), "thread1");
            thread2 = new Thread(new ThreadCheckArray(sd), "thread2");
            thread1.start();
            thread2.start();

            try {
                thread1.join();
                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (!sd.getFlag()) {
                System.out.println("Sorry");
                return;
            }

            // Updated length references to use .size()
            System.out.println("Solution for b : " + sd.getB() + ",n = " + sd.getArray().size());
            System.out.print("I:    ");
            for (int index = 0; index < sd.getArray().size(); index++) {
                System.out.print(index + "    ");
            }
            System.out.println();
            System.out.print("A:    ");
            for (int index : sd.getArray()) {
                System.out.print(index);
                int counter = 5;
                while (true) {
                    index = index / 10;
                    counter--;
                    if (index == 0) break;
                }
                for (int i = 0; i < counter; i++) System.out.print(" ");
            }
            System.out.println();
            System.out.print("C:    ");
            for (boolean index : sd.getWinArray()) {
                if (index) System.out.print("1    ");
                else System.out.print("0    ");
            }
        }
    }
}