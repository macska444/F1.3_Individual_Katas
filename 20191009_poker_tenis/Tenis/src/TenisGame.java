public class TenisGame {

    private int playerAWonGamePoint = 0;
    private int playerBWonGamePoint = 0;

    public TenisScore getScore() {
        TenisScore ts = new TenisScore();
        ts.playerAScore = calculateScore(playerAWonGamePoint);
        ts.playerBScore = calculateScore(playerBWonGamePoint);
        return ts;
    }

    private Score calculateScore(int wonGamePoint) {
        Score score = new Score();
        if (wonGamePoint == 4)
            score.game = 1;
        else if (wonGamePoint == 3)
            score.gamePoint = 40;
        else if (wonGamePoint == 2)
            score.gamePoint = 30;
        else if (wonGamePoint ==1)
            score.gamePoint = 15;
        return score;
    }

    public void addGamePoint(String player) {
        if (player.equals("A"))
            playerAWonGamePoint++;
        else if (player.equals("B"))
            playerBWonGamePoint++;

    }
}
