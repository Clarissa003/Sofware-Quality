import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FancyPresentationBuilderTest {

    private SlideBuilder builder;
    private SlideDirector director;

    @BeforeEach
    public void setup() {
        builder = new FancyPresentationBuilder();
        director = new SlideDirector(builder);
    }

    @Test
    public void testFancySlideBuilder() {
        List<SlideItem> slideItems = new ArrayList<>();
        slideItems.add(new TextItem(1, "Fancy Text 1"));
        slideItems.add(new TextItem(2, "Fancy Text 2"));

        Slide slide = director.createSlide("Fancy Slide", slideItems);

        assertEquals("Fancy:Fancy Slide", slide.getTitle());
        assertEquals(2, slide.getSize());

        // Check the contents of the slide items
        assertEquals("Fancy Text 1", slide.getSlideItem(0).getContent());
        assertEquals("Fancy Text 2", slide.getSlideItem(1).getContent());
    }

    @Test
    public void testCreateTitle() {
        String title = "Fancy Title Test";
        SlideBuilder slideBuilder = new FancyPresentationBuilder();
        Slide slide = slideBuilder.createTitle(title).build();

        assertEquals("Fancy:" + title, slide.getTitle());
    }

    @Test
    public void testCreateSlideItem() {
        String text = "Fancy Slide Item Test";
        SlideBuilder slideBuilder = new FancyPresentationBuilder();
        Slide slide = slideBuilder.createSlideItem(new TextItem(1, text)).build();

        assertEquals(1, slide.getSize());
        assertEquals(text, slide.getSlideItem(0).getContent());
    }

    @Test
    public void testCreateText() {
        String text = "Fancy Text Test";
        SlideBuilder slideBuilder = new FancyPresentationBuilder();
        Slide slide = slideBuilder.createText(text).build();

        assertEquals(1, slide.getSize());
        assertEquals(text, slide.getSlideItem(0).getContent());
    }
}
