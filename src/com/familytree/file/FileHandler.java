package com.familytree.file;

import java.io.*;
import java.util.Optional;

public class FileHandler<T> implements FileHandlerInterface<T> {

    @Override
    public void save(T data, String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(data);
        }
    }

    @Override
    public Optional<T> load(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return Optional.of((T) ois.readObject());
        }
    }
}
