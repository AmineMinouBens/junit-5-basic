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

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BasicTest {

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

    @Test
    void assertJTest() {
        log.debug("Assertions using AssertJ");

        int sum = 1 + 1;

        assertThat(sum).isGreaterThan(1).isLessThan(3);
        assertThat(sum).isEqualTo(2);
    }

    @Test
    void standardAssertions() {
        assertEquals(2, 2);
        assertTrue(true,
                "The optional assertion message is now the last parameter");
        assertFalse(false, () -> "Really " + "expensive " + "message" + ".");
    }

    @Test
    void truthTest() {
        log.debug("Assertion using Truth");

        int sum = 1 + 1;

        assertThat(sum).isEqualTo(2);
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