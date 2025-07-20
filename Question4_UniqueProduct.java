
import java.util.HashMap;// importing hasmap class

public class Question4_UniqueProduct {
    // first unique product mthod
    public static String firstUniqueProduct(String[] products) {
        try {
            if (products == null) {
                throw new IllegalArgumentException("product array must have values");
            } else if (products.length == 0) {
                return null;
            }
            // hasmap object
            HashMap<String, Integer> productCounts = new HashMap();
            for (String product : products) {
                if (product != null) {
                    productCounts.put(product, productCounts.getOrDefault(product, 0) + 1);
                }
            }
            // first product with countzero
            for (String product : products) {
                if (product != null && productCounts.get(product) == 1) {
                    return product;
                }
            }
            return null;// for no unique product
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    // main method
    public static void main(String[] args) {
        String[] test1 = { "Apple", "Computer", "Apple", "Bag" };
        System.out.println("test1= " + firstUniqueProduct(test1));

        String[] test2 = { "Apple", "Apple", "Bag", "Bag" };
        System.out.println("test2: " + firstUniqueProduct(test2));
    }

}
