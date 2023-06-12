package com.example.springbootthymleaf.services;

import com.example.springbootthymleaf.entities.Livre;
import org.springframework.data.domain.Page;

import java.util.List;

public interface LivreServiceI {


    List<Livre> findAll();

    Livre getBookByIsbn(Long isbn);

    Livre addBook(Livre book);

    Livre updateBook(Livre book);

    void deleteBook(Long id);


}
