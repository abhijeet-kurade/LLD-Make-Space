package Scheduler;

import java.util.ArrayList;
import java.util.List;

public class BufferTimeHandler {
    List<BufferTime> bufferTime;

    public BufferTimeHandler() {
        this.bufferTime = new ArrayList<>();

        for (BufferTime time : BufferTime.values()) {
            this.bufferTime.add(time);
        }
    }

    public List<BufferTime> getBufferTime() {
        return this.bufferTime;
    }
}
