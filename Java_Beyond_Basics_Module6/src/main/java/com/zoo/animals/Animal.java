package com.zoo.animals;

public abstract sealed class Animal permits Lion, Elephant, UnknownAnimal {
    public abstract String sound();
}
