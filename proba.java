import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class proba {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // input words stored in array and splited 
        String[] wordtext = sc.nextLine().split(" ");
        // collection of the words given to store in Hash Table by converting Arrays to list for HashSet to accept. 
        HashSet<String> noDupWords = new HashSet<>(Arrays.asList(wordtext));
        // use the conditional operator to check if words length doesn't exceed with no duplicates true yes, otherwise no.
        System.out.println(wordtext.length == noDupWords.size() ? "yes" : "no");
        sc.close();
    }
}