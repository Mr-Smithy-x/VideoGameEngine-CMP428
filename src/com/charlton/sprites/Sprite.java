package com.charlton.sprites;

import com.charlton.contracts.Drawable;
import com.charlton.helpers.Camera;
import com.charlton.models.MovableObject;

import java.awt.*;

public class Sprite extends MovableObject implements Drawable {

    private int action = 0;
    private boolean moving = false;
    private Animation[] anim;

    public static final int UP = 0;
    public static final int DOWN = 1;
    public static final int LEFT = 2;
    public static final int RIGHT = 3;
    public static final int JUMP = 4;



    @Override
    public void draw(Graphics g) {
        if(moving)
            g.drawImage(anim[action].getCurrentImage(), (int)position_x - (int) Camera.getX(), (int)position_y, null);
        else
            g.drawImage(anim[action].getStillImage(), (int)position_x - (int)Camera.getX(), (int)position_y, null);
        moving = false;
    }



    public Sprite(int x, int y, String[] poses, int count, int duration)
    {
        this.position_x = x;
        this.position_y = y;
        anim = new Animation[poses.length];
        for(int i = 0; i < poses.length; i++)
            anim[i] = new Animation(poses[i] + "_" + i, count, duration);
    }


    public void moveUp(int dist)
    {
        position_y -= dist;
        action = UP;
        moving = true;
    }

    public void moveDown(int dist)
    {
        position_y += dist;
        action = DOWN;
        moving = true;
    }

    public void moveLeft(int dist)
    {
        position_x -= dist;
        action = LEFT;
        moving = true;
    }

    public void moveRight(int dist)
    {
        position_x += dist;
        action = RIGHT;
        moving = true;
    }

    @Override
    public int getType() {
        return TYPE_POLY;
    }
}