import java.util.Map;

interface FileOperations {
    void saveToFile(String filename, Map<Long, Human> humans);
    Map<Long, Human> loadFromFile(String filename);
}

