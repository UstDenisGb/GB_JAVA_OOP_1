package OOPseminar2_2;

import OOPseminar2.Actor;

import java.util.ArrayList;
import java.util.List;

public class Market implements MarketBehavior, QueueBehavior {

    private List<Actor> queue;

    @Override
    public void acceptToMarket(Actor actor) {
        System.out.println(actor.getName() + " пришел в магазин");
        takeInQueue(actor);
    }

    @Override
    public void takeInQueue(Actor actor) {
        System.out.println(actor.getName() + " встал в очередь");
        this.queue.add(actor);
    }

    @Override
    public void takeOrders() {
        for (Actor actor : queue) {
            if (!actor.isMakeOrder()) {
                actor.setMakeOrder(true);
                System.out.println(actor.getName() + " сделал свой заказ");
            }
        }
    }

    @Override
    public void giveOrders() {
        for (Actor actor : queue) {
            if (actor.isMakeOrder()) {
                actor.setTakeOrder(true);
                System.out.println(actor.getName() + " получил свой заказ");
            }
        }
    }

    @Override
    public void releaseFromQueue() {
        List<Actor> releasesActors = new ArrayList<>();
        for (Actor actor : queue) {
            if (actor.isTakeOrder()) {
                releasesActors.add(actor);
                System.out.println(actor.getName() + " вышел из очереди и готов уходить");
            }
        }
        releaseFromMarket(releasesActors);
    }

    @Override
    public void releaseFromMarket(List<Actor> actors) {
        for (Actor actor : actorList) {
            System.out.println(actor.getName() + " вышел из магазина");
            queue.remove(actor);
            }
        }
    @Override
    public void update() {
        takeOrders();
        giveOrders();
        releaseFromQueue();
    }
    }
