package kz.kaznu.watercal.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A class that is used to calculate highest peak from the right of the given index by a given terrain.
 * This class uses O(n) both time and space for it's constructor to initialize a cache
 * and O(1) to find the highest.
 *
 * @author <a href="mailto:mark.jay.mk@gmail.com">mark jay</a>
 * @since 9/29/18 9:51 PM
 */
class TerrainHighestRightSeeker {

    private final List<Long> highestRight;

    /**
     * O(N) Creates a seeker and initilizes its cache to search using {@link TerrainHighestRightSeeker#findHighestFromTheRight(int)}
     * @param terrain terrain to search in
     */
    TerrainHighestRightSeeker(Terrain terrain) {
        this.highestRight = initHighestRight(terrain.getAsList());
    }

    private List<Long> initHighestRight(List<Long> asList) {
        List<Long> res = Arrays.asList(new Long[asList.size()]);
        Long maxHighestSoFar = 0L;
        for (int i = asList.size() - 1; i >= 0; i--) {
            Long height = asList.get(i);
            res.set(i, maxHighestSoFar);
            maxHighestSoFar = Math.max(maxHighestSoFar, height);
        }
        return res;
    }

    /**
     * O(1) finds a highest possible peak to the right of the given index in terrain it was initialized with
     * @param index
     * @return
     */
    Long findHighestFromTheRight(int index) {
        return highestRight.get(index);
    }
}
