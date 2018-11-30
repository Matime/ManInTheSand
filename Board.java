import java.util.Arrays;

class Board {
    private int width;
    private int height;
    private Boolean[][] board;

    public void printBoard() {
        for (Boolean[] outer : board) {
            System.out.println();
            for (Boolean inner : outer) {
                if (inner) {
                    System.out.print('X');
                } else
                    System.out.print('O');
            }

        }
    }

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        board = new Boolean[width][height];
        for (Boolean[] b : board
                ) {
            for (int i = 0; i < b.length; i++)
                b[i] = false;

        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Boolean[][] getBoard() {
        return board;
    }

    public void setWidth(int width) {
        this.width = width;
        regenerateBoard();
    }

    public void setHeight(int height) {
        this.height = height;
        regenerateBoard();
    }

    public void regenerateBoard() {
        if (width != 0 && height != 0) board = new Boolean[width][height];
    }

    public Boolean[][] getNewBoard() {
        regenerateBoard();
        return board;
    }

    public void printNonVisitedCount() {
        System.out.println(Arrays.deepToString(board).replaceAll("[^f]", "").length());
    }
}
