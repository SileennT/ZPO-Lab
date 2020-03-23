import static org.junit.jupiter.api.Assertions.*;

class LevensteinTest{
    @org.junit.jupiter.api.Test
    void levQWERTY() {
        assertEquals(3,Levenstein.LevQWERTY("halo","aloha"));
        assertEquals(3,Levenstein.LevQWERTY("tomek","tola"));
        assertEquals(2,Levenstein.LevQWERTY("romek","radek"));
        assertEquals(0.5,Levenstein.LevQWERTY("lolek","lilek"));
        assertEquals(0,Levenstein.LevQWERTY("ala","ala"));
    }
}