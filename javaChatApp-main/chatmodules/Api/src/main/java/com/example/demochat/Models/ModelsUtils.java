package com.example.demochat.Models;

import java.util.UUID;

public class ModelsUtils {
    public record Message(String PasswordMessage,
                          String UsernameMessage,
                          Boolean status){
        @Override
        public String toString()
        {
            return this.UsernameMessage()+" "+ this.PasswordMessage()+" "+this.status();
        }

    }
    public record RegisterForm(UUID sessionUUID,
                               String username,
                               String password

    ){
        @Override
        public String toString()
        {
            return this.username()+" "+this.password();
        }

    }

}
