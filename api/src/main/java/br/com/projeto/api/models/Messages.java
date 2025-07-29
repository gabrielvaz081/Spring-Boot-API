package br.com.projeto.api.models;

import org.springframework.stereotype.Component;

@Component
public class Messages {
    
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
