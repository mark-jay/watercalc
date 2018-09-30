package kz.kaznu.watercal.model;

import org.junit.Assert;
import org.junit.Test;

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
        TerrainHighestLeftSeeker seeker = new TerrainHighestLeftSeeker(terrain);
        testLeft(0, 0L, seeker);
        testLeft(1, 2L, seeker);
        testLeft(2, 2L, seeker);
        testLeft(3, 3L, seeker);
        testLeft(4, 3L, seeker);
        testLeft(5, 3L, seeker);
        testLeft(6, 3L, seeker);
        testLeft(7, 4L, seeker);
        testLeft(8, 4L, seeker);
        testLeft(9, 4L, seeker);
        testLeft(10, 4L, seeker);
        testLeft(11, 4L, seeker);
        testLeft(12, 4L, seeker);
    }

    private void testLeft(int index, long expected, TerrainHighestLeftSeeker seeker) {
        Assert.assertEquals(expected, (long) seeker.findHighestFromTheLeft(index));
    }
}