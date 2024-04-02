import java.awt.*;

public class StyleLevel2 extends Style
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
        return 36;
    }

    @Override
    int getLeading()
    {
        return 10;
    }
}
