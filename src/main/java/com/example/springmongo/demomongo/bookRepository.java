package com.example.springmongo.demomongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;
import java.util.List;

public interface bookRepository extends MongoRepository<book,Integer> {
    public ArrayList<book> findByAuthorName(String name);

}
