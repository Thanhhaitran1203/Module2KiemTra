package controller;

import model.Product;
import storage.ReadAnhWriteFile;

import java.util.*;

public class ProductManager {
    String fileName = "product.csv";
    public static List<Product> listProduct = ReadAnhWriteFile.list;
    public void add(int id,String name,int price,int quantity,String des){
        listProduct.add(new Product(id, name,price, quantity,des));
    }
    public Product getMaxPriceProduct(){
        int index = findIndexMaxProduct();
        return listProduct.get(index);
    }
    public int findIndexMaxProduct(){
        int max = 0;
        int index = -1;
        for(int i= 0;i < listProduct.size();i++){
            if (listProduct.get(i).getPrice() > max){
                max = listProduct.get(i).getPrice();
                index = i;
            }
        }
        return index;
    }
    public void delete(int index){
        listProduct.remove(index);
    }
    public void update(int index,int id,String name,int price,int quantity,String des){
       Product product =  listProduct.get(index);
        product.setId(id);
        product.setName(name);
        product.setPrice(price);
        product.setQuantity(quantity);
        product.setDescribe(des);
    }
    public int getIndex(int code){
        int index = -1;
        for (int i = 0; i < listProduct.size(); i++) {
            Product product = listProduct.get(i);
            if (product.getId() == code){
                index = i;
            }
        }
        return index;
    }
    public boolean checkId(int code){
        boolean check = false;
        for (Product product:listProduct){
            if (product.getId() == code){
                check = true;
            }
        }
        return check;
    }
    public void showProduct(){
        for (Product product:listProduct){
            System.out.println(product);
        }
    }
    public void sortByPrice(){
        Collections.sort(listProduct, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getPrice() < o2.getPrice()){
                    return -1;
                }else if (o1.getPrice() > o2.getPrice()){
                    return 1;
                }else return 0;
            }
        });
    }
    public void sortByPrice2(){
        Collections.sort(listProduct, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getPrice() < o2.getPrice()){
                    return 1;
                }else if (o1.getPrice() > o2.getPrice()){
                    return -1;
                }else return 0;
            }
        });
    }
    public void writeFile(){
        ReadAnhWriteFile.writeFile(fileName);
    }
    public void readFile(){
       listProduct = ReadAnhWriteFile.readFile(fileName);
    }
}
