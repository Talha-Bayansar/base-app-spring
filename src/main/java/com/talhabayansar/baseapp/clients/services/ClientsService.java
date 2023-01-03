package com.talhabayansar.baseapp.clients.services;

import com.talhabayansar.baseapp.clients.entities.Client;
import com.talhabayansar.baseapp.clients.entities.ClientDto;

public interface ClientsService {

    Iterable<Client> findAll();
    Client findOne(Integer id);
    Client create(ClientDto clientDto);
    Client update(Integer id, ClientDto clientDto);
    Client remove(Integer id);
}
