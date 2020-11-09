package ua.home.javapro;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Field;

public class Serializer {
    public static void serialize(Object obj, String fileName) {
        Field[] fields = obj.getClass().getDeclaredFields();
        String values = "";
        try {
            for (Field field : fields) {
                if (field.isAnnotationPresent(Save.class)) {
                    values += field.getName() + "==";
                    field.setAccessible(true);
                    values += field.get(obj) + "#";
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        if (!values.isEmpty()) {
            try {
                FileWriter fileWriter = new FileWriter(fileName);
                fileWriter.write(values);
                fileWriter.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static Object deSerialize(Class<?> c, String fileName) {
        try {
            Object obj = c.newInstance();
            try {
                FileReader fileReader = new FileReader(fileName);
                BufferedReader br = new BufferedReader(fileReader);
                String[] fields = br.readLine().split("#");
                fileReader.close();

                for (String field : fields) {
                    String value[] = field.split("==");
                    Field oField = c.getDeclaredField(value[0]);
                    oField.setAccessible(true);
                    if (oField.getType().getSimpleName().equals("int"))
                        oField.set(obj, Integer.parseInt(value[1]));
                    if (oField.getType().getSimpleName().equals("long"))
                        oField.set(obj, Long.parseLong(value[1]));
                    if (oField.getType().getSimpleName().equals("String"))
                        oField.set(obj, value[1]);
                    if (oField.getType().getSimpleName().equals("boolean"))
                        oField.set(obj, Boolean.parseBoolean(value[1]));
                }
                return obj;
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
