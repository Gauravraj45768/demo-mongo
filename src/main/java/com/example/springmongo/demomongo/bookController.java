package com.example.springmongo.demomongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class bookController {
    @Autowired
    bookRepository bookRepo;
    @GetMapping("/getBooks")
    public ArrayList<book> getBook(){
        return (ArrayList<book>) bookRepo.findAll();
    }
    @PostMapping("/insertBook")
    public void insertBook(@RequestBody CreateRequest request){
      book book1=new book(request.getName(), request.getAuthorName(), request.getCost());
      bookRepo.save(book1);
    }
    //http://localhost:8080/bookByAuthor?name=soham
    @GetMapping("/bookByAuthor")
    public ArrayList<book> getBookByAuthorName(@RequestParam(value="name") String name){
        return bookRepo.findByAuthorName(name);
    }
}
