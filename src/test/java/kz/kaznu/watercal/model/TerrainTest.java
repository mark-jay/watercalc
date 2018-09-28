package kz.kaznu.watercal.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author <a href="mailto:mark.jay.mk@gmail.com">mark jay</a>
 * @since 9/28/18 10:10 PM
 */
public class TerrainTest {
    
    @Test
    public void terrainConstructor_whenCalled_shouldGenerateCorrectTerrain() {
        Terrain terrain = new Terrain( "" +
                "      #     # ",
                "  #   #     # ",
                "# #   #  #  # ",
                "# #   #  #  # "
        );
        Assert.assertEquals(Arrays.<Long>asList(2L, 0L, 3L, 0L, 0L, 0L, 4L, 0L, 0L, 2L, 0L, 0L, 4L, 0L), terrain.getAsList());

    }

}