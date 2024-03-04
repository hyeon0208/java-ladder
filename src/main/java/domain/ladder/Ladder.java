package domain.ladder;

import java.util.List;

public class Ladder {
    private final List<Floor> floors;

    public Ladder(final List<Floor> floors) {
        this.floors = List.copyOf(floors);
    }

    public int getFinalPosition(int curPosition) {
        int finalPosition = curPosition;
        for (Floor floor : floors) {
            finalPosition = floor.getMovablePosition(finalPosition);
        }
        return finalPosition;
    }

    public List<Floor> getFloorsOfLadder() {
        return floors;
    }
}
