package com.jinxuliang.springspademo.controllers;

import com.jinxuliang.springspademo.model.Client;
import com.jinxuliang.springspademo.service.ClientErrorInfo;
import com.jinxuliang.springspademo.service.ClientNotFoundException;
import com.jinxuliang.springspademo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/client")
//允许跨域调用
@CrossOrigin(origins = "*")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("{client_id}")
    public ResponseEntity<?> findById(@PathVariable("client_id") int id) {
        try {
            var client = clientService.findById(id);
            return new ResponseEntity<Client>(client, HttpStatus.OK);
        } catch (ClientNotFoundException ex) {
            var info = ClientErrorInfo.builder()
                    .message(ex.getMessage())
                    .statusCode(HttpStatus.NOT_FOUND.value())
                    .build();
            return new ResponseEntity<>(info, HttpStatus.NOT_FOUND);
        }
    }
}
