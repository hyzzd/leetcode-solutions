public class Codec {

    Map<Integer, String> map = new HashMap<>();
    Random r = new Random();
    int key = r.nextInt(10000);

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        while (map.containsKey(key))
            key = r.nextInt(10000);
        map.put(key, longUrl);
        return "http://tinyurl.com/" + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));

// Using random value key
