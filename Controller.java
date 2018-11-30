import java.util.Arrays;
import java.util.Random;

class Controller {
    private Man man;
    private Wind wind;
    private Board board;
    private Random random = new Random();

    public Controller() {
        man = new Man();
        wind = new Wind(4);
        board = new Board(random.nextInt(9997) + 3, random.nextInt(9998) + 2);
        //board = new Board(4, 4);
    }

    public void run() {
        board.getBoard()[0][0] = true;
        while (canManMove()) {
            wind.step();
            moveMan();
        }
        //board.printBoard();
        board.printNonVisitedCount();
    }

    private boolean canManMove() {
        int startX = Math.max(man.getX() - 1, 0);
        int startY = Math.max(man.getY() - 1, 0);
        int endX = Math.min(man.getX() + 1, board.getWidth() - 1);
        int endY = Math.min(man.getY() + 1, board.getHeight() - 1);
        for(int rowNum=startX;rowNum<=endX;rowNum++)
            for(int colNum=startY;colNum<=endY;colNum++){
                if(!board.getBoard()[rowNum][colNum])
                    return true;
            }
            return false;
    }

    private void moveMan() {
        int x = man.getX();
        int y = man.getY();
        int xMod = 0;
        int yMod = 0;
        if (wind.direction.name().contains("S"))
            yMod = 1;
        if (wind.direction.name().contains("N"))
            yMod = -1;
        if (wind.direction.name().contains("E"))
            xMod = 1;
        if (wind.direction.name().contains("W"))
            xMod = -1;
        x += xMod;
        y += yMod;
        if (x >= 0 && x < board.getWidth() && y >= 0 && y < board.getHeight()) {
            if (Math.abs(x) + Math.abs(y) > 0) {
                man.setX(x);
                man.setY(y);
                board.getBoard()[x][y] = true;
            }
        }
    }

}
