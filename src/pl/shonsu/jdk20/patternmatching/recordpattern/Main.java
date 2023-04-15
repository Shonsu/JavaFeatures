package pl.shonsu.jdk20.patternmatching.recordpattern;


import java.util.List;

class Main {
    public static void main(String[] args) {
        Object address = new Address("C", "S", 1);

        if(address instanceof Address(String c, String s, int n)){
            System.out.println( c + " " + s + " " + n);
        }

        Container c = new Container("Shonsu");

        var res = switch (c){
            case Container(String s) -> "string : %s".formatted(s);
            case Container(Integer i)  -> "Int %d".formatted(i);
            case Container(Object s)  -> "...";
        };
        System.out.println(res);


        Address address1 = new Address("City", "Street", 1);
        Contact contact = new Contact("Shonsu", "Bard", address1);

        if(contact instanceof Contact(var name, var surname, Address(var city, var street, var number))){
            System.out.println(name);
            System.out.println(street);
        }

        //Multi<String> multi = new Triple<>("A", "B","C");
        Multi<String> multi = new Tuple<>("A", "B");
        if(multi instanceof Tuple(var t1, var t2)){
            System.out.println((t1.toUpperCase()));
            System.out.println((t2.toUpperCase()));
        }else if(multi instanceof Triple(var t1, var t2, var t3)){
            System.out.println( (t1.strip()));
            System.out.println( (t2.toUpperCase()));
            System.out.println( (t3.toUpperCase()));
        }

        List<Point> points = List.of(
                new Point(2.,2.),
                new Point(2.,3.),
                new Point(1.,2.)
        );
        for(Point(Double x, Double y) : points){
            System.out.println(x + " " + y);
        }
    }

    private record Address(String city, String street, int number){}
    private record  Container(Object data){}
    record Contact(String name, String surname, Address address) {}

    private interface Multi<T>{
    }
    private record Tuple<T>(T t1, T t2) implements Multi<T>{}
    record Triple<T>(T t1, T t2, T t3) implements Multi<T>{}

    private record Point(Double x, Double y){}

}
