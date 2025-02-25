package br.com.matheusjuan.eventlinker.error;

public class EventNotFoundException extends RuntimeException {


    public EventNotFoundException(String msg) {
        super(msg);
    }
}
