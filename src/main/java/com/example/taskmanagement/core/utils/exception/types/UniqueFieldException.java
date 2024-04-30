package com.example.taskmanagement.core.utils.exception.types;

import org.hibernate.NonUniqueResultException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;

import java.lang.reflect.InvocationTargetException;

public class UniqueFieldException extends DataAccessException {
    public UniqueFieldException(String msg) {
        super(msg);
    }
}
