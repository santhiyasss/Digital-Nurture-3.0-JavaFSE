import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class MyServiceTest {

    private ExternalApi mockApi;
    private MyService service;

    @Before
    public void setUp() {
        // Create mock object for ExternalApi
        mockApi = Mockito.mock(ExternalApi.class);
        System.out.println("Setup: Mock created");
    }

    @After
    public void tearDown() {
        mockApi = null;
        service = null;
        System.out.println("Teardown: Mock destroyed");
    }

    @Test
    public void testExternalApi() {
        // Arrange - Stub the method to return predefined value
        when(mockApi.getData()).thenReturn("Mock Data");

        // Act - Inject mock into service and call method
        service = new MyService(mockApi);
        String result = service.fetchData();

        // Assert - Verify result matches stubbed value
        assertEquals("Mock Data", result);

        // Verify the mock method was actually called once
        verify(mockApi, times(1)).getData();

        System.out.println("Test passed! Result: " + result);
    }

    @Test
    public void testExternalApiReturnsNull() {
        // Arrange
        when(mockApi.getData()).thenReturn(null);

        // Act
        service = new MyService(mockApi);
        String result = service.fetchData();

        // Assert
        assertNull(result);
        verify(mockApi, times(1)).getData();
    }

    @Test
    public void testExternalApiCalledMultipleTimes() {
        // Arrange
        when(mockApi.getData()).thenReturn("First Call").thenReturn("Second Call");

        // Act
        service = new MyService(mockApi);
        String first = service.fetchData();
        String second = service.fetchData();

        // Assert
        assertEquals("First Call", first);
        assertEquals("Second Call", second);
        verify(mockApi, times(2)).getData();
    }
}