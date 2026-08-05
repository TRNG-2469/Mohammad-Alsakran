package Week2.Wedensday.CodeAlongExercise.Service;

import Week2.Wedensday.CodeAlongExercise.model.product;

import java.util.List;

public interface ProductService {

    void createProduct(product product);
    void updateProduct(product product);
    void deleteProduct(int id);

    // Read All, Read One
    product findById(int id);
    List<product> findAll();
}
