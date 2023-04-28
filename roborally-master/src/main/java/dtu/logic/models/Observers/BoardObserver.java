package dtu.logic.models.Observers;

import dtu.logic.models.Cards.ActionCard;
import dtu.logic.models.Player.Player;

public interface BoardObserver {
    public void updateNewAction(ActionCard actionCard);

    public void updateCardTaken(Player player, String cardImageString);
}
