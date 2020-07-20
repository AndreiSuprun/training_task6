package com.suprun.bookstorage.controller;

import com.suprun.bookstorage.model.entity.Book;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

public class BookControllerTest {

    BookController bookController;

    @BeforeClass
    public void beforeClass() {
        bookController = new BookController();
    }

    @DataProvider
    public static Object[][] addBookProcessRequestNotContain() {
        return new Object[][]{{"Add_book", new HashMap<String, String>(){{put ("name", "Head First Design Patterns");
                put("authors", "Sierra Kathy, Bates Bert, Freeman Eric, Robson Elisabeth");
                put("publisher", "O'Reilly Media"); put("publishyear", "2004"); put("pagequantity", "694");}},
                new HashMap<String, Object>(){{ put("books", new ArrayList<>(){{
        add(new Book(1,"Head First Java", new ArrayList<String>(Arrays.asList("Sierra Kathy", "Bates Bert")),
                "O'Reilly Media", 2005, 688));
        add(new Book(2,"Java Concurrency in Practice", new ArrayList<String>(Arrays.asList("Goetz Brian")),
                "Addison-Wesley Professional", 2006, 424));
        add(new Book(3,"Effective Java", new ArrayList<String>(Arrays.asList("Bloch Joshua")),
                "Addison-Wesley Professional", 2017, 412));
        add(new Book(4,"Java: The Complete Reference", new ArrayList<String>(Arrays.asList("Schildt Herbert")),
                "McGraw-Hill Education", 2018, 1248));
        add(new Book(5,"Clean Code: A Handbook of Agile Software Craftsmanship",
                new ArrayList<String>(Arrays.asList("Martin Robert C.")), "Pearson", 2008, 464));
        add(new Book(6,"Java Generics and Collections",
                new ArrayList<String>(Arrays.asList("Naftalin Maurice", "Wadler Philip")), "O'Reilly Media",
                2006, 273));
        add(new Book(7,"Design Patterns: Elements of Reusable Object-Oriented Software",
                new ArrayList<String>(Arrays.asList("Gamma Erich", "Helm Richard", "Johnson Ralph", "Vlissides John")), "O'Reilly Media",
                1994, 416));
        add(new Book(8,"Mastering Lambdas: Java Programming in a Multicore World",
                new ArrayList<String>(Arrays.asList("Naftalin Maurice")), "Pearson", 2014, 208));
        add(new Book(9,"Grokking Algorithms: An illustrated guide for programmers and other curious people",
                new ArrayList<String>(Arrays.asList("Bhargava Aditya")), "Manning Publications", 2016, 256));
        add(new Book(10,"Soft Skills: The software developer's life manual",
                new ArrayList<String>(Arrays.asList("Sonmez John")), "Manning Publications", 2015, 504));
        add(new Book(11,"Head First Design Patterns",
                new ArrayList<String>(Arrays.asList("Sierra Kathy", "Bates Bert", "Freeman Eric", "Robson Elisabeth")),
                "O'Reilly Media", 2004, 694));}});}}}};
    }
    @Test(dataProvider = "addBookProcessRequestNotContain")
    public void testAddBookProcessRequestNotContain(String requestType, Map<String, String> request, Map<String, Object> expectedResult) {
        Map<String, Object> actual = bookController.processRequest(requestType, request);
        assertEquals(actual,expectedResult);
    }

    @DataProvider
    public static Object[][] addBookProcessRequestContain() {
        return new Object[][]{{"Add_book", new HashMap<String, String>(){{put ("name", "Head First Java");
            put("authors", "Sierra Kathy, Bates Bert");
            put("publisher", "O'Reilly Media"); put("publishyear", "2005"); put("pagequantity", "688");}},
                new HashMap<String, Object>(){{ put("exceptions", "Book is already in storage");}}}};
    }

    @Test(dataProvider = "addBookProcessRequestContain")
    public void testAddBookProcessRequestContain(String requestType, Map<String, String> request, Map<String, Object> expectedResult) {
        Map<String, Object> actual = bookController.processRequest(requestType, request);
        assertEquals(actual,expectedResult);
    }

