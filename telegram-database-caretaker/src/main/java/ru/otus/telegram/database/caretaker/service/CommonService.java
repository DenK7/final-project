package ru.otus.telegram.database.caretaker.service;

import org.codehaus.jackson.map.ObjectMapper;
import ru.otus.telegram.database.caretaker.exception.ZipCommonException;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * класс для общих утилитарных функций
 */
public abstract class CommonService {
    public static final ObjectMapper objectMapper = new ObjectMapper();

    private CommonService() {
    }


    /**
     * @param data строка которую нужно зазиповать
     * @return массив байт со сжатой входящей строкой
     */
    public static byte[] zip(String data) {
        return zip(data.getBytes());
    }

    /**
     * @param data массив байт для зипования
     * @return сжатый массив байт
     */
    public static byte[] zip(byte[] data) {
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ZipOutputStream outputStream = new ZipOutputStream(out);
            outputStream.putNextEntry(new ZipEntry("data"));
            outputStream.write(data);
            outputStream.close();
            return out.toByteArray();
        } catch (IOException var3) {
            throw new ZipCommonException("Error zipping data", var3);
        }
    }

    /**
     * @param data сжатый массив байт
     * @return развернутый массив байт
     */
    public static byte[] unzip(byte[] data) {
        try {
            ByteArrayInputStream in = new ByteArrayInputStream(data);
            ZipInputStream inputStream = new ZipInputStream(in);
            inputStream.getNextEntry();
            byte[] buff = new byte[4096];
            ByteArrayOutputStream out = new ByteArrayOutputStream();

            while(true) {
                int len = inputStream.read(buff);
                if (len <= 0) {
                    inputStream.close();
                    return out.toByteArray();
                }

                out.write(buff, 0, len);
            }
        } catch (IOException var6) {
            throw new ZipCommonException("Error unzipping data", var6);
        }
    }

    /**
     * @param json водящий json в виде строки
     * @param clazz класс, в объект которого нужно преобразовать json
     * @param <T> класс, объект которого будет возвращен
     * @return  объект нужного класса, полученый из данных, пришедших из json
     * @throws IOException - ошибка при разборе
     */
    public static <T> T parseJsonFromString(String json, Class<T> clazz) throws IOException {
        return objectMapper.readValue(json, clazz);
    }

    /**
     * @param o объект, с которого нужно получить json
     * @return  строка json, полученная из данных, находящихся в объекте
     * @throws IOException - ошибка при разборе
     */
    public static String parsObjectToJsonString(Object o) throws IOException {
        return objectMapper.writeValueAsString(o);
    }
}
