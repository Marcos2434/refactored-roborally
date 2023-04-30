package dtu.logic.models.Board;

import dtu.logic.models.Cards.ActionCard;
import dtu.logic.models.Cards.ActionCards.ActionCardFactory;
import dtu.logic.models.Cards.ActionCards.ActionCardTypes;
import dtu.logic.models.Robot.Robot;

public class TileAction extends Tile {
    /*
    The action tile has effects on all robots of the game or the one that stepped on it.
    This is defined in the getRandomActionType method
    */

    public TileAction(TileType type) {
        super(type);
        super.setImageString("tiles/Action.png");
    }

    
    
    @Override
    public void effect(Robot robot, BoardController boardController) {
        ActionCard card = ActionCardFactory.createActionCard(ActionCardTypes.getRandomActionType());
        boardController.notifyNewAction(card);
        card.action(robot,boardController);
        
    }
}
