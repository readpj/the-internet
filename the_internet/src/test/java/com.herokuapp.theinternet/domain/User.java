package com.herokuapp.theinternet.domain;

public class User {

    private TheInternetCredentials theInternetCredentials;

    public User(Examples examples) {

    }

    public User() {
    }

    public enum Examples {
        CONTEXT_MENU,
        DROPDOWN,
        HORIZONTAL_SLIDER,
        FORM_AUTHENTICATION
    }

    private Examples examples;

    public void setExamples(Examples examples) {
        this.examples = examples;
    }

    public Examples getExamples() {
        return this.examples;
    }

    public User(TheInternetCredentials theInternetCredentials) {
        this.theInternetCredentials = theInternetCredentials;
    }

    public TheInternetCredentials getTheInternetCredentials() {
        return theInternetCredentials;
    }

    public void setTheInternetCredentials(TheInternetCredentials theInternetCredentials) {
        this.theInternetCredentials=theInternetCredentials;
    }
}
