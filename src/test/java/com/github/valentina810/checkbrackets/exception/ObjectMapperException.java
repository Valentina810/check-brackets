package com.github.valentina810.checkbrackets.exception;

public class ObjectMapperException extends RuntimeException {
    public ObjectMapperException(Object object) {
        super("Возникла ошибка при преобразовании объекта " + object.toString());
    }
}