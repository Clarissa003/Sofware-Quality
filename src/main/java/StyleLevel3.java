import java.awt.*;

public class StyleLevel3 extends Style
{
    @Override
    String getFontName()
    {
        return "Helvetica";
    }

    @Override
    Color getColor()
    {
        return Color.black;
    }

    @Override
    int getIndent()
    {
        return 0;
    }

    @Override
    int getFontSize()
    {
        return 30;
    }

    @Override
    int getLeading()
    {
        return 10;
    }
}
