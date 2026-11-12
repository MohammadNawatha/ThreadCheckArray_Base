import java.util.ArrayList;

/**
 * Represents shared data containing an {@code ArrayList<Integer>}, a tracking boolean array,
 * a state flag, and a constant integer value.
 */
public class SharedData {

    /** The list of integer data. */
    private ArrayList<Integer> array;

    /** The boolean array tracking win conditions, initialized using the size of the array list. */
    private boolean[] winArray;

    /** A flag indicating a specific state or condition. */
    private boolean flag;

    /** A constant integer value associated with the shared data. */
    private final int b;

    /**
     * Constructs a new {@code SharedData} instance with the specified integer list and constant value.
     * Automatically initializes the {@code winArray} to match the size of the provided list.
     *
     * @param array the {@code ArrayList<Integer>} to be stored
     * @param b     the integer value {@code b}
     */
    public SharedData(ArrayList<Integer> array, int b) {
        this.array = array;
        this.b = b;
        if (array != null) {
            this.winArray = new boolean[array.size()];
        } else {
            this.winArray = new boolean[0];
        }
    }

    /**
     * Returns the win array.
     *
     * @return the {@code boolean[]} win array
     */
    public boolean[] getWinArray() {
        return winArray;
    }

    /**
     * Sets the win array.
     *
     * @param winArray the {@code boolean[]} to set
     */
    public void setWinArray(boolean[] winArray) {
        this.winArray = winArray;
    }

    /**
     * Returns the integer list.
     *
     * @return the {@code ArrayList<Integer>} array
     */
    public ArrayList<Integer> getArray() {
        return array;
    }

    /**
     * Returns the constant integer value {@code b}.
     *
     * @return the integer value {@code b}
     */
    public int getB() {
        return b;
    }

    /**
     * Returns the status of the flag.
     *
     * @return {@code true} if the flag is set, {@code false} otherwise
     */
    public boolean getFlag() {
        return flag;
    }

    /**
     * Sets the status of the flag.
     *
     * @param flag the boolean value to set
     */
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}