package com.charlton.applets.base;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public abstract class GameApplet extends Applet implements Runnable, KeyListener, MouseListener, MouseMotionListener {
    Thread t;

    private static final GraphicsConfiguration GFX_CONFIG = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();

    public static BufferedImage toCompatibleImage(final BufferedImage image) {
        /*
         * if image is already compatible and optimized for current system settings, simply return it
         */
        if (image.getColorModel().equals(GFX_CONFIG.getColorModel())) {
            return image;
        }

        // image is not optimized, so create a new image that is
        final BufferedImage new_image = GFX_CONFIG.createCompatibleImage(image.getWidth(), image.getHeight(), image.getTransparency());

        // get the graphics context of the new image to draw the old image on
        final Graphics2D g2d = (Graphics2D) new_image.getGraphics();

        // actually draw the image and dispose of context no longer needed
        g2d.drawImage(image, 0, 0, null);
        g2d.dispose();

        // return the new optimized image
        return new_image;
    }

    protected boolean[] pressing = new boolean[1024];


    public static final int UP = KeyEvent.VK_UP;
    public static final int DN = KeyEvent.VK_DOWN;
    public static final int LT = KeyEvent.VK_LEFT;
    public static final int RT = KeyEvent.VK_RIGHT;

    public static final int _A = KeyEvent.VK_A;
    public static final int _B = KeyEvent.VK_B;
    public static final int _C = KeyEvent.VK_C;
    public static final int _D = KeyEvent.VK_D;
    public static final int _E = KeyEvent.VK_E;
    public static final int _F = KeyEvent.VK_F;
    public static final int _G = KeyEvent.VK_G;
    public static final int _H = KeyEvent.VK_H;
    public static final int _I = KeyEvent.VK_I;
    public static final int _J = KeyEvent.VK_J;
    public static final int _K = KeyEvent.VK_K;
    public static final int _L = KeyEvent.VK_L;
    public static final int _M = KeyEvent.VK_M;
    public static final int _N = KeyEvent.VK_N;
    public static final int _O = KeyEvent.VK_O;
    public static final int _P = KeyEvent.VK_P;
    public static final int _Q = KeyEvent.VK_Q;
    public static final int _R = KeyEvent.VK_R;
    public static final int _S = KeyEvent.VK_S;
    public static final int _T = KeyEvent.VK_T;
    public static final int _U = KeyEvent.VK_U;
    public static final int _V = KeyEvent.VK_V;
    public static final int _W = KeyEvent.VK_W;
    public static final int _X = KeyEvent.VK_X;
    public static final int _Y = KeyEvent.VK_Y;
    public static final int _Z = KeyEvent.VK_Z;

    public static final int _1 = KeyEvent.VK_1;
    public static final int _2 = KeyEvent.VK_2;
    public static final int _3 = KeyEvent.VK_3;
    public static final int _4 = KeyEvent.VK_4;
    public static final int _5 = KeyEvent.VK_5;
    public static final int _6 = KeyEvent.VK_6;
    public static final int _7 = KeyEvent.VK_7;
    public static final int _8 = KeyEvent.VK_8;
    public static final int _9 = KeyEvent.VK_9;

    public static final int CTRL = KeyEvent.VK_CONTROL;
    public static final int SHFT = KeyEvent.VK_SHIFT;
    public static final int ALT = KeyEvent.VK_ALT;

    public static final int SPACE = KeyEvent.VK_SPACE;

    public static final int COMMA = KeyEvent.VK_COMMA;
    public static final int PERIOD = KeyEvent.VK_PERIOD;
    public static final int SLASH = KeyEvent.VK_SLASH;
    public static final int SEMICOLON = KeyEvent.VK_SEMICOLON;
    public static final int COLON = KeyEvent.VK_COLON;
    public static final int QUOTE = KeyEvent.VK_QUOTE;

    /**
     * Mouse Variables
     */
    protected int mx = 0, my = 0;
    private Image off_screen_image;
    private Graphics off_g;

    public void init() {
        off_screen_image = this.createImage(getWidth(), getHeight());
        off_g = off_screen_image.getGraphics();
        requestFocus();
        addKeyListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);
        t = new Thread(this);
        t.start();
    }

    @Override
    public void repaint() {
        update(getGraphics());
    }

    public void update(Graphics g) {
        off_g.clearRect(0, 0, getWidth(), getHeight());

        paint(off_g);

        g.drawImage(off_screen_image, 0, 0, null);
    }

    public void run() {
        while (true) {
            inGameLoop();
            repaint();  // Ask the OS to call paint (but not directly, paint is called via update)
            try {
                t.sleep(16);
            } catch (InterruptedException x) {
            }
            ;
        }
    }

    public void inGameLoop() {
    }

    public void mouseMoved(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }


    public final void keyPressed(KeyEvent e) {
        pressing[e.getKeyCode()] = true;
    }

    public void keyReleased(KeyEvent e) {
        pressing[e.getKeyCode()] = false;
    }

    public final void keyTyped(KeyEvent e) {
    }

}
