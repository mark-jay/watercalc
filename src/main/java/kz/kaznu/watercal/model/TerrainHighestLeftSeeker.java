package kz.kaznu.watercal.model;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that is used to calculate highest peak from the left of the given index by a given terrain.
 * This class uses O(n) both time and space for it's constructor to initialize a cache
 * and O(1) to find the highest.
 *
 * @author <a href="mailto:mark.jay.mk@gmail.com">mark jay</a>
 * @since 9/29/18 9:51 PM
 */
class TerrainHighestLeftSeeker {

    private final List<Long> highestLeft;

    /**
     * O(N) Creates a seeker and initilizes its cache to search using {@link TerrainHighestLeftSeeker#findHighestFromTheLeft(int)}
     * @param terrain terrain to search in
     */
    TerrainHighestLeftSeeker(Terrain terrain) {
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

    /**
     * O(1) finds a highest possible peak to the left of the given index in terrain it was initialized with
     * @param index
     * @return
     */
    Long findHighestFromTheLeft(int index) {
        return highestLeft.get(index);
    }
}
