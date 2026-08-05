package Week2.Wedensday.CodeAlongExercise.Service;

import week2.Wedensday.CodeAlongExercise.DAO.ProductDAO;
import week2.Wedensday.CodeAlongExercise.DAO.ProductDAOImpl;
import week2.Wedensday.CodeAlongExercise.model.product;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    @Override
    public void createProduct(product product) {
        ProductDAO productDAO = new ProductDAOImpl();

        if (product.getName() == null ||
                product.getName().isEmpty() ||
                product.getPrice() < 0) {

            throw new IllegalArgumentException("Invalid product data");
        }

        productDAO.createProduct(product);
    }

    @Override
    public void updateProduct(product product) {
        ProductDAO productDAO = new ProductDAOImpl();
        if (product.getName() == null || product.getName().isEmpty() || product.getPrice() < 0) {
            throw new IllegalArgumentException("Invalid product data");
        }
        productDAO.updateProduct(product);

    }

    @Override
    public void deleteProduct(int id) {
        ProductDAO productDAO = new ProductDAOImpl();
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid product ID");
        }
        productDAO.deleteProduct(id);
    }

    @Override
    public product findById(int id) {
        ProductDAO productDAO = new ProductDAOImpl();
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid product ID");
        }
        return productDAO.findById(id);
    }

    @Override
    public List<product> findAll() {
        ProductDAO productDAO = new ProductDAOImpl();
        return productDAO.findAll();
    }
    // Implement the methods defined in the ProductService interface


}
