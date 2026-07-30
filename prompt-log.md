```markdown
# Prompt Log

## Week 1 - Monday

### Exercise: Array Analyzer
**Prompt:** 
**Output:** 
**Notes:** 

---

### Exercise: Guessing Game
**Prompt:** 
**Output:** 
**Notes:** 

---

### Exercise: Primitives Practice
**Prompt:** 
**Output:** 
**Notes:** 

---

## Week 1 - Tuesday

### Exercise: Palindrome Checker
**Prompt:** See prompt-log-palindromes.md
**Output:** See prompt-log-palindromes.md
**Notes:** See prompt-log-palindromes.md
```

## Week 1 - Wedensday

### Exercise: String-manipulation-exercise

**Prompt:** IDE Auto suggested the block of code when I typed the signiture for countVowels

**Output:** public static int countVowels(String s){
        if (s == null) {
            return 0;
        }
        s = s.toLowerCase();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }
        return count;
    }

**Notes:** Initially approached this with a HashSet style solution to store vowels for O(1) lookup, similar to a LeetCode optimization pattern. After reviewing the exercise requirements, the spec only asks for a count using primitive loops and charAt() with no mention of data structure requirements. The IDE suggestion used a simple conditional chain which technically satisfies the constraints. Accepted it after verifying it matched the manual approach requirements. The experience highlights a risk: IDE completions can silently bypass the learning objective if not audited before accepting.
```
## Week 1 - Friday


### Exercise: String-manipulation-exercise

**Prompt:** implement methods in Calculator for all the other basic calculator functions like subtraction, multiplication, division and sqrt.
**Output:** public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }

    public double sqrt(double a) {
        if (a < 0) {
            throw new ArithmeticException("Square root of negative number");
        }
        return Math.sqrt(a);
    }
    
**Notes:** I did not like the inclusion of the Math.sqrt() method in the sqrt implementation. I would have preferred to implement the square root calculation manually, but I understand that the exercise is focused on basic calculator functions and not on implementing complex mathematical algorithms.


**Prompt:** write test coverage for all calculator mathods, test for divide by zerp exceptions, positive test cases and negative test cases and edge cases

**Output:** 
import Week1.Friday.CalculatorTesting.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp(){
        calculator = new Calculator();
    }

    @Test
    public void testAdd(){
        assertEquals(5, calculator.add(2,3));
        assertEquals(-1, calculator.add(2,-3));
        assertEquals(0, calculator.add(0,0));
        assertEquals(Integer.MAX_VALUE, calculator.add(Integer.MAX_VALUE, 0));
    }

    @Test
    public void testSubtract(){
        assertEquals(-1, calculator.subtract(2,3));
        assertEquals(5, calculator.subtract(2,-3));
        assertEquals(Integer.MIN_VALUE, calculator.subtract(Integer.MIN_VALUE, 0));
    }

    @Test
    public void testMultiply(){
        assertEquals(6, calculator.multiply(2,3));
        assertEquals(0, calculator.multiply(0,5));
        assertEquals(4, calculator.multiply(-2,-2));
        assertEquals(Integer.MAX_VALUE, calculator.multiply(Integer.MAX_VALUE, 1));
    }

    @Test
    public void testDivide(){
        assertEquals(3, calculator.divide(9,3));
        assertEquals(3, calculator.divide(7,2)); // integer division truncates
        assertEquals(-3, calculator.divide(-7,2));
    }

    @Test
    public void testDivideByZero(){
        assertThrows(ArithmeticException.class, () -> calculator.divide(1,0));
    }

    @Test
    public void testSqrt(){
        assertEquals(2.0, calculator.sqrt(4), 1e-9);
        assertEquals(0.0, calculator.sqrt(0), 1e-9);
        assertEquals(Math.sqrt(2), calculator.sqrt(2), 1e-9);
    }

    @Test
    public void testSqrtNegative(){
        assertThrows(ArithmeticException.class, () -> calculator.sqrt(-1));
    }
}

    
**Notes:**  Learning mode instructions did not appear to influence this output. Copilot generated test coverage that passed all assertions on the first run, including @BeforeEach setup, delta-based floating point comparison for sqrt, and exception tests for divide by zero and negative sqrt. One edge case I noticed was missing: no test for multiply with one positive and one negative number. Accepted the output after reviewing and running the tests successfully.




## Week 1 - Wedensday

### Exercise: String-manipulation-exercise

**Prompt:** IDE Auto suggested the block of code when I typed the signiture for countVowels

**Output:** public static int countVowels(String s){
        if (s == null) {
            return 0;
        }
        s = s.toLowerCase();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }
        return count;
    }

**Notes:** Initially approached this with a HashSet style solution to store vowels for O(1) lookup, similar to a LeetCode optimization pattern. After reviewing the exercise requirements, the spec only asks for a count using primitive loops and charAt() with no mention of data structure requirements. The IDE suggestion used a simple conditional chain which technically satisfies the constraints. Accepted it after verifying it matched the manual approach requirements. The experience highlights a risk: IDE completions can silently bypass the learning objective if not audited before accepting.
```
## Week 2 - Thursday


### Exercise: finishing up CRUD methods for productDAO and ProductService

**Prompt:** implement craeteProduct method for ProductDAO
**Output:** 

@Override
public void createProduct(product product) {
    String insertSQL = "INSERT INTO product (name, price) VALUES (?, ?)";
    try (Connection connection = ConnectionFactory.getInstance().getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
        preparedStatement.setString(1, product.getName());
        preparedStatement.setDouble(2, product.getPrice());
        preparedStatement.executeUpdate();
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}

    
**Notes:** It created the method mostly correctly, but it neglected to pass in and initilize product_id because it assumed that the DB is configuered to autoincrement the PK, I had to fix the result manually.
