
import java.util.*;

public class Question6_CommonWords {
    public static String[] threeMostCommonWords(String sentence) {
        String[] words = sentence.split("\\s+");
        if (words.length == 0) {
            return new String[0];
        }

        // count word frequencies using Hsmap
        HashMap<String, Integer> wordCount = new HashMap();
        for (String word : words) {
            if (!word.isEmpty()) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);

            }
        }
        // array to store words and freq
        String[] wordArray = new String[wordCount.size()];
        int[] frequencyArray = new int[wordCount.size()];
        int index = 0;
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            wordArray[index] = entry.getKey();
            frequencyArray[index] = entry.getValue();
            index++;
        }
        // top3 freq
        String[] result = new String[Math.min(3, wordArray.length)];
        int resultIndex = 0;

        for (int k = 0; k < Math.min(3, wordArray.length); k++) {
            int maxFreq = -1;
            int maxIndex = -1;
            String maxWord = null;

            for (int i = 0; i < wordArray.length; i++) {
                if (frequencyArray[i] > maxFreq) {
                    maxFreq = frequencyArray[i];
                    maxIndex = i;
                    maxWord = wordArray[i];
                } else if (frequencyArray[i] == maxFreq && maxWord != null && wordArray[i].compareTo(maxWord) < 0) {
                    maxWord = wordArray[i];
                    maxIndex = i;
                }
            }

            if (maxIndex != -1) {
                result[resultIndex++] = maxWord;
                frequencyArray[maxIndex] = -1;
            }

        }
        Arrays.sort(result, 0, resultIndex);
        return result;
    }

    public static void main(String[] args) {
        String text = "hi there care to discuss algorithms basis or how to solve algorithm or";

        System.out.println("testing: " + Arrays.toString(threeMostCommonWords(text)));
    }

}
