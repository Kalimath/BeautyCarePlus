
package domain.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/*public class UserRepositorySQL implements UserRepository {

    private Properties properties = new Properties();
    private String url = "jdbc:mysql://81.82.179.4:3306/klanten";

    public UserRepositorySQL(Properties properties) {
        this.properties = properties;
        try {
            Class.forName("org.gjt.mm.mysql.Driver"); // als dit niet juist is miis dit: Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new DbException(e.getMessage(), e);
        }
    }


*//**
     * Returns product with given name
     *
     * @param name
     * @return null if no product with given name is found
     * @trows IllegalArgumentException if the given name is not effective of empty
     *//*

    *//*@Override
    public Product get(String name) {
        Product p = null;
        String query = "select * from veggie where name like  ? ";
        try(Connection connection = DriverManager.getConnection(url,properties); PreparedStatement statement = connection.prepareStatement(query)){
            statement.setString(1,name);
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                String nameProduct = set.getString("name");
                double price = Double.parseDouble(set.getString("price"));
                boolean veg = set.getString("vegetarian").equals("t");
                p = new Product(nameProduct, price, veg);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }*//*


*//**
     * Returns a list with all products
     *//*

    @Override
    public List<Product> getAll() {
        try (Connection connection = DriverManager.getConnection(url, properties);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM veggie order by name");
            return createListFromResultset(resultSet);
        } catch (SQLException e) {
            throw new DbException(e.getMessage(), e);
        }
    }

    public void addProduct(Product dish){
        String query = "insert into veggie(name,price,vegetarian) values(?,?,?)";
        try(Connection connection = DriverManager.getConnection(url,properties); PreparedStatement statement = connection.prepareStatement(query)){
            statement.setString(1,dish.getName());
            statement.setDouble(2,dish.getPrice());
            statement.setBoolean(3,dish.isVegetarian());
            statement.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


*//**
     * Creates a list of products from the given resultset
     *
     * @throws SQLException
     *//*

    private List<Product> createListFromResultset(ResultSet resultSet) throws SQLException {
        List<Product> products = new ArrayList<>();
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            double price = Double.parseDouble(resultSet.getString("price"));
            boolean vegetarian = resultSet.getString("vegetarian").equals("t");
            Product product = new Product(name, price, vegetarian);
            products.add(product);
        }
        return products;
    }

*//**
     * Sorts products on price
     *//*

    @Override
    public List<Product> sortProducts() {
        String orderBy= "price";
        String query = "SELECT * FROM veggie order by ?";
        try (Connection connection = DriverManager.getConnection(url, properties);
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1,orderBy);
            ResultSet resultSet = statement.executeQuery();

            return createListFromResultset(resultSet);
        } catch (SQLException e) {
            throw new DbException(e.getMessage(), e);
        }
    }


*//**
     * Gives list of all vegetarian products
     * Method is not yet tested
     *//*

    @Override
    public List<Product> getAllVegetarianProducts() {
        try (Connection connection = DriverManager.getConnection(url, properties);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM veggie WHERE vegetarian = 'true'");
            return createListFromResultset(resultSet);
        } catch (SQLException e) {
            throw new DbException(e.getMessage(), e);
        }
    }


*//**
     * Gives list of all non-vegetarian products
     * Method is not yet tested
     *//*

    @Override
    public List<Product> getAllNonVegetarianProducts() {
        try (Connection connection = DriverManager.getConnection(url, properties);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM veggie WHERE vegetarian = 'false'");
            return createListFromResultset(resultSet);
        } catch (SQLException e) {
            throw new DbException(e.getMessage(), e);
        }    }
}*/

