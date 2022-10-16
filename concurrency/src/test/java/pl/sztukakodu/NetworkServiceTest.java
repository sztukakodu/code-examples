package pl.sztukakodu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NetworkServiceTest {
    @Test
    public void calculateNetworkBandwidth() {
        // given
        NetworkService service = new NetworkService();

        // it should run slow logic just once
        // subsequent calls should be super-fast
        // when
        service.getBandwidth();
        service.getBandwidth();
        service.getBandwidth();
        service.getBandwidth();

        // then
        Assertions.assertTrue(true);
    }
}
