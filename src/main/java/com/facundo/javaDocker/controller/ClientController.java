package com.facundo.javaDocker.controller;

import com.facundo.javaDocker.dto.ClientDTO;
import com.facundo.javaDocker.models.Client;
import com.facundo.javaDocker.service.ClientService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    ClientService clientService;
    @GetMapping("/clients")
    public Set<ClientDTO> getAllClients(){
        return clientService.getAllClients().stream().map(ClientDTO::new).collect(Collectors.toSet());
    }

    @GetMapping("/clients/{id}")
    public ClientDTO getClientById(@PathVariable Long id){
        return new ClientDTO(clientService.getClientById(id));
    }

    @DeleteMapping("/client")
    public ResponseEntity<Object> deleteCLientById(@RequestParam Long id, Authentication authentication){
        Client client = clientService.getClientById(id);
        Client clientAuht = clientService.findClietnByEmail(authentication.name());

        if(client==null){
            return new ResponseEntity<>("Client not found.", HttpStatus.FORBIDDEN);
        }
        if(clientAuht==null){
            return new ResponseEntity<>("You do not have permission to perform this action.", HttpStatus.FORBIDDEN);
        }

        clientService.deleteClient(client);
        return new ResponseEntity<>("The client has been deleted.", HttpStatus.ACCEPTED);

    }

    @PatchMapping("/client")
    public ResponseEntity<Object> modifyClientById(@RequestBody ClientDTO clientModifyDTO, Authentication authentication){
        Client clientAuht = clientService.findClietnByEmail(authentication.name());
        Client clientModify = clientService.findClietnByEmail(clientModifyDTO.getEmail());


        if (!clientModifyDTO.getEmail().contains("@") || clientModifyDTO.getEmail().equalsIgnoreCase("admin@admin")) {
            return new ResponseEntity<>("The email is incomplete or incorrect.", HttpStatus.BAD_REQUEST);
        }
        if (clientModifyDTO.getName().length() < 4 || clientModifyDTO.getLastName().length() < 3) {
            return new ResponseEntity<>("The name and/or last name do not meet the minimum characters.", HttpStatus.BAD_REQUEST);
        }

        if (clientModifyDTO.getDni()<100000) {
            return new ResponseEntity<>("The DNI is incorrect.", HttpStatus.BAD_REQUEST);
        }

        if(clientModifyDTO.getPassword().isEmpty()){
            return new ResponseEntity<>("The password is incomplete or incorrect.", HttpStatus.FORBIDDEN);
        }

        clientModify.setName(clientModifyDTO.getName());
        clientModify.setLastName(clientModifyDTO.getLastName());
        clientModify.setEmail(clientModifyDTO.getEmail());
        clientModify.setPassword(clientModifyDTO.getPassword());
        clientModify.setDni(clientModifyDTO.getDni());
        clientService.saveClient(clientModify);

        return new ResponseEntity<>("Los cambios han sido exitosos", HttpStatus.CREATED);
    }

    @PostMapping("/client")
    public ResponseEntity<Object> createNewClient(@RequestBody ClientDTO newClientDTO, Authentication authentication){
        Client clientAuht = clientService.findClietnByEmail(authentication.name());

        if (!newClientDTO.getEmail().contains("@") || newClientDTO.getEmail().equalsIgnoreCase("admin@admin")) {
            return new ResponseEntity<>("The email is incomplete or incorrect.", HttpStatus.BAD_REQUEST);
        }
        if (newClientDTO.getName().length() < 4 || newClientDTO.getName().isEmpty()) {
            return new ResponseEntity<>("The name do not meet the minimum characters.", HttpStatus.BAD_REQUEST);
        }
        if (newClientDTO.getLastName().isEmpty() || newClientDTO.getLastName().length() < 3) {
            return new ResponseEntity<>("The last name do not meet the minimum characters.", HttpStatus.BAD_REQUEST);
        }
        if (newClientDTO.getDni()<100000) {
            return new ResponseEntity<>("The DNI is incorrect.", HttpStatus.BAD_REQUEST);
        }
        if(newClientDTO.getPassword().isEmpty()){
            return new ResponseEntity<>("The password is incomplete or incorrect.", HttpStatus.FORBIDDEN);
        }
        Client client = new Client(newClientDTO.getName(), newClientDTO.getLastName(), newClientDTO.getPassword(), newClientDTO.getEmail(), newClientDTO.getDni());
        clientService.saveClient(client);
        return new ResponseEntity<>("The client has been created.", HttpStatus.ACCEPTED);
    }


}

