import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SlideDirectorTest
{

    private SlideBuilder builder;
    private SlideDirector director;

    @BeforeEach
    public void setup()
    {
        builder = new SimplePresentationBuilder(); // Use any builder here for testing
        director = new SlideDirector(builder);
    }

    @Test
    public void testSlideDirector()
    {
        List<SlideItem> slideItems = new ArrayList<>();
        slideItems.add(new TextItem(1, "Text 1"));
        slideItems.add(new TextItem(2, "Text 2"));

        Slide slide = director.createSlide("Test Slide", slideItems);

        assertEquals("Test Slide", slide.getTitle());
        assertEquals(2, slide.getSize());

        assertEquals("Text 1", slide.getSlideItem(0).getContent());
        assertEquals("Text 2", slide.getSlideItem(1).getContent());
    }

    @Test
    public void testSlideDirectorWithEmptyList()
    {
        List<SlideItem> emptySlideItems = new ArrayList<>();

        Slide slide = director.createSlide("Empty Slide", emptySlideItems);

        assertEquals("Empty Slide", slide.getTitle());
        assertEquals(0, slide.getSize());
    }

    @Test
    public void testSlideDirectorWithNullList()
    {
        Slide slide = director.createSlide("Null Slide", null);

        assertEquals("Null Slide", slide.getTitle());
        assertEquals(0, slide.getSize());
    }
}
