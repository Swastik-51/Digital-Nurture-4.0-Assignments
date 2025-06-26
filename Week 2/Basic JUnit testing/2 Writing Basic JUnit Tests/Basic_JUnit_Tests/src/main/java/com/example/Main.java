package com.example;

public class Main {
    public static void main(String[] args) {
        MathUtils mu = new MathUtils();

        System.out.println("Square of 5: " + mu.square(5));
        System.out.println("Is 4 even? " + mu.isEven(4));
        System.out.println("Is 7 even? " + mu.isEven(7));
        System.out.println("Max of (10, 7): " + mu.max(10, 7));
        System.out.println("Max of (15, 20): " + mu.max(15, 20));
    }
}
