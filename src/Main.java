import controller.ProductManager;
import model.Product;
import storage.ReadAnhWriteFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static List<Product> list = ProductManager.listProduct;
    static ProductManager productManager = new ProductManager();

    public static void main(String[] args) {
        menu();

    }

    public static void menu() {
        int choice = -1;
        while (choice != 0) {
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Sắp xếp");
            System.out.println("6. Tìm sản phẩm có giá cao nhất");
            System.out.println("7. Đọc từ file");
            System.out.println("8. Ghi vào file");
            System.out.println("0. Thoát");
            System.out.println("Chọn chức năng");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    productManager.showProduct();
                    break;
                case 2:
                    System.out.println("Mã sản phẩm");
                    int id = sc.nextInt();
                    System.out.println("Tên");
                    String name = sc.next();
                    System.out.println("Giá");
                    int price = sc.nextInt();
                    System.out.println("Số lượng");
                    int quantity = sc.nextInt();
                    System.out.println("mô tả");
                    String des = sc.next();
                    productManager.add(id, name, price, quantity, des);
                    break;
                case 3:
                    System.out.println("Mã sản phẩm");
                    int idUpdate = sc.nextInt();
                    int index = productManager.getIndex(idUpdate);
                    System.out.println("Mã sản phẩm");
                    int idUpdate2 = sc.nextInt();
                    System.out.println("Tên");
                    String nameUpdate = sc.next();
                    System.out.println("Giá");
                    int priceUpdate = sc.nextInt();
                    System.out.println("Số lượng");
                    int quantityUpdate = sc.nextInt();
                    System.out.println("mô tả");
                    String desUpdate = sc.next();
                    productManager.update(index, idUpdate2, nameUpdate, priceUpdate, quantityUpdate, desUpdate);
                    break;
                case 4:
                    System.out.println("Mã sản phẩm");
                    int idDelete = sc.nextInt();
                    int indexDelete = productManager.getIndex(idDelete);
                    productManager.delete(indexDelete);
                    break;
                case 5:
                    int sortChoice = -1;
                    while (sortChoice != 0){
                        System.out.println("1.Sắp xếp tăng dần");
                        System.out.println("2.Sắp xếp giảm dần");
                        System.out.println("0.Thoát");
                        System.out.println("Nhập lựa chon");
                        sortChoice = sc.nextInt();
                        switch (sortChoice) {
                            case 1:
                                productManager.sortByPrice();
                                productManager.showProduct();
                                break;
                            case 2:
                                productManager.sortByPrice2();
                                productManager.showProduct();
                                break;
                        }
                    }
                case 6:
                    System.out.println("sản phẩm có gi cao nhất là");
                    System.out.println(productManager.getMaxPriceProduct());
                    break;
                case 7:
                    System.out.println("sao");
                    String readChoice = "";
                    while (!readChoice.equals("Y") && !readChoice.equals("N")){
                        System.out.println("Đọc file sẽ mất toàn bộ dữ liệu trên bộ nhớ");
                        System.out.println("Y/N");
                        readChoice = sc.next();
                        productManager.readFile();
                    }
                    break;
                case 8:
                    String saveChoice = "";
                    while (!saveChoice.equals("Y") && !saveChoice.equals("N")){
                        System.out.println("bạn muốn lưu");
                        System.out.println("Y/N");
                        saveChoice = sc.next();
                    }
                    productManager.writeFile();
                    break;
            }
        }
    }
}