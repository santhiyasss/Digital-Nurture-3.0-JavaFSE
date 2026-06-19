import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class VerifyInteractionTest {

    private ExternalApi mockApi;
    private MyService service;

    @Before
    public void setUp() {
        mockApi = Mockito.mock(ExternalApi.class);
        service = new MyService(mockApi);
        System.out.println("Setup: Mock created");
    }

    @After
    public void tearDown() {
        mockApi = null;
        service = null;
        System.out.println("Teardown: Mock destroyed");
    }

    @Test
    public void testVerifyInteraction() {
        // Arrange
        when(mockApi.getData()).thenReturn("Mock Data");

        // Act
        service.fetchData();

        // Assert - verify getData() was called exactly once
        verify(mockApi).getData();
        System.out.println("Verified: getData() was called once");
    }

    @Test
    public void testVerifyInteractionCalledTwice() {
        // Arrange
        when(mockApi.getData()).thenReturn("Mock Data");

        // Act
        service.fetchData();
        service.fetchData();

        // Assert - verify getData() was called exactly twice
        verify(mockApi, times(2)).getData();
        System.out.println("Verified: getData() was called twice");
    }

    @Test
    public void testVerifyNoMoreInteractions() {
        // Arrange
        when(mockApi.getData()).thenReturn("Mock Data");

        // Act
        service.fetchData();

        // Assert - verify getData() called once and no other interactions
        verify(mockApi, times(1)).getData();
        verifyNoMoreInteractions(mockApi);
        System.out.println("Verified: No more interactions with mock");
    }

    @Test
    public void testVerifyNeverCalled() {
        // Act - never call fetchData()

        // Assert - verify getData() was never called
        verify(mockApi, never()).getData();
        System.out.println("Verified: getData() was never called");
    }
}