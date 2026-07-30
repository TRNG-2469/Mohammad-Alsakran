package Week2.Thursday.DAO;

import week2.Wedensday.CodeAlongExercise.model.product;
import week2.Wedensday.CodeAlongExercise.utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {
    @Override
    public void createProduct(product product) {

    }

    @Override
    public void updateProduct(product product) {
        String updateSQL = "UPDATE product SET name = ?, price = ? WHERE product_id = ?";
        try(Connection connection = ConnectionFactory.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(updateSQL);
        ) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteProduct(int id) {

    }

    @Override
    public product findById(int id) {
        return null;
    }

    @Override
    public List<product> findAll() {
        return null;
    }
}
