public interface SlideBuilder
{
    SlideBuilder createTitle(String title);
    SlideBuilder createSlideItem(SlideItem item);
    SlideBuilder createText(String text);
    Slide build();
}
