import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimplePresentationBuilderTest
{

    private SlideBuilder builder;
    private SlideDirector director;

    @BeforeEach
    public void setup()
    {
        builder = new SimplePresentationBuilder();
        director = new SlideDirector(builder);
    }

    @Test
    public void testSimpleSlideBuilder()
    {
        List<SlideItem> slideItems = new ArrayList<>();
        slideItems.add(new TextItem(1, "Simple Text 1"));
        slideItems.add(new TextItem(2, "Simple Text 2"));

        Slide slide = director.createSlide("Simple Slide", slideItems);

        assertEquals("Simple Slide", slide.getTitle());
        assertEquals(2, slide.getSize());

        assertEquals("Simple Text 1", slide.getSlideItem(0).getContent());
        assertEquals("Simple Text 2", slide.getSlideItem(1).getContent());
    }

    @Test
    public void testCreateTitle()
    {
        String title = "Title Test";
        SlideBuilder slideBuilder = new SimplePresentationBuilder();
        Slide slide = slideBuilder.createTitle(title).build();

        assertEquals(title, slide.getTitle());
    }

    @Test
    public void testCreateSlideItem()
    {
        String text = "Slide Item Test";
        SlideBuilder slideBuilder = new SimplePresentationBuilder();
        Slide slide = slideBuilder.createSlideItem(new TextItem(1, text)).build();

        assertEquals(1, slide.getSize());
        assertEquals(text, slide.getSlideItem(0).getContent());
    }

    @Test
    public void testCreateText()
    {
        String text = "Text Test";
        SlideBuilder slideBuilder = new SimplePresentationBuilder();
        Slide slide = slideBuilder.createText(text).build();

        assertEquals(1, slide.getSize());
        assertEquals(text, slide.getSlideItem(0).getContent());
    }
}
