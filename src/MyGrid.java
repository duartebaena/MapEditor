import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.io.*;
import java.util.LinkedList;

public class MyGrid {

    public static final int PADDING = 10;
    public static final int CELL_SIZE = 25;
    private int colNum;
    private int rowNum;

    private Rectangle[][] rectangles;

    public MyGrid(int cols, int rows) {
        this.colNum = cols;
        this.rowNum = rows;
    }

    public void init() {
        rectangles = new Rectangle[colNum][rowNum];

        for (int i = 0; i < colNum; i++) {
            for (int j = 0; j < rowNum; j++) {
                rectangles[i][j] = new Rectangle(PADDING + i * CELL_SIZE, PADDING + j * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                rectangles[i][j].draw();
            }
        }
    }

    public void saveFile() {
        LinkedList<String> rectanglesPainted = new LinkedList<>();

        for (int i = 0; i < colNum; i++) {
            for (int j = 0; j < rowNum; j++) {
                if (rectangles[i][j].isFilled()) {
                    rectanglesPainted.add(i + ":" + j);
                }
            }
        }
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("files/imageSaved.txt"));
            for (String str : rectanglesPainted) {
                bufferedWriter.write(str + "\n");
            }
            bufferedWriter.close();
            System.out.println("saved file");

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void loadFile() {
        clearGrid();

        try {
            String line = "";
            BufferedReader bufferedReader = new BufferedReader(new FileReader("files/imageSaved.txt"));

            while ((line = bufferedReader.readLine()) != null) {
                Integer colNum = Integer.valueOf(line.split(":")[0]);
                Integer rowNum = Integer.valueOf(line.split(":")[1]);
                rectangles[colNum][rowNum].setColor(Color.BLACK);
                rectangles[colNum][rowNum].fill();
            }
            bufferedReader.close();
            System.out.println("File loaded");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void clearGrid() {
        for (int i = 0; i < colNum; i++) {
            for (int j = 0; j < rowNum; j++) {
                rectangles[i][j].draw();
            }
        }
    }


    public int getColNum() {
        return colNum;
    }

    public int getRowNum() {
        return rowNum;
    }

    public Rectangle[][] getRectangles() {
        return rectangles;
    }
}
