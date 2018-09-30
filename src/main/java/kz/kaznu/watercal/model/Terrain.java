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

    public Terrain(String ... data) {
        AsciiToTerrainConverter asciiToTerrainConverter = new AsciiToTerrainConverter();
        this.asList = asciiToTerrainConverter.generateFromStringArray(data);
        this.leftSeeker = new TerrainHighestLeftSeeker(this);
        this.rightSeeker = new TerrainHighestRightSeeker(this);
    }

    Terrain(List<Long> result) {
        this.asList = result;
        this.leftSeeker = new TerrainHighestLeftSeeker(this);
        this.rightSeeker = new TerrainHighestRightSeeker(this);
    }

    /**
     * Find amount of water in the whole terrain
     * @return
     */
    public Long calc() {
        return IntStream.range(0, asList.size())
                .mapToLong(this::findUnitsByIndex)
                .sum();
    }

    /**
     * finds amount of water in a specific point by a given index
     * @param index
     * @return
     */
    public long findUnitsByIndex(int index) {
        Long left = leftSeeker.findHighestFromTheLeft(index);
        log.info(String.format("left = %d", left));

        Long right = rightSeeker.findHighestFromTheRight(index);
        log.info(String.format("right = %d", right));

        long waterLevel = Math.min(left, right);
        log.info(String.format("waterLevel = %d", waterLevel));

        long unitsOfWater = waterLevel - asList.get(index);
        log.info(String.format("unitsOfWater = %d", unitsOfWater));

        return Math.max(0, unitsOfWater);
    }

    List<Long> getAsList() {
        return asList;
    }
}
