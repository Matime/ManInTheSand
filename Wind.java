import java.util.Random;

class Wind {
    private int time;
    private int timeRemaining;
    private Random random;
    private int enumSize;
    private int randomIncrement;

    public Wind(int randomIncrement) {
        random = new Random();
        enumSize = Direction.values().length;
        time = timeRemaining = random.nextInt(randomIncrement) + 3;
        this.randomIncrement = randomIncrement;
        direction = getRandomDirection();
    }

    enum Direction {
        N,
        NE,
        E,
        SE,
        S,
        SW,
        W,
        NW
    }

    Direction direction;

    private Direction getRandomDirection() {
        return Direction.values()[random.nextInt(enumSize)];
    }

    public void step() {
        timeRemaining--;
        if (timeRemaining == 0) {
            time += random.nextInt(randomIncrement);
            timeRemaining = time - 1;
            direction = getRandomDirection();
        }
    }

}