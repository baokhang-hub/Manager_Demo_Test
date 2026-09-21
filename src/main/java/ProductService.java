import java.util.ArrayList;
import java.util.List;

public class ProductService {// service - tầng nghiệp vụ xử lý logic trong hệ thống
    public List<Product> productList = new ArrayList<>();

    public List<Product> findAll(){
        return productList;
    }

    public void add(Product newProduct){
        productList.add(newProduct);
    }

    public void remove(long id){
        int index = this.findIndexById(id);
        if (index == -1){
            System.out.println("Khong co san pham nao!!!");
        }else {
            productList.remove(index);
            System.out.println("Xoa thanh cong");
        }
    }

    public void updateProduct(long id, Product newProduct){
        int index = this.findIndexById(id);
        productList.set(index, newProduct);
    }

    private int findIndexById(long id){
        for (int i = 0; i < this.productList.size(); i++) {
            Product item = this.productList.get(i);
            if (item.getId()==id){
                return  i;
            }
        }
        return -1;
    }
}
