package com.example.demo.controller;

import com.example.demo.modal.Book;
import com.example.demo.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("library")
public class LibraryController {

    private GreetingService greetingService;

    @Autowired
    public void setGreetingService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }


    @GetMapping("/getBookName")
    public String getBookName() {
        return "Hathpana";
    }

    @PostMapping("/saveBook")
    public Book saveBook(@RequestBody Book book) {
        Book newBook = new Book();
        newBook.setBookName(book.getBookName());
        newBook.setAuthor(book.getAuthor());
        return newBook;
    }

    @PutMapping("/updateBook")
    public Book updateBook(@RequestParam(value = "name") String name ,
                           @RequestParam(value = "author") String author) {
        Book newBook = new Book();
        newBook.setBookName(name);
        newBook.setAuthor(author);
        return newBook;
    }

    @DeleteMapping("/deleteBook/{name}")
    public String deleteBookByName(@PathVariable String name) {
        return name;
    }

}
