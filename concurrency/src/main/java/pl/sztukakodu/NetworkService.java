package pl.sztukakodu;

import java.util.concurrent.TimeUnit;

// Double-Check Locking Algorithm
class NetworkService {
    private volatile String bandwidth;

    public String getBandwidth() {
        if(bandwidth == null) {
            synchronized (this) {
                if(bandwidth == null) {
                    bandwidth = calculateBandwidth();
                }
            }
        }
        return bandwidth;
    }

    private String calculateBandwidth() {
        try {
            System.out.println("Calculating bandwidth...");
            TimeUnit.SECONDS.sleep(5);
            return "Down: 20 Mb/s, Up: 1 Mb/s";
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
