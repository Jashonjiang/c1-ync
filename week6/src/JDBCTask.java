import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JDBCTask {
    public static void main(String[] args) throws ClassNotFoundException {
        ResultSet rs = null;
        Statement stmt = null;
        Connection conn = null;
        List<Emp> list = null;
        try {
            conn = JDBCUtils.getConnection();
            //1.插入如下数据
            //('s001','老大',20,'计算机学院')
            //('s002','老二',19,'计算机学院')
            //('s003','老三',18,'计算机学院')
            //('s004','老四',17,'计算机学院')
            String sql = "INSERT INTO STUDENT1 VALUES('s001','老大',20,'计算机学院');";
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            sql = "INSERT INTO STUDENT1 VALUES('s002','老二',19,'计算机学院');";
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            sql = "INSERT INTO STUDENT1 VALUES('s003','老三',18,'计算机学院');";
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            sql = "INSERT INTO STUDENT1 VALUES('s004','老四',17,'计算机学院');";
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            System.out.println("第1题的效果\n------------------");
            list = new JDBCTask().findAll();
            for (Emp e : list){
                System.out.println(e.toString());
            }
            //2.查看表中的所有信息，遍历输出到控制台
            System.out.println("------------------\n第2题的效果\n------------------");
            list = new JDBCTask().findAll();
            for (Emp e : list){
                System.out.println(e.toString());
            }
            //3.把sn0为s004的记录删除
            sql = "DELETE FROM STUDENT1 WHERE SN0='s004'";
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            System.out.println("------------------\n第3题的效果\n------------------");
            list = new JDBCTask().findAll();
            for (Emp e : list){
                System.out.println(e.toString());
            }
            //4.查询sn0为s003的记录
            sql = "SELECT * FROM STUDENT1 WHERE SN0 = 's003';";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            System.out.println("------------------\n第4题的效果\n------------------");
            while (rs.next()) {
                System.out.println(rs.getString("sn0") + " " +
                        rs.getString("name") + " " +
                        rs.getInt("age") + " " +
                        rs.getString("college"));
            }
            // 5.把sno为s001的记录修改为('s001','老大',20,'通信学院')
            sql = "UPDATE STUDENT1 SET COLLEGE = '通信学院' WHERE SN0 = 'S001';";
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            System.out.println("------------------\n第5题的效果\n------------------");
            list = new JDBCTask().findAll();
            for (Emp e : list){
                System.out.println(e.toString());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //回收资源
        JDBCUtils.close(rs,stmt,conn);

    }
    //查询方法
    public List<Emp> findAll(){
        ResultSet rs = null;
        Statement stmt = null;
        Connection conn = null;
        List<Emp> list = null;
        try {
            conn = JDBCUtils.getConnection();
            //定义sql
            String sql = "SELECT * FROM STUDENT1";
            //获取sql执行对象
            stmt = conn.createStatement();
            //执行sql
            rs = stmt.executeQuery(sql);
            //装载集合
            Emp emp = null;
            list = new ArrayList<>();
            while(rs.next()){
                String sn0 = rs.getString("sn0");
                String name = rs.getString("name");
                Integer age = rs.getInt("age");
                String college = rs.getString("college");

                emp = new Emp();
                emp.setSn0(sn0);
                emp.setName(name);
                emp.setAge(age);
                emp.setCollege(college);

                list.add(emp);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(rs,stmt,conn);
        }

        return list;
    }
}

class Emp {
    private String sn0;
    private String name;
    private Integer age;
    private String college;

    public String getSn0() {
        return sn0;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getCollege() {
        return college;
    }

    public void setSn0(String sn0) {
        this.sn0 = sn0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    @Override
    public String toString() {
        return sn0 + " " + name + " " + age + " " + college;
    }
}

class JDBCUtils{
    private static String url;
    private static String user;
    private static String password;
    private static String driver;
    //获取配置文件数据
    static {
        try {
            Properties pro = new Properties();
            //获取scr路径下文件
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
            URL res = classLoader.getResource("jdbc.properties");
            String path = null;
            try {
                path = res.toURI().getPath();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }

            pro.load(new FileReader(path));
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");
            //注册驱动
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //获取连接对象
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    //释放资源
    public static void close(Statement stmt, Connection conn){
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(ResultSet rs, Statement stmt, Connection conn){
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
