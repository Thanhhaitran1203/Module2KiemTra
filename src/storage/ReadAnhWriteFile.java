package storage;

import model.Product;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAnhWriteFile {
    public static List<Product> list = new ArrayList<>();
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
//    public static List<Product> readFile(){
//        File file = new File("product.csv");
//        try {
//            BufferedReader br = new BufferedReader(new FileReader(file));
//            String line = "";
//            while ((line = br.readLine()) != null){
//                String[] temp = line.split(",");
//                list.add(new Product(Integer.parseInt(temp[0]),temp[1],Integer.parseInt(temp[2]),Integer.parseInt(temp[3]),temp[4]));
//            }
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        return list;
//    }
//    public static void writeFile(){
//        File file = new File("product.csv");
//        try {
//            FileWriter fileWriter = new FileWriter(file);
//            for (Product product:list){
//                fileWriter.append(String.valueOf(product.getId()));
//                fileWriter.append(COMMA_DELIMITER);
//                fileWriter.append(product.getName());
//                fileWriter.append(COMMA_DELIMITER);
//                fileWriter.append(String.valueOf(product.getPrice()));
//                fileWriter.append(COMMA_DELIMITER);
//                fileWriter.append(String.valueOf(product.getQuantity()));
//                fileWriter.append(COMMA_DELIMITER);
//                fileWriter.append(product.getDescribe());
//                fileWriter.append(NEW_LINE_SEPARATOR);
//                fileWriter.flush();
//                fileWriter.close();
//            }
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//    }
    public static List<Product> readFile(String fileName){
        File file = new File(fileName);
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            list = (List<Product>) ois.readObject();
            ois.close();
        }catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    public static void writeFile(String fileName){
        File file = new File(fileName);
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(list);
            oos.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
