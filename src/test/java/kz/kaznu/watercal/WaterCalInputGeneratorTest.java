 package kz.kaznu.watercal;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author <a href="mailto:mark.jay.mk@gmail.com">mark jay</a>
 * @since 9/28/18 9:45 PM
 */
public class WaterCalInputGeneratorTest {

    @Test
    public void generateInput() {
        List<Long> result = new WaterCalInputGenerator().generateInput( "" +
                "      #     # ",
                "  #   #     # ",
                "# #   #  #  # ",
                "# #   #  #  # "
        );
        Assert.assertEquals(Arrays.<Long>asList(2L, 0L, 3L, 0L, 0L, 0L, 4L, 0L, 0L, 2L, 0L, 0L, 4L, 0L), result);
    }
}