import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;


public class TenisGameTest {

    private TenisGame tenisGame;
    @BeforeMethod
    public void setUp()
    {
        tenisGame = new TenisGame();
    }
    @Test
    public void afterNewGameStartNoScore(){

        Assert.assertEquals(tenisGame.getScore().playerAScore.gamePoint, 0);
        Assert.assertEquals(tenisGame.getScore().playerAScore.game, 0);
        Assert.assertEquals(tenisGame.getScore().playerBScore.gamePoint, 0);
        Assert.assertEquals(tenisGame.getScore().playerBScore.game, 0);
    }
    @Test
    public void afterOneGamePoint(){
        AddWonMatch("A",1);
        Assert.assertEquals(tenisGame.getScore().playerAScore.gamePoint, 15);
        Assert.assertEquals(tenisGame.getScore().playerAScore.game, 0);
    }
    @Test
    public void afterPlayerAWonThreeMatch(){
        AddWonMatch("A",3);
        Assert.assertEquals(tenisGame.getScore().playerAScore.gamePoint, 40);
        Assert.assertEquals(tenisGame.getScore().playerAScore.game, 0);
    }

    @Test
    public void PlayerAWin(){
        AddWonMatch("A",4);
        Assert.assertEquals(tenisGame.getScore().playerAScore.gamePoint, 0);
        Assert.assertEquals(tenisGame.getScore().playerAScore.game, 1);
    }

    @Test
    public void AfterTwoMatchTheScoreEquals(){
        AddWonMatch("A",1);
        AddWonMatch("B",1);
        Assert.assertEquals(tenisGame.getScore().playerAScore.gamePoint, 15);
        Assert.assertEquals(tenisGame.getScore().playerAScore.game, 0);
        Assert.assertEquals(tenisGame.getScore().playerBScore.gamePoint, 15);
        Assert.assertEquals(tenisGame.getScore().playerBScore.game, 0);
    }

    private void AddWonMatch(String player, int numberOfWin)
    {
        for (int i =0; i< numberOfWin; i++) {
            tenisGame.addGamePoint(player);
        }
    }
}