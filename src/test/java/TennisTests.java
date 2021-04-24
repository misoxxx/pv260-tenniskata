import org.junit.Test;

import static com.googlecode.catchexception.CatchException.catchException;
import static org.junit.Assert.*;

public class TennisTests {
    @Test
    public void testPlayersStartWithZeroPoints() {
        Tennis tennis = new Tennis();
        assertEquals(0,tennis.getScoreA());
        assertEquals(0,tennis.getScoreB());
    }
    @Test
    public void testPlayerScoreNonEqual() {
        Tennis tennis = new Tennis();
        tennis.scoredA();
        assertEquals(15,tennis.getScoreA());
        assertEquals(0,tennis.getScoreB());
        tennis.scoredA();
        assertEquals(30,tennis.getScoreA());
        assertEquals(0,tennis.getScoreB());
        tennis.scoredA();
        assertEquals(40,tennis.getScoreA());
        assertEquals(0,tennis.getScoreB());
        tennis.scoredB();
        assertEquals(40,tennis.getScoreA());
        assertEquals(15,tennis.getScoreB());
        tennis.scoredB();
        assertEquals(40,tennis.getScoreA());
        assertEquals(30,tennis.getScoreB());
    }

    @Test
    public void testPlayerWinsIfHeScoresWhenHeHas40Points(){
        Tennis tennis = new Tennis();
        tennis.scoredA();
        tennis.scoredA();
        tennis.scoredA();
        tennis.scoredA();
        assertEquals(true,tennis.isAWinner());
        assertEquals(false,tennis.isBWinner());

        tennis = new Tennis();
        tennis.scoredA();
        tennis.scoredA();
        tennis.scoredB();
        tennis.scoredA();
        tennis.scoredB();
        tennis.scoredA();
        assertEquals(true,tennis.isAWinner());
        assertEquals(false,tennis.isBWinner());


        tennis = new Tennis();
        tennis.scoredB();
        tennis.scoredB();
        tennis.scoredA();
        tennis.scoredB();
        tennis.scoredA();
        tennis.scoredB();
        assertEquals(true,tennis.isBWinner());
        assertEquals(false,tennis.isAWinner());

        tennis = new Tennis();
        tennis.scoredA();
        tennis.scoredB();
        tennis.scoredA();
        tennis.scoredB();
        tennis.scoredA();
        tennis.scoredB();
        tennis.scoredA();
        assertEquals(false,tennis.isBWinner());
        assertEquals(false,tennis.isAWinner());
    }
    @Test
    public void testAdvantage(){
        Tennis tennis = new Tennis();
        tennis.scoredA();
        tennis.scoredA();
        tennis.scoredA();
        tennis.scoredB();
        tennis.scoredB();
        tennis.scoredB();
        tennis.scoredA();
        assertTrue(tennis.hasAAdvantage());
        assertFalse(tennis.hasBAdvantage());
    }
    @Test
    public void testAdvantageWinA(){
        Tennis tennis = new Tennis();
        tennis.scoredA();
        tennis.scoredA();
        tennis.scoredA();
        tennis.scoredB();
        tennis.scoredB();
        tennis.scoredB();
        tennis.scoredA();
        assertFalse(tennis.isAWinner());
        tennis.scoredA();
        assertTrue(tennis.isAWinner());
    }

    @Test
    public void testAdvantageRemovedIfOtherScores(){
        Tennis tennis = new Tennis();
        tennis.scoredA();
        tennis.scoredA();
        tennis.scoredA();
        tennis.scoredB();
        tennis.scoredB();
        tennis.scoredB();
        tennis.scoredA();
        assertTrue(tennis.hasAAdvantage());
        assertFalse(tennis.hasBAdvantage());
        tennis.scoredB();
        assertEquals(40,tennis.getScoreA());
        assertEquals(40,tennis.getScoreB());
        assertFalse(tennis.hasBAdvantage());
        assertFalse(tennis.hasAAdvantage());
        tennis.scoredB();
        assertTrue(tennis.hasBAdvantage());
        assertFalse(tennis.hasAAdvantage());
        tennis.scoredA();
        assertFalse(tennis.hasBAdvantage());
        assertFalse(tennis.hasAAdvantage());
        assertEquals(40,tennis.getScoreA());
        assertEquals(40,tennis.getScoreB());
    }

    @Test
    public void testNonEqualScores(){
        Tennis tennis = new Tennis();
        tennis.scoredA();
        assertEquals("15 - 0", tennis.showScore());
        tennis.scoredB();
        tennis.scoredA();
        assertEquals("30 - 15", tennis.showScore());
        tennis.scoredB();
        tennis.scoredB();
        assertEquals("30 - 40", tennis.showScore());
    }

    @Test
    public void testAdvantageShowing(){
        Tennis tennis = new Tennis();
        tennis.scoredA();
        tennis.scoredB();
        tennis.scoredA();
        tennis.scoredB();
        tennis.scoredA();
        tennis.scoredB();
        tennis.scoredA();
        assertEquals("A - 40", tennis.showScore());
        tennis.scoredB();
        tennis.scoredB();
        assertEquals("40 - A", tennis.showScore());
    }
    @Test
    public void testEqualScoreShowing(){
        Tennis tennis = new Tennis();
        assertEquals("0 all", tennis.showScore());
        tennis.scoredA();
        tennis.scoredB();
        assertEquals("15 all", tennis.showScore());
        tennis.scoredA();
        tennis.scoredB();
        assertEquals("30 all", tennis.showScore());
    }

    public void testDeuce(){
        Tennis tennis = new Tennis();
        tennis.scoredA();
        tennis.scoredB();
        tennis.scoredA();
        tennis.scoredB();
        tennis.scoredA();
        tennis.scoredB();
        assertEquals("deuce",tennis.showScore());
    }

    public void testWin(){
        Tennis tennis = new Tennis();
        tennis.scoredA();
        tennis.scoredB();
        tennis.scoredA();
        tennis.scoredB();
        tennis.scoredA();
        tennis.scoredA();
        assertEquals("winner: A",tennis.showScore());
        tennis = new Tennis();
        tennis.scoredB();
        tennis.scoredB();
        tennis.scoredB();
        tennis.scoredB();
        assertEquals("winner: B",tennis.showScore());
    }
}
