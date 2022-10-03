package com.andytech.notebook.controllers;


import com.andytech.notebook.pojos.inputs.EncryptionRequest;
import com.andytech.notebook.pojos.response.DecryptedResponse;
import com.andytech.notebook.pojos.response.EncryptionResponse;
import com.andytech.notebook.services.NotebookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Andres Toledo on 10/02/22
 *
 * This class is used to handle the requests for sorting algorithms.
 */
@RestController
public class NotebookController {

    Logger logger = LoggerFactory.getLogger(NotebookController.class);

    //Encryption Service
    @Autowired
    private NotebookService notebookService;


    @GetMapping("/test")
    public ResponseEntity<String> test()
    {
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }

    @PostMapping("notebook/encrypt")
    public ResponseEntity<EncryptionResponse> encrypt(@RequestBody EncryptionRequest encryptionRequest)
    {
        return new ResponseEntity<>(notebookService.encrypt(encryptionRequest), HttpStatus.OK);
    }

    @PostMapping("notebook/decrypt")
    public ResponseEntity<DecryptedResponse> decrypt(@RequestBody EncryptionRequest encryptionRequest)
    {
        return new ResponseEntity<>(notebookService.decrypt(encryptionRequest), HttpStatus.OK);
    }

}
