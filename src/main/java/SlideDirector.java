import java.util.List;

public class SlideDirector
{
    private SlideBuilder builder;

    public SlideDirector (SlideBuilder builder)
    {
        this.builder = builder;
    }

<<<<<<< HEAD
    //Create slide with the builder
    public Slide createSlide(String title, List<? extends SlideItem> slideItems) {
        builder.createTitle(title);
        if (slideItems != null) {
            for (SlideItem item : slideItems) {
                builder.createSlideItem(item);
=======
    public Slide createSlide (String title, List<? extends SlideItem> slideItems)
    {
        builder.createTitle (title);
        if (slideItems != null)
        {
            for (SlideItem item : slideItems)
            {
                builder.createSlideItem (item);
>>>>>>> ce374ceeef8addccd8353186312f32c3379b7756
            }
        }
        return builder.build ();
    }
}
