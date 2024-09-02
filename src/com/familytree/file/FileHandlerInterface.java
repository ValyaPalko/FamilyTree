package com.familytree.file;

import java.io.IOException;
import java.util.Optional;

public interface FileHandlerInterface<T> {
    void save(T data, String fileName) throws IOException;
    Optional<T> load(String fileName) throws IOException, ClassNotFoundException;
}
