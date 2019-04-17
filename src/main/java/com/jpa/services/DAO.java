package com.jpa.services;

public interface DAO<T> {

    T read(int id);

    void create(T developer);

    void update(T developer);

    void delete(T developer);
}
