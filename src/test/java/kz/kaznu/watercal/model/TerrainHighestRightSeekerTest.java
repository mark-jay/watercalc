package kz.kaznu.watercal.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author <a href="mailto:mark.jay.mk@gmail.com">mark jay</a>
 * @since 9/30/18 3:23 PM
 */
public class TerrainHighestRightSeekerTest {

    @Test
    public void testFindHighestFromTheRight_whenCalled_shouldCalc() {
        Terrain terrain = TerrainGenerationTestUtils.getTerrain();
        testRight(terrain, 0, 4L);
        testRight(terrain, 1, 4L);
        testRight(terrain, 2, 4L);
        testRight(terrain, 3, 4L);
        testRight(terrain, 4, 4L);
        testRight(terrain, 5, 4L);
        testRight(terrain, 6, 4L);
        testRight(terrain, 7, 4L);
        testRight(terrain, 8, 4L);
        testRight(terrain, 9, 4L);
        testRight(terrain, 10, 4L);
        testRight(terrain, 11, 4L);
        testRight(terrain, 12, 0L);
        testRight(terrain, 13, 0L);
    }

    private void testRight(Terrain terrain, int index, long expected) {
        Assert.assertEquals("index = " + index, expected, (long) terrain.findHighestFromTheRight(index));
    }
}