package com.jinxuliang.springspademo.repository;

import com.jinxuliang.springspademo.model.Client;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {

    private final List<Client> clients = new ArrayList<>();
    //生成一些用于测试的记录
    {
        for (int i = 1; i <= 10; i++) {
            clients.add(Client.builder().id(i)
                    .name("Client" + i)
                    .build());
        }
    }

    public Optional<Client> findById(int id) {
        return clients.stream()
                .filter(c -> c.getId() == id).findAny();
    }
}
