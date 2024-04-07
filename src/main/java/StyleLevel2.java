import java.awt.*;

public class StyleLevel2 extends Style
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
        return 50;
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
