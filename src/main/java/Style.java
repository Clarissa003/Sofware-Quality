import java.awt.Color;
import java.awt.Font;

/** <p>Style is for Indent, Color, Font and Leading.</p>
 * <p>Direct relation between style-number and item-level:
 * in Slide style if fetched for an item
 * with style-number as item-level.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public abstract class Style {
	// Factory method to create concrete style instances based on the level
	public static Style getStyleForLevel(int level) {
		switch (level) {
			case 0:
				return new StyleLevel0();
			case 1:
				return new StyleLevel1();
			case 2:
				return new StyleLevel2();
			case 3:
				return new StyleLevel3();
			case 4:
				return new StyleLevel4();
			default:
				throw new IllegalArgumentException("Invalid style level: " + level);
		}
	}

	abstract String getFontName();
	abstract Color getColor();
	abstract int getIndent();
	abstract int getFontSize();
	abstract int getLeading();
}