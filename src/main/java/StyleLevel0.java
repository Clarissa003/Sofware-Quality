import java.awt.*;

public class StyleLevel0 extends Style
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
        return Color.red;
    }

    @Override
    int getIndent()
    {
        return 0;
    }

    @Override
    int getFontSize()
    {
        return 48;
    }

    @Override
    int getLeading()
    {
        return 20;
    }
}
