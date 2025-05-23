import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BrickLayout {

    private ArrayList<Brick> bricks;
    private int[][] brickLayout;
    private int cols;
    public static int reps = 0;
    public static int start = 0;
    public static int end = 0;
    public static int height = 0;

    public BrickLayout(String fileName, int cols, boolean dropAllBricks) {
        this.cols = cols;
        ArrayList<String> fileData = getFileData(fileName);
        bricks = new ArrayList<Brick>();
        for (String line : fileData) {
            String[] points = line.split(",");
            int start = Integer.parseInt(points[0]);
            int end = Integer.parseInt(points[1]);
            Brick b = new Brick(start, end);
            bricks.add(b);
        }
        brickLayout = new int[bricks.size()][cols];
    }

    public void doOneBrick() {


        if (bricks.size() != 0) {
            Brick b = bricks.remove(0);
            reps = 0;


            b.setHeight(brickLayout.length - 1);


            for (int i = b.getStart() - 1; i <= b.getEnd(); i++) {
                for (int j = 0; j < brickLayout.length; j++) {
                    if (checkBrickSpot(j, i)) {
                        if (j <= b.getHeight()) {
                            b.setHeight(j - 1);
                        }
                    }
                }
            }
            start = b.getStart();
            end = b.getEnd();
            height = b.getHeight() + 1;
    }
    }


    public void fallBrick(int start, int end)
    {
            for (int i = start - 1; i < end; i++) {
                try {
            brickLayout[reps][i + 1] = 1;
            brickLayout[reps - 1][i + 1] = 0;
                } catch (Exception _) {

                }
            }
            reps++;
    }



    public ArrayList<String> getFileData(String fileName) {
        File f = new File(fileName);
        Scanner s = null;
        try {
            s = new Scanner(f);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(1);
        }
        ArrayList<String> fileData = new ArrayList<String>();
        while (s.hasNextLine())
            fileData.add(s.nextLine());

        return fileData;
    }

    public void printBrickLayout() {
        for (int r = 0; r < brickLayout.length; r++) {
            for (int c = 0; c < brickLayout[0].length; c++) {
                System.out.print(brickLayout[r][c] + " ");
            }
            System.out.println();
        }
    }

    public int[][] getBrickLayout()
    {
        return brickLayout;
    }


    public boolean checkBrickSpot(int r, int c) {
        if (brickLayout[r][c] == 1) {
            return true;
        }
        else {
            return false;
        }
    }
}