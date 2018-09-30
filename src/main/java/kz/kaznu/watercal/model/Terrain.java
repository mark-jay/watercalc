package kz.kaznu.watercal.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author <a href="mailto:mark.jay.mk@gmail.com">mark jay</a>
 * @since 9/28/18 10:08 PM
 */
public class Terrain {

    private static final Logger log = Logger.getLogger(Terrain.class.getCanonicalName());

    private final List<Long> asList;

    private final TerrainHighestLeftSeeker leftSeeker;
    private final TerrainHighestRightSeeker rightSeeker;

    /**
     * O(N*M) where M - is the highest place
     * Creates a terrain by the given ascii art:)
     * @param data
     */
    public Terrain(String ... data) {
        AsciiToTerrainConverter asciiToTerrainConverter = new AsciiToTerrainConverter();
        this.asList = asciiToTerrainConverter.generateFromStringArray(data);
        this.leftSeeker = new TerrainHighestLeftSeeker(this);
        this.rightSeeker = new TerrainHighestRightSeeker(this);
    }

    /**
     * O(N) creates a terrain by the given raw data
     * @param result
     */
    public Terrain(List<Long> result) {
        this.asList = result;
        this.leftSeeker = new TerrainHighestLeftSeeker(this);
        this.rightSeeker = new TerrainHighestRightSeeker(this);
    }

    /**
     * O(N). Find amount of water in the whole terrain that will remain after the rain
     * @return
     */
    public Long calc() {
        return IntStream.range(0, asList.size())
                .mapToLong(this::findUnitsByIndex)
                .sum();
    }

    /**
     * O(1)
     *
     * finds amount of water in a specific point by a given index.
     *
     * @param index
     * @return number of units of water that will remain after the rain at a specified index. This guaranteed to be a positive number
     */
    public long findUnitsByIndex(int index) {
        long waterLevel = getHighestPossibleWaterLevel(index);

        long unitsOfWater = waterLevel - asList.get(index);
        log.info(String.format("unitsOfWater = %d", unitsOfWater));

        return Math.max(0, unitsOfWater);
    }

    /**
     * O(1)
     *
     * Finds maximum potential water level that walls by the left and right can possibly hold.
     * For example in this case:
     *
     *   #
     * #_#  #
     * #_# ##
     * 01234567
     *
     * If we consider index = 3 then this method returns 2 because even though the left at index 2 can hold up to 3 units
     * the wall on the right at index 5 can only hold 2 units.
     *
     * Worth noting that if we change this a bit to have a peak at index 3:
     *
     *    #
     *   ##
     * #_## #
     * #_####
     * 01234567
     *
     * The result of this function won't change as it ignores heigh at index
     *
     * @param index
     * @return
     */
    private long getHighestPossibleWaterLevel(int index) {
        Long left = leftSeeker.findHighestFromTheLeft(index);
        log.info(String.format("left = %d", left));

        Long right = rightSeeker.findHighestFromTheRight(index);
        log.info(String.format("right = %d", right));

        long waterLevel = Math.min(left, right);
        log.info(String.format("waterLevel = %d", waterLevel));
        return waterLevel;
    }

    List<Long> getAsList() {
        return asList;
    }
}
