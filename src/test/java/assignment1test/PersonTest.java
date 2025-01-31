package assignment1test;

import assignment1.Dog;
import assignment1.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    void testPersonCreationWithDog() {
        Dog dog = new Dog("Hanzo", 12);
        Person sajita = new Person("Sajita", 40, dog);
        assertEquals("Sajita", sajita.getName());
        assertEquals(40, sajita.getAge());
        assertTrue(sajita.getDog().isPresent());
        assertEquals(dog, sajita.getDog().get());
    }

    @Test
    void testPersonCreationWithoutDog() {
        Person parmod = new Person("Parmod", 30);
        assertEquals("Parmod", parmod.getName());
        assertEquals(30, parmod.getAge());
        assertFalse(parmod.getDog().isPresent());
    }

    @Test
    void testHasOldDogTrue() {
        Dog dog = new Dog("Hanzo", 12);
        Person sajita = new Person("Sajita", 40, dog);
        assertTrue(sajita.hasOldDog());
    }

    @Test
    void testHasOldDogFalse() {
        Dog dog = new Dog("Brody", 8);
        Person adit = new Person("Adit", 35, dog);
        assertFalse(adit.hasOldDog());
    }

    @Test
    void testHasOldDogNoDog() {
        Person parmod = new Person("Parmod", 30);
        assertFalse(parmod.hasOldDog());
    }

    @Test
    void testChangeDogsName() {
        Dog dog = new Dog("Brody", 6);
        Person adit = new Person("Adit", 40, dog);
        adit.changeDogsName("Saber");
        assertEquals("Saber", adit.getDog().get().getName());
    }

    @Test
    void testChangeDogsNameNoDog() {
        Person parmod = new Person("Parmod", 30);
        RuntimeException exception = assertThrows(RuntimeException.class, () -> parmod.changeDogsName("Brody"));
        assertEquals("Parmod does not own a dog!", exception.getMessage());
    }

    @Test
    void testPersonEquals() {
        Dog dog1 = new Dog("Brody", 3);
        Person person1 = new Person("Parmod", 30, dog1);
        Person person2 = new Person("Parmod", 30, dog1);
        Person person3 = new Person("Adit", 25);

        assertEquals(person1, person2);
        assertNotEquals(person1, person3);
    }
}
