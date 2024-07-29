package com.familytree.file;

import com.familytree.model.Human;

import java.io.*;
import java.util.List;

public class FileHandler implements FileOperations {
    @Override
    public void saveToFile(String filename, List<Human> humans) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(humans);
        } catch (IOException e) {
            System.err.println("Error saving family tree to file: " + e.getMessage());
        }
    }

    @Override
    public List<Human> loadFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<Human>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading family tree from file: " + e.getMessage());
        }
        return null;
    }
}
