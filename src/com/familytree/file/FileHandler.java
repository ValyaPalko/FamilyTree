package com.familytree.file;

import com.familytree.model.Human;

import java.io.*;
import java.util.List;
import java.util.Optional;

public class FileHandler<T> implements FileOperations<T> {
    @Override
    public void saveToFile(String filename, List<T> elements) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(elements);
        } catch (IOException e) {
            System.err.println("Error saving family tree to file: " + e.getMessage());
        }
    }

    @Override
    public List<T> loadFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<T>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading family tree from file: " + e.getMessage());
        }
        return null;
    }

    public Optional<T> load(String fileName) {
    }
}
