package dz.amine;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.slf4j.Logger;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BasicTestsTest {

    static final Logger log = getLogger(lookup().lookupClass());

    BasicTests basicTests;

    @BeforeAll
    void setupAll() {
        basicTests = new BasicTests("[Complete lifecycle Test]", "");
    }

    @BeforeEach
    void setup() {
        basicTests.initId();
    }

    @Test
    void sumTest() {
        log.debug("Testing sum method in {}", basicTests.getName());

        // exercise
        int sum = basicTests.sum(1, 2, 3);

        // verify
        Assertions.assertTrue(sum == 6);
    }

    @Test
    void concatenateTest() {
        log.debug("Testing sum concatenate in {}", basicTests.getName());

        // exercise
        String phrase = basicTests.concatenate("hello", "world");

        // verify
        Assertions.assertTrue(phrase.equals("hello world"));
    }

    @AfterEach
    void teardown() {
        basicTests.releaseId();
    }

    @AfterAll
    void teardownAll() {
        basicTests.close();
    }
}