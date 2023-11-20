package class_.com.dlsp.dao;

import org.junit.experimental.categories.Category;

import java.util.List;

/**
 * @author Cuiyq
 * @version 1.0
 * describe:
 */
public interface CategoryDao {
    List<CategoryDao> getAllCategory();

Category getCategoryById(int cateId);

void addCategory(Category category);

void updateCategory(Category category);
void deleteCategory(int cateId);

}
