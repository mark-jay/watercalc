package kz.kaznu.watercal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * @author <a href="mailto:mark.jay.mk@gmail.com">mark jay</a>
 * @since 9/28/18 9:43 PM
 */
public class WaterCalInputGenerator {
    public List<Long> generateInput(String ... data) {
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
}
