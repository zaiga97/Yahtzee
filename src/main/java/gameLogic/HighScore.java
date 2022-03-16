package gameLogic;

import java.io.*;
import java.util.*;

/**
 * This class is meant to deal with the saving and loading of players scores.
 * It keeps in memory all the results for each player to allow flexibility when showing high scores.
 * @author zaiga97
 */

public class HighScore {
    private Map<String, List<Integer>> scoreHistory;

    public HighScore() {
        scoreHistory = new HashMap<>();
    }

    /**
     * Add a new score to the player.
     * @param name Name of the player. It must be unique.
     * @param score The score done by the player
     */
    public void add(String name, int score) {

        if(scoreHistory.containsKey(name)){
            List<Integer> oldList = scoreHistory.get(name);
            List<Integer> newList = new ArrayList<>(oldList);
            newList.add(score);
            scoreHistory.put(name, newList);
        }

        scoreHistory.putIfAbsent(name, Collections.singletonList(score));
    }

    /**
     * Load the scoring history from a file.
     * The format for the file should be each record on a new line,
     * each record be a name followed by a space and then an integer.
     * @param path Path of the file to load
     */
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

    /**
     * Saves the scores on a file at the location path.
     * @param path Path where to save the file.
     */
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

    /**
     * Map of all scores.
     * If you want the saved scores you need to use load first
     * @return The scores of the players.
     */
    public Map<String, List<Integer>> getScoreHistory() {
        return scoreHistory;
    }
}
