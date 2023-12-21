package com.jinxuliang.springspademo.service;

import com.jinxuliang.springspademo.model.Client;
import com.jinxuliang.springspademo.repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {
    //注入Repository
    private ClientRepository repository = null;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.repository = clientRepository;
    }

    public Client findById(int id) {
        var client= repository.findById(id);
        if(client.isPresent()){
            return client.get();
        }
        throw new ClientNotFoundException("指定id的Client记录没有找到");
    }
}
