package com.chel.lab1.dao;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

public interface Dao<T> {

    T get(int id);

    ArrayList<T> getAll();

    void save(T t);

    void update(int id, Map<String, String> params);

    void delete(int id);
}