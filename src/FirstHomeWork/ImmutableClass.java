package FirstHomeWork;


public final class ImmutableClass {

    private final String name;
    private final Person person;

    public ImmutableClass(String name, Person person){
        this.name = name;
        this.person = new Person(person);
    }

    public String getName(){
        return name;
    }

    public Person getPerson() {
        return new Person(person);
    }
}
