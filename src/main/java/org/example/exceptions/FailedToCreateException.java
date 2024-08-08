package org.example.exceptions;
import org.example.exceptions.Entity;

public class FailedToCreateException extends Throwable{

    public FailedToCreateException(Entity entity){
        super(entity.getEntity() + " does not exist");
    }
}