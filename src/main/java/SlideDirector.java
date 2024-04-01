import java.util.List;

public class SlideDirector {
    private SlideBuilder builder;

    public SlideDirector(SlideBuilder builder) {
        this.builder = builder;
    }

    public Slide createSlide(String title, List<SlideItem> slideItems) {
        builder.createTitle(title);
        for (SlideItem item : slideItems) {
            builder.createSlideItem(item);
        }
        return builder.build();
    }
}
