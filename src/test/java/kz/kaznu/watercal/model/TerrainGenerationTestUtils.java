package kz.kaznu.watercal.model;

/**
 * @author <a href="mailto:mark.jay.mk@gmail.com">mark jay</a>
 * @since 9/29/18 10:01 PM
 */
public class TerrainGenerationTestUtils {
    public static Terrain getTerrain() {
        return new Terrain("" +
                "      #     # ",
                "  #   #     # ",
                "# #   #  #  # ",
                "# #   #  #  # "
        );
    }
}
