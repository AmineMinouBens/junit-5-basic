package dz.amine;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

import java.io.Closeable;
import java.util.UUID;
import java.util.stream.IntStream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasicTests implements Closeable {

    static final Logger log = getLogger(lookup().lookupClass());

    String name;
    String id;

    public void initId() {
        id = UUID.randomUUID().toString();
        log.info("Id created: {}", id);
    }

    public void releaseId() {
        if (id == null) {
            throw new IllegalArgumentException(name + " not initialized");
        }
        log.info("Id released: {}", id);
        id = null;
    }

    public int sum(int... numbers) {
        return IntStream.of(numbers).sum();
    }

    public String concatenate(String... words) {
        return String.join(" ", words);
    }

    public void close() {
        log.info("{} closed", name);
    }
}
