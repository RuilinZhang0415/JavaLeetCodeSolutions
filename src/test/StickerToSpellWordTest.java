package test;

import main.StickerToSpellWord;
import org.junit.Test;

import static org.junit.Assert.*;

public class StickerToSpellWordTest {
    @Test
    public void testMinStickers() {
        StickerToSpellWord test = new StickerToSpellWord();

        String[] stickers = {"abbcc", "abbbc", "ccc", "ccd"};
        String target = "abbbcccd";
        assertEquals(test.minStickers(stickers, target), 2);

        stickers = new String[] {"a", "c"};
        target = "b";
        assertEquals(test.minStickers(stickers, target), -1);

        System.out.println("\nbelow: ");
        stickers = new String[] {"these","guess","about","garden","him"};
        target = "atomher";
        assertEquals(test.minStickers(stickers, target), 3);
    }
}
