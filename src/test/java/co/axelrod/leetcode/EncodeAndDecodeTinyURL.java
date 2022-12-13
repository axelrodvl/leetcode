package co.axelrod.leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/encode-and-decode-tinyurl/
 */
class EncodeAndDecodeTinyURL {
    @Test
    void tinyUrlTest() {
        String input = "https://leetcode.com/problems/design-tinyurl";
        String tiny = encode(input); // returns the encoded tiny url.
        assertEquals("http://tinyurl.com/-1163677885", tiny);
        String ans = decode(tiny); // returns the original url after deconding it.
        assertEquals(input, ans);
    }

    private static final String PREFIX = "http://tinyurl.com/";

    private Map<Integer, String> urls = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int hash = longUrl.hashCode();
        urls.put(hash, longUrl);
        return PREFIX + hash;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return urls.get(Integer.valueOf(shortUrl.replace(PREFIX, "")));
    }
}
