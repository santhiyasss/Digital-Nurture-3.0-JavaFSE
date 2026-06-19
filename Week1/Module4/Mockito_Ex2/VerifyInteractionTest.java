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
       
        when(mockApi.getData()).thenReturn("Mock Data");

        service.fetchData();

        verify(mockApi).getData();
        System.out.println("Verified: getData() was called once");
    }

    @Test
    public void testVerifyInteractionCalledTwice() {
      
        when(mockApi.getData()).thenReturn("Mock Data");

        service.fetchData();
        service.fetchData();

        verify(mockApi, times(2)).getData();
        System.out.println("Verified: getData() was called twice");
    }

    @Test
    public void testVerifyNoMoreInteractions() {
        
        when(mockApi.getData()).thenReturn("Mock Data");

        service.fetchData();

        verify(mockApi, times(1)).getData();
        verifyNoMoreInteractions(mockApi);
        System.out.println("Verified: No more interactions with mock");
    }

    @Test
    public void testVerifyNeverCalled() {
        
        verify(mockApi, never()).getData();
        System.out.println("Verified: getData() was never called");
    }
}