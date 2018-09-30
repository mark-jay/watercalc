package kz.kaznu.watercal.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author <a href="mailto:mark.jay.mk@gmail.com">mark jay</a>
 * @since 9/30/18 3:23 PM
 */
public class TerrainHighestRightSeekerTest {

    @Test
    public void testFindHighestFromTheRight_whenCalled_shouldCalc() {
        Terrain terrain = TerrainGenerationTestUtils.getTerrain();
        TerrainHighestRightSeeker seeker = new TerrainHighestRightSeeker(terrain);
        testRight(0, 4L, seeker);
        testRight(1, 4L, seeker);
        testRight(2, 4L, seeker);
        testRight(3, 4L, seeker);
        testRight(4, 4L, seeker);
        testRight(5, 4L, seeker);
        testRight(6, 4L, seeker);
        testRight(7, 4L, seeker);
        testRight(8, 4L, seeker);
        testRight(9, 4L, seeker);
        testRight(10, 4L, seeker);
        testRight(11, 4L, seeker);
        testRight(12, 0L, seeker);
        testRight(13, 0L, seeker);
    }

    private void testRight(int index, long expected, TerrainHighestRightSeeker seeker) {
        Assert.assertEquals("index = " + index, expected, (long) seeker.findHighestFromTheRight(index));
    }
}