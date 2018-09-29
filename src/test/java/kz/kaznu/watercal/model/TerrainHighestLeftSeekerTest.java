package kz.kaznu.watercal.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author <a href="mailto:mark.jay.mk@gmail.com">mark jay</a>
 * @since 9/29/18 9:59 PM
 */
public class TerrainHighestLeftSeekerTest {

    @Test
    public void findHighestFromTheLeft() {
    }

    @Test
    public void testFindHighestFromTheLeft_whenCalled_shouldCalc() {
        Terrain terrain = TerrainGenerationTestUtils.getTerrain();
        testLeft(terrain, 0, 0L);
        testLeft(terrain, 1, 2L);
        testLeft(terrain, 2, 2L);
        testLeft(terrain, 3, 3L);
        testLeft(terrain, 4, 3L);
        testLeft(terrain, 5, 3L);
        testLeft(terrain, 6, 3L);
        testLeft(terrain, 7, 4L);
        testLeft(terrain, 8, 4L);
        testLeft(terrain, 9, 4L);
        testLeft(terrain, 10, 4L);
        testLeft(terrain, 11, 4L);
        testLeft(terrain, 12, 4L);
    }

    private void testLeft(Terrain terrain, int index, long expected) {
        Assert.assertEquals(expected, (long) terrain.findHighestFromTheLeft(index));
    }
}