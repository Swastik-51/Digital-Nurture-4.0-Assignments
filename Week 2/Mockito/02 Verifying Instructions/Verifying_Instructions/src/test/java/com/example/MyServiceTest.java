package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    public void testVerifyInteraction() {
        // Step 1: Mock ExternalApi
        ExternalApi mockApi = mock(ExternalApi.class);

        // Step 2: Inject mock into MyService
        MyService service = new MyService(mockApi);

        // Step 3: Call method
        service.fetchData();

        // Step 4: Verify method call
        verify(mockApi).getData();
    }
}
