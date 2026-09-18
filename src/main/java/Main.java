import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    List<String> productList = new ArrayList<>();
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
        System.out.println("Enter name Proudct: ");
        String name = inputString.nextLine();
        productList.add(name);
        System.out.println("Add Product succesful!!!");
    }

    public void showProduct() {
        int index = 1;
        for (String item : productList) {
            System.out.println(index + ". " + item);
            index++;
        }
    }

    public void removeProduct() {
        System.out.println("Enter name Product: ");
        String name = inputString.nextLine();
        int removeIndex = productList.indexOf(name);
        if (removeIndex == -1){
            System.out.println("Khong co san pham nao nhu vay!!!");
        }else {
            productList.remove(removeIndex);
            System.out.println("Remove product successful!!");
        }

    }

    public void updateProduct(){
        System.out.println("Enter name Product: ");
        String name = inputString.nextLine();
        int updateIndex = productList.indexOf(name);
        if (updateIndex==-1){
            System.out.println("Khong co san pham nao nhu vay!!!");
        }else {
            System.out.println("Enter new product name");
            String newName = inputString.nextLine();
            productList.set(updateIndex,newName);
        }
    }

    static void main(String[] args) {
        Main main = new Main();
        main.showMenu();
    }
}
