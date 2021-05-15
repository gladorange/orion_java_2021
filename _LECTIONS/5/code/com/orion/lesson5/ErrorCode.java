package com.orion.lesson5;


interface ErrorCode {
    String getDescription();
}


enum AuthorizationErrorCode implements ErrorCode {

    /*   TOO_MANY_ATTEMPTS("") {
        @Override
        public String getDescription() {
            return super.getDescription();
        }
    },*/
    INCORRECT_EMAIL("Неправильный email"),
    INCORRECT_PASSWORD("Неправильный пароль" );




    final String description;

    AuthorizationErrorCode(String description) {
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }
}


enum EmailSendErrorCode implements ErrorCode {
    TOO_MANY_RECIPIENTS;

    @Override
    public String getDescription() {
        return "Много получателей";
    }
}