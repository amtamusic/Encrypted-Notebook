package com.andytech.notebook.services.impl;

import com.andytech.notebook.pojos.inputs.EncryptionRequest;
import com.andytech.notebook.pojos.response.DecryptedResponse;
import com.andytech.notebook.pojos.response.EncryptionResponse;
import com.andytech.notebook.services.NotebookService;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class NotebookServiceImpl implements NotebookService {

    Logger logger = Logger.getLogger(NotebookServiceImpl.class.getName());

    @Override
    public EncryptionResponse encrypt(EncryptionRequest request) {

        final String password = request.getKey();
        EncryptionResponse response = new EncryptionResponse();
        request.setSalt(getSalt(request));
        try{
            TextEncryptor encryptor = Encryptors.text(password, request.getSalt());
            String cipherText = encryptor.encrypt(encryptor.encrypt(request.getText()));
            response.setSalt(request.getSalt());
            response.setEncryptedText(cipherText);
            response.setMessage("Encryption Successful");
        }catch (Exception e){
            response.setMessage("Encryption Failed: "+e.getMessage());
        }
        return response;
    }

    @Override
    public DecryptedResponse decrypt(EncryptionRequest request) {
        final String password = request.getKey();
        DecryptedResponse response = new DecryptedResponse();
        request.setSalt(getSalt(request));
        try{
            TextEncryptor encryptor = Encryptors.text(password, request.getSalt());
            String plainText = encryptor.decrypt(encryptor.decrypt(request.getText()));
            response.setDecryptedText(plainText);
            response.setMessage("Decryption Successful");
        } catch (Exception e) {
            response.setMessage("Decryption Failed: "+e.getMessage());
        }
        return response;
    }


    public String getSalt(EncryptionRequest request) {
        if(null == request.getSalt() || request.getSalt().isBlank())
        {
            String salt = KeyGenerators.string().generateKey();
            logger.info("Salt Generated: " + salt);
            return salt;
        }
        logger.info("Salt Provided: " + request.getSalt());
        return request.getSalt();
    }


}
