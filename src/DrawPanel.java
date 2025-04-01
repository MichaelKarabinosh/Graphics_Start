import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.Arrays;

public class DrawPanel extends JPanel implements MouseListener {

    private boolean[][] grid = new boolean[30][40];
    private int[][] gridNums = new int[30][40];


    public DrawPanel() {
        this.addMouseListener(this);
        setTrueNums();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = 10;
        int y = 10;

       for (int i = 0; i < 40; i++)
       {
           for (int j  = 0; j < 30; j++)
           {

               g.drawRect(x,y,20,20);
               if (gridNums[j][i] == 0)
               {
                   g.setColor(Color.RED);
               }
               if (gridNums[j][i] == 1)
               {
                   g.setColor(Color.BLUE);
               }
               if (gridNums[j][i] == 2)
               {
                   g.setColor(Color.GREEN);
               }
               if (gridNums[j][i] == 3)
               {
                   g.setColor(Color.YELLOW);
               }
               if (gridNums[j][i] == 4)
               {
                   g.setColor(Color.PINK);
               }
               if (gridNums[j][i] == 5)
               {
                   g.setColor(Color.MAGENTA);
               }
               g.fillRect(x,y,20,20);
               g.setColor(Color.BLACK);
               y += 25;
           }
           y = 10;
           x += 25;
       }
        try {
            Thread.sleep(50);
            setTrueNums();
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
                gridNums[i][j] = rand;
            }
        }
    }



    @Override
    public void mouseClicked(MouseEvent e) {
setTrueNums();
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