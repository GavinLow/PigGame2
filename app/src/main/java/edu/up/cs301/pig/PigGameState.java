package edu.up.cs301.pig;

import edu.up.cs301.game.infoMsg.GameState;

/**
 * Created by gavinlow on 3/12/17.
 */

public class PigGameState extends GameState
{
    //Instance Variables
    private int turn;
    private int p0Score;
    private int p1Score;
    private int runningTotal;
    private int dieValue;

    //Constructor
    public PigGameState()
    {
        turn = 0;
        p0Score = 0;
        p1Score = 0;
        runningTotal = 0;
    }

    //Copy Constructor
    public PigGameState(PigGameState orig)
    {
        this.turn = orig.turn;
        this.p0Score = orig.p0Score;
        this.p1Score = orig.p1Score;
        this.runningTotal = orig.runningTotal;
    }

    //Getters
    public int getTurn()
    {
        return turn;
    }

    public int getP0Score()
    {
        return p0Score;
    }

    public int getP1Score()
    {
        return p1Score;
    }

    public int getRunningTotal()
    {
        return runningTotal;
    }

    public int getDieValue()
    {
        return dieValue;
    }


    //Setters

    public void setTurn(int turn)
    {
        this.turn = turn;
    }

    public void setP0Score(int p0Score)
    {
        this.p0Score = p0Score;
    }

    public void setP1Score(int p1Score)
    {
        this.p1Score = p1Score;
    }

    public void setRunningTotal(int runningTotal)
    {
        this.runningTotal = runningTotal;
    }

    public void setDieValue(int dieValue)
    {
        this.dieValue = dieValue;
    }
}
