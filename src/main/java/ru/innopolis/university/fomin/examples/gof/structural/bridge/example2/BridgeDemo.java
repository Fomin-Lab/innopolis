package ru.innopolis.university.fomin.examples.gof.structural.bridge.example2;

public class BridgeDemo {
    public static void main(String[] args) {
        Movie movie = new Movie();
        movie.setClassification("Action");
        movie.setTitle("John Wick");
        movie.setRuntime("2:15");
        movie.setYear("2015");

        Book book = new Book();
        book.setAuthor("Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides");
        book.setTitle("Design Patterns");
        book.setContPage("395");
        book.setYear("1994");

        Formatter printFormatter = new PrintFormatter();
        Printer moviePrinter = new MoviePrinter(movie);
        Printer bookPrinter = new BookPrinter(book);

        System.out.println(moviePrinter.print(printFormatter));
        System.out.println("================================");
        System.out.println(bookPrinter.print(printFormatter));
    }
}
