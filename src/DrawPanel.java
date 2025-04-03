import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;

// when the program starts, get the current time
// long startTime = System.currentTimeMillis();

// in paintcomponent:
// check how much time has elapsed
// elapsedTIme = (currentTime) - start
// if elapsedTIme > interval amount: do brickrbickrbick
// reset startTIme

public class DrawPanel extends JPanel implements MouseListener {

    private boolean[][] grid = new boolean[30][40];
    private int[][] bricksLayout = new int[30][40];
    BrickLayout bricks = new BrickLayout("src/Input", 40, true);
    private long startTime;


    public DrawPanel() {
        this.addMouseListener(this);
        setTrueNums();
        startTime = System.currentTimeMillis();
    }

    protected void paintComponent(Graphics g) {
        long elapsedTime = System.currentTimeMillis() - startTime;
        super.paintComponent(g);
        int x = 10;
        int y = 10;
        System.out.println(elapsedTime);
        if (elapsedTime > 5)
        {
            startTime = System.currentTimeMillis();
            brickBrickBrick();
        }
bricksLayout = bricks.getBrickLayout();
       for (int i = 0; i < bricksLayout.length; i++)
       {
           for (int j = 0; j < bricksLayout[0].length - 1; j++)
           {
               g.drawRect(x,y,20,20);






               if (bricksLayout[i][j] == 1)
               {
                   g.setColor(Color.RED);
               }
               else {
                   g.setColor(Color.BLACK);
               }
               g.fillRect(x,y,20,20);
               g.setColor(Color.BLACK);
              x += 25;
           }
           x = 10;
           y += 25;
       }
    }

    protected void setTrue()
    {
        int rand = 0;
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++)
            {
                rand = (int) (Math.random() * 10);
                if (rand < 3)
                {
                    grid[i][j] = true;
                }
                else {
                    grid[i][j] = false;
                }
            }
        }
    }

    protected void setTrueNums()
    {
        int rand = 0;
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++)
            {
                rand = (int) (Math.random() * 6);
                bricksLayout[i][j] = rand;
            }
        }
    }

    public void brickBrickBrick()
    {
        if (BrickLayout.reps <  BrickLayout.height) {
            bricks.fallBrick(BrickLayout.start, BrickLayout.end);
        } else {
            bricks.doOneBrick();
        }
    }



    @Override
    public void mouseClicked(MouseEvent e) {
            if (BrickLayout.reps < bricksLayout.length) {
                bricks.fallBrick(BrickLayout.start, BrickLayout.end);
            } else {
                bricks.doOneBrick();
            }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}