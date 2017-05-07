package de.hdm.dev4cloud.gif.dev4cloud.gif;

import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author patrick.kleindienst
 */

@Component
public class AnimalGifGenerator implements GifGenerator {

    private static String[] animalGifs = new String[]{
            "https://media3.giphy.com/media/WXB88TeARFVvi/200w.webp#4-grid1",
            "https://media3.giphy.com/media/6XjDsvyFpIhYA/200.webp#15-grid1",
            "https://media0.giphy.com/media/5KuPVqoVRvQcg/200w.webp#11-grid1",
            "https://media0.giphy.com/media/14uXQbPS73Y3qU/200.webp#5-grid1",
            "https://media2.giphy.com/media/g69ZPJfLy7hD2/200w.webp#0-grid1",
            "https://media2.giphy.com/media/11StaZ9Lj74oCY/200.webp#6-grid1",
            "https://media0.giphy.com/media/uSYQsJQWEv6O4/giphy.gif#1-grid1",
            "https://media1.giphy.com/media/GFHJXPCoVQEec/200.webp#3-grid1",
            "https://media0.giphy.com/media/kLLvH1EOtCwQ8/200.webp#20-grid1",
            "https://media4.giphy.com/media/8nv5NfqUxWJt6/200.webp#25-grid1"
    };

    private final Random random;

    public AnimalGifGenerator() {
        random = new Random();
    }

    @Override
    public String getRandomURL() {
        return animalGifs[getNextRandomGifIndex()];
    }

    private int getNextRandomGifIndex() {
        return random.nextInt(animalGifs.length);
    }

}
