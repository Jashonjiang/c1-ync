import java.io.*;
import java.util.ArrayList;

/**
 * 8.在电脑 c 盘的 csatest 目录下，创建一个名称为 demo.txt 的文件。然后将下列内容：
 */
public class Task8 {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\csatest/demo.txt");
        FileReader reader = new FileReader(file);
        BufferedReader bReader = new BufferedReader(reader);
        StringBuilder sb = new StringBuilder();
        String s = "";
        while ((s = bReader.readLine()) != null) {
            sb.append(s + "\n");
        }
        bReader.close();
        String str = sb.toString();
        System.out.println("该文本内容为：" + str);

        ArrayList nums = new ArrayList();
        for (int i = 0; i < str.length(); i++)
        {
            if (str.charAt(i) >= 48 && str.charAt(i) <= 57)
            {
                int j = i;
                while (j < str.length() && str.charAt(j) >= 48 && str.charAt(j) <= 57)
                {
                    j++;
                }
                if (j < str.length())
                {
                    nums.add(Integer.valueOf(str.substring(i, j)));
                }
                else
                {
                    nums.add(Integer.valueOf(str.substring(i)));
                }
                i = j;
            }
        }

        System.out.println("该文本含有2021的个数：" + nums.size());
    }
}
