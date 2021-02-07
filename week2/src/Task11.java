import java.util.ArrayList;

/*
 * 11.宠物商店
 */
public class Task11 {
    public static void main(String[] args) {
        PetShop shop = new PetShop();
        shop.add(new Cat("波斯猫",1));
        shop.add(new Cat("小奶猫",2));
        shop.add(new Cat("波米拉猫",1));
        shop.add(new Dog("松狮",1));
        shop.add(new Dog("波尔多",2));
        shop.delete(new Cat("波米拉猫",1));
        ArrayList all = shop.search("波");
        for (int i = 0; i < all.size(); i++)
        {
            System.out.println(all.get(i));
        }
    }
}

interface Pet
{
    String getName();
    int getAge();
}

class PetShop
{
    public PetShop() {}

    // 宠物列表
    private ArrayList pets = new ArrayList();

    // 增加宠物信息
    public void add(Pet pet)
    {
        this.pets.add(pet);
    }

    // 删除宠物信息
    public void delete(Pet pet)
    {
        this.pets.remove(pet);
    }

    // 模糊查找
    public ArrayList search(String kewWord)
    {
        ArrayList result = new ArrayList();

        // 添加满足keyWord的宠物到要返回的数组
        for (int i = 0; i < pets.size(); i++)
        {
            Pet p = (Pet) pets.get(i);
            if (p.getName().contains(kewWord))
            {
                result.add(pets.get(i));
            }
        }

        return result;
    }
}

class Cat implements Pet
{
    private String name;
    private int age;

    public Cat(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public Cat() {}

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }

        if (obj == null)
        {
            return false;
        }

        if (!(obj instanceof Cat))
        {
            return false;
        }

        Cat c = (Cat) obj;
        if (this.name.equals(c.name) && this.age == c.age)
        {
            return true;
        }

        return false;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    public String toString()
    {
        return "猫的名字：" + this.name + ". 年龄：" + this.age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Dog implements Pet
{
    private String name;
    private int age;

    public Dog(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public Dog() {}

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }

        if (obj == null)
        {
            return false;
        }

        if (!(obj instanceof Dog))
        {
            return false;
        }

        Dog d = (Dog) obj;
        if (this.name.equals(d.name) && this.age == d.age)
        {
            return true;
        }

        return false;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    public String toString()
    {
        return "狗的名字：" + this.name + ". 年龄：" + this.age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}