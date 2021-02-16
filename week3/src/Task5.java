/*
 * 5.自定义一个异常类，然后在发生异常时能调用到你自定义的异常类
 */
public class Task5 {
    public static void main(String[] args) throws TCPException {
        try{
            int i = 3/0;
        }catch (Exception e){
            throw new TCPException(false,20001,"发生了除零错误");
        }
    }
}

class TCPException extends Exception{
    public TCPException(boolean b, int i, String s){
        super(b + ", " + i + "," + s);
    }
}