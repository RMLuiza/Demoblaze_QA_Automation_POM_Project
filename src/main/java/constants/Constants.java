package constants;

import com.github.javafaker.Faker;

public class Constants {
    public static final String URL = "https://www.demoblaze.com/index.html";
    public static final String USERNAME = "Luiza10101021";
    public static final String PASSWORD = "parola";
    public static final String WELCOME_MESSAGE = "Welcome";
    public static final String SIGNUP_SUCCESSFUL_MESSAGE = "Sign up successful.";
    public static final String LOGIN_OR_SIGNUP_ERROR_MESSAGE = "Please fill out Username and Password.";
    public static final String LOGIN_WRONG_USERNAME = "User does not exist.";
    public static final String LOGIN_WRONG_PASSWORD = "Wrong password.";
    public static final String SIGNUP_USER_ALREADY_EXISTS_MESSAGE = "This user already exist.";
    public static final String SIGNUP_TITLE = "Sign up";
    public static final String PRODUCT_ADDED_TEXT = "Product added.";

    // css values
    public static final String BACKGROUND_COLOR = "background-color";
    public static final String LOGIN_TITLE = "Log in";
    public static String generateUsername() {
        Faker faker = new Faker();
        return faker.name().firstName() + "@gmail.com";
    }

    public static String generatePassword() {
        Faker faker = new Faker();
        return faker.name().name() + 123;
    }

    // rGB colors
    public static final String blueColor = "rgba(2, 117, 216, 1)";



}
