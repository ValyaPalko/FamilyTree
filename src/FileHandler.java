import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileHandler implements FileOperations {
    @Override
    public void saveToFile(String filename, Map<Long, Human> humans) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(humans);
            System.out.println("Family tree saved to file: " + filename);
        } catch (IOException e) {
            System.err.println("Error saving family tree to file: " + e.getMessage());
        }
    }

    @Override
    public Map<Long, Human> loadFromFile(String filename) {
        Map<Long, Human> humans = new HashMap<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            humans = (Map<Long, Human>) ois.readObject();
            System.out.println("Family tree loaded from file: " + filename);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading family tree from file: " + e.getMessage());
        }
        return humans;
    }
}
