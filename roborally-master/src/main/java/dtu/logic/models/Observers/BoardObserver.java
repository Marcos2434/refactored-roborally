package dtu.logic.models.Observers;

import dtu.logic.models.Cards.ActionCard;
import dtu.logic.models.Robot.Lazer;

public interface BoardObserver {
    public void updateNewAction(ActionCard actionCard);
    public void updateLaser(Lazer laser);
}
