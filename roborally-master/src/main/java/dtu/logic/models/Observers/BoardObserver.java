package dtu.logic.models.Observers;

import dtu.logic.models.Cards.ActionCard;
import dtu.logic.models.Robot.Lazer;
import dtu.logic.models.Player.Player;

public interface BoardObserver {
    /*
    Interface for all observers of the board
    */
    public void updateNewAction(ActionCard actionCard);
    public void updateLaser(Lazer laser);
    public void updateCardTaken(Player player, String cardImageString);
}
