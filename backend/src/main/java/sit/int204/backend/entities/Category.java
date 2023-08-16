package sit.int204.backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @Column(name = "categoryId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    @Column(name = "categoryName", nullable = false, length = 50)
    private String announcementCategory;


  // annotation to handle serialization of circular reference
    @JsonIgnore
    @OneToMany(mappedBy = "categories")
    private Set<Announcement> announces = new LinkedHashSet<>();


}
