public class ArrayOps {
    public static void main(String[] args) {
    }

    public static int findMissingInt(int[] array) {
        // Write your code here:
        for (int i = 0; i < array.length; i++) {
            boolean inArray = false;
            for (int j = 0; j < array.length; j++) {
                if (array[j] == i) {
                    inArray = true;
                }
            }
            if (inArray == false) {
                return i;
            }
        }
        return -1;
    }

    public static int secondMaxValue(int[] array) {
        // Write your code here:
        int[] new_array = new int[array.length - 1];
        int original_max = max(array);
        for (int i = 0; i < array.length; i++) {
            if (array[i] != original_max) {
                new_array[i] = array[i];
            }
        }
        return max(new_array);
    }

    public static int max(int[] array) {
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
        }
        return max;
    }

    public static boolean containsTheSameElements(int[] array1, int[] array2) {
        // Write your code here:
        for (int num : array1) {
            if (!contains(array2, num, array2.length)) {
                return false;
            }
            for (int num2 : array2) {
                if (!contains(array1, num2, array1.length)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean contains(int[] array, int value, int index) {
        for (int i = 0; i < index; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSorted(int[] array) {
        // Write your code here:
        int counter = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                counter++;
            }
        }
        if (counter == array.length - 1) {
            return true;
        }
        counter = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                counter++;
            }
        }
        if (counter == array.length - 1) {
            return true;
        } else {
            return false;
        }
    }

}
