package model;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email implements Serializable
{
    private String email;

    public Email(String email)
    {
        if (isEmailValid(email))
            this.email = email;
        else throw new IllegalArgumentException("The email is not valid");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean equals(Email email)
    {
        if (!(email instanceof Email))
            return false;

        /*Email o = (Email)email;*/
        return email.getEmail().equals(this.email);
    }

    public static boolean isEmailValid(String email)
    {
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher1 = pattern.matcher(email);
        return matcher1.matches();
    }
}
