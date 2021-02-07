/*
 * 10.USB 接口程序设计
 */

import java.util.ArrayList;

public class Task10 {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.add(new Mouse());
        computer.add(new KeyBoard());
        computer.add(new Microphone());
        computer.powerOn();
        System.out.println("------------");
        computer.powerOff();
    }

}

/*
 * USB接口定义设备启动和关闭的方法
 */
interface USB
{
    void trunOn();
    void trunOff();
}

class Mouse implements USB
{
    public void trunOn()
    {
        System.out.println("鼠标启动了");
    }

    public void trunOff()
    {
        System.out.println("鼠标关闭了");
    }
}

class KeyBoard implements USB
{
    public void trunOn()
    {
        System.out.println("键盘启动了");
    }

    public void trunOff()
    {
        System.out.println("键盘关闭了");
    }
}

class Microphone implements USB
{
    public void trunOn()
    {
        System.out.println("麦克风启动了");
    }

    public void trunOff()
    {
        System.out.println("麦克风关闭了");
    }
}

class Computer
{
    private USB[] usbArr = new USB[4];

    public void add(USB usb)
    {
        for (int i = 0; i < usbArr.length; i++)
        {
            if (usbArr[i] == null)
            {
                usbArr[i] = usb;
                break;
            }
        }
    }

    public void powerOn()
    {
        for (int i = 0; i < usbArr.length; i++)
        {
            if (usbArr[i] != null)
            {
                usbArr[i].trunOn();
            }
        }
        System.out.println("电脑开机成功");
    }

    public void powerOff()
    {
        for (int i = 0; i < usbArr.length; i++)
        {
            if (usbArr[i] != null)
            {
                usbArr[i].trunOff();
            }
        }
        System.out.println("电脑关机成功");
    }
}