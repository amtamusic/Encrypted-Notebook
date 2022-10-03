package com.andytech.notebook.services;

import com.andytech.notebook.pojos.inputs.EncryptionRequest;
import com.andytech.notebook.pojos.response.DecryptedResponse;
import com.andytech.notebook.pojos.response.EncryptionResponse;

public interface NotebookService {
    EncryptionResponse encrypt(EncryptionRequest request);
    DecryptedResponse decrypt(EncryptionRequest request);
}
