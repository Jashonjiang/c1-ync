import java.util.*;

/**
 * 7.给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字
 */
public class Task7 {
    public static void main(String[] args) {
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        String[] str1 = new String[strs.length];
        for (int k = 0; k <strs.length; k++){
            char[] chars = strs[k].toCharArray();
            for (int i = 0; i < chars.length - 1; i++){
                for (int j = i+1; j < chars.length; j++){
                    if (chars[j] < chars[i]){
                        char temp = chars[i];
                        chars[i] = chars[j];
                        chars[j] = temp;
                    }
                }
            }
            String s = "";
            for (char ch : chars){
                s += ch;
            }
            str1[k] = s;
        }

        Set<String> set = new HashSet<>();
        for (String s : str1){
            set.add(s);
        }

        ArrayList[] lists = new ArrayList[set.size()];
        for (int i = 0; i < set.size(); i++){
            lists[i] = new ArrayList<String>();
        }

        int m = 0;
        for (String s : set){
            for (int j = 0; j < str1.length; j++){
                if (s.equals(str1[j])){
                    lists[m].add(strs[j]);
                }
            }
            m++;
        }

        System.out.println(Arrays.deepToString(lists));
    }
}
