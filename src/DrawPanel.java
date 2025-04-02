import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.Arrays;

public class DrawPanel extends JPanel implements MouseListener {

    private boolean[][] grid = new boolean[30][40];
    private int[][] bricksLayout = new int[30][40];
    BrickLayout bricks = new BrickLayout("src/Input", 40, true);


    public DrawPanel() {
        this.addMouseListener(this);
        setTrueNums();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = 10;
        int y = 10;
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
//               if (bricksLayout[i][j] == 2)
//               {
//                   g.setColor(Color.GREEN);
//               }
//               if (bricksLayout[i][j] == 3)
//               {
//                   g.setColor(Color.YELLOW);
//               }
//               if (bricksLayout[i][j] == 4)
//               {
//                   g.setColor(Color.PINK);
//               }
//               if (bricksLayout[i][j] == 5)
//               {
//                   g.setColor(Color.MAGENTA);
//               }
               g.fillRect(x,y,20,20);
               g.setColor(Color.BLACK);
              x += 25;
           }
           x = 10;
           y += 25;
       }
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
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



    @Override
    public void mouseClicked(MouseEvent e) {
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