    @DataProvider
    public static Object[][] removeBookProcessRequestContain() {
        return new Object[][]{{"Remove_book", new HashMap<String, String>(){{put ("name", "Head First Java");
            put("authors", "Sierra Kathy, Bates Bert"); put("publisher", "O'Reilly Media"); put("publishyear", "2005");
            put("pagequantity", "688");}},
                new HashMap<String, Object>(){{ put("books", new ArrayList<>(){{
                    add(new Book(2,"Java Concurrency in Practice", new ArrayList<String>(Arrays.asList("Goetz Brian")),
                            "Addison-Wesley Professional", 2006, 424));
                    add(new Book(3,"Effective Java", new ArrayList<String>(Arrays.asList("Bloch Joshua")),
                            "Addison-Wesley Professional", 2017, 412));
                    add(new Book(4,"Java: The Complete Reference", new ArrayList<String>(Arrays.asList("Schildt Herbert")),
                            "McGraw-Hill Education", 2018, 1248));
                    add(new Book(5,"Clean Code: A Handbook of Agile Software Craftsmanship",
                            new ArrayList<String>(Arrays.asList("Martin Robert C.")), "Pearson", 2008, 464));
                    add(new Book(6,"Java Generics and Collections",
                            new ArrayList<String>(Arrays.asList("Naftalin Maurice", "Wadler Philip")), "O'Reilly Media",
                            2006, 273));
                    add(new Book(7,"Design Patterns: Elements of Reusable Object-Oriented Software",
                            new ArrayList<String>(Arrays.asList("Gamma Erich", "Helm Richard", "Johnson Ralph", "Vlissides John")), "O'Reilly Media",
                            1994, 416));
                    add(new Book(8,"Mastering Lambdas: Java Programming in a Multicore World",
                            new ArrayList<String>(Arrays.asList("Naftalin Maurice")), "Pearson", 2014, 208));
                    add(new Book(9,"Grokking Algorithms: An illustrated guide for programmers and other curious people",
                            new ArrayList<String>(Arrays.asList("Bhargava Aditya")), "Manning Publications", 2016, 256));
                    add(new Book(10,"Soft Skills: The software developer's life manual",
                            new ArrayList<String>(Arrays.asList("Sonmez John")), "Manning Publications", 2015, 504));
                    add(new Book(11,"Head First Design Patterns",
                            new ArrayList<String>(Arrays.asList("Sierra Kathy", "Bates Bert", "Freeman Eric", "Robson Elisabeth")),
                            "O'Reilly Media", 2004, 694));}});}}}};
    }

    @Test(dataProvider = "removeBookProcessRequestContain")
    public void testRemoveBookProcessRequestContain(String requestType, Map<String, String> request, Map<String, Object> expectedResult) {
        Map<String, Object> actual = bookController.processRequest(requestType, request);
        assertEquals(actual,expectedResult);
    }

    @DataProvider
    public static Object[][] removeBookProcessRequestNotContain() {
        return new Object[][]{{"Remove_book", new HashMap<String, String>(){{put ("name", "Head First Design Pattern");
            put("authors", "Sierra Kathy, Bates Bert, Freeman Eric, Robson Elisabeth");
            put("publisher", "O'Reilly Media"); put("publishyear", "2004"); put("pagequantity", "694");}},
                new HashMap<String, Object>(){{ put("exceptions", "Removed book is not found in storage");}}}};
    }

    @Test(dataProvider = "removeBookProcessRequestNotContain")
    public void testRemoveBookProcessRequestNotContain(String requestType, Map<String, String> request, Map<String, Object> expectedResult) {
        Map<String, Object> actual = bookController.processRequest(requestType, request);
        assertEquals(actual,expectedResult);
    }

    @DataProvider
    public static Object[][] findByIdProcessRequest() {
        return new Object[][]{{"Find_by_id", new HashMap<String, String>(){{put ("id", "2");}},
                new HashMap<String, Object>(){{ put("books", new ArrayList<>(){{ add(new Book(2,
                        "Java Concurrency in Practice", new ArrayList<String>(Arrays.asList("Goetz Brian")),
                            "Addison-Wesley Professional", 2006, 424));}});}}}};
    }

