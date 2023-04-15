package pl.shonsu.jdk20.patternmatching.forinstanceof;

import java.util.Objects;

class Person {
    private String name;
    private String lastName;
    private int age;

    @Override
    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Person person = (Person) o;
//        return Objects.equals(name, person.name) &&
//                Objects.equals(lastName, person.lastName) &&
//                Objects.equals(age, person.age);
        return o instanceof Person p &&
                name.equals(p.name) &&
                lastName.equals(p.lastName)&&
                age == p.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, age);
    }
}
