package com.charlton.game.models.base.model2d;

import com.charlton.game.models.base.model2d.contracts.AI2D;

public abstract class AIObject2D extends GravitationalObject2D implements AI2D {

    @Override
    public void setChaseSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public void setTurnSpeed(int turnspeed) {
        this.turnspeed = turnspeed;
    }
}
