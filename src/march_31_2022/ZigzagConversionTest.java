package march_31_2022;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZigzagConversionTest {

    ZigzagConversion obj ;
    @BeforeEach
    void setUp() {
        this.obj  = new ZigzagConversion();
    }

    @Test
    void convert() {
        String res = obj.convert("PAYPALISHIRING",3);
        Assert.assertEquals("PAHNAPLSIIGYIR",res);
        Assert.assertEquals("PINALSIGYAHRPI",obj.convert("PAYPALISHIRING",4));
        Assert.assertEquals("PINALSIGYAHRPI",obj.convert("PAYPALISHIRING",4));
    }
}