package com.jastrzab.app.infrastructure;

import java.util.List;
import java.util.Map;

public abstract class AbstractRepository<T> {
    public abstract T get(int id);
    public abstract List<T> getAll();
    public abstract boolean delete(int id);
    public abstract boolean delete(T object);
    public abstract boolean insert(T object);
    public abstract boolean update(T object);
}
