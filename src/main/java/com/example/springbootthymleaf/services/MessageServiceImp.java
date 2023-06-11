package com.example.springbootthymleaf.services;

import com.example.springbootthymleaf.entities.Message;
import com.example.springbootthymleaf.repositories.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImp implements MessageServiceI{

    private final MessageRepository messageRepository;

    public MessageServiceImp(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public Message save(Message message) {
        return this.messageRepository.save(message);
    }

    @Override
    public List<Message> findAll() {
        return this.messageRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        this.messageRepository.deleteById(id);
    }

    @Override
    public Message findById(Long id) {
        return this.messageRepository.findById(id).orElse(null);
    }
}
