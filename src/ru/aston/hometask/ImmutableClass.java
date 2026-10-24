package ru.aston.hometask;


import java.util.Objects;

public final class ImmutableClass {

    private final String name;
    private final Person person;

    public ImmutableClass(String name, Person person){
        this.name = Objects.requireNonNull(name, "name must not be null");
        this.person = new Person(Objects.requireNonNull(person, "person must not be null"));
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ImmutableClass that = (ImmutableClass) o;
        return Objects.equals(name, that.name) && Objects.equals(person, that.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, person);
    }

    public String getName(){
        return name;
    }

    public Person getPerson() {
        return new Person(person);
    }
}
