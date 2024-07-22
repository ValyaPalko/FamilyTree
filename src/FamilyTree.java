import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class FamilyTree implements Serializable {
    private static final long serialVersionUID = 1L;

    private Map<Long, Human> humans;
    private transient FileOperations fileHandler;

    public FamilyTree(FileOperations fileHandler) {
        this.humans = new HashMap<>();
        this.fileHandler = fileHandler;
    }

    public void addHuman(Human human) {
        if (human != null && human.getId() != null && !humans.containsKey(human.getId())) {
            humans.put(human.getId(), human);
        }
    }


    public Human getHuman(Long id) {
        return humans.get(id);
    }


    public void printAllHumans() {
        for (Human human : humans.values()) {
            System.out.println(human.getInfo());
        }
    }


    public void saveToFile(String filename) {
        fileHandler.saveToFile(filename, humans);
    }


    public void loadFromFile(String filename) {
        humans = fileHandler.loadFromFile(filename);
    }
}