    @Test(dataProvider = "findByIdProcessRequest")
    public void finByIdProcessRequest(String requestType, Map<String, String> request, Map<String, Object> expectedResult) {
        Map<String, Object> actual = bookController.processRequest(requestType, request);
        assertEquals(actual,expectedResult);
    }

    @DataProvider
    public static Object[][] findByNameProcessRequest() {
        return new Object[][]{{"Find_by_name", new HashMap<String, String>(){{put ("name", "Concurrency");}},
                new HashMap<String, Object>(){{ put("books", new ArrayList<>(){{ add(new Book(2,
                        "Java Concurrency in Practice", new ArrayList<String>(Arrays.asList("Goetz Brian")),
                        "Addison-Wesley Professional", 2006, 424));}});}}}};
    }

    @Test(dataProvider = "findByNameProcessRequest")
    public void finByNameProcessRequest(String requestType, Map<String, String> request, Map<String, Object> expectedResult) {
        Map<String, Object> actual = bookController.processRequest(requestType, request);
        assertEquals(actual,expectedResult);
    }

    @DataProvider
    public static Object[][] findByAuthorsProcessRequest() {
        return new Object[][]{{"Find_by_authors", new HashMap<String, String>(){{put ("authors", "Goetz Brian");}},
                new HashMap<String, Object>(){{ put("books", new ArrayList<>(){{ add(new Book(2,
                        "Java Concurrency in Practice", new ArrayList<String>(Arrays.asList("Goetz Brian")),
                        "Addison-Wesley Professional", 2006, 424));}});}}}};
    }

    @Test(dataProvider = "findByAuthorsProcessRequest")
    public void finByAuthorsProcessRequest(String requestType, Map<String, String> request, Map<String, Object> expectedResult) {
        Map<String, Object> actual = bookController.processRequest(requestType, request);
        assertEquals(actual,expectedResult);
    }

    @DataProvider
    public static Object[][] findByPublisherProcessRequest() {
        return new Object[][]{{"Find_by_publisher", new HashMap<String, String>(){{put ("publisher", "O'Reilly Media");}},
                new HashMap<String, Object>(){{ put("books", new ArrayList<>(){{
                    add(new Book(1,"Head First Java", new ArrayList<String>(Arrays.asList("Sierra Kathy", "Bates Bert")),
                            "O'Reilly Media", 2005, 688));
                    add(new Book(6,"Java Generics and Collections",
                            new ArrayList<String>(Arrays.asList("Naftalin Maurice", "Wadler Philip")), "O'Reilly Media",
                            2006, 273));
                    add(new Book(7,"Design Patterns: Elements of Reusable Object-Oriented Software",
                            new ArrayList<String>(Arrays.asList("Gamma Erich", "Helm Richard", "Johnson Ralph", "Vlissides John")), "O'Reilly Media",
                            1994, 416));}});}}}};
    }

    @Test(dataProvider = "findByPublisherProcessRequest")
    public void finByPublisherProcessRequest(String requestType, Map<String, String> request, Map<String, Object> expectedResult) {
        Map<String, Object> actual = bookController.processRequest(requestType, request);
        assertEquals(actual,expectedResult);
    }

    @DataProvider
    public static Object[][] findByPublishYearProcessRequest() {
        return new Object[][]{{"Find_by_publish_year", new HashMap<String, String>(){{put ("publishyear", "2015");}},
                new HashMap<String, Object>(){{ put("books", new ArrayList<>(){{ add(new Book(10,"Soft Skills: The software developer's life manual",
                        new ArrayList<String>(Arrays.asList("Sonmez John")), "Manning Publications", 2015, 504));}});}}}};
    }

    @Test(dataProvider = "findByPublishYearProcessRequest")
    public void finByPublishYearProcessRequest(String requestType, Map<String, String> request, Map<String, Object> expectedResult) {
        Map<String, Object> actual = bookController.processRequest(requestType, request);
        assertEquals(actual,expectedResult);
    }

