package store;

import java.util.HashMap;
import java.util.Map;

public class FileStore {
    private final Map<String, String> files = new HashMap<>();

    public void save(String name, String content) {
        files.put(name, content);
    }

    public int countLines(String name) {
        String c = files.getOrDefault(name, "");
        if (c.isEmpty()) return 0;
        return c.split("\n").length;
    }
}