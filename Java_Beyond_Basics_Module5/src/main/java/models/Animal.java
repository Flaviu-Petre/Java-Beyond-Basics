package models;

public abstract sealed class Animal permits Lion, Elephant, UnknownAnimal {
    public abstract String sound();
}
