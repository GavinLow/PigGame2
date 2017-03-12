package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.actionMsg.GameAction;

/**
 * Created by gavinlow on 3/12/17.
 */

public class PigHoldAction extends GameAction
{
    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     */
    public PigHoldAction(GamePlayer player)
    {
        super(player);
    }

    public boolean isHold()
    {
        return false;
    }
}
