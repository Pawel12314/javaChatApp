package com.example.demochat.Models;


import lombok.Getter;
import lombok.Setter;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

//@Configuration
@Component
public class RegisterFormRequest {

    @Getter
    @Setter
    private String uuid;


    @Setter
    @Getter
    private String username;

    @Setter
    private String password;

    @Getter
    private String hashedPassword;
    @Getter
    @Setter
    private int passwordLength;
    @Setter
    @Getter
    private int usernameLength;

    public void setUsername(String username)
    {
        this.username=username;
        this.usernameLength=this.username.length();

    }
    public void setPassword(String password)
    {
        this.password = password;
        this.hashedPassword = DigestUtils.sha256Hex(password);
        try {
            Thread.sleep(500L);

        }catch (Exception ex)
        {

        }
        //String second = DigestUtils.sha256Hex(password);
        //System.out.println("hashes should be equal..."+second.equals(this.hashedPassword));
        this.passwordLength=this.password.length();
    }

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
    public static RegisterFormRequest fromJson(String object)
    {
        try
        {
            ObjectMapper om = new ObjectMapper();
            RegisterFormRequest u = om.readValue(object, RegisterFormRequest.class);
            return u;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
    @Override
    public String toString()
    {
        return "<--\n"
                + this.uuid+"\n"
                + this.hashedPassword+"\n"
                +"-->\n";
    }

}
