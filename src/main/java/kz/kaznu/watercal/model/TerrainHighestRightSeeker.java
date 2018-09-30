package kz.kaznu.watercal.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author <a href="mailto:mark.jay.mk@gmail.com">mark jay</a>
 * @since 9/29/18 9:51 PM
 */
public class TerrainHighestRightSeeker {

    private final List<Long> highestRight;

    public TerrainHighestRightSeeker(Terrain terrain) {
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

    public Long findHighestFromTheRight(int index) {
        return highestRight.get(index);
    }
}
