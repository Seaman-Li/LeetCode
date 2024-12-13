import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

class PPGSample {
    private long timestamp;
    private double value;

    public PPGSample(long timestamp, double value) {
        this.timestamp = timestamp;
        this.value = value;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public double getValue() {
        return value;
    }
}

public class binary_convert {
    public static byte[] serializePPGSamples(List<PPGSample> samples) {
        // 计算所需的ByteBuffer大小：每个时间戳8字节，每个值8字节
        ByteBuffer buffer = ByteBuffer.allocate(samples.size() * (Long.BYTES + Double.BYTES));
        for (PPGSample sample : samples) {
            buffer.putLong(sample.getTimestamp());
            buffer.putDouble(sample.getValue());
        }
        return buffer.array();
    }

    public static List<PPGSample> deserializePPGSamples(byte[] data) {
        ByteBuffer buffer = ByteBuffer.wrap(data);
        List<PPGSample> samples = new ArrayList<>();
        while (buffer.hasRemaining()) {
            long timestamp = buffer.getLong();
            double value = buffer.getDouble();
            samples.add(new PPGSample(timestamp, value));
        }
        return samples;
    }

    public static void main(String[] args) {
        List<PPGSample> samples = new ArrayList<>();
        samples.add(new PPGSample(1732346701044L, 385689.0));
        samples.add(new PPGSample(1732346701049L, 386342.0));
        samples.add(new PPGSample(1732346701055L, 386583.0));

        byte[] binaryData = serializePPGSamples(samples);
        System.out.println("Serialized binary data: " + java.util.Arrays.toString(binaryData));

        List<PPGSample> deserializedSamples = deserializePPGSamples(binaryData);
        for (PPGSample sample : deserializedSamples) {
            System.out.println("Timestamp: " + sample.getTimestamp() + ", Value: " + sample.getValue());
        }
    }
}
