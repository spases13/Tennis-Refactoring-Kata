
public class TennisGame2 implements TennisGame {
    public int player1_point = 0;
    public int player2_point = 0;

    public String player1_result = "";
    public String player2_result = "";
    private String player1_name;
    private String player2_name;

    public TennisGame2(String player1_name, String player2_name) {
        this.player1_name = player1_name;
        this.player2_name = player2_name;
    }

    public String getScore() {
        String score = "";
        if (player1_point == player2_point && player1_point < 4) {
            if (player1_point == 0)
                score = "Love";
            if (player1_point == 1)
                score = "Fifteen";
            if (player1_point == 2)
                score = "Thirty";
            score += "-All";
        }
        if (player1_point == player2_point && player1_point >= 3)
            score = "Deuce";

        if (player1_point > 0 && player2_point == 0) {
            if (player1_point == 1)
                player1_result = "Fifteen";
            if (player1_point == 2)
                player1_result = "Thirty";
            if (player1_point == 3)
                player1_result = "Forty";

            player2_result = "Love";
            score = player1_result + "-" + player2_result;
        }
        if (player2_point > 0 && player1_point == 0) {
            if (player2_point == 1)
                player2_result = "Fifteen";
            if (player2_point == 2)
                player2_result = "Thirty";
            if (player2_point == 3)
                player2_result = "Forty";

            player1_result = "Love";
            score = player1_result + "-" + player2_result;
        }

        if (player1_point > player2_point && player1_point < 4) {
            if (player1_point == 2)
                player1_result = "Thirty";
            if (player1_point == 3)
                player1_result = "Forty";
            if (player2_point == 1)
                player2_result = "Fifteen";
            if (player2_point == 2)
                player2_result = "Thirty";
            score = player1_result + "-" + player2_result;
        }
        if (player2_point > player1_point && player2_point < 4) {
            if (player2_point == 2)
                player2_result = "Thirty";
            if (player2_point == 3)
                player2_result = "Forty";
            if (player1_point == 1)
                player1_result = "Fifteen";
            if (player1_point == 2)
                player1_result = "Thirty";
            score = player1_result + "-" + player2_result;
        }

        if (player1_point > player2_point && player2_point >= 3) {
            score = "Advantage " + player1_name;
        }

        if (player2_point > player1_point && player1_point >= 3) {
            score = "Advantage " + player2_name;
        }

        if (player1_point >= 4 && player2_point >= 0 && (player1_point - player2_point) >= 2) {
            score = "Win for " + player1_name;
        }
        if (player2_point >= 4 && player1_point >= 0 && (player2_point - player1_point) >= 2) {
            score = "Win for " + player2_name;
        }
        return score;
    }

    public void SetP1Score(int number) {

        for (int i = 0; i < number; i++) {
            P1Score();
        }

    }

    public void SetP2Score(int number) {

        for (int i = 0; i < number; i++) {
            P2Score();
        }

    }

    public void P1Score() {
        player1_point++;
    }

    public void P2Score() {
        player2_point++;
    }

    public void wonPoint(String player_name) {
        if (this.player1_name == player_name)
            P1Score();
        else
            P2Score();
    }
}