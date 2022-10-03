package com.andytech.notebook.pojos.inputs;

import lombok.Data;

@Data
public class EncryptionRequest {
    private String text;
    private String key;
    private String salt;
}