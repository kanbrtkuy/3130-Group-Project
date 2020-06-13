package com.example.project;

public class UserAccount {
    private String Username;
    private String EmailAddress;
    private String Password;

    public UserAccount(String Username, String EmailAddress, String Password){
        this.Username = Username;
        this.EmailAddress = EmailAddress;
        this.Password = Password;
    }

    public String getUsername(){return Username;}

    public String getEmailAddress(){return EmailAddress;}

    public String getPassword(){return Password;}

    public void setUsername(String Username ) {this.Username = Username;}

    public void setEmailAddress(String EmailAddress){this.EmailAddress = EmailAddress;}

    public void setPassword(String Password){ this.Password = Password;}

    public boolean PasswordLength(){
        int l = Password.length();
        if (l >= 6){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean ValidEmail(){
        int l = EmailAddress.length();
        for (int i = 0; i < l ; i ++){
            if (EmailAddress.charAt(i) == '@' ){
                return true;
            }
        }
        return false;
    }

}