    @DataProvider
    public static Object[][] findByPageQuantityProcessRequest() {
        return new Object[][]{{"Find_by_page_quantity", new HashMap<String, String>(){{put ("pagequantity", "200");}},
                new HashMap<String, Object>(){{ put("books", new ArrayList<Book>());}}}};
    }

    @Test(dataProvider = "findByPageQuantityProcessRequest")
    public void finByPageQuantityProcessRequest(String requestType, Map<String, String> request, Map<String, Object> expectedResult) {
        Map<String, Object> actual = bookController.processRequest(requestType, request);
        assertEquals(actual,expectedResult);
    }

    @DataProvider
    public static Object[][] sortByIdProcessRequest() {
        return new Object[][]{{"sort_by_id", new HashMap<String, String>(){{put ("descending", "false");}},
                new HashMap<String, Object>(){{ put("books", new ArrayList<>(){{
                    add(new Book(1,"Head First Java", new ArrayList<String>(Arrays.asList("Sierra Kathy", "Bates Bert")),
                            "O'Reilly Media", 2005, 688));
                    add(new Book(2,"Java Concurrency in Practice", new ArrayList<String>(Arrays.asList("Goetz Brian")),
                            "Addison-Wesley Professional", 2006, 424));
                    add(new Book(3,"Effective Java", new ArrayList<String>(Arrays.asList("Bloch Joshua")),
                            "Addison-Wesley Professional", 2017, 412));
                    add(new Book(4,"Java: The Complete Reference", new ArrayList<String>(Arrays.asList("Schildt Herbert")),
                            "McGraw-Hill Education", 2018, 1248));
                    add(new Book(5,"Clean Code: A Handbook of Agile Software Craftsmanship",
                            new ArrayList<String>(Arrays.asList("Martin Robert C.")), "Pearson", 2008, 464));
                    add(new Book(6,"Java Generics and Collections",
                            new ArrayList<String>(Arrays.asList("Naftalin Maurice", "Wadler Philip")), "O'Reilly Media",
                            2006, 273));
                    add(new Book(7,"Design Patterns: Elements of Reusable Object-Oriented Software",
                            new ArrayList<String>(Arrays.asList("Gamma Erich", "Helm Richard", "Johnson Ralph", "Vlissides John")), "O'Reilly Media",
                            1994, 416));
                    add(new Book(8,"Mastering Lambdas: Java Programming in a Multicore World",
                            new ArrayList<String>(Arrays.asList("Naftalin Maurice")), "Pearson", 2014, 208));
                    add(new Book(9,"Grokking Algorithms: An illustrated guide for programmers and other curious people",
                            new ArrayList<String>(Arrays.asList("Bhargava Aditya")), "Manning Publications", 2016, 256));
                    add(new Book(10,"Soft Skills: The software developer's life manual",
                            new ArrayList<String>(Arrays.asList("Sonmez John")), "Manning Publications", 2015, 504));}});}}}};
    }
    @Test(dataProvider = "sortByIdProcessRequest")
    public void sortByIdProcessRequest(String requestType, Map<String, String> request, Map<String, Object> expectedResult) {
        Map<String, Object> actual = bookController.processRequest(requestType, request);
        assertEquals(actual,expectedResult);
    }

