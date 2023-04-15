package pl.shonsu.jdk20.patternmatching.switchexpression;

class Main {
    public static void main(String[] args) {

        Object o = 12.2;
        String result = switch (o) {
            case Integer a -> "Int %d".formatted(a);
            case Double b -> "double %.2f".formatted(b);
            case String c -> c.toLowerCase();
            case Object ob -> "...";
        };

        System.out.println(result);

        Object obj = "estymata";
        result = switch (obj) {
            case Integer a -> "Int %d".formatted(a);
            case Double b -> "double %.2f".formatted(b);
            case String c when c.length() > 4 && c.startsWith("e")-> c.toLowerCase();
            case Object ob -> "...";
        };

        System.out.println(result);
    }
}
