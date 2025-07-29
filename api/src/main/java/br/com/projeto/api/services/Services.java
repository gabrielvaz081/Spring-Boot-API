package br.com.projeto.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.projeto.api.models.Messages;
import br.com.projeto.api.models.Persons;
import br.com.projeto.api.storages.Storages;

@Service
public class Services {
    
    @Autowired
    private Messages message;

    @Autowired
    private Storages action;

    public ResponseEntity<?> register(Persons obj) {

        if(obj.getName().equals("")) {
            message.setMessage("The name needs to be filled in");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        } else if(obj.getAge() < 0) {
            message.setMessage("Enter a valid age");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(action.save(obj), HttpStatus.CREATED);
        }

    }

    public ResponseEntity<?> select() {
        return new ResponseEntity<>(action.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> selectByCode(int code) {

        if(action.countByCode(code) == 0) {
            message.setMessage("No person was found");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(action.findByCode(code), HttpStatus.OK);
        }

    }
    
    public ResponseEntity<?> selectByName(String name) {

        if(action.countByName(name) == 0) {
            message.setMessage("No person was found");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(action.findByName(name), HttpStatus.OK);
        }

    }

    public ResponseEntity<?> selectByAge(int age) {

        if(action.countByAge(age) == 0) {
            message.setMessage("No person was found");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(action.findByAge(age), HttpStatus.OK);
        }

    }

    public ResponseEntity<?> edit(Persons obj) {
        
        if(action.countByCode(obj.getCode()) == 0) {
            message.setMessage("The code provided does not exist");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        } else if(obj.getName().equals("")) {
            message.setMessage("A name is required");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        } else if(obj.getAge() < 0) {
            message.setMessage("Enter a valid age");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(action.save(obj), HttpStatus.OK);
        }

    }

    public ResponseEntity<?> remove(int code) {

        if(action.countByCode(code) == 0) {
            message.setMessage("The code provided does not exist");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        } else {
            Persons obj = action.findByCode(code);
            action.delete(obj);

            message.setMessage("Person removed successfully");
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        
    }

}
