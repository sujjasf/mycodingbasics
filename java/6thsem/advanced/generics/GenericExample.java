
import java.util.Arrays;

// Using generic to swap two elements in an array
public class GenericExample {
    public static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, 4, 5};
        swap(nums, 0, 2);
        System.out.println(Arrays.toString(nums));

        Float[] numsf = {1.3f, 2.3f, 3.3f, 4.3f, 5.3f};
        swap(numsf, 0, 2);
        System.out.println(Arrays.toString(numsf));

        Double[] numsd = {1.3, 2.3, 3d, 4d, 5d};
        swap(numsd, 0, 2);
        System.out.println(Arrays.toString(numsd));

        String[] words = {"Java", "Python", "C++"};
        swap(words, 1, 2);
        System.out.println(Arrays.toString(words));
    }
}
