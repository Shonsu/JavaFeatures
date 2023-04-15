package pl.shonsu.jdk20.patternmatching.forinstanceof;

public class Main {
    public static void main(String[] args) {

        printUpperIfString(34);
        printUpperIfString("stringi");
        printUpperIfStringWithNegation("String");
        printUpperIfStringStartWithA("Amajtek");
    }

    private static void printUpperIfString(Object o) {
        if (o instanceof String s) {
            System.out.println("Text: " + s.toUpperCase());
        }
    }

    private static void printUpperIfStringWithNegation(Object o) {
        if (!(o instanceof String s)) {
            return;
        }
        System.out.println(s.toUpperCase());
    }

    private static void printUpperIfStringStartWithA(Object o) {
        if (o instanceof String s && s.startsWith("A")) {
            System.out.println("Text: " + s.toUpperCase());
        }
    }
}