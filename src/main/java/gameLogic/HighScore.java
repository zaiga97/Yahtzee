package gameLogic;

import java.io.*;
import java.util.*;

public class HighScore {
    private Map<String, List<Integer>> scoreHistory;

    public HighScore() {
        scoreHistory = new HashMap<>();
    }

    public void add(String name, int score) {

        if(scoreHistory.containsKey(name)){
            List<Integer> oldList = scoreHistory.get(name);
            List<Integer> newList = new ArrayList<>(oldList);
            newList.add(score);
            scoreHistory.put(name, newList);
        }

        scoreHistory.putIfAbsent(name, Collections.singletonList(score));
    }

    public void load(String path) {
        scoreHistory = new HashMap<>();

        try {
            Scanner scanner = new Scanner(new File(path));
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                if (!line.isEmpty()){
                    String[] s = line.split(" ");
                    add(s[0], Integer.parseInt(s[1]));
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void write(String path) {
        try {
            FileWriter fileWriter = new FileWriter(path);
            for (String k: scoreHistory.keySet()) {
                scoreHistory.get(k)
                        .forEach(integer -> {
                            try {
                                fileWriter.write(k + " " + integer + "\n");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<String, List<Integer>> getScoreHistory() {
        return scoreHistory;
    }
}
