package practice.maths;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BitManipulationTest {
    @Test
    public void convertToBinaryBuiltIn() {

        String binary = BitManipulation.convertToBinaryBuiltIn(28);

        assertEquals("11100", binary);

    }

    @Ignore
    @Test
    public void convertToBinaryBuiltIn_nagative() {

        String binary = BitManipulation.convertToBinaryBuiltIn(-28);

        // TODO: check
        assertEquals("11100", binary);

    }

    @Test
    public void convertToBinaryUsingMask() {

        String binary = BitManipulation.convertToBinaryUsingMask(28);

        assertEquals("00000000000000000000000000011100", binary);

    }

}
