public class Question2_SumCombination {

public static int countUniqueWays(int result, int[] array) {
    try
    {
        if (array == null) {
            throw new IllegalArgumentException("Array cant be null");
        } else if (array.length == 0) {
            return result == 0 ? 1 : 0; // ternary operation in use
        }
        // recursive function
        return countWays(array, 0, result);
    }catch(
    IllegalArgumentException e)
    {
        System.out.println("Errors: " + e.getMessage());
        return 0;
    }
    }
    // let us implement the recursive function now

    private static int countWays(int[] array, int index, int target) {
        // base cases
        if (target == 0) {
            return 1;// this for correct combination
        } else if (target < 0 || index >= array.length) {
            return 0;// invalid combination
        }
        // below code either include or skip current number
        int includeNumber = countWays(array, index + 1, target - array[index]);
        int excludeNumber = countWays(array, index + 1, target);
        return includeNumber + excludeNumber;
    }

    // now lets go to main method
    public static void main(String[] args) {
        int result = 10;
        int[] array = { 1, 2, 3, 4, 5 };
        System.out.println("Number of ways: " + countUniqueWays(result, array));

    }

}
