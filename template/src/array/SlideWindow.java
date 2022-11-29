package array;

import java.util.HashMap;
import java.util.Map;

public class SlideWindow {
    public void slideWindow(String s, String t){
        Map<Character, Integer> need=new HashMap<>();
        Map<Character, Integer> window=new HashMap<>();
        for(char c:s.toCharArray())
            need.put(c, need.getOrDefault(c,0)+1);

        int left=0, right=0, count=0;
        
    }
}
