package com.hubberspot.mockito.test_doubles.dummy;

public interface EmailService {

    default void sendEmail(String message){

    }
}
