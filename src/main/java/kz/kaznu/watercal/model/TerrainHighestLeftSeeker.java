package kz.kaznu.watercal.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:mark.jay.mk@gmail.com">mark jay</a>
 * @since 9/29/18 9:51 PM
 */
public class TerrainHighestLeftSeeker {

    private final List<Long> highestLeft;

    public TerrainHighestLeftSeeker(Terrain terrain) {
        this.highestLeft = initHighestLeft(terrain);
    }

    private List<Long> initHighestLeft(Terrain terrain) {
        ArrayList<Long> res = new ArrayList<>();
        Long maxHighestSoFar = 0L;
        for (Long height : terrain.getAsList()) {
            res.add(maxHighestSoFar);
            maxHighestSoFar = Math.max(maxHighestSoFar, height);
        }
        return res;
    }

    public Long findHighestFromTheLeft(int index) {
        return highestLeft.get(index);
    }
}
