public class TennisGame3 implements TennisGame {
    
    private int player2_point;
    private int player1_point;
    private String player1_name;
    private String player2_name;

    public TennisGame3(String player1_name, String player2_name) {
        this.player1_name = player1_name;
        this.player2_name = player2_name;
    }

    public String getScore() {
        String score;
        if (player1_point < 4 && player2_point < 4 && !(player1_point + player2_point == 6)) {
            String[] p = new String[]{"Love", "Fifteen", "Thirty", "Forty"}; 
            score = p[player1_point];
            return (player1_point == player2_point) ? score + "-All" : score + "-" + p[player2_point];
        } else {
            if (player1_point == player2_point)
                return "Deuce";
            score = player1_point > player2_point ? player1_name : player2_name;
            return ((player1_point-player2_point)*(player1_point-player2_point) == 1) ? "Advantage " + score : "Win for " + score;
        }
    }
    
    public void wonPoint(String player_name) {
        if (this.player1_name == player_name)
            this.player1_point += 1;
        else
            this.player2_point += 1;
        
    }

}
