import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import java.awt.Color;

public class StyleTest {

    @Test
    public void testGetStyleForLevel_Level0_ReturnsStyleLevel0Instance() {
        Style style = Style.getStyleForLevel(0);
        assertFalse(style instanceof StyleLevel1);
        assertFalse(style instanceof StyleLevel2);
        assertFalse(style instanceof StyleLevel3);
        assertFalse(style instanceof StyleLevel4);
    }

    @Test
    public void testGetStyleForLevel_Level1_ReturnsStyleLevel1Instance() {
        Style style = Style.getStyleForLevel(1);
        assertFalse(style instanceof StyleLevel0);
        assertFalse(style instanceof StyleLevel2);
        assertFalse(style instanceof StyleLevel3);
        assertFalse(style instanceof StyleLevel4);
    }

    @Test
    public void testGetStyleForLevel_Level2_ReturnsStyleLevel2Instance() {
        Style style = Style.getStyleForLevel(2);
        assertFalse(style instanceof StyleLevel0);
        assertFalse(style instanceof StyleLevel1);
        assertFalse(style instanceof StyleLevel3);
        assertFalse(style instanceof StyleLevel4);
    }

    @Test
    public void testGetStyleForLevel_Level3_ReturnsStyleLevel3Instance() {
        Style style = Style.getStyleForLevel(3);
        assertFalse(style instanceof StyleLevel0);
        assertFalse(style instanceof StyleLevel1);
        assertFalse(style instanceof StyleLevel2);
        assertFalse(style instanceof StyleLevel4);
    }

    @Test
    public void testGetStyleForLevel_Level4_ReturnsStyleLevel4Instance() {
        Style style = Style.getStyleForLevel(4);
        assertFalse(style instanceof StyleLevel0);
        assertFalse(style instanceof StyleLevel1);
        assertFalse(style instanceof StyleLevel2);
        assertFalse(style instanceof StyleLevel3);
    }

    @Test
    public void getStyleForLevel_InvalidStyle_ExpectThrows() {
        assertThrows(IllegalArgumentException.class, () -> {
            Style.getStyleForLevel(-1);
        });
    }

    @Test
    public void getStyleForLevel_validStyle_ExpectDoesNotThrows() {
        assertDoesNotThrow(() -> {
            Style.getStyleForLevel(0);
        });
    }
}
