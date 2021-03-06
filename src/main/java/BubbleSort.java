import java.util.Arrays;
import java.util.stream.Collectors;

public class BubbleSort {
    public static void main(String[] args) {


        boolean finished = true;


        int[] array = {88, 55, 99, 77, 1, 30, 21, 34};

        System.out.print("unsorted data: ");
        printArray(array);

        System.out.print("ascending order: ");
        bubble_sort(array);

        printArray(array);

        System.out.print("descending order: ");
        bubble_sort(array, false);

        printArray(array);


    }


    private static void bubble_sort(int[] input) {
        bubble_sort(input, true);
    }

    private static void bubble_sort(int[] input, boolean ascending) {

        int inputLength = input.length;
        int temp;
        boolean is_sorted;

        for (int i = 0; i < inputLength; i++) {

            is_sorted = true;

            for (int j = 1; j < (inputLength - i); j++) {

                if (ascending) {
                    if (input[j - 1] > input[j]) {
                        temp = input[j - 1];
                        input[j - 1] = input[j];
                        input[j] = temp;
                        is_sorted = false;
                    }
                } else {
                    if (input[j - 1] < input[j]) {
                        temp = input[j - 1];
                        input[j - 1] = input[j];
                        input[j] = temp;
                        is_sorted = false;
                    }

                }

            }

            // is sorted? then break it, avoid useless loop.
            if (is_sorted) break;

        }

    }

    private static void printArray(int[] data) {
        String result = Arrays.stream(data)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(","));
        System.out.println(result);
    }

}
