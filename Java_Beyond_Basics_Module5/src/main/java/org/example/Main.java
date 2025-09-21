package org.example;

import Repository.ProductRepository;
import Service.ProductServiceImpl;
import models.Person;
import models.Product;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) {

        ProductRepository productRepository = new ProductRepository();
        ProductServiceImpl productService = new ProductServiceImpl(productRepository);

        List<Person> persons = List.of(
            new models.Person("Alice", Optional.of(30), "alice@gamil.com"),
            new models.Person("Bob", Optional.empty(), "bob@gmail.com"),
            new models.Person("Charlie", Optional.of(30), "charlie@gmail.com"),
            new models.Person("Diana", Optional.of(30), "diana@gmail.com")
        );

//        Optional<Person> oldestPerson = getOldestPerson(persons);
//        oldestPerson.ifPresent(person ->
//            System.out.println("Oldest person: " + person.name() + ", Age: " + person.age().orElse(-1))
//        );

//        String personsJson = createPersonsJson(persons);
//        System.out.println("Persons JSON:\n" + personsJson);

        List<Product> products = List.of(
            new Product("Laptop", 999.99, 5),
            new Product("Smartphone", 1199.49, 10),
            new Product("Tablet", 299.99, 7)
        );

        System.out.println(productService.getTotalValue(products));

        Optional<Product> mostExpensiveProduct = productService.getMostExpensiveProduct(products);

        System.out.println(mostExpensiveProduct.isPresent()
            ? mostExpensiveProduct.get().name()
            : "No products available");
    }

    private static Optional<Person> getOldestPerson(List<Person> persons) {
        return persons.stream()
                .filter(p -> p.age().isPresent())
                .max(Comparator.comparing(p -> p.age().get()));
    }

    private static String createPersonsJson(List<Person> persons) {
        if (persons.isEmpty()) {
            return "[]";
        }

        StringJoiner joiner = new StringJoiner(",\n  ", "", "");

        for (Person person : persons) {
            String personJson = createSinglePersonJson(person);
            joiner.add(personJson);
        }

        return """
               [
                 %s
               ]""".formatted(joiner.toString());
    }

    private static String createSinglePersonJson(Person person) {
        String ageValue = person.age().isPresent()
                ? String.valueOf(person.age().get())
                : "null";

        return """
               {
                   "name": "%s",
                   "age": %s,
                   "email": "%s"
                 }""".formatted(
                escapeJsonString(person.name()),
                ageValue,
                escapeJsonString(person.email())
        );
    }

    private static Object escapeJsonString(String name) {
        return name.replace("\"", "\\\"");
    }
}