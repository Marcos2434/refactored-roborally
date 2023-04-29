package dtu.logic.models.Board;

import dtu.logic.models.Cards.ActionCard;
import dtu.logic.models.Cards.ActionCards.ActionCardFactory;
import dtu.logic.models.Cards.ActionCards.ActionCardTypes;
import dtu.logic.models.Cards.ActionCards.FireRain;
import dtu.logic.models.Robot.Robot;

public class TileAction extends Tile {

    public TileAction(TileType type) {
        super(type);
        this.imageString = "tiles/Action.png";
    }

    @Override
    public void effect(Robot robot, BoardController boardController) {
        ActionCard card = ActionCardFactory.createActionCard(ActionCardTypes.getRandomActionType());
        card.action(robot,boardController);
        boardController.notifyNewAction(card);
    }
}
