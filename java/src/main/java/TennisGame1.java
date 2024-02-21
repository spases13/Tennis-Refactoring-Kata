
public class TennisGame1 implements TennisGame {

    private int player1_score = 0;
    private int player2_score = 0;
    private String player1_name;
    private String player2_name;

    public TennisGame1(String player1_name, String player2_name) {
        this.player1_name = player1_name;
        this.player2_name = player2_name;
    }

    public void wonPoint(String player_name) {
        if (player_name == player1_name)
            player1_score += 1;
        else
            player2_score += 1;
    }

    public String getScore() {
        String score = "";
        int temp_score = 0;
        if (player1_score == player2_score) {
            switch (player1_score) {
                case 0:
                    score = "Love-All";
                    break;
                case 1:
                    score = "Fifteen-All";
                    break;
                case 2:
                    score = "Thirty-All";
                    break;
                default:
                    score = "Deuce";
                    break;

            }
        } else if (player1_score >= 4 || player2_score >= 4) {
            int score_difference = player1_score - player2_score;
            if (score_difference == 1)
                score = "Advantage " + player1_name;
            else if (score_difference == -1)
                score = "Advantage " + player2_name;
            else if (score_difference >= 2)
                score = "Win for " + player1_name;
            else
                score = "Win for " + player2_name;
        } else {
            for (int i = 1; i < 3; i++) {
                if (i == 1)
                    temp_score = player1_score;
                else {
                    score += "-";
                    temp_score = player2_score;
                }
                switch (temp_score) {
                    case 0:
                        score += "Love";
                        break;
                    case 1:
                        score += "Fifteen";
                        break;
                    case 2:
                        score += "Thirty";
                        break;
                    case 3:
                        score += "Forty";
                        break;
                }
            }
        }
        return score;
    }
}
