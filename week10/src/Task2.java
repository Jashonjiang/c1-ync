import java.util.HashSet;
import java.util.Set;

/**
 * ②一个字符串的非空子串是指字符串中长度至少为 1 的连续的一段字符组成的 串。
 * 例如，字符串 aaab 有非空子串 a, b, aa, ab, aaa, aab, aaab，一共 7 个。
 * （注意在计算时，只算本质不同的串的个数）
 * 请问，字符串 0100110001010001 有多少个不同的非空子串？
 */
public class Task2 {
    public static void main(String[] args) {
        String string = "0100110001010001";
        Set<String> set = new HashSet<>();
        for(int i = 1; i <= string.length(); i++){
            for(int j = 0; j+i <= string.length(); j++){
                set.add(string.substring(j, j+i));
            }
        }
        System.out.println(set.size());
    }
}