    @DataProvider
    public static Object[][] sortByNameProcessRequest() {
        return new Object[][]{{"sort_by_name", new HashMap<String, String>(){{put ("descending", "false");}},
                new HashMap<String, Object>(){{ put("books", new ArrayList<>(){{
                    add(new Book(5,"Clean Code: A Handbook of Agile Software Craftsmanship",
                            new ArrayList<String>(Arrays.asList("Martin Robert C.")), "Pearson", 2008, 464));
                    add(new Book(7,"Design Patterns: Elements of Reusable Object-Oriented Software",
                            new ArrayList<String>(Arrays.asList("Gamma Erich", "Helm Richard", "Johnson Ralph", "Vlissides John")), "O'Reilly Media",
                            1994, 416));
                    add(new Book(3,"Effective Java", new ArrayList<String>(Arrays.asList("Bloch Joshua")),
                            "Addison-Wesley Professional", 2017, 412));
                    add(new Book(9,"Grokking Algorithms: An illustrated guide for programmers and other curious people",
                            new ArrayList<String>(Arrays.asList("Bhargava Aditya")), "Manning Publications", 2016, 256));
                    add(new Book(1,"Head First Java", new ArrayList<String>(Arrays.asList("Sierra Kathy", "Bates Bert")),
                            "O'Reilly Media", 2005, 688));
                    add(new Book(2,"Java Concurrency in Practice", new ArrayList<String>(Arrays.asList("Goetz Brian")),
                            "Addison-Wesley Professional", 2006, 424));
                    add(new Book(6,"Java Generics and Collections",
                            new ArrayList<String>(Arrays.asList("Naftalin Maurice", "Wadler Philip")), "O'Reilly Media",
                            2006, 273));
                    add(new Book(4,"Java: The Complete Reference", new ArrayList<String>(Arrays.asList("Schildt Herbert")),
                            "McGraw-Hill Education", 2018, 1248));
                    add(new Book(8,"Mastering Lambdas: Java Programming in a Multicore World",
                            new ArrayList<String>(Arrays.asList("Naftalin Maurice")), "Pearson", 2014, 208));
                    add(new Book(10,"Soft Skills: The software developer's life manual",
                            new ArrayList<String>(Arrays.asList("Sonmez John")), "Manning Publications", 2015, 504));}});}}}};
    }

    @Test(dataProvider = "sortByNameProcessRequest")
    public void sortByNameProcessRequest(String requestType, Map<String, String> request, Map<String, Object> expectedResult) {
        Map<String, Object> actual = bookController.processRequest(requestType, request);
        assertEquals(actual,expectedResult);
    }

    @DataProvider
    public static Object[][] sortByAuthorsProcessRequest() {
        return new Object[][]{{"sort_by_authors", new HashMap<String, String>(){{put ("descending", "false");}},
                new HashMap<String, Object>(){{ put("books", new ArrayList<>(){{
                    add(new Book(1,"Head First Java", new ArrayList<String>(Arrays.asList("Sierra Kathy", "Bates Bert")),
                            "O'Reilly Media", 2005, 688));
                    add(new Book(9,"Grokking Algorithms: An illustrated guide for programmers and other curious people",
                            new ArrayList<String>(Arrays.asList("Bhargava Aditya")), "Manning Publications", 2016, 256));
                    add(new Book(3,"Effective Java", new ArrayList<String>(Arrays.asList("Bloch Joshua")),
                            "Addison-Wesley Professional", 2017, 412));
                    add(new Book(7,"Design Patterns: Elements of Reusable Object-Oriented Software",
                            new ArrayList<String>(Arrays.asList("Gamma Erich", "Helm Richard", "Johnson Ralph", "Vlissides John")), "O'Reilly Media",
                            1994, 416));
                    add(new Book(2,"Java Concurrency in Practice", new ArrayList<String>(Arrays.asList("Goetz Brian")),
                            "Addison-Wesley Professional", 2006, 424));
                    add(new Book(5,"Clean Code: A Handbook of Agile Software Craftsmanship",
                            new ArrayList<String>(Arrays.asList("Martin Robert C.")), "Pearson", 2008, 464));
                    add(new Book(6,"Java Generics and Collections",
                            new ArrayList<String>(Arrays.asList("Naftalin Maurice", "Wadler Philip")), "O'Reilly Media",
                            2006, 273));
                    add(new Book(8,"Mastering Lambdas: Java Programming in a Multicore World",
                            new ArrayList<String>(Arrays.asList("Naftalin Maurice")), "Pearson", 2014, 208));
                    add(new Book(4,"Java: The Complete Reference", new ArrayList<String>(Arrays.asList("Schildt Herbert")),
                            "McGraw-Hill Education", 2018, 1248));
                    add(new Book(10,"Soft Skills: The software developer's life manual",
                            new ArrayList<String>(Arrays.asList("Sonmez John")), "Manning Publications", 2015, 504));}});}}}};
    }
    @Test(dataProvider = "sortByAuthorsProcessRequest")
    public void sortByAuthorsProcessRequest(String requestType, Map<String, String> request, Map<String, Object> expectedResult) {
        Map<String, Object> actual = bookController.processRequest(requestType, request);
        assertEquals(actual,expectedResult);
    }

