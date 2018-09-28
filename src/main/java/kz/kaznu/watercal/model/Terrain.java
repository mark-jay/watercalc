package kz.kaznu.watercal.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author <a href="mailto:mark.jay.mk@gmail.com">mark jay</a>
 * @since 9/28/18 10:08 PM
 */
public class Terrain {
    private final List<Long> asList;
    private final List<Long> highestLeft;
    private final List<Long> highestRight;

    public Terrain(String ... data) {
        this.asList = generateFromStringArray(data);
        this.highestLeft = initHighestLeft();
        this.highestRight = initHighestRight();
    }

    private List<Long> initHighestLeft() {
        ArrayList<Long> res = new ArrayList<>();
        Long maxHighestSoFar = 0L;
        for (Long height : asList) {
            res.add(maxHighestSoFar);
            maxHighestSoFar = Math.max(maxHighestSoFar, height);
        }
        return res;
    }

    public Long calc() {
        return IntStream.range(0, asList.size())
                .mapToLong(this::findUnitsByIndex)
                .sum();
    }

    public long findUnitsByIndex(int index) {
        Long left = findHighestFromTheLeft(index);
        System.out.println("left = " + left);

        Long right = findHighestFromTheRight(index);
        System.out.println("right = " + right);

        long waterLevel = Math.min(left, right);
        System.out.println("waterLevel = " + waterLevel);

        long unitsOfWater = waterLevel - asList.get(index);
        System.out.println("unitsOfWater = " + unitsOfWater);

        return Math.max(0, unitsOfWater);
    }

    private List<Long> initHighestRight() {
        List<Long> res = Arrays.asList(new Long[asList.size()]);
        Long maxHighestSoFar = 0L;
        for (int i = asList.size() - 1; i >= 0; i--) {
            Long height = asList.get(i);
            res.set(i, maxHighestSoFar);
            maxHighestSoFar = Math.max(maxHighestSoFar, height);
        }
        return res;
    }

    Long findHighestFromTheLeft(int index) {
        return highestLeft.get(index);
    }

    Long findHighestFromTheRight(int index) {
        return highestRight.get(index);
    }

    private List<Long> generateFromStringArray(String ... data) {
        Objects.requireNonNull(data);

        if (data.length == 0) {
            throw new IllegalArgumentException("data.length == 0");
        }

        boolean allSameSize = Stream.of(data)
                .allMatch(string -> string.length() == data[0].length());

        if (!allSameSize) {
            throw new IllegalArgumentException("!allSameSize");
        }

        int length = data[0].length();
        ArrayList<Long> result = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            final int index = i;
            long height = Arrays.stream(data)
                    .map(string -> string.charAt(index))
                    .filter(character -> '#' == character)
                    .count();
            result.add(height);
        }

        return result;
    }

    public List<Long> getAsList() {
        return asList;
    }
}
