package com.sda.jdbc.student;

import java.util.List;
import java.util.Map;

public interface AbstractRepsitoryI<T> {
    T get(int id);

    List<T> getAll();

    boolean delete(int id);

    boolean insert(Map<String, String> map);

    boolean update(int id, Map<String, String> map);
}
