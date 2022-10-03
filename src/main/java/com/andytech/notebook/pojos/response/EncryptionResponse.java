package com.andytech.notebook.pojos.response;

import lombok.Data;

@Data
public class EncryptionResponse {
    private String message;
    private String encryptedText;
    private String salt;
}
