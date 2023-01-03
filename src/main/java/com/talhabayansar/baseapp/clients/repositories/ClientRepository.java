package com.talhabayansar.baseapp.clients.repositories;

import com.talhabayansar.baseapp.clients.entities.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Integer> {

}
