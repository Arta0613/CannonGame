package com.rushlimit.cannongame;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by aminm on 5/9/16.
 */
public class GameElement {
    protected CannonView view;
    protected Paint paint = new Paint();
    protected Rect shape;
    private float velocityY;
    private int soundId;

    public GameElement(CannonView view, int color, int soundId,
                       int x, int y, int width, int length, float velocityY) {
        this.view = view;
        paint.setColor(color);
        shape = new Rect(x, y, x + width, y + length);
        this.soundId = soundId;
        this.velocityY = velocityY;
    }

    // Update GameElement position and check for wall collisions
    public void update(double interval) {
        // Update vertical position
        shape.offset(0, (int) (velocityY * interval));

        // If this GameElement collides with the wall, reverse direction
        if (shape.top < 0 && velocityY < 0 || shape.bottom > view.getScreenHeight() && velocityY > 0) {
            velocityY *= -1; // Reverse this GameElement's velocity
        }
    }

    public void draw(Canvas canvas) {
        canvas.drawRect(shape, paint);
    }

    public void playSound() {
        view.playSound(soundId);
    }
}
