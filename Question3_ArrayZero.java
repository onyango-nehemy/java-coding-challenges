
public class Question3_ArrayZero {
    // canMakeZero function
    public static int canMakeZero(int[] a) {
        try {
            if (a == null || a.length == 0) {
                throw new IllegalArgumentException(" arry not allowed to be null or empty");
            } else if (a.length == 1) {
                return 1;
            }
            // lets create a copy of new array from the original
            int[] arr = new int[a.length];
            for (int i = 0; i < a.length; i++) {
                arr[i] = a[i];
            }
            // now lets work backwards to make array zero

            for (int j = arr.length - 1; j >= 1; j--) {
                while (arr[j] > 0) {
                    if (arr[j] < arr[j - 1]) {
                        return 0;
                    } else {
                        arr[j] = arr[j] - arr[j - 1];
                    }
                }
                if (arr[j] < 0) {
                    return 0;
                }

            }
            return 1;// correct result
        } catch (IllegalArgumentException e) {
            System.out.println("Errors: " + e.getMessage());
            return 0;
        }

    }

    // now main method
    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 3 };
        System.out.println("can make zero: " + canMakeZero(arr1));
    }

}

// this program is very challenging , the backward logic is difficult ,
// adjusting it is a prfoblem to me
