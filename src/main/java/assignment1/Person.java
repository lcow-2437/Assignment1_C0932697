package assignment1;

import java.util.Objects;
import java.util.Optional;

public class Person {
    private String name;
    private Integer age;
    private Optional<Dog> dog;

    public Person(String name, Integer age) {
        this(name, age, null);
    }

    public Person(String name, Integer age, Dog dog) {
        this.name = name;
        this.age = age;
        this.dog = Optional.ofNullable(dog);
    }

    public boolean hasOldDog() {
        return dog.filter(d -> d.getAge() >= 10).isPresent();
    }

    public void changeDogsName(String newName) {
        dog.map(d -> {
            d.setName(newName);
            return d;
        }).orElseThrow(() -> new RuntimeException(this.name + " does not own a dog!"));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Optional<Dog> getDog() {
        return dog;
    }

    public void setDog(Optional<Dog> dog) {
        this.dog = dog;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(age, person.age) &&
                Objects.equals(dog, person.dog);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, dog);
    }
}
