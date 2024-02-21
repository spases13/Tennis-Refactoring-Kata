public class TennisGame4 implements TennisGame {

    int server_score;
    int receiver_score;
    String server;
    String receiver;

    public TennisGame4(String player1_name, String player2_name) {
        this.server = player1_name;
        this.receiver = player2_name;
    }

    @java.lang.Override
    public void wonPoint(String player_name) {
        if (server.equals(player_name))
            this.server_score += 1;
        else
            this.receiver_score += 1;
    }

    @java.lang.Override
    public String getScore() {
        TennisResult result = new Deuce(
                this, new GameServer(
                        this, new GameReceiver(
                                this, new AdvantageServer(
                                        this, new AdvantageReceiver(
                                                this, new DefaultResult(this)))))).getResult();
        return result.format();
    }

    boolean receiverHasAdvantage() {
        return receiver_score >= 4 && (receiver_score - server_score) == 1;
    }

    boolean serverHasAdvantage() {
        return server_score >= 4 && (server_score - receiver_score) == 1;
    }

    boolean receiverHasWon() {
        return receiver_score >= 4 && (receiver_score - server_score) >= 2;
    }

    boolean serverHasWon() {
        return server_score >= 4 && (server_score - receiver_score) >= 2;
    }

    boolean isDeuce() {
        return server_score >= 3 && receiver_score >= 3 && (server_score == receiver_score);
    }
}

class TennisResult {
    String server_score;
    String receiver_score;

    TennisResult(String server_score, String receiver_score) {
        this.server_score = server_score;
        this.receiver_score = receiver_score;
    }

    String format() {
        if ("".equals(this.receiver_score))
            return this.server_score;
        if (server_score.equals(receiver_score))
            return server_score + "-All";
        return this.server_score + "-" + this.receiver_score;
    }
}

interface ResultProvider {
    TennisResult getResult();
}

class Deuce implements ResultProvider {
    private final TennisGame4 game;
    private final ResultProvider next_result;

    public Deuce(TennisGame4 game, ResultProvider next_result) {
        this.game = game;
        this.next_result = next_result;
    }

    @Override
    public TennisResult getResult() {
        if (game.isDeuce())
            return new TennisResult("Deuce", "");
        return this.next_result.getResult();
    }
}

class GameServer implements ResultProvider {
    private final TennisGame4 game;
    private final ResultProvider next_result;

    public GameServer(TennisGame4 game, ResultProvider next_result) {
        this.game = game;
        this.next_result = next_result;
    }

    @Override
    public TennisResult getResult() {
        if (game.serverHasWon())
            return new TennisResult("Win for " + game.server, "");
        return this.next_result.getResult();
    }
}

class GameReceiver implements ResultProvider {
    private final TennisGame4 game;
    private final ResultProvider next_result;

    public GameReceiver(TennisGame4 game, ResultProvider next_result) {
        this.game = game;
        this.next_result = next_result;
    }

    @Override
    public TennisResult getResult() {
        if (game.receiverHasWon())
            return new TennisResult("Win for " + game.receiver, "");
        return this.next_result.getResult();
    }
}

class AdvantageServer implements ResultProvider {
    private final TennisGame4 game;
    private final ResultProvider next_result;

    public AdvantageServer(TennisGame4 game, ResultProvider next_result) {
        this.game = game;
        this.next_result = next_result;
    }

    @Override
    public TennisResult getResult() {
        if (game.serverHasAdvantage())
            return new TennisResult("Advantage " + game.server, "");
        return this.next_result.getResult();
    }
}

class AdvantageReceiver implements ResultProvider {

    private final TennisGame4 game;
    private final ResultProvider next_result;

    public AdvantageReceiver(TennisGame4 game, ResultProvider next_result) {
        this.game = game;
        this.next_result = next_result;
    }

    @Override
    public TennisResult getResult() {
        if (game.receiverHasAdvantage())
            return new TennisResult("Advantage " + game.receiver, "");
        return this.next_result.getResult();
    }
}

class DefaultResult implements ResultProvider {

    private static final String[] scores = {"Love", "Fifteen", "Thirty", "Forty"};

    private final TennisGame4 game;

    public DefaultResult(TennisGame4 game) {
        this.game = game;
    }

    @Override
    public TennisResult getResult() {
        return new TennisResult(scores[game.server_score], scores[game.receiver_score]);
    }
}
