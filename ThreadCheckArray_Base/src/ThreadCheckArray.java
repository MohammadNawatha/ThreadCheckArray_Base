import java.util.ArrayList;

/**
 * A runnable task that performs a recursive check on an {@code ArrayList<Integer>}
 * to find a subset that sums up to a target value {@code b}, coordinating results
 * concurrently via a {@link SharedData} object.
 */
public class ThreadCheckArray implements Runnable {
    private boolean flag;
    private boolean[] winArray;
    private SharedData sd;
    private ArrayList<Integer> array;
    private int b;

    /**
     * Constructs a new {@code ThreadCheckArray} task using the provided shared data.
     * Initializes the local {@code winArray} based on the size of the shared {@code ArrayList<Integer>}.
     *
     * @param sd the {@link SharedData} instance containing the list and target value
     */
    public ThreadCheckArray(SharedData sd) {
        this.sd = sd;
        synchronized (sd) {
            array = sd.getArray();
            b = sd.getB();
        }
        winArray = new boolean[array.size()];
    }

    /**
     * Recursively checks if a subset of the {@code ArrayList<Integer>} sums up to the remaining target value.
     *
     * @-param n the current element count being evaluated
     * @param b the remaining target sum
     */
    void rec(int n, int b) {
        synchronized (sd) {
            if (sd.getFlag()) return;
        }
        if (n == 1) {
            if (b == 0 || b == array.get(n - 1)) {
                flag = true;
                synchronized (sd) { sd.setFlag(true); }
            }
            if (b == array.get(n - 1)) {
                winArray[n - 1] = true;
            }
            return;
        }

        rec(n - 1, b - array.get(n - 1));
        if (flag) {
            winArray[n - 1] = true;
        }
        synchronized (sd) {
            if (sd.getFlag()) return;
        }
        rec(n - 1, b);
    }

    /**
     * Executes the thread's check routine, initiating recursive evaluation based on the thread name
     * and updating the shared state upon finding a solution.
     */
    @Override
    public void run() {
        if (array.size() != 1) {
            if (Thread.currentThread().getName().equals("thread1")) {
                rec(array.size() - 1, b - array.get(array.size() - 1));
            } else {
                rec(array.size() - 1, b);
            }
        }
        if (array.size() == 1) {
            if (b == array.get(0) && !flag) {
                winArray[0] = true;
                flag = true;
                synchronized (sd) { sd.setFlag(true); }
            }
        }
        if (flag) {
            if (Thread.currentThread().getName().equals("thread1")) {
                winArray[array.size() - 1] = true;
            }
            synchronized (sd) { sd.setWinArray(winArray); }
        }
    }
}