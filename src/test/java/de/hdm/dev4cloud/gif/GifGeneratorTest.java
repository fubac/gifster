package de.hdm.dev4cloud.gif;

import de.hdm.dev4cloud.gif.dev4cloud.gif.AnimalGifGenerator;
import de.hdm.dev4cloud.gif.dev4cloud.gif.GifGenerator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author patrick.kleindienst
 */

public class GifGeneratorTest {

    private GifGenerator g;

    @Before
    public void setUp() throws Exception {
        g = new AnimalGifGenerator();
    }

    @Test
    public void getRandomMustNotReturnNull() throws Exception {
        String url = g.getRandomURL();

        assertNotNull(url);
    }

    @Test
    public void getRandomMustNotReturnEmptyString() throws Exception {
        String url = g.getRandomURL();

        assertNotEquals("", url);
    }
}
