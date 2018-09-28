package kz.kaznu.watercal.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author <a href="mailto:mark.jay.mk@gmail.com">mark jay</a>
 * @since 9/28/18 11:20 PM
 */
public class TerrainTestFromPlanData {

    public Object[][] testData() {
        return new Object[][] {
            {Arrays.asList(3L,2L,4L,1L,2L), 2L},
            {Arrays.asList(4L,1L,1L,0L,2L,3L), 8L},
            {Arrays.asList(1L,2L,5L,7L,1L,2L,3L,12L),15L},
            {Arrays.asList(5L,3L,1L,3L,1L,4L,1L,7L,4L,3L,2L,1L,0L,2L,5L,7L), 49L}
        };
    }

    @Test
    public void calc() {
        for (Object[] objects : testData()) {
            List<Long> input = (List<Long>) objects[0];
            Long result = (Long) objects[1];
            Assert.assertEquals(result, new Terrain(input).calc());
        }
    }
}