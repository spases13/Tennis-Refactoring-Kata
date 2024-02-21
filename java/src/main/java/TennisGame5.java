import java.util.HashMap;
import java.util.Map;

public class TennisGame5 implements TennisGame {

    private final String player1_name;
    private final String player2_name;
    private int player1_score;
    private int player2_score;

    public TennisGame5(String player1_name, String player2_name) {
        this.player1_name = player1_name;
        this.player2_name = player2_name;
    }

    @Override
    public void wonPoint(String player_name) {
        if (player_name.equals(player1_name))
            player1_score++;
        else if (player_name.equals(player2_name))
            player2_score++;
        else
            throw new IllegalArgumentException("Invalid player name.");
    }

    @Override
    public String getScore() {

        while (player1_score > 4 || player2_score > 4) {
            player1_score--;
            player2_score--;
        }

        var lookup = new HashMap<Map.Entry, String>();
        lookup.put(Map.entry(0, 0), "Love-All");
        lookup.put(Map.entry(0, 1), "Love-Fifteen");
        lookup.put(Map.entry(0, 2), "Love-Thirty");
        lookup.put(Map.entry(0, 3), "Love-Forty");
        lookup.put(Map.entry(0, 4), "Win for " + player2_name);
        lookup.put(Map.entry(1, 0), "Fifteen-Love");
        lookup.put(Map.entry(1, 1), "Fifteen-All");
        lookup.put(Map.entry(1, 2), "Fifteen-Thirty");
        lookup.put(Map.entry(1, 3), "Fifteen-Forty");
        lookup.put(Map.entry(1, 4), "Win for "+ player2_name);
        lookup.put(Map.entry(2, 0), "Thirty-Love");
        lookup.put(Map.entry(2, 1), "Thirty-Fifteen");
        lookup.put(Map.entry(2, 2), "Thirty-All");
        lookup.put(Map.entry(2, 3), "Thirty-Forty");
        lookup.put(Map.entry(2, 4), "Win for "+ player2_name);
        lookup.put(Map.entry(3, 0), "Forty-Love");
        lookup.put(Map.entry(3, 1), "Forty-Fifteen");
        lookup.put(Map.entry(3, 2), "Forty-Thirty");
        lookup.put(Map.entry(3, 3), "Deuce");
        lookup.put(Map.entry(3, 4), "Advantage "+ player2_name);
        lookup.put(Map.entry(4, 0), "Win for " + player1_name);
        lookup.put(Map.entry(4, 1), "Win for " + player1_name);
        lookup.put(Map.entry(4, 2), "Win for " + player1_name);
        lookup.put(Map.entry(4, 3), "Advantage " + player1_name);
        lookup.put(Map.entry(4, 4), "Deuce");

        var entry = Map.entry(player1_score, player2_score);
        if (lookup.containsKey(entry)) {
            return lookup.get(entry);
        } else {
            throw new IllegalArgumentException("Invalid score.");
        }
    }
}
