import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Controls implements KeyboardHandler {

    private Pointer position;
    private boolean spacePressed;
    private boolean deletePressed;
    private MyGrid grid;

    public Controls(Pointer position, MyGrid grid) {
        this.position = position;
        this.grid = grid;
        init();
    }

    private void init() {

        Keyboard keyboard = new Keyboard(this);


        KeyboardEvent pressedUp = new KeyboardEvent();
        pressedUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedUp.setKey(KeyboardEvent.KEY_UP);
        keyboard.addEventListener(pressedUp);

        KeyboardEvent pressedDown = new KeyboardEvent();
        pressedDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedDown.setKey(KeyboardEvent.KEY_DOWN);
        keyboard.addEventListener(pressedDown);

        KeyboardEvent pressedRight = new KeyboardEvent();
        pressedRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedRight.setKey(KeyboardEvent.KEY_RIGHT);
        keyboard.addEventListener(pressedRight);

        KeyboardEvent pressedLeft = new KeyboardEvent();
        pressedLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedLeft.setKey(KeyboardEvent.KEY_LEFT);
        keyboard.addEventListener(pressedLeft);

        KeyboardEvent pressedSpace = new KeyboardEvent();
        pressedSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedSpace.setKey(KeyboardEvent.KEY_SPACE);
        keyboard.addEventListener(pressedSpace);

        KeyboardEvent pressedD = new KeyboardEvent();
        pressedD.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedD.setKey(KeyboardEvent.KEY_D);
        keyboard.addEventListener(pressedD);

        KeyboardEvent releaseSpace = new KeyboardEvent();
        releaseSpace.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        releaseSpace.setKey(KeyboardEvent.KEY_SPACE);
        keyboard.addEventListener(releaseSpace);

        KeyboardEvent releaseD = new KeyboardEvent();
        releaseD.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        releaseD.setKey(KeyboardEvent.KEY_D);
        keyboard.addEventListener(releaseD);

        KeyboardEvent pressedS = new KeyboardEvent();
        pressedS.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedS.setKey(KeyboardEvent.KEY_S);
        keyboard.addEventListener(pressedS);

        KeyboardEvent pressedC = new KeyboardEvent();
        pressedC.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedC.setKey(KeyboardEvent.KEY_C);
        keyboard.addEventListener(pressedC);

        KeyboardEvent pressedL = new KeyboardEvent();
        pressedL.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedL.setKey(KeyboardEvent.KEY_L);
        keyboard.addEventListener(pressedL);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        int key = keyboardEvent.getKey();

        switch (key) {

            case KeyboardEvent.KEY_UP:
                if (deletePressed) {
                    position.delete();
                }
                if (spacePressed) {
                    position.draw();
                }
                position.moveUp();

                break;
            case KeyboardEvent.KEY_DOWN:
                if (deletePressed) {
                    position.delete();
                }
                if (spacePressed) {
                    position.draw();
                }
                position.moveDown();

                break;
            case KeyboardEvent.KEY_RIGHT:
                if (deletePressed) {
                    position.delete();
                }
                if (spacePressed) {
                    position.draw();
                }
                position.moveRight();
                break;
            case KeyboardEvent.KEY_LEFT:
                if (deletePressed) {
                    position.delete();
                }
                if (spacePressed) {
                    position.draw();
                }
                position.moveLeft();
                break;
            case KeyboardEvent.KEY_SPACE:
                position.draw();
                spacePressed = true;
                break;
            case KeyboardEvent.KEY_D:
                position.delete();
                deletePressed = true;
                break;
            case KeyboardEvent.KEY_S:
                grid.saveFile();
                break;
            case KeyboardEvent.KEY_C:
                grid.clearGrid();
                break;
            case KeyboardEvent.KEY_L:
                grid.loadFile();
                break;


        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        int key = keyboardEvent.getKey();
        switch (key) {
            case KeyboardEvent.KEY_SPACE:
                spacePressed = false;
                break;
            case KeyboardEvent.KEY_D:
                deletePressed = false;
                break;

        }

    }


}
