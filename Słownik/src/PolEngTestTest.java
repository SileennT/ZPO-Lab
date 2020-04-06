import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PolEngTestTest {

    @Test
    public void checkIfNoDuplicates() {
        PolEngTest eng = new PolEngTest();
        eng.questions.forEach(it -> {
            Assert.assertEquals(1, Collections.frequency(eng.questions, it));
        });

    }

    @Test
    public void stop() {
    }
}

class LevensteinTest{
    @org.junit.jupiter.api.Test
    void levQWERTY() {
        assertEquals(1,Levenstein.LevQWERTY("cat","caat"));
        assertEquals(1,Levenstein.LevQWERTY("run","runn"));
        assertEquals(1,Levenstein.LevQWERTY("catch","cath"));
        assertEquals(0,Levenstein.LevQWERTY("catch","catch"));
        assertEquals(0,Levenstein.LevQWERTY("cat","cat"));
        assertEquals(2,Levenstein.LevQWERTY("cat","cry"));
        assertEquals(3,Levenstein.LevQWERTY("cat","asd"));
    }
}
