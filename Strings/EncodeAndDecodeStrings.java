package Strings;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {
    
    public String encode(List<String> strs) {

        StringBuilder result = new StringBuilder();
        for(String str: strs) {
            result.append(str.length()).append("_").append(str);
        }
        return result.toString();
        
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> decoded = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int underscoreIndex = s.indexOf("_", i);
            int length = Integer.parseInt(s.substring(i, underscoreIndex));
            i = underscoreIndex + 1;
            decoded.add(s.substring(i, i + length));
            i += length;
        }
        return decoded;
    }
}
