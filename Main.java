package ua.home.javapro;

public class Main {
    public static final String FILE_PATH = "D:\\Projects\\JavaPro\\HomeWork3_3\\resources\\serialized.txt";

    public static void main(String[] args) {
        SomeClass someClass1 = new SomeClass();
        someClass1.setSomeString("my third HomeWork");
        someClass1.setSomeInt(123456789);
        someClass1.setSomeLong(65432100);
        someClass1.setSomeBoolean(true);

        Serializer.serialize(someClass1, FILE_PATH);
        SomeClass someClass2 = (SomeClass) Serializer.deSerialize(SomeClass.class, FILE_PATH);

        System.out.println(someClass2.getSomeString());
        System.out.println(someClass2.getSomeInt());
        System.out.println(someClass2.getSomeLong());
        System.out.println(someClass2.getSomeBoolean());
    }
}
