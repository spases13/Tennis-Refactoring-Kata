public class TennisGame6 implements TennisGame {
    private final String player1_name;
    private final String player2_name;
    private int player1_score;
    private int player2_score;

    public TennisGame6(String player1_name, String player2_name) {
        this.player1_name = player1_name;
        this.player2_name = player2_name;
    }

    @Override
    public void wonPoint(String playerName) {
        if (playerName.equals(player1_name))
            player1_score++;
        else
            player2_score++;

    }

    public String getScore()
    {
        String result;

        if (player1_score == player2_score)
        {
            // tie score
            String tieScore;
            switch (player1_score)
            {
                case 0:
                    tieScore = "Love-All";
                    break;
                case 1:
                    tieScore = "Fifteen-All";
                    break;
                case 2:
                    tieScore = "Thirty-All";
                    break;
                default:
                    tieScore = "Deuce";
                    break;
            }

            result = tieScore;
        }
        else if (player1_score >= 4 || player2_score >= 4)
        {
            // end-game score
            String endGameScore;

            if (player1_score - player2_score == 1) {
                endGameScore = "Advantage " + player1_name;
            } else if (player1_score - player2_score == -1) {
                endGameScore = "Advantage " + player2_name;
            } else if (player1_score - player2_score >= 2) {
                endGameScore = "Win for " + player1_name;
            } else {
                endGameScore = "Win for " + player2_name;
            }

            result = endGameScore;
        }
        else
        {
            // regular score
            String regularScore;
            String score1 =  switch (player1_score)
            {
                case 0 -> "Love";
                case 1 -> "Fifteen";
                case 2 -> "Thirty";
                default -> "Forty";
            };

            var score2 =  switch (player2_score)
            {
                case 0 -> "Love";
                case 1 -> "Fifteen";
                case 2 -> "Thirty";
                default -> "Forty";
            };

            regularScore = score1 + "-" + score2;

            result = regularScore;
        }

        return result;
    }
}
