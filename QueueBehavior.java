package OOPseminar2_2;

import OOPseminar2.Actor;

public interface QueueBehavior {

    void takeInQueue(Actor actor);
    void takeOrders();
    void giveOrders();
    void releaseFromQueue();
}
