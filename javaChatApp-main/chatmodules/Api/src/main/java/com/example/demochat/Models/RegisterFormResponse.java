package com.example.demochat.Models;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.Getter;
import lombok.Setter;

public class RegisterFormResponse {

    @Getter
    @Setter
    private Boolean usernameStatus;
    @Getter
    @Setter
    private Boolean isUsernameTaken;
    @Getter
    @Setter
    private Boolean passwordStatus;

    @Setter
    @Getter
    private Boolean registerStatus;
    public String toJson()
    {
        try
        {
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = ow.writeValueAsString(this);
            return json;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return "";
    }
    public static RegisterFormResponse fromJson(String object)
    {
        try
        {
            ObjectMapper om = new ObjectMapper();
            RegisterFormResponse u = om.readValue(object, RegisterFormResponse.class);
            return u;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
}
