import java.awt.*;

public class StyleLevel1 extends Style
{
    @Override
    String getFontName()
    {
        return "Helvetica";
    }

    @Override
    Color getColor()
    {
        return Color.blue;
    }

    @Override
    int getIndent()
    {
        return 0;
    }

    @Override
    int getFontSize()
    {
        return 40;
    }

    @Override
    int getLeading()
    {
        return 10;
    }
}
