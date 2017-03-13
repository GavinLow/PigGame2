package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameState;

import android.util.Log;

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {

    PigGameState state;

    /**
     * This ctor creates a new game state
     */
    public PigLocalGame()
    {
        state = new PigGameState();
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx)
    {
        return playerIdx == state.getTurn();
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action)
    {
       if(action instanceof PigRollAction)
       {
           int dieValue = (int)(Math.random()*5)+1;
           if(dieValue != 1)
           {
               state.setRunningTotal(state.getRunningTotal() + dieValue);
           }
           else
           {
               state.setRunningTotal(0);
               if(state.getTurn() == 0)
               {
                   state.setTurn(1);

               }
               else
               {
                   state.setTurn(0);
               }
           }
           return true;
       }
       else if(action instanceof PigHoldAction)
       {
           int turn = state.getTurn();
           if(turn == 0)
           {
               state.setP0Score(state.getP0Score()+state.getRunningTotal());
               state.setRunningTotal(0);
           }
           else
           {
               state.setP1Score(state.getP1Score()+state.getRunningTotal());
               state.setRunningTotal(0);
           }

           if(state.getTurn() == 0)
           {
               state.setTurn(1);

           }
           else
           {
               state.setTurn(0);
           }

           return true;
       }
        else
       {
           return false;

       }
    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p)
    {
        if(state == null)
        {
            return;
        }

        PigGameState stateForPlayer = new PigGameState(state);

        p.sendInfo(stateForPlayer);

    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver()
    {
        if(state.getP0Score() >= 50)
        {
            return "player 0 has won with " +state.getP0Score();
        }
        else if(state.getP1Score() >= 50)
        {
            return "player 1 has won with " + state.getP1Score();
        }
        else
        {
            return null;
        }
    }

}// class PigLocalGame
