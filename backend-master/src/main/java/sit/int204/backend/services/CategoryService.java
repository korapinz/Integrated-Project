package sit.int204.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import sit.int204.backend.entities.Announcement;
import sit.int204.backend.entities.Category;
import sit.int204.backend.exception.ResourceNotFoundException;
import sit.int204.backend.repositories.AnnouncementRepository;
import sit.int204.backend.repositories.CategoryRepository;

import java.util.List;
import java.util.Set;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;
    @Autowired
    private AnnouncementRepository announcementRepository;

    //Get All Categories
    public List<Category> getAllCategories(){
        return repository.findAll();
    }

    //Get 1 Category
    public Category getCategoryById(Integer id) {
        return repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Category Id " + id + " DOES NOT EXIST !!!"));
    }

    //Get 1 Category has announcements
    public Set<Announcement> getCategoryAnnouncements (Integer id) {
        Category category = getCategoryById(id);
        return category.getAnnounces();
    }

    //Create Category
    public Category createCategory(Category category) {
        return repository.saveAndFlush(category);
    }

    //Update Category
    public Category updateCategory(Integer id, Category category) {
        Category exitsCategory = repository.findById(id).orElseThrow(
                () -> new ResourceAccessException(id + " does not exit !!!"));
        exitsCategory.setAnnouncementCategory(category.getAnnouncementCategory());
        return repository.saveAndFlush(exitsCategory);
    }

    //Delete Category
    public void deleteCategory(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException(id + "does not exit !!!");
        }
    }


}
