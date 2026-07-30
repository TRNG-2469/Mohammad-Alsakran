package Week2.Thursday;

import week2.Wedensday.CodeAlongExercise.DAO.ProductDAO;
import week2.Wedensday.CodeAlongExercise.DAO.ProductDAOImpl;
import week2.Wedensday.CodeAlongExercise.model.product;

public class MainClass {
    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAOImpl();
        product product = new product(5, "WiFi", 250);
        productDAO.updateProduct(product);
    }
}
