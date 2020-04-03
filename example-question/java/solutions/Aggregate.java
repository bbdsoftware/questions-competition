import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {
    public static Map<String, Integer> AggregateNames(String[] nameList) {
        Map<String, Integer> map = new TreeMap<String, Integer>();
        Integer ONE = Integer.valueOf(1);

        for (int i = 0, n = nameList.length; i < n; i++) {
            String name = nameList[i];
            if (map.containsKey(name))
                map.put(name, map.get(name) + 1);
            else
                map.put(name,ONE);
        }
        return map;
    }
}


public class Aggregate {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        Map<String, Integer> res = new TreeMap<String, Integer>();
        
        int _nameList_size = 0;
        _nameList_size = Integer.parseInt(in.nextLine().trim());
        String[] _nameList = new String[_nameList_size];
        String _nameList_item;
        for(int _nameList_i = 0; _nameList_i < _nameList_size; _nameList_i++) {
            try {
                _nameList_item = in.nextLine();
            } catch (Exception e) {
                _nameList_item = null;
            }
            _nameList[_nameList_i] = _nameList_item;
        }
        
        res = Result.AggregateNames(_nameList);
        
        for (Map.Entry<String, Integer> entry : res.entrySet()) {
            bw.write(entry.getKey() + " " + String.valueOf(entry.getValue()));
            bw.newLine();
        }
        bw.close();
    }
}
