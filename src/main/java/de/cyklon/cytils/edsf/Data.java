package de.cyklon.cytils.edsf;

import java.util.*;
import java.util.stream.Collectors;

public class Data {

    public static final String seperator = "♦";

    private HashMap<String, String> data = new HashMap<>();
    private DataType type;

    public Data(String[] values, DataType type) {
        if (type.equals(DataType.DECODED)) {
            for (int i = 0; i < values.length; i++) {
                String s = values[i];
                this.data.put(s.split(seperator)[0], s.split(seperator)[1]);
            }
        }
        this.type = type;
    }

    @Override
    public String toString() {
        return data.toString();
    }

    public String get(String key) {
        if (type.equals(DataType.DECODED)) {
            return data.getOrDefault(key, null);
        } else {
            return null;
        }
    }

    public ArrayList<String> getKeys() {
        ArrayList<String> keys = new ArrayList<>();
        for (String key : data.keySet()) {
            keys.add(key);
        }
        return keys;
    }

    public List<String> findKeys(Integer value){
        return data
                .entrySet()
                .stream()
                .filter(e -> Objects.equals(e.getValue(), value))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public DataType getType() {
        return type;
    }
}
