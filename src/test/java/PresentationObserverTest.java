import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PresentationObserverTest {

    @Test
    public void testPresentationObserverMock() {
        Presentation presentation = new Presentation();
        PresentationObserverMock observer = new PresentationObserverMock();
        presentation.addObserver(observer);

        assertEquals(0, observer.getUpdateCallCount());

        presentation.notifyObservers();
        assertEquals(1, observer.getUpdateCallCount());

        presentation.notifyObservers();
        assertEquals(2, observer.getUpdateCallCount());
    }

    static class PresentationObserverMock implements PresentationObserver {
        private int updateCallCount = 0;

        @Override
        public void update() {
            updateCallCount++;
        }

        public int getUpdateCallCount() {
            return updateCallCount;
        }
    }
}
