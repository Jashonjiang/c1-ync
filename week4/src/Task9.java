import java.io.*;

/**
 * 9.将之前 c/csatest/demo.txt 中的内容复制到 c/csatest2/demo2.txt 文件中
 */
public class Task9 {
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

        PrintWriter pw = new PrintWriter("C:\\csatest/demo2.txt");
        pw.write(str);
        pw.flush();
        pw.close();
    }
}
