import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {
    List<Subscriber> phoneBook = new ArrayList<>();
    private static final String FILE_NAME = "phoneBook.json";

    public void addSubscriber(Subscriber subscriber) {
        phoneBook.add(subscriber);
    }

    public void deleteSubscriberByField(String field, String name) {
        Pattern pattern = Pattern.compile(field + "=" + name);
        for (int i = 0; i < phoneBook.size(); i++) {
            Object object = phoneBook.get(i);
            Matcher matcher = pattern.matcher(object.toString());
            if(matcher.find()){
                phoneBook.remove(i);
            }
        }
    }

    public String findSubscriberByField(String field, String name){
        Pattern pattern = Pattern.compile(field + "=" + name);
        for (int i = 0; i < phoneBook.size(); i++) {
            Object object = phoneBook.get(i);
            Matcher matcher = pattern.matcher(object.toString());
            if(matcher.find()){
                return object.toString();
            }
        }

        return "";
    }

    //вывод всех записей с сортировкой по указанному полю (можно ограничиться двумя на выбор)
    //редактирование элемента

    public void createJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDate.class, new LocalDateSerializer());
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer());
        mapper.registerModule(module);

        String json = mapper.writeValueAsString(phoneBook);
        try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(FILE_NAME))) {
            outputStreamWriter.write(json);
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public void parseJson(String fileName) throws JsonProcessingException, FileNotFoundException {
        StringBuilder parseJson = new StringBuilder();
        Scanner scan = new Scanner(new FileInputStream(FILE_NAME));
        while (scan.hasNext()) {
            parseJson.append(scan.nextLine());
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDate.class, new LocalDateSerializer());
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer());
        mapper.registerModule(module);

        phoneBook = mapper.readValue(parseJson.toString(), List.class);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("PhoneBook{\n");
        for (int i = 0; i < phoneBook.size(); i++) {
            stringBuilder.append((i + 1) + " " + phoneBook.get(i) + "\n");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