    @DataProvider
    public static Object[][] sortByPublisherProcessRequest() {
        return new Object[][]{{"sort_by_publisher", new HashMap<String, String>(){{put ("descending", "false");}},
                new HashMap<String, Object>(){{ put("books", new ArrayList<>(){{
                    add(new Book(2,"Java Concurrency in Practice", new ArrayList<String>(Arrays.asList("Goetz Brian")),
                            "Addison-Wesley Professional", 2006, 424));
                    add(new Book(3,"Effective Java", new ArrayList<String>(Arrays.asList("Bloch Joshua")),
                            "Addison-Wesley Professional", 2017, 412));
                    add(new Book(9,"Grokking Algorithms: An illustrated guide for programmers and other curious people",
                            new ArrayList<String>(Arrays.asList("Bhargava Aditya")), "Manning Publications", 2016, 256));
                    add(new Book(10,"Soft Skills: The software developer's life manual",
                            new ArrayList<String>(Arrays.asList("Sonmez John")), "Manning Publications", 2015, 504));
                    add(new Book(4,"Java: The Complete Reference", new ArrayList<String>(Arrays.asList("Schildt Herbert")),
                            "McGraw-Hill Education", 2018, 1248));
                    add(new Book(1,"Head First Java", new ArrayList<String>(Arrays.asList("Sierra Kathy", "Bates Bert")),
                            "O'Reilly Media", 2005, 688));
                    add(new Book(6,"Java Generics and Collections",
                            new ArrayList<String>(Arrays.asList("Naftalin Maurice", "Wadler Philip")), "O'Reilly Media",
                            2006, 273));
                    add(new Book(7,"Design Patterns: Elements of Reusable Object-Oriented Software",
                            new ArrayList<String>(Arrays.asList("Gamma Erich", "Helm Richard", "Johnson Ralph", "Vlissides John")), "O'Reilly Media",
                            1994, 416));
                    add(new Book(5,"Clean Code: A Handbook of Agile Software Craftsmanship",
                            new ArrayList<String>(Arrays.asList("Martin Robert C.")), "Pearson", 2008, 464));
                    add(new Book(8,"Mastering Lambdas: Java Programming in a Multicore World",
                            new ArrayList<String>(Arrays.asList("Naftalin Maurice")), "Pearson", 2014, 208));}});}}}};
    }

    @Test(dataProvider = "sortByPublisherProcessRequest")
    public void sortByPublisherProcessRequest(String requestType, Map<String, String> request, Map<String, Object> expectedResult) {
        Map<String, Object> actual = bookController.processRequest(requestType, request);
        assertEquals(actual,expectedResult);
    }

    @DataProvider
    public static Object[][] sortByPublishYearProcessRequest() {
        return new Object[][]{{"sort_by_publish_year", new HashMap<String, String>(){{put ("descending", "false");}},
                new HashMap<String, Object>(){{ put("books", new ArrayList<>(){{
                    add(new Book(7,"Design Patterns: Elements of Reusable Object-Oriented Software",
                            new ArrayList<String>(Arrays.asList( "Gamma Erich", "Helm Richard", "Johnson Ralph", "Vlissides John")), "O'Reilly Media",
                            1994, 416));
                    add(new Book(1,"Head First Java", new ArrayList<String>(Arrays.asList("Sierra Kathy", "Bates Bert")),
                            "O'Reilly Media", 2005, 688));
                    add(new Book(2,"Java Concurrency in Practice", new ArrayList<String>(Arrays.asList("Goetz Brian")),
                            "Addison-Wesley Professional", 2006, 424));
                    add(new Book(6,"Java Generics and Collections",
                            new ArrayList<String>(Arrays.asList("Naftalin Maurice", "Wadler Philip")), "O'Reilly Media",
                            2006, 273));
                    add(new Book(5,"Clean Code: A Handbook of Agile Software Craftsmanship",
                            new ArrayList<String>(Arrays.asList("Martin Robert C.")), "Pearson", 2008, 464));
                    add(new Book(8,"Mastering Lambdas: Java Programming in a Multicore World",
                            new ArrayList<String>(Arrays.asList("Naftalin Maurice")), "Pearson", 2014, 208));
                    add(new Book(10,"Soft Skills: The software developer's life manual",
                            new ArrayList<String>(Arrays.asList("Sonmez John")), "Manning Publications", 2015, 504));
                    add(new Book(9,"Grokking Algorithms: An illustrated guide for programmers and other curious people",
                            new ArrayList<String>(Arrays.asList("Bhargava Aditya")), "Manning Publications", 2016, 256));
                    add(new Book(3,"Effective Java", new ArrayList<String>(Arrays.asList("Bloch Joshua")),
                            "Addison-Wesley Professional", 2017, 412));
                    add(new Book(4,"Java: The Complete Reference", new ArrayList<String>(Arrays.asList("Schildt Herbert")),
                            "McGraw-Hill Education", 2018, 1248));}});}}}};
    }

