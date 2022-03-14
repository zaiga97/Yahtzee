import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class HighScore {
    Map<String, List<Integer>> scoreHistory = new HashMap<>();

    public void add(String name, int score) {

        if(scoreHistory.containsKey(name)){
            List<Integer> oldList = scoreHistory.get(name);
            List<Integer> newList = new ArrayList<>(oldList);
            newList.add(score);
            scoreHistory.put(name, newList);
        }

        scoreHistory.putIfAbsent(name, Collections.singletonList(score));
    }

    public List<Integer> getScores(String name) {
        return scoreHistory.get(name);
    }

    public void load(String path) {
        scoreHistory = new HashMap<>();

        try {
            Scanner scanner = new Scanner(new File(path));
            while (scanner.hasNextLine()){
                add(scanner.next(), scanner.nextInt());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
