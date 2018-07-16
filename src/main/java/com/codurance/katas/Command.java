package com.codurance.katas;

public enum Command implements RoverCommand {
    TURN_LEFT, TURN_RIGHT, MOVE_FORWARD;

    private Rover rover;
    private Grid grid;
    private Direction direction;

    public void execute(){
        this.rover.setDirection(this.direction.newDirection(this));
        if (equals(MOVE_FORWARD)){
            switch (this.direction){
                case NORTH:
                    moveNorth(this.rover, this.grid);
                    break;
                case WEST:
                    moveWest(this.rover, this.grid);
                    break;
                case EAST:
                    moveEast(this.rover, this.grid);
                    break;
                case SOUTH:
                    this.rover.setY(this.grid.getY(this.rover.getY() -1));
                    break;
            }
        }

    }

    public void applyCommandOn(Direction direction, Rover rover, Grid grid) {
        RoverCommand command = initiate(direction, rover, grid);
        command.execute();
    }

    private RoverCommand initiate(Direction direction, Rover rover, Grid grid) {
        this.rover = rover;
        this.grid = grid;
        this.direction = direction;
        return this;
    }

    private void moveEast(Rover rover, Grid grid) {
        this.rover.setX(this.grid.getX(this.rover.getX() +1));
    }

    private void moveWest(Rover rover, Grid grid) {
        this.rover.setX(this.grid.getX( this.rover.getX() -1));
    }

    private void moveNorth(Rover rover, Grid grid) {
        this.rover.setY(this.grid.getY(this.rover.getY() +1));
    }
}
