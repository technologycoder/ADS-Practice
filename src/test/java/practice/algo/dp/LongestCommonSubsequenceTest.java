package practice.algo.dp;

import org.junit.Assert;
import org.junit.Test;

public class LongestCommonSubsequenceTest {
    @Test
    public void lcs() {

        String lcs = LongestCommonSubsequence.lcs("ABCBDAB", "BDCABA");
        Assert.assertEquals("BDAB", lcs);

    }

    @Test
    public void lcsDP() {

        LongestCommonSubsequence.lcsDP("ABCBDAB", "BDCABA");
        // Assert.assertEquals("BDAB", lcs);

    }

}
