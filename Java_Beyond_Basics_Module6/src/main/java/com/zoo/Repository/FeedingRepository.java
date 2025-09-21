package com.zoo.Repository;

import com.zoo.animals.Animal;

public class FeedingRepository {
    public void feedAnimal(Animal animal) {
        System.out.println("Feeding " + animal.getClass().getSimpleName() + " with its favorite food.");
    }
}
