package kz.kaznu.watercal.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author <a href="mailto:mark.jay.mk@gmail.com">mark jay</a>
 * @since 9/28/18 10:10 PM
 */
public class TerrainTest {

    @Test
    public void testCalc_whenCalledOnEmpty_shouldReturn0() {
        Terrain terrain = new Terrain("" +
                "",
                "",
                ""
        );
        long result = terrain.calc();
        Assert.assertEquals(
                0
                , result);
    }

    @Test
    public void testCalc_whenCalledOnSingleTower_shouldReturn0() {
        Terrain terrain = new Terrain("" +
                "#",
                "#",
                "#"
        );
        long result = terrain.calc();
        Assert.assertEquals(
                0
                , result);
    }

    @Test
    public void testCalc_whenCalledOnTwoTower_shouldReturn0() {
        Terrain terrain = new Terrain("" +
                "# ",
                "##",
                "##"
        );
        long result = terrain.calc();
        Assert.assertEquals(
                0
                , result);
    }

    @Test
    public void testCalc_whenCalledOnTwoTowerSameSize_shouldReturn0() {
        Terrain terrain = new Terrain("" +
                "##",
                "##",
                "##"
        );
        long result = terrain.calc();
        Assert.assertEquals(
                0
                , result);
    }

    @Test
    public void testCalc_whenCalledOnThreeTowerSameSize_shouldReturn0() {
        Terrain terrain = new Terrain("" +
                "###",
                "###",
                "###"
        );
        long result = terrain.calc();
        Assert.assertEquals(
                0
                , result);
    }

    @Test
    public void testCalc_whenCalledOnEmpty1Sized_shouldReturn0() {
        Terrain terrain = new Terrain("" +
                " ",
                " ",
                " "
        );
        long result = terrain.calc();
        Assert.assertEquals(
                0
                , result);
    }

    @Test
    public void testConstructor_whenCalled_shouldGenerateCorrectTerrain() {
        Terrain terrain = TerrainGenerationTestUtils.getTerrain();

        Assert.assertEquals(Arrays.<Long>asList(2L, 0L, 3L, 0L, 0L, 0L, 4L, 0L, 0L, 2L, 0L, 0L, 4L, 0L), terrain.getAsList());
    }

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

    @Test
    public void testFindUnitsByIndex_whenCalled_shouldPass() {
        Terrain terrain = TerrainGenerationTestUtils.getTerrain();
        assertHeight(terrain, 0, 0);
        assertHeight(terrain, 1, 2);
        assertHeight(terrain, 2, 0);
        assertHeight(terrain, 3, 3);
        assertHeight(terrain, 4, 3);
        assertHeight(terrain, 5, 3);
        assertHeight(terrain, 6, 0);
        assertHeight(terrain, 7, 4);
        assertHeight(terrain, 8, 4);
        assertHeight(terrain, 9, 2);
        assertHeight(terrain, 10, 4);
        assertHeight(terrain, 11, 4);
        assertHeight(terrain, 12, 0);
        assertHeight(terrain, 13, 0);
    }

    @Test
    public void testCalc_whenCalled_shouldCount() {
        Terrain terrain = TerrainGenerationTestUtils.getTerrain();
        long result = terrain.calc();
        Assert.assertEquals(
                0 + 2 + 0 + 3 + 3 + 3 + 0 + 4 + 4 + 2 + 4 + 4 + 0 + 0
                , result);
    }

    private void testRight(Terrain terrain, int index, long expected) {
        Assert.assertEquals("index = " + index, expected, (long) terrain.findHighestFromTheRight(index));
    }

    private void assertHeight(Terrain terrain, int index, int expected) {
        Assert.assertEquals(expected, terrain.findUnitsByIndex(index));
    }
}
