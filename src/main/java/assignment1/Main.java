package assignment1;

public class Main {
    public static void main(String[] args) {
        Person personWithoutDog = new Person("Parmod", 25);

        try {
            personWithoutDog.changeDogsName("Brody");
        } catch (RuntimeException e) {
            System.out.println("Unable to change dog's name: " + e.getMessage());
        }

        Dog dog = new Dog("Saber", 12);
        Person personWithDog = new Person("Sajita", 30, dog);
        personWithDog.changeDogsName("Hanzo");
        System.out.println("Dog's new name: " + personWithDog.getDog().get().getName());
    }
}