class MapSum {

    Map<String, Integer> map;
    Map<String, Integer> score;

    /** Initialize your data structure here. */
    public MapSum() {
        map = new HashMap<String, Integer>();
        score = new HashMap<String, Integer>();
    }

    public void insert(String key, int val) {
        int delta = val - map.getOrDefault(key, 0);
        map.put(key, val);
        String prefix = "";
        for (char c : key.toCharArray()) {
            prefix += c;
            score.put(prefix, score.getOrDefault(prefix, 0) + delta);
        }
    }

    public int sum(String prefix) {
        return score.getOrDefault(prefix, 0);
    }
}

/**
 * Your MapSum object will be instantiated and called as such: MapSum obj = new
 * MapSum(); obj.insert(key,val); int param_2 = obj.sum(prefix);
 */

// O(k) k-length of the key
// O(n)
