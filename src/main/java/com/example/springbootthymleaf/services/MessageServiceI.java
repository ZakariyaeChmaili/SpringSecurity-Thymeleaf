package com.example.springbootthymleaf.services;

import com.example.springbootthymleaf.entities.Message;

import java.util.List;

public interface MessageServiceI {

    Message save(Message message);
    List<Message> findAll();

    void deleteById(Long id);
    Message findById(Long id);



}
