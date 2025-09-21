package org.example;

import models.Sale;
import models.SaleSummary;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<Sale> salesStream = Stream.of(
            new Sale("Laptop", 1200.00, "2023-10-01", 101),
            new Sale("Smartphone", 800.00, "2023-10-02", 102),
            new Sale("Tablet", 300.00, "2023-10-03", 103),
            new Sale("Laptop", 1500.00, "2023-10-04", 103)
        );

//        salesAfterACertainDate(salesStream, "2023-10-01");
//        mapSalesToCorespondindProductName(salesStream);
//        System.out.println(calculateTotalSalesAmountOfAProduct(salesStream, "Laptop"));
//        sortSalesByAmount(salesStream);
//        getDistingCustomerIds(salesStream);
//        groupSalesByProductName(salesStream);
//        System.out.println(calculateSalesWithOverAmount(salesStream, 500.00));
//        getDistingCustomerIdsUsingParralStream(salesStream);
//        productNameAndTotalSalesAmount(salesStream);
        System.out.println(calculatreAverageSalesAmount(salesStream));
    }

    private static void salesAfterACertainDate(Stream<Sale> salesStream, String date) {
        salesStream
            .filter(sale -> sale.getSaleDate().compareTo(date) > 0)
            .forEach(sale -> System.out.println("Product: " + sale.getProductName() + ", Amount: " + sale.getSaleAmount()));

    }

    private static void mapSalesToCorespondindProductName(Stream<Sale> salesStream) {
        salesStream
            .collect(Collectors.toMap(Sale::getProductName, Sale::getSaleAmount, Double::sum))
            .forEach((productName, totalAmount) -> System.out.println("Product: " + productName + ", Total Amount: " + totalAmount));
    }

    private static double calculateTotalSalesAmountOfAProduct(Stream<Sale> salesStream, String productName) {
        return salesStream
            .filter(sale -> sale.getProductName().equals(productName))
            .mapToDouble(Sale::getSaleAmount)
            .sum();
    }

    private static void sortSalesByAmount(Stream<Sale> salesStream) {
        salesStream
            .sorted((s1, s2) -> Double.compare(s2.getSaleAmount(), s1.getSaleAmount()))
            .forEach(sale -> System.out.println("Product: " + sale.getProductName() + ", Amount: " + sale.getSaleAmount()));
    }

    private static void getDistingCustomerIds(Stream<Sale> salesStream) {
        salesStream
                .map(Sale::getCustomerId)
                .distinct()
                .forEach(customerId -> System.out.println("CustomerId: " + customerId));
    }

    private static void getDistingCustomerIdsUsingParralStream(Stream<Sale> salesStream) {
        salesStream
                .parallel()
                .map(Sale::getCustomerId)
                .distinct()
                .forEach(customerId -> System.out.println("CustomerId: " + customerId));
    }

    private static void groupSalesByProductName(Stream<Sale> salesStream) {
        salesStream
                .collect(Collectors.groupingBy(Sale::getProductName, Collectors.summingDouble(Sale::getSaleAmount)))
                .forEach((productName, totalAmount) -> System.out.println("Product: " + productName + ", Total Amount: " + totalAmount));
    }

    private static double calculateSalesWithOverAmount(Stream<Sale> salesStream, double amount) {
        return salesStream
                .filter(sale -> sale.getSaleAmount() > amount)
                .mapToDouble(Sale::getSaleAmount)
                .sum();
    }

    private static void productNameAndTotalSalesAmount(Stream<Sale> salesStream) {
        salesStream
                .collect(Collectors.groupingBy(Sale::getProductName, Collectors.summingDouble(Sale::getSaleAmount)))
                .entrySet()
                .stream()
                .map(entry -> new SaleSummary(entry.getKey(), entry.getValue()))
                .forEach(summary -> System.out.println("Product: " + summary.getProductName() + ", Total Sales Amount: " + summary.getTotalSalesAmount()));
    }

    private static double calculatreAverageSalesAmount(Stream<Sale> salesStream) {
        return salesStream
                .mapToDouble(Sale::getSaleAmount)
                .average()
                .orElse(0.0);
    }

}