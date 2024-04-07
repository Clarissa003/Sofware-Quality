import java.awt.*;

public class StyleLevel4 extends Style
{
    //Set values for style
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
        return 90;
    }

    @Override
    int getFontSize()
    {
        return 24;
    }

    @Override
    int getLeading()
    {
        return 10;
    }
}
