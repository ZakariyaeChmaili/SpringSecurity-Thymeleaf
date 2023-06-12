package com.example.springbootthymleaf.services;

import com.example.springbootthymleaf.entities.Livre;
import com.example.springbootthymleaf.repositories.ILivreRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LivreServiceImp implements LivreServiceI {

    private final ILivreRepository livreRepository;

    public LivreServiceImp(ILivreRepository livreRepository) {
        this.livreRepository = livreRepository;
    }

    @Override
    public List<Livre> findAll() {
        return livreRepository.findAll();
    }

    @Override
    public Livre getBookByIsbn(Long isbn) {
        return livreRepository.findById(isbn).orElseThrow(() ->
                new RuntimeException("Livre not found with isbn: " + isbn));
    }

    @Override
    public Livre addBook(Livre book) {
        return livreRepository.save(book);
    }

    @Override
    public Livre updateBook(Livre book) {
        Livre livre1 = this.livreRepository.findById(book.getISBN()).orElse(null);
        if (livre1 != null) {
            livre1.setAuteur((book.getAuteur() != null) ? book.getAuteur() : livre1.getAuteur());
            livre1.setTitre((book.getTitre() != null) ? book.getTitre() : livre1.getTitre());
            livre1.setDate((book.getDate() != null) ? book.getDate() : livre1.getDate());
            livre1.setDomaine((book.getDomaine() != null) ? book.getDomaine() : livre1.getDomaine());
            livre1.setNbrExemplaire((book.getNbrExemplaire() != 0) ? book.getNbrExemplaire() : livre1.getNbrExemplaire());
        }
        return this.livreRepository.save(livre1);
    }

    @Override
    public void deleteBook(Long isbn) {
        livreRepository.deleteById(isbn);
    }


}
