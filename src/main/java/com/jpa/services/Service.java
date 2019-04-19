package com.jpa.services;

public interface Service<T> {

    T read(int id);

    void create(T item);

    void update(T item);

    void delete(T item);
}
