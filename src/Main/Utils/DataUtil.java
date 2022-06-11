package Main.Utils;

import Main.Class.Event;
import Main.Data.StaticData;
import Main.Main;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;


import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Type;

public class DataUtil {



    /**
     * 序列化函数
     *
     * @param object 需要序列化的对象
     */
    public static void writeObj(Object object, File file) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file.getPath()));
            objectOutputStream.writeObject(object);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * @param file 需要序列化的对象的文件
     * @return 反序列化
     */
    public static Object readObj(File file) {
        Object object = null;
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file.getPath()));
            try {
                object = (Object) objectInputStream.readObject();
                for (Field field : object.getClass().getFields()) {
                    System.out.println("reading field from object" + field.getName() + ": " + field.toString());
                }


            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return object;
    }

    public static void saveAll() throws IOException {
        saveEvents();
    }

    public static void saveEvents() throws IOException {
        writeObj(Main.staticData.perMissionData, new File("./permission"));
    }


}
