import javax.swing.*;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;
import java.awt.event.*;
import java.util.Hashtable;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.*;

class random {
    ArrayList<Integer> list = new ArrayList<>();
    public random() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
    }
    public void addToList(int num) {
        if(!list.contains(num)) {
            list.add(num);
        }
    }
    public int getRandomElement()
    {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }
}

public class Main extends Frame {
    public static void main(String[] args) {
        new Main();
    }
    Main() {
        super("Tetris Assignment 3");
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        setSize(600, 600);
        add("Center", new CvTetris(this));
        setVisible(true);
//        show();
    }
}
class Brick {
    int brick_type;
    public Brick(int brick_type) {
        this.brick_type = brick_type;
    }
    int x,y;
    public void setLocation(int locationx, int locationy) {
        x = locationx;
        y = locationy;
    }
    public int getLocationx() {
        return x;
    }
    public int getLocationy() {
        return y;
    }
    public int getType() {
        return brick_type;
    }
    int orientation;
    public void setDirection(int orientation) {
        this.orientation = orientation;
    }
    int[][] b_array = new int[4][2];
    public void setb_array(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4)
    {
        b_array[0][0] = x1;
        b_array[0][1] = y1;
        b_array[1][0] = x2;
        b_array[1][1] = y2;
        b_array[2][0] = x3;
        b_array[2][1] = y3;
        b_array[3][0] = x4;
        b_array[3][1] = y4;
    }
    public void setBricks() {
        switch (brick_type) {
            case 1: switch (orientation) {
                case 0:setb_array(x,y,x,y - 1,x - 1,y,x + 1,y - 1);
                    break;
                case 1:setb_array(x,y,x,y - 1,x + 1,y,x + 1,y + 1);
                    break;
                case 2:setb_array(x,y-1,x,y - 2,x - 1,y-1,x + 1,y - 2);
                    break;
                case 3:setb_array(x-1,y,x-1,y - 1,x,y,x,y + 1);
                    break;
            }
                break;
            case 2: switch (orientation) {
                case 0:setb_array(x,y,x,y - 1,x - 1,y-1,x + 1,y);
                    break;
                case 1:setb_array(x,y,x,y + 1,x + 1,y,x + 1,y - 1);
                    break;
                case 2:setb_array(x,y+1,x,y,x - 1,y,x + 1,y + 1);
                    break;
                case 3:setb_array(x-1,y,x-1,y + 1,x,y,x,y - 1);
                    break;
            }
                break;
            case 3: switch (orientation) {
                case 0:setb_array(x,y,x+2,y + 1,x,y+1,x + 1,y + 1);
                    break;
                case 1:setb_array(x+1,y,x+2,y,x + 1,y+2,x + 1,y + 1);
                    break;
                case 2:setb_array(x+2,y+2,x+2,y + 1,x,y+1,x + 1,y + 1);
                    break;
                case 3:setb_array(x+1,y,x,y +2,x + 1,y+2,x + 1,y + 1);
                    break;
            }
                break;
            case 4: switch (orientation) {
                case 0:setb_array(x+2,y,x+2,y + 1,x,y+1,x + 1,y + 1);
                    break;
                case 1:setb_array(x+1,y,x+2,y + 2,x+1,y+2,x + 1,y + 1);
                    break;
                case 2:setb_array(x,y+2,x+2,y + 1,x,y+1,x + 1,y + 1);
                    break;
                case 3:setb_array(x+1,y,x,y,x+1,y+2,x + 1,y + 1);
                    break;
            }
                break;
            case 5: setb_array(x,y,x+1,y,x,y+1,x + 1,y + 1);
                break;
            case 6: switch (orientation) {
                case 0:setb_array(x+1,y,x+2,y + 1,x,y+1,x + 1,y + 1);
                    break;
                case 1:setb_array(x+1,y,x+2,y + 1,x+1,y+2,x + 1,y + 1);
                    break;
                case 2:setb_array(x,y+1,x+2,y + 1,x+1,y+2,x + 1,y + 1);
                    break;
                case 3:setb_array(x,y+1,x+1,y,x+1,y+2,x + 1,y + 1);
                    break;
            }
                break;
            case 7: switch (orientation) {
                case 0:setb_array(x+3,y+1,x+2,y + 1,x,y+1,x + 1,y + 1);
                    break;
                case 1:setb_array(x+3,y,x+3,y + 1,x+3,y+2,x + 3,y + 3);
                    break;
                case 2:setb_array(x+3,y+2,x+2,y + 2,x,y+2,x + 1,y + 2);
                    break;
                case 3:setb_array(x+2,y,x+2,y + 1,x+2,y+2,x + 2,y + 3);
                    break;
            }
                break;
            case 8:setb_array(x,y,x+1,y,x,y-1,x,y);
                break;
            case 9:setb_array(x+1,y,x+1,y,x-1,y-1,x,y);
                break;
            case 10:setb_array(x,y,x+1,y - 1,x,y,x,y);
                break;
            case 11:setb_array(x+1,y,x+1,y,x-1,y,x,y);
                break;
            case 12:setb_array(x,y,x,y,x,y-1,x,y);
                break;
            case 13:setb_array(x,y,x,y,x,y,x,y);
                break;
            case 14:setb_array(x,y,x,y,x-1,y+1,x + 1,y-1);
                break;
            case 15: switch (orientation) {
                case 0:setb_array(x,y,x+1,y - 1,x+2,y,x,y);
                    break;
                case 1:setb_array(x,y,x+1,y-1,x-1,y-1,x,y);
                    break;
                case 2:setb_array(x,y,x-1,y + 1,x-1,y-1,x,y);
                    break;
                case 3:setb_array(x,y-2,x-1,y - 1,x,y,x,y);
                    break;
            }
                break;
        }}
}
class updating {
    static int width=13,length =25, brick_size = 10,M = 10,N = 20,lines = 0,level = 1,score = 0;
    static float S = 0.1f;
}
class CvTetris extends Canvas {
    static class GameTimerTask extends TimerTask {
        CvTetris c;
        GameTimerTask(CvTetris c) {
            super();
            this.c = c;
        }
        @Override
        public void run() {
            c.fall();
        }
    }
    int centerX, centerY;
    float pixelSize, rWidth = 400.0F, rHeight = 400.0F, xP, yP, xM, yM;
    boolean j_m_area = false,j_m_area_now = false, j_brick = false,j_brick_now = false;
    public void setmain_arena_row(boolean j_m_area_now) {
        if (this.j_m_area_now != j_m_area_now) {
            if (j_m_area_now) {
                if (t != null) {
                    t.cancel();
                    t = null;
                }
            } else {
                t = new Timer();
                float interval = (float) 1000 / (1f + updating.S * (float) updating.level);
                t.scheduleAtFixedRate(new GameTimerTask(this), 0, (int) interval);
            }
            this.j_m_area_now = j_m_area_now; } }
    random r = new random();
    int m_rand = r.getRandomElement();
    int n_rand = r.getRandomElement();
    int m_brick_x = 2,m_brick_y = 1;
    Brick m_brick;
    Timer t;
    boolean bttm = false;
    int fallarea[][] = new int[ updating.width][updating.length + 1];
    int orientation = 0;
    int m_area[][] = new int[updating.width][updating.length];
    CvTetris(Frame f) {
        this.f = f;
        addMouseWheelListener(new MouseAdapter() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                super.mouseWheelMoved(e);
                if (bttm)
                    return;
                if (j_m_area)
                    return;
                for (int x = 0; x < 4; x++) {
                    if (m_brick.b_array[x][0] == 0 || m_brick.b_array[x][0] == updating.width - 1) {
                        return;
                    }
                }
                if (e.getWheelRotation() < 0) {
                    orientation = (orientation + 1);
                    if (orientation < 0) {
                        orientation = orientation + 4;
                    }
                    orientation = orientation % 4;
                    m_brick.setLocation(m_brick_x, m_brick_y);
                    m_brick.setBricks();
                    repaint();
                } else {
                    orientation = (orientation - 1);
                    if (orientation < 0) {
                        orientation = orientation + 4;
                    }
                    orientation = orientation % 4;
                    m_brick.setLocation(m_brick_x, m_brick_y);
                    m_brick.setBricks();
                    repaint();
                }
            }
        });
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                int buttonFlag = e.getButton();
                xP = e.getX();
                yP = e.getY();
                if ((xP < iX(80)) && (xP > iX(20)) && (yP < iY(-100)) && (yP > iY(-80)))
                    System.exit(0);
                else if((xP < iX(130)) && (xP > iX(110)) && (yP < iY(75)) && (yP > iY(85)))
                    r.addToList(8);
                else if((xP < iX(165)) && (xP > iX(145)) && (yP < iY(75)) && (yP > iY(85)))
                    r.addToList(9);
                else if((xP < iX(130)) && (xP > iX(110)) && (yP < iY(25)) && (yP > iY(35)))
                    r.addToList(10);
                else if((xP < iX(170)) && (xP > iX(146)) && (yP < iY(25)) && (yP > iY(35)))
                    r.addToList(11);
                else if((xP < iX(132)) && (xP > iX(112)) && (yP < iY(-40)) && (yP > iY(-30)))
                    r.addToList(12);
                else if((xP < iX(170)) && (xP > iX(150)) && (yP < iY(-40)) && (yP > iY(-30)))
                    r.addToList(13);
                else if((xP < iX(120)) && (xP > iX(110)) && (yP < iY(-110)) && (yP > iY(-100)))
                    r.addToList(14);
                else if((xP < iX(170)) && (xP > iX(150)) && (yP < iY(-110)) && (yP > iY(-100)))
                    r.addToList(15);
                else if((xP < iX(80)) && (xP > iX(20)) && (yP < iY(-70)) && (yP > iY(-50))){
                    setmain_arena_row(true);
                    showNewGameDialog();
                }
                else if ((xM < iX(0)) && (xM > iX(-updating.width * updating.brick_size)) && (yM < iY(-updating.length * updating.brick_size / 2)) && (yM > iY(updating.length * updating.brick_size / 2)))
                    return;
                else {
                    switch (buttonFlag) {
                        case MouseEvent.BUTTON1:
                            if (bttm)
                                return;
                            for (int x = 0; x < 4; x++) {
                                if (m_brick.b_array[x][0] == 0)
                                    return;
                            }
                            m_brick_x = m_brick_x - 1;
                            m_brick.setLocation(m_brick_x, m_brick_y);
                            m_brick.setBricks();
                            boolean repaintjudge = true;
                            if (repaintjudge) {
                                repaint();
                            }
                            break;
                        case MouseEvent.BUTTON3:
                            if (bttm) {
                                return;
                            }
                            for (int x = 0; x < 4; x++) {
                                if (m_brick.b_array[x][0] == updating.width - 1) {
                                    return;
                                }
                            }
                            m_brick_x = m_brick_x + 1;
                            m_brick.setLocation(m_brick_x, m_brick_y);
                            m_brick.setBricks();
                            repaint();
                            break;
                    }
                }
            }
        });
        addMouseMotionListener(new MouseAdapter() {
            public void mouseMoved(MouseEvent evtM) {
                if (bttm)
                    return;
                if (m_brick != null) {
                    xM = evtM.getX();
                    yM = evtM.getY();
                    if ((xM < iX(0)) && (xM > iX(-updating.width * updating.brick_size)) && (yM < iY(-updating.length * updating.brick_size / 2)) && (yM > iY(updating.length * updating.brick_size / 2))) {
                        j_m_area = true;
                        if (j_m_area_now != j_m_area) {
                            repaint();
                            setmain_arena_row(j_m_area);
                        }
                    } else {
                        j_m_area = false;
                        if (j_m_area_now != j_m_area) {
                            repaint();
                            setmain_arena_row(j_m_area);
                        } }
                    int ax1 = m_brick.b_array[0][0];
                    int ay1 = m_brick.b_array[0][1];
                    int ax2 = m_brick.b_array[1][0];
                    int ay2 = m_brick.b_array[1][1];
                    int ax3 = m_brick.b_array[2][0];
                    int ay3 = m_brick.b_array[2][1];
                    int ax4 = m_brick.b_array[3][0];
                    int ay4 = m_brick.b_array[3][1];
                    int b_x1 = -updating.width * updating.brick_size + updating.brick_size * ax1;
                    int b_y1 = updating.length * updating.brick_size / 2 - updating.brick_size * ay1;
                    int b_x2 = -updating.width * updating.brick_size + updating.brick_size * ax2;
                    int b_y2 = updating.length * updating.brick_size / 2 - updating.brick_size * ay2;
                    int b_x3 = -updating.width * updating.brick_size + updating.brick_size * ax3;
                    int b_y3 = updating.length * updating.brick_size / 2 - updating.brick_size * ay3;
                    int b_x4 = -updating.width * updating.brick_size + updating.brick_size * ax4;
                    int b_y4 = updating.length * updating.brick_size / 2 - updating.brick_size * ay4;
                    if (((xM > iX(b_x1)) && (xM < iX(b_x1 + updating.brick_size)) && (yM < iY(b_y1 - updating.brick_size)) && (yM > iY(b_y1)))
                            || ((xM > iX(b_x2)) && (xM < iX(b_x2 + updating.brick_size)) && (yM < iY(b_y2 - updating.brick_size)) && (yM > iY(b_y2)))
                            || ((xM > iX(b_x3)) && (xM < iX(b_x3 + updating.brick_size)) && (yM < iY(b_y3 - updating.brick_size)) && (yM > iY(b_y3)))
                            || ((xM > iX(b_x4)) && (xM < iX(b_x4 + updating.brick_size)) && (yM < iY(b_y4 - updating.brick_size)) && (yM > iY(b_y4)))) {
                        j_brick = true;
                        if (j_brick != j_brick_now) {
                            updating.score = updating.score - updating.level * updating.M;
                            int temporary;
                            do {
                                temporary = r.getRandomElement();
                            }

                            while (temporary == m_rand || temporary == n_rand);
                            m_rand = temporary;
                            m_brick.setBricks();
                            repaint();
                            j_brick_now = true;
                        }
                    } else
                        j_brick_now = false;
                }
            }
        });
        t = new Timer();
        float interval = (float) 1000 / (1f + updating.S * (float) updating.level);
        t.scheduleAtFixedRate(new GameTimerTask(this), 0, (int) interval);
    }
    public void fall() {
        if (m_brick == null)
            return;
        if (bttm)
            return;
        m_brick_y = m_brick_y + 1;
        m_brick.setLocation(m_brick_x, m_brick_y);
        m_brick.setBricks();
        m_brick.setDirection(orientation);
        for (int x = 0; x < 4; x++) {
            if (fallarea[m_brick.b_array[x][0]][m_brick.b_array[x][1]] != 0) {
                bttm = true;
                m_brick_y = m_brick_y - 1;
                m_brick.setLocation(m_brick_x, m_brick_y);
                m_brick.setBricks();
                m_brick.setDirection(orientation);
                for (int y = 0; y < 4; y++) {
                    fallarea[m_brick.b_array[y][0]][m_brick.b_array[y][1]] = m_brick.brick_type;
                }
                for (int a = 0; a <  updating.width; a++) {
                    for (int b = 0; b <  updating.length; b++) {
                        m_area[a][b] = 0;
                    }
                }
                boolean check = true;
                for (int i = updating.length - 1; i > 0; i--) {

                    for (int z = 0; z < updating.width; z++) {
                        if (fallarea[z][i] == 0) {
                            check = false;
                            break;
                        }
                    }
                    if (check) {
                        updating.lines++;
                        if (updating.lines == updating.N) {
                            updating.lines = updating.lines - updating.N;
                            updating.level++;
                        }
                        updating.score = updating.score + updating.level * updating.M;
                        for (int k = i; k > 0; k--)
                            for (int z = 0; z < updating.width; z++)
                                if (k == 0) {
                                    fallarea[z][k] = 0;
                                } else {
                                    fallarea[z][k] = fallarea[z][k - 1];
                                }
                        i++;
                        System.out.println(i);
                    }
                    check = true;
                }
                for (int top = 0; top < updating.width; top++) {
                    if (fallarea[top][1] != 0) {
                        System.out.println("Game Over");
                        System.exit(0);
                    }
                }
                m_brick_x = 2;
                m_brick_y = 1;
                orientation = 0;
                m_rand = n_rand;
                n_rand = r.getRandomElement();
                m_brick.setLocation(m_brick_x, m_brick_y);
                m_brick.setBricks();
                m_brick.setDirection(orientation);
                bttm = false;
                break; }
        }
        boolean repaint_j = true;
        if (repaint_j) {
            repaint();
        }
    }
    public void upcoming(int[][] area, int x1, int x2, int x3, int x4, int y1, int y2, int y3, int y4, int j_brick_now)
    {
        area[x1][y1] = j_brick_now;
        area[x2][y2] = j_brick_now;
        area[x3][y3] = j_brick_now;
        area[x4][y4] = j_brick_now;
    }
    void initgr() {
        Dimension d = getSize();
        int maxX = d.width - 1, maxY = d.height - 1;
        pixelSize = Math.max(rWidth / maxX, rHeight / maxY);
        centerX = maxX / 2;
        centerY = maxY / 2;
    }
    int iX(float x) {
        return Math.round(centerX + x / pixelSize);
    }
    int iY(float y) {
        return Math.round(centerY - y / pixelSize);
    }
    int iL(float l) {
        return Math.round(l / pixelSize);
    }

    int iF(float f) {
        return Math.round(f / pixelSize);
    }
    public void drawrect(Graphics g, int tx,int ty, int bx,int by,int rtx,int rty, int rbx, int rby ){
        System.out.println("My code starts : Yay");
        g.drawLine(tx, ty, bx, by);
        g.drawLine(rtx, rty, rbx, rby);
        g.drawLine(tx,ty, rtx, rty);
        g.drawLine(bx, by, rbx,rby);
    }

    public void dropArea()
    {
        for (int x = 0; x < updating.width; x++) {
            fallarea[x][ updating.length] = 7;
            fallarea[x][ updating.length] = 7;
        }
    }

    public void paint(Graphics g) {
        initgr();
        dropArea();
        drawrect(g, iX(-updating.width * updating.brick_size),iY(updating.length * updating.brick_size / 2), iX(-updating.width * updating.brick_size),
                iY(-updating.length * updating.brick_size / 2),iX(0),iY(updating.length * updating.brick_size / 2),iX(0),iY(-updating.length * updating.brick_size / 2));
        drawrect(g,iX(20), iY(110), iX(20), iY(60),iX(100),iY(110),iX(100),iY(60));
        drawrect(g,iX(20), iY(-80), iX(20), iY(-100),iX(80),iY(-80),iX(80),iY(-100));
        drawrect(g,iX(20), iY(-50), iX(20), iY(-70),iX(80),iY(-50),iX(80),iY(-70));
        int m_area[][] = new int[ updating.width][ updating.length];
        this.m_brick = new Brick(m_rand);
        m_brick.setLocation(m_brick_x, m_brick_y);
        int brick_type = m_brick.getType();
        m_brick.setDirection(orientation);
        m_brick.setBricks();
        upcoming(m_area, m_brick.b_array[0][0], m_brick.b_array[1][0], m_brick.b_array[2][0], m_brick.b_array[3][0],
                m_brick.b_array[0][1], m_brick.b_array[1][1],m_brick.b_array[2][1],m_brick.b_array[3][1], brick_type);
        for (int fallareax = 0; fallareax < updating.width; fallareax++)
            for (int fallareay = 0; fallareay < updating.length; fallareay++) {
                if (fallarea[fallareax][fallareay] != 0) {
                    int brick_x = - updating.width *  updating.brick_size +  updating.brick_size * fallareax;
                    int brick_y =  updating.length *  updating.brick_size / 2 - updating.brick_size * fallareay;
                    switch (fallarea[fallareax][fallareay]) {
                        case 1:
                            g.setColor(Color.YELLOW);
                            break;
                        case 2:
                            g.setColor(new Color(127, 0, 255));
                            break;
                        case 3:
                            g.setColor(new Color(0, 102, 204));
                            break;
                        case 4:
                            g.setColor(Color.red);
                            break;
                        case 5:
                            g.setColor(new Color(0, 153, 0));
                            break;
                        case 6:
                            g.setColor(new Color(204, 102, 0));
                            break;
                        case 7:
                            g.setColor(Color.blue);
                            break;
                        case 8:
                            g.setColor(Color.black);
                            break;
                        case 9:
                            g.setColor(new Color(41, 163, 41));
                            break;
                        case 10:
                            g.setColor(new Color(255, 153, 0));
                            break;
                        case 11:
                            g.setColor(new Color(255, 102, 153));
                            break;
                        case 12:
                            g.setColor(new Color(51, 153, 102));
                            break;
                        case 13:
                            g.setColor(new Color(0, 0, 102));
                            break;
                        case 14:
                            g.setColor(new Color(51, 102, 153));
                            break;
                        case 15:
                            g.setColor(new Color(102, 102, 51));
                            break;
                    }
                    g.fillRect(iX(brick_x), iY(brick_y), iL(updating.brick_size), iL(updating.brick_size));
                    g.setColor(Color.black);
                    g.drawRect(iX(brick_x), iY(brick_y), iL(updating.brick_size), iL(updating.brick_size));
                }
            }
        for (int ax = 0; ax <  updating.width; ax++)
            for (int ay = 0; ay <  updating.length; ay++) {
                if (m_area[ax][ay] != 0) {
                    int brick_x = - updating.width *  updating.brick_size +  updating.brick_size * ax;
                    int brick_y = updating.length *  updating.brick_size / 2 - updating.brick_size * ay;
                    switch (m_area[ax][ay]) {
                        case 1:
                            g.setColor(Color.YELLOW);
                            break;
                        case 2:
                            g.setColor(new Color(127, 0, 255));
                            break;
                        case 3:
                            g.setColor(new Color(0, 102, 204));
                            break;
                        case 4:
                            g.setColor(Color.red);
                            break;
                        case 5:
                            g.setColor(new Color(0, 153, 0));
                            break;
                        case 6:
                            g.setColor(new Color(204, 102, 0));
                            break;
                        case 7:
                            g.setColor(Color.blue);
                            break;
                        case 8:
                            g.setColor(Color.black);
                            break;
                        case 9:
                            g.setColor(new Color(41, 163, 41));
                            break;
                        case 10:
                            g.setColor(new Color(255, 153, 0));
                            break;
                        case 11:
                            g.setColor(new Color(255, 102, 153));
                            break;
                        case 12:
                            g.setColor(new Color(51, 153, 102));
                            break;
                        case 13:
                            g.setColor(new Color(0, 0, 102));
                            break;
                        case 14:
                            g.setColor(new Color(51, 102, 153));
                            break;
                        case 15:
                            g.setColor(new Color(102, 102, 51));
                            break;
                    }
                    g.fillRect(iX(brick_x), iY(brick_y), iL(updating.brick_size), iL(updating.brick_size));
                    g.setColor(Color.black);
                    g.drawRect(iX(brick_x), iY(brick_y), iL(updating.brick_size), iL(updating.brick_size));
                }
            }
        int upcoming_arena[][] = new int[8][4];
        Brick nextbrick = new Brick(n_rand);
        nextbrick.setLocation(2, 1);
        int upcoming_type = nextbrick.getType();
        int upcoming_brick_x = nextbrick.getLocationx();
        int upcoming_brick_y = nextbrick.getLocationy();
        switch (upcoming_type) {
            case 1: upcoming(upcoming_arena, upcoming_brick_x, upcoming_brick_x+1, upcoming_brick_x-1, upcoming_brick_x, upcoming_brick_y, upcoming_brick_y,upcoming_brick_y+1,upcoming_brick_y+1, upcoming_type);
                break;
            case 2: upcoming(upcoming_arena, upcoming_brick_x, upcoming_brick_x+1, upcoming_brick_x+1, upcoming_brick_x+2, upcoming_brick_y, upcoming_brick_y,upcoming_brick_y+1,upcoming_brick_y+1, upcoming_type);
                break;
            case 3: upcoming(upcoming_arena, upcoming_brick_x, upcoming_brick_x+2, upcoming_brick_x, upcoming_brick_x+1, upcoming_brick_y, upcoming_brick_y+1,upcoming_brick_y+1,upcoming_brick_y+1, upcoming_type);
                break;
            case 4: upcoming(upcoming_arena, upcoming_brick_x+2, upcoming_brick_x+2, upcoming_brick_x, upcoming_brick_x+1, upcoming_brick_y, upcoming_brick_y+1,upcoming_brick_y+1,upcoming_brick_y+1, upcoming_type);
                break;
            case 5: upcoming(upcoming_arena, upcoming_brick_x, upcoming_brick_x+1, upcoming_brick_x, upcoming_brick_x+1, upcoming_brick_y, upcoming_brick_y,upcoming_brick_y+1,upcoming_brick_y+1, upcoming_type);
                break;
            case 6: upcoming(upcoming_arena, upcoming_brick_x+1, upcoming_brick_x+2, upcoming_brick_x, upcoming_brick_x+1, upcoming_brick_y, upcoming_brick_y+1,upcoming_brick_y+1,upcoming_brick_y+1, upcoming_type);
                break;
            case 7: upcoming(upcoming_arena, upcoming_brick_x+3, upcoming_brick_x+2, upcoming_brick_x, upcoming_brick_x+1, upcoming_brick_y, upcoming_brick_y,upcoming_brick_y,upcoming_brick_y, upcoming_type);
                break;
            case 8: upcoming(upcoming_arena, upcoming_brick_x, upcoming_brick_x+1, upcoming_brick_x, upcoming_brick_x, upcoming_brick_y, upcoming_brick_y,upcoming_brick_y-1,upcoming_brick_y, upcoming_type);
                break;
            case 9:upcoming(upcoming_arena, upcoming_brick_x+1, upcoming_brick_x+1, upcoming_brick_x-1, upcoming_brick_x, upcoming_brick_y, upcoming_brick_y,upcoming_brick_y-1,upcoming_brick_y, upcoming_type);
                break;
            case 10: upcoming(upcoming_arena, upcoming_brick_x, upcoming_brick_x+1, upcoming_brick_x, upcoming_brick_x,upcoming_brick_y, upcoming_brick_y-1,upcoming_brick_y,upcoming_brick_y, upcoming_type);
                break;
            case 11: upcoming(upcoming_arena, upcoming_brick_x+1, upcoming_brick_x+1, upcoming_brick_x-1, upcoming_brick_x, upcoming_brick_y, upcoming_brick_y,upcoming_brick_y,upcoming_brick_y, upcoming_type);
                break;
            case 12: upcoming(upcoming_arena, upcoming_brick_x, upcoming_brick_x, upcoming_brick_x, upcoming_brick_x, upcoming_brick_y, upcoming_brick_y,upcoming_brick_y-1,upcoming_brick_y, upcoming_type);
                break;
            case 13: upcoming(upcoming_arena, upcoming_brick_x, upcoming_brick_x, upcoming_brick_x, upcoming_brick_x, upcoming_brick_y, upcoming_brick_y,upcoming_brick_y,upcoming_brick_y, upcoming_type);
                break;
            case 14: upcoming(upcoming_arena, upcoming_brick_x, upcoming_brick_x, upcoming_brick_x-1, upcoming_brick_x+1, upcoming_brick_y, upcoming_brick_y,upcoming_brick_y+1,upcoming_brick_y-1, upcoming_type);
                break;
            case 15: upcoming(upcoming_arena, upcoming_brick_x, upcoming_brick_x+1, upcoming_brick_x+2, upcoming_brick_x, upcoming_brick_y, upcoming_brick_y-1,upcoming_brick_y,upcoming_brick_y, upcoming_type);
                break;
        }
        for (int ax = 0; ax < 8; ax++)
            for (int ay = 0; ay < 4; ay++) {
                if (upcoming_arena[ax][ay] != 0) {
                    int nextx = 20 + 10 * ax;
                    int nexty = 100 - 10 * ay;
                    switch (upcoming_arena[ax][ay]) {
                        case 1:
                            g.setColor(Color.yellow);
                            break;
                        case 2:
                            g.setColor(new Color(127, 0, 255));
                            break;
                        case 3:
                            g.setColor(new Color(0, 102, 204));
                            break;
                        case 4:
                            g.setColor(Color.red);
                            break;
                        case 5:
                            g.setColor(new Color(0, 153, 0));
                            break;
                        case 6:
                            g.setColor(new Color(204, 102, 0));
                            break;
                        case 7:
                            g.setColor(Color.blue);
                            break;
                        case 8:
                            g.setColor(Color.black);
                            break;
                        case 9:
                            g.setColor(new Color(41, 163, 41));
                            break;
                        case 10:
                            g.setColor(new Color(255, 153, 0));
                            break;
                        case 11:
                            g.setColor(new Color(255, 102, 153));
                            break;
                        case 12:
                            g.setColor(new Color(51, 153, 102));
                            break;
                        case 13:
                            g.setColor(new Color(0, 0, 102));
                            break;
                        case 14:
                            g.setColor(new Color(51, 102, 153));
                            break;
                        case 15:
                            g.setColor(new Color(102, 102, 51));
                            break;
                    }
                    g.fillRect(iX(nextx), iY(nexty), iL(10), iL(10));
                    g.setColor(Color.black);
                    g.drawRect(iX(nextx), iY(nexty), iL(10), iL(10));
                }
            }
        Font infoFont = new Font("Arial", Font.BOLD, iF(7));
        g.setFont(infoFont);
        g.drawString("Bonus Shapes:", iX(110), iY(125));
        g.setColor(Color.black);
        g.fillRect(iX(110), iY(110), iL(10), iL(10));
        g.fillRect(iX(110), iY(100), iL(10), iL(10));
        g.fillRect(iX(120), iY(100), iL(10), iL(10));

        g.setColor(Color.black);
        g.drawRect(iX(110), iY(110), iL(10), iL(10));
        g.drawRect(iX(110), iY(100), iL(10), iL(10));
        g.drawRect(iX(120), iY(100), iL(10), iL(10));

        g.setColor(Color.black);
        g.drawRect(iX(110), iY(85), iL(20), iL(10));
        g.drawString("Click", iX(112), iY(76));

        g.setColor(new Color(41, 163, 41));
        g.fillRect(iX(140), iY(110), iL(10), iL(10));
        g.fillRect(iX(150), iY(100), iL(10), iL(10));
        g.fillRect(iX(160), iY(100), iL(10), iL(10));
        g.setColor(Color.black);
        g.drawRect(iX(140), iY(110), iL(10), iL(10));
        g.drawRect(iX(150), iY(100), iL(10), iL(10));
        g.drawRect(iX(160), iY(100), iL(10), iL(10));
        g.drawRect(iX(145), iY(85), iL(20), iL(10));
        g.drawString("Click", iX(147), iY(76));

        g.setColor(new Color(255, 102, 153));
        g.fillRect(iX(150), iY(60), iL(10), iL(10));
        g.fillRect(iX(160), iY(60), iL(10), iL(10));
        g.fillRect(iX(170), iY(60), iL(10), iL(10));
        g.setColor(Color.black);
        g.drawRect(iX(150), iY(60), iL(10), iL(10));
        g.drawRect(iX(160), iY(60), iL(10), iL(10));
        g.drawRect(iX(170), iY(60), iL(10), iL(10));
        g.setColor(Color.black);
        g.drawRect(iX(150), iY(35), iL(20), iL(10));
        g.drawString("Click", iX(152), iY(26));

        g.setColor(new Color(255, 153, 0));
        g.fillRect(iX(120), iY(60), iL(10), iL(10));
        g.fillRect(iX(110), iY(50), iL(10), iL(10));
        g.setColor(Color.black);
        g.drawRect(iX(120), iY(60), iL(10), iL(10));
        g.drawRect(iX(110), iY(50), iL(10), iL(10));
        g.drawRect(iX(110), iY(35), iL(20), iL(10));
        g.drawString("Click", iX(112), iY(26));

        g.setColor(new Color(51, 153, 102));
        g.fillRect(iX(110), iY(0), iL(10), iL(10));
        g.fillRect(iX(110), iY(-10), iL(10), iL(10));
        g.setColor(Color.black);
        g.drawRect(iX(110), iY(0), iL(10), iL(10));
        g.drawRect(iX(110), iY(-10), iL(10), iL(10));
        g.drawRect(iX(112), iY(-30), iL(20), iL(10));
        g.drawString("Click", iX(114), iY(-39));

        g.setColor(new Color(0, 0, 102));
        g.fillRect(iX(160), iY(0), iL(10), iL(10));
        g.setColor(Color.black);
        g.drawRect(iX(160), iY(0), iL(10), iL(10));
        g.drawRect(iX(150), iY(-30), iL(20), iL(10));
        g.drawString("Click", iX(152), iY(-39));

        g.setColor(new Color(51, 102, 153));
        g.fillRect(iX(130), iY(-60), iL(10), iL(10));
        g.fillRect(iX(120), iY(-70), iL(10), iL(10));
        g.fillRect(iX(110), iY(-80), iL(10), iL(10));
        g.setColor(Color.black);
        g.drawRect(iX(130), iY(-60), iL(10), iL(10));
        g.drawRect(iX(120), iY(-70), iL(10), iL(10));
        g.drawRect(iX(110), iY(-80), iL(10), iL(10));
        g.drawRect(iX(110), iY(-100), iL(20), iL(10));
        g.drawString("Click", iX(112), iY(-109));

        g.setColor(new Color(102, 102, 51));
        g.fillRect(iX(160), iY(-70), iL(10), iL(10));
        g.fillRect(iX(170), iY(-80), iL(10), iL(10));
        g.fillRect(iX(150), iY(-80), iL(10), iL(10));
        g.setColor(Color.black);
        g.drawRect(iX(160), iY(-70), iL(10), iL(10));
        g.drawRect(iX(170), iY(-80), iL(10), iL(10));
        g.drawRect(iX(150), iY(-80), iL(10), iL(10));
        g.drawRect(iX(150), iY(-100), iL(20), iL(10));
        g.drawString("Click", iX(152), iY(-109));
        g.drawString("Level:     " + updating.level, iX(20), iY(20));
        g.drawString("Lines:     " + updating.lines, iX(20), iY(0));
        g.drawString("Score:    " + updating.score, iX(20), iY(-20));
        g.drawString("QUIT", iX(35), iY(-95));
        g.drawString("START", iX(35), iY(-65));
        if (j_m_area) {
            g.setColor(Color.BLACK);
            drawrect(g,iX(-80), iY(10), iX(-80), iY(-10),iX(-30),iY(10),iX(-30),iY(-10));
            g.setColor(Color.BLUE);
            g.drawString("PAUSE", iX(-75), iY(-5));
        }
    }
    private Frame f;
    private JDialog dialog;
    private void showNewGameDialog() {
        if (SwingUtilities.isEventDispatchThread()) {
            dialog = new JDialog(f, "Game Options", true);
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            dialog.add(panel);
            {
                JPanel row_j = new JPanel();
                row_j.setLayout(new FlowLayout(FlowLayout.LEADING));
                row_j.add(new JLabel("Setting:"));
                panel.add(row_j); }
            {
                JPanel t_panel = new JPanel();
                t_panel.setLayout(new GridBagLayout());
                GridBagConstraints c = new GridBagConstraints();
                c.fill = GridBagConstraints.VERTICAL;
                c.gridy = 0;
                c.insets = new Insets(10, 10, 10, 10);
                {
                    JPanel factorPanel = new JPanel();
                    factorPanel.setLayout(new BoxLayout(factorPanel, BoxLayout.X_AXIS));
                    factorPanel.setBorder(new BorderUIResource.LineBorderUIResource(Color.lightGray));
                    factorPanel.add(new JLabel("Factors:"));
                    {
                        JPanel row_j = new JPanel();
                        row_j.setLayout(new FlowLayout(FlowLayout.LEADING));
                        row_j.add(new JLabel("N:"));
                        JLabel value = new JLabel(String.format("%02d", updating.N));
                        JSlider slide_j = new JSlider(JSlider.VERTICAL, 20, 50, updating.N);
                        slide_j.setMajorTickSpacing(5);
                        slide_j.setMinorTickSpacing(1);
                        slide_j.setPaintTicks(true);
                        slide_j.setPaintLabels(true);
                        slide_j.setToolTipText("Slide Me to change");
                        slide_j.addChangeListener(e -> {
                            updating.N = slide_j.getValue();

                            value.setText(String.format("%02d", updating.N));
                        });
                        row_j.add(value);
                        row_j.add(slide_j);
                        factorPanel.add(row_j);
                    }
                    {
                        JPanel row_j = new JPanel();
                        row_j.setLayout(new FlowLayout(FlowLayout.LEADING));
                        row_j.add(new JLabel("S:"));
                        JLabel value = new JLabel(String.format("%.1f", updating.S));
                        JSlider slide_j = new JSlider(JSlider.VERTICAL, (int) (0.1 * 10), (int) ((float)1 * (float)10), (int) (updating.S * 10));
                        slide_j.setMajorTickSpacing(3);
                        slide_j.setMinorTickSpacing(1);
                        Hashtable<Integer, JLabel> labelTable = new Hashtable<>();
                        labelTable.put((int) ((float)0.1 * (float)10), new JLabel(String.format("%.1f", (float)0.1)));
                        labelTable.put((int) ((float)1 * (float)10 /2), new JLabel(String.format("%.1f", (float)1 /2)));
                        labelTable.put((int) ((float)1 * (float)10), new JLabel(String.format("%.1f", (float)1)));
                        slide_j.setLabelTable(labelTable);
                        slide_j.setPaintTicks(true);
                        slide_j.setPaintLabels(true);
                        slide_j.setToolTipText("Slide Me to change");
                        slide_j.addChangeListener(e -> {
                            updating.S = ( slide_j.getValue()) /10.0f;
                            value.setText(String.format("%.1f", updating.S));
                        });
                        row_j.add(value);
                        row_j.add(slide_j);
                        factorPanel.add(row_j);
                    }
                    {
                        JPanel row_j = new JPanel();
                        row_j.setLayout(new FlowLayout(FlowLayout.LEADING));
                        row_j.add(new JLabel("M:"));
                        JLabel value = new JLabel(String.format("%02d", updating.M));
                        JSlider slide_j = new JSlider(JSlider.VERTICAL, 1, 10, updating.M);
                        slide_j.setMajorTickSpacing(3);
                        slide_j.setMinorTickSpacing(1);
                        slide_j.setPaintTicks(true);
                        slide_j.setPaintLabels(true);
                        slide_j.setToolTipText("Slide Me to change");
                        slide_j.addChangeListener(e -> {
                            updating.M = slide_j.getValue();
                            value.setText(String.format("%02d", updating.M));
                        });
                        row_j.add(value);
                        row_j.add(slide_j);

                        factorPanel.add(row_j);
                    }
                    c.gridx = 0;
                    t_panel.add(factorPanel, c); }
                {
                    JPanel m_panel = new JPanel();
                    m_panel.setLayout(new BoxLayout(m_panel, BoxLayout.X_AXIS));
                    m_panel.setBorder(new BorderUIResource.LineBorderUIResource(Color.lightGray));
                    m_panel.add(new JLabel("Main Area:"));
                    {
                        JPanel row_j = new JPanel();
                        row_j.setLayout(new FlowLayout(FlowLayout.TRAILING));
                        row_j.add(new JLabel("Rows:"));
                        JLabel value = new JLabel(String.format("%02d", updating.length));
                        JSlider slide_j = new JSlider(JSlider.VERTICAL, 20, 25, updating.length);
                        slide_j.setMajorTickSpacing(5);
                        slide_j.setMinorTickSpacing(1);
                        slide_j.setPaintTicks(true);
                        slide_j.setPaintLabels(true);
                        slide_j.setToolTipText("Slide Me to change");
                        slide_j.addChangeListener(e -> {
                            updating.length = slide_j.getValue();
                            for(int i=0;i<fallarea.length;i++)
                            {
                                Arrays.fill(fallarea[i],0);
                            }
                            dropArea();
                            value.setText(String.format("%02d", updating.length));
                        });
                        row_j.add(value);
                        row_j.add(slide_j);
                        m_panel.add(row_j); }
                    {
                        JPanel row_j = new JPanel();
                        row_j.setLayout(new FlowLayout(FlowLayout.TRAILING));
                        row_j.add(new JLabel("Column:"));
                        JLabel value = new JLabel(String.format("%02d", updating.width));
                        JSlider slide_j = new JSlider(JSlider.VERTICAL, 10, 13, updating.width);
                        slide_j.setMajorTickSpacing(3);
                        slide_j.setMinorTickSpacing(1);
                        slide_j.setPaintTicks(true);
                        slide_j.setPaintLabels(true);
                        slide_j.setToolTipText("Slide Me to change");
                        slide_j.addChangeListener(e -> {
                            updating.width = slide_j.getValue();
                            value.setText(String.format("%02d", updating.width));
                        });
                        row_j.add(value);
                        row_j.add(slide_j);
                        m_panel.add(row_j);
                    }
                    {
                        JPanel row_j = new JPanel();
                        row_j.setLayout(new FlowLayout(FlowLayout.TRAILING));
                        row_j.add(new JLabel("Block Size:"));
                        JLabel value = new JLabel(String.format("%02d", updating.brick_size));
                        JSlider slide_j = new JSlider(JSlider.VERTICAL, 8, 12, updating.brick_size);
                        slide_j.setMajorTickSpacing(4);
                        slide_j.setMinorTickSpacing(1);
                        slide_j.setPaintTicks(true);
                        slide_j.setPaintLabels(true);
                        slide_j.setToolTipText("Slide Me to change");
                        slide_j.addChangeListener(e -> {
                            updating.brick_size = slide_j.getValue();
                            value.setText(String.format("%02d", updating.brick_size));
                            repaintDialog(); });
                        row_j.add(value);
                        row_j.add(slide_j);
                        c.gridx = 1;
                        m_panel.add(row_j); }
                    t_panel.add(m_panel, c); }
                panel.add(t_panel);
            }
            {
                JPanel btnPanel = new JPanel();
                btnPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
                Button start = new Button("Set");
                start.addActionListener(e -> dialog.setVisible(false));
                btnPanel.add(start);
                Button quit = new Button("Cancel");
                quit.addActionListener(e -> dialog.setVisible(false));
                btnPanel.add(quit);
                panel.add(btnPanel);
            }
            dialog.pack();
            dialog.setVisible(true);
        } else {
            try {
                SwingUtilities.invokeAndWait(() -> showNewGameDialog());
            } catch (Exception e) {
                e.printStackTrace();
            }        }
    }
    private void repaintDialog(){
        if(SwingUtilities.isEventDispatchThread()){
            dialog.revalidate();
            dialog.repaint();
            dialog.pack();
        }
        else {
            try{
                SwingUtilities.invokeAndWait(() -> repaintDialog()); }
            catch (Exception e){
                e.printStackTrace(); }
        } }

}