package com.rushlimit.cannongame;

/**
 * Created by aminm on 5/9/16.
 */
public class Target extends GameElement {
    private int hitReward;

    public Target(CannonView view, int color, int hitReward,
                  int x, int y, int width, int length, float velocityY) {
        super(view, color, hitReward, x, y, width, length, velocityY);
        this.hitReward = hitReward;
    }

    public int getHitReward() {
        return hitReward;
    }
}
