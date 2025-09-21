package org.example;


import com.zoo.Repository.FeedingRepository;
import com.zoo.animals.Animal;

public class Main {
    public static void main(String[] args) {

        com.zoo.Repository.FeedingRepository feedingRepository = new FeedingRepository();
        com.zoo.Serivce.FeedingService feedingService = new com.zoo.Serivce.FeedingService(feedingRepository);

        Animal lion = new com.zoo.animals.Lion();
        Animal elephant = new com.zoo.animals.Elephant();
        Animal unknownAnimal = new com.zoo.animals.UnknownAnimal();

//        System.out.println("Lion sound: " + lion.sound());
//        System.out.println("Elephant sound: " + elephant.sound());
//        System.out.println("Unknown Animal sound: " + unknownAnimal.sound());

        feedingService.feedAnimal(lion);
        feedingService.feedAnimal(elephant);
        feedingService.feedAnimal(unknownAnimal);
    }
}