package Week2.CodeAlongExercise.DAO;

import week2.Wedensday.CodeAlongExercise.model.product;

import java.util.List;

public interface ProductDAO {
    // CRUD

    void createProduct(product product);
    void updateProduct(product product);
    void deleteProduct(int id);

    // Read All, Read One
    product findById(int id);
    List<product> findAll();

}
