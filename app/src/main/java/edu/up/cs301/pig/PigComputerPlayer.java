package edu.up.cs301.pig;

import java.util.Map;

import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameInfo;
import edu.up.cs301.game.infoMsg.NotYourTurnInfo;
import edu.up.cs301.game.util.Tickable;

/**
 * An AI for Pig
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */


public class PigComputerPlayer extends GameComputerPlayer {

    private PigGameState savedState;

    /**
     * ctor does nothing extra
     */
    public PigComputerPlayer(String name) {
        super(name);
    }

    /**
     * callback method--game's state has changed
     *
     * @param info
     * 		the information (presumably containing the game's state)
     */
    @Override
    protected void receiveInfo(GameInfo info)
    {
        if(info instanceof NotYourTurnInfo)
        {
            return;
        }

        savedState = (PigGameState)info;

        double action = Math.random();
        if(action < 0.5)
        {
            game.sendAction(new PigHoldAction(this));
        }
        else
        {
            game.sendAction(new PigRollAction(this));
        }

    }//receiveInfo

}
