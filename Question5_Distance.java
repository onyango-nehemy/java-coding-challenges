
public class Question5_Distance {
    // findcloseMinnDistance

    public static int findClosestMinDistance(int[] arr) {
        try {
            if (arr == null || arr.length < 2) {
                throw new IllegalArgumentException("Array should betwo values");
            }
            // minimum value
            int minValue = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < minValue) {
                    minValue = arr[i];
                }
            }

            // minimum distance btwn consecutive minimus
            int previousIndex = -1;
            int minDistance = Integer.MAX_VALUE;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == minValue) {
                    if (previousIndex != -1) {
                        int distance = j- previousIndex;
                        if (distance < minDistance) {
                            minDistance = distance;
                        }
                    }
                    previousIndex = j;
                }
            }
            // minimum must appear atleast twice
            if (minDistance == Integer.MAX_VALUE) {
                throw new IllegalArgumentException("minimum vakue must appear atleast two times");
            }
            return minDistance;

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return -1;

        }
    }

    // main method
    public static void main(String[] args) {
        int[] test = { 1, 2, 3, 1, 4, 5, 2 };
        System.out.println("closest MINIMUM DISTANCE: " + findClosestMinDistance(test));
    }

}