    @Test(dataProvider = "sortByPublishYearProcessRequest")
    public void sortByPublishYearProcessRequest(String requestType, Map<String, String> request, Map<String, Object> expectedResult) {
        Map<String, Object> actual = bookController.processRequest(requestType, request);
        assertEquals(actual,expectedResult);
    }

    @DataProvider
    public static Object[][] sortByPageQuantityProcessRequest() {
        return new Object[][]{{"sort_by_page_quantity", new HashMap<String, String>(){{put ("descending", "false");}},
                new HashMap<String, Object>(){{ put("books", new ArrayList<>(){{
                    add(new Book(8,"Mastering Lambdas: Java Programming in a Multicore World",
                            new ArrayList<String>(Arrays.asList("Naftalin Maurice")), "Pearson", 2014, 208));
                    add(new Book(9,"Grokking Algorithms: An illustrated guide for programmers and other curious people",
                            new ArrayList<String>(Arrays.asList("Bhargava Aditya")), "Manning Publications", 2016, 256));
                    add(new Book(6,"Java Generics and Collections",
                            new ArrayList<String>(Arrays.asList("Naftalin Maurice", "Wadler Philip")), "O'Reilly Media",
                            2006, 273));
                    add(new Book(3,"Effective Java", new ArrayList<String>(Arrays.asList("Bloch Joshua")),
                            "Addison-Wesley Professional", 2017, 412));
                    add(new Book(7,"Design Patterns: Elements of Reusable Object-Oriented Software",
                            new ArrayList<String>(Arrays.asList( "Gamma Erich", "Helm Richard", "Johnson Ralph", "Vlissides John")), "O'Reilly Media",
                            1994, 416));
                    add(new Book(2,"Java Concurrency in Practice", new ArrayList<String>(Arrays.asList("Goetz Brian")),
                            "Addison-Wesley Professional", 2006, 424));
                    add(new Book(5,"Clean Code: A Handbook of Agile Software Craftsmanship",
                            new ArrayList<String>(Arrays.asList("Martin Robert C.")), "Pearson", 2008, 464));
                    add(new Book(10,"Soft Skills: The software developer's life manual",
                            new ArrayList<String>(Arrays.asList("Sonmez John")), "Manning Publications", 2015, 504));
                    add(new Book(1,"Head First Java", new ArrayList<String>(Arrays.asList("Sierra Kathy", "Bates Bert")),
                            "O'Reilly Media", 2005, 688));
                    add(new Book(4,"Java: The Complete Reference", new ArrayList<String>(Arrays.asList("Schildt Herbert")),
                            "McGraw-Hill Education", 2018, 1248));}});}}}};
    }

    @Test(dataProvider = "sortByPageQuantityProcessRequest")
    public void sortByPageQuantityProcessRequest(String requestType, Map<String, String> request, Map<String, Object> expectedResult) {
        Map<String, Object> actual = bookController.processRequest(requestType, request);
        assertEquals(actual,expectedResult);
    }
}