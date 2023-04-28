package dtu.logic.models.Observers;

import dtu.logic.models.Cards.ActionCard;

public interface BoardObserver {
    public void updateNewAction(ActionCard actionCard);
}
