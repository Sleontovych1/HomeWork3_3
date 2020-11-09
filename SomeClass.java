package ua.home.javapro;

public class SomeClass {
    @Save private int someInt;
    @Save private long someLong;
    @Save private String someString;
    @Save private boolean someBoolean;

    public String getSomeString() {
        return someString;
    }

    public void setSomeString(String someString) {
        this.someString = someString;
    }

    public int getSomeInt() {
        return someInt;
    }

    public void setSomeInt(int someInt) {
        this.someInt = someInt;
    }

    public long getSomeLong() {
        return someLong;
    }

    public void setSomeLong(long someLong) {
        this.someLong = someLong;
    }

    public boolean getSomeBoolean() {
        return  someBoolean;
    }

    public void setSomeBoolean(boolean var) {
        this.someBoolean = var;
    }
}