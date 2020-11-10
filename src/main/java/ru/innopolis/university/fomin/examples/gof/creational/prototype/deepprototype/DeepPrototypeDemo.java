package ru.innopolis.university.fomin.examples.gof.creational.prototype.deepprototype;

public class DeepPrototypeDemo {
    public static void main(String[] args) {
        Registry registry = new Registry();
        Movie movie = (Movie) registry.cloneItem("Movie");
        movie.setTitle("Creation Patterns in Java");
        movie.setUrl("http://movie.com");
        System.out.println("======================");
        System.out.println(movie);
        System.out.println(movie.getRuntime());
        System.out.println(movie.getTitle());
        System.out.println(movie.getUrl());

        Movie anotherMovie = (Movie) registry.cloneItem("Movie");
        anotherMovie.setTitle("Gang of Four");
        System.out.println("======================");
        System.out.println(anotherMovie);
        System.out.println(anotherMovie.getRuntime());
        System.out.println(anotherMovie.getTitle());
        System.out.println(anotherMovie.getUrl());

        Book book = (Book) registry.cloneItem("Book");
        book.setTitle("Book in Java");
        book.setUrl("http://books.com");
        System.out.println("======================");
        System.out.println(book);
        System.out.println(book.getNumberOfPages());
        System.out.println(book.getTitle());
        System.out.println(book.getUrl());
    }
}
