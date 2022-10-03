package com.andytech.notebook.pojos.response;

import lombok.Data;

@Data
public class DecryptedResponse {
    private String message;
    private String decryptedText;
}
