package com.zoo.Serivce;

import com.zoo.Repository.FeedingRepository;

public class FeedingService {
    private FeedingRepository feedingRepository;

    public FeedingService(FeedingRepository feedingRepository) {
        this.feedingRepository = feedingRepository;
    }

    public void feedAnimal(com.zoo.animals.Animal animal) {
        feedingRepository.feedAnimal(animal);
    }
}
