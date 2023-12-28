import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Pointer {
    private int col;
    private int row;

    private MyGrid grid;
    private Rectangle rectangle;


    private Controls controls;


    public Pointer(int col, int row, MyGrid grid) {
        this.col = col;
        this.row = row;
        this.grid = grid;
        rectangle = new Rectangle(col + grid.PADDING, row + grid.PADDING, grid.CELL_SIZE, grid.CELL_SIZE);
        rectangle.setColor(Color.GREEN);
        rectangle.fill();
        controls = new Controls(this, grid);

    }

    public void moveUp() {
        if(rectangle.getY()<=grid.PADDING){
            return;
        }
        rectangle.translate(0, -grid.CELL_SIZE);
        row--;
    }

    public void moveDown() {
      if(rectangle.getY()>=(grid.getRowNum()-1)*grid.CELL_SIZE){
            return;
        }
        rectangle.translate(0, grid.CELL_SIZE);
        row++;
    }

    public void moveRight() {
      if(rectangle.getX()>=(grid.getColNum()-1)*grid.CELL_SIZE){
            return;
        }
        rectangle.translate(grid.CELL_SIZE, 0);
        col++;
    }

    public void moveLeft() {
       if(rectangle.getX()<=grid.PADDING){
            return;
        }
        rectangle.translate(-grid.CELL_SIZE, 0);
        col--;

    }

    public void draw() {
        grid.getRectangles()[col][row].setColor(Color.BLACK);
        grid.getRectangles()[col][row].fill();
    }


    public void delete() {
        grid.getRectangles()[col][row].draw();

    }



}
