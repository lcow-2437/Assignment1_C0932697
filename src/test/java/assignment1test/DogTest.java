package assignment1test;

import assignment1.Dog;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DogTest {

    @Test
    void testDogAttributes() {
        Dog dog = new Dog("Saber", 12);
        assertEquals("Saber", dog.getName());
        assertEquals(12, dog.getAge());
    }

    @Test
    void testDogEquality() {
        Dog dog1 = new Dog("Hanzo", 10);
        Dog dog2 = new Dog("Hanzo", 10);
        assertEquals(dog1, dog2);
    }

    @Test
    void testDogNotEquality() {
        Dog dog1 = new Dog("Hanzo", 10);
        Dog dog2 = new Dog("Saber", 12);
        assertNotEquals(dog1, dog2);  // This will pass since the two dogs are not equal
    }
}
