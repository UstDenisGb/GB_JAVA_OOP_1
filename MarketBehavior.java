package OOPseminar2_2;

import OOPseminar2.Actor;

import java.util.List;

public interface MarketBehavior {

    void acceptToMarket(Actor actor);
    void releaseFromMarket(List<Actor> actors);
    void update();

}
