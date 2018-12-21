package Rooms;

import Game.Runner;
import People.Person;

public class Mine extends Room2
{

    public Mine(int x, int y)
    {
        super(x, y);
    }

    /**
     * Triggers the game ending conditions.
     * @param x the Person entering
     */
    @Override
    public void enterRoom(Person x)
    {
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        System.out.println("The mine you stepped on suddenly sent you back to the starting point.");
        Runner.mineReset();
    }


}
