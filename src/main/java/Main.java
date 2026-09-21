import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {// entity - đại diện cho các thực thẻ có trong hệ thống
    ProductService productService = new ProductService();
    Scanner inputNumber = new Scanner(System.in);
    Scanner inputString = new Scanner(System.in);

    public void showMenu() {
        int choice;
        do {
            System.out.println("===== Menu =====");
            System.out.println("1. Add product");
            System.out.println("2. Show product list");
            System.out.println("3. Remove product");
            System.out.println("4. Update product");
            System.out.println("0. Exit Menu");
            System.out.println("Enter your choice: ");
            choice = inputNumber.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("=====Add Product=====");
                    addProduct();
                    break;
                case 2:
                    System.out.println("=====Product List=====");
                    showProduct();
                    break;
                case 3:
                    System.out.println("=====Remove Product=====");
                    removeProduct();
                    break;
                case 4:
                    System.out.println("=====Update Product=====");
                    updateProduct();
                    break;
                case 0:
                    System.out.println("Goobye and see you again!!!!");

            }
        } while (choice != 0);
    }

    public void addProduct() {
        long id = Instant.now().getEpochSecond();// lấy Id với số giây khỏi trùng lặp
        System.out.println("Enter name Proudct: ");
        String name = inputString.nextLine();
        System.out.println("Enter product Price");
        double price = inputNumber.nextDouble();
        System.out.println("Enter product discription");
        String dicript = inputString.nextLine();
        Product products = new Product(id, name, price, dicript);
        productService.add(products);
        System.out.println("Add Product succesful!!!");
    }

    public void showProduct() {
        List<Product> list = productService.findAll();
        int index = 1;
        for (Product item : list){
            System.out.println(index + ". Id: " + item.getId() + ", Name: " + item.getName() + ", Price: " + item.getPrice());
            index++;
        }
    }

    public void removeProduct() {
        System.out.println("Enter Id Product: ");
        long removeId = inputNumber.nextLong();
        productService.remove(removeId);
    }

    public void updateProduct() {
        System.out.println("Enter Id Product: ");
        long updateId=inputNumber.nextLong();
        System.out.println("Enter new name Proudct: ");
        String newName = inputString.nextLine();
        System.out.println("Enter new product Price");
        double newPrice = inputNumber.nextDouble();
        System.out.println("Enter new product discription");
        String newDicript = inputString.nextLine();
        Product newProduct = new Product(updateId,newName,newPrice,newDicript);
        productService.updateProduct(updateId, newProduct);
    }

    static void main(String[] args) {
        Main main = new Main();
        main.showMenu();
    }
}
