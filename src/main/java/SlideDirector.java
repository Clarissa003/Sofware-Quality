import java.util.List;

public class SlideDirector {
    private SlideBuilder builder;

    public SlideDirector(SlideBuilder builder) {
        this.builder = builder;
    }

    public Slide createSlide(String title, List<? extends SlideItem> slideItems) {
        builder.createTitle(title);
        if (slideItems != null) {
            for (SlideItem item : slideItems) {
                builder.createSlideItem(item);
            }
        }
        return builder.build();
    }
}
