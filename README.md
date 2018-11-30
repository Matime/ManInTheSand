# ManInTheSand
Wrote this for a person on StackOverflow. Reminded me of a man stumbling with the win in the sand leaving a trail.

This program is not very good, theres plenty of other ways to do it but this is what i thought up in around an hour or so.

# Main
This instantiates a Controller Object and runs the controller

# Man
This stores the current positions of the man (could have just used a point)

# Wind
Determines the direction of the wind and how long the wind will last until it changes direction. Timing and Direction are random. Each time the direction changes the time will be between the previous time + a user defined increment. Direction is held using Enum.

# Board
Board is implemented using a 2d array of boolean. True is where the man has been, false is unvisited.

# Controller
This handles the interactions between the Man, the Wind, and the Board. It checks if the man is able to move at all (N,E,S,W,NE,SE,NW,SW) if any of those directions are still available then the controller will keep running. Every iteration, the wind will 'step' (decreasing time till next direction change by one and possibly changing direction' and then the man will move with the wind (if possible). Once the man can no longer move the controller will print the amount of spaces not visited.
