package com.talhabayansar.baseapp.clients.services;

import com.talhabayansar.baseapp.clients.entities.Client;
import com.talhabayansar.baseapp.clients.entities.ClientDto;
import com.talhabayansar.baseapp.clients.repositories.ClientRepository;
import com.talhabayansar.baseapp.products.entities.Product;
import com.talhabayansar.baseapp.products.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientsServiceImpl implements ClientsService {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ProductRepository productRepository;

    public Iterable<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client findOne(Integer id) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        return optionalClient.orElse(null);
    }

    public Client create(ClientDto clientDto) {
        try {
            clientRepository.save(clientDto.toClient());
            return clientDto.toClient();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "The client couldn't be created.");
        }
    }

    public Client update(Integer id, ClientDto clientDto) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if(optionalClient.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "The client you tried to edit doesn't exist.");
        }
        try {
            Client client = clientDto.toClient();
            client.setId(id);
            Iterable<Product> iterableProducts = productRepository.findAllById(clientDto.getProductIds());
            List<Product> products = new ArrayList<>();
            iterableProducts.forEach(products::add);
            client.setProducts(products);
            clientRepository.save(client);
            return client;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Something went wrong when updating this client.");
        }
    }

    public Client remove(Integer id) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if(optionalClient.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "The client you tried to remove doesn't exist.");
        }
        try {
            Client client = optionalClient.get();
            clientRepository.delete(client);
            return client;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "This client couldn't be removed.");
        }
    }
}