package Week2.CodeAlongExercise.DAO;

import week2.Wedensday.CodeAlongExercise.model.product;
import week2.Wedensday.CodeAlongExercise.utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {


    @Override
    public void createProduct(product product) {
    String insertSQL = "INSERT INTO product (product_id, name, price) VALUES (?, ?, ?)";
    try (Connection connection = ConnectionFactory.getInstance().getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
        preparedStatement.setInt(1, product.getId());
        preparedStatement.setString(2, product.getName());
        preparedStatement.setDouble(3, product.getPrice());
        preparedStatement.executeUpdate();
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
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
        String deleteSQL = "DELETE FROM product WHERE product_id = ?";
        try (Connection connection = ConnectionFactory.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public product findById(int id) {
        String selectSQL = "SELECT * FROM product WHERE product_id = ?";
        try (Connection connection = ConnectionFactory.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSQL)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return new product(
                        rs.getInt("product_id"),
                        rs.getString("name"),
                        rs.getDouble("price")
                );
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public List<product> findAll() {
        List<product> products = new ArrayList<>();
        String selectSQL = "SELECT * FROM product";
        try (Connection connection = ConnectionFactory.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSQL)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                products.add(new product(
                        rs.getInt("product_id"),
                        rs.getString("name"),
                        rs.getDouble("price")
                ));
            }
            return products;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
