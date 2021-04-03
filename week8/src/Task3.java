import java.util.ArrayList;
import java.util.List;

/**
 * 3.最长单词
 * 给定一组单词words，编写一个程序，找出其中的最长单词，且该单词由这组单词中的 其他单词组合而成。
 * 若有多个长度相同的结果，返回其中字典序最小的一项，若没有符 合要求的单词则返回空字符串。
 */

public class Task3 {
    public static void main(String[] args) {
        String[] strings = new String[]{"cat", "banana", "dog", "nana", "walk", "walker", "dogwalker"};
        String s = A(strings);
        System.out.println(s);
    }

    //找出其中的最长单词，且该单词由这组单词中的 其他单词组合而成
    public static String A(String[] strings){
        List<Integer> list = maxLen(strings);
        for(int d : list){
            if(fun(strings, d)){
                return strings[d];
            }
        }

        return "";
    }

    //找到该数组中最长的字符串的下标集合
    public static List<Integer> maxLen(String[] strings){
        List<Integer> list = new ArrayList<>();
        int maxLen = strings[0].length();
        for(int i = 1; i < strings.length; i++){
            if(maxLen < strings[i].length()){
                maxLen = strings[i].length();
            }
        }
        for(int i = 0; i < strings.length; i++){
            if(strings[i].length() == maxLen){
                list.add(i);
            }
        }
        return list;
    }

    //判断一个字符串是否可以由数组中其他两个字符串连接而成
    public static boolean fun(String[] strings, int d){
        for(int i = 0; i < strings.length; i++){
            if(i == d) continue;
            for(int j = 0; j < strings.length; j++){
                if(j == d || j == i) continue;
                if(strings[d].equals(strings[i] + strings[j])){
                    return true;
                }
            }
        }
        return false;
    }
}
