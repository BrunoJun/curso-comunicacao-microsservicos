package org.me.productapi.module.category.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.me.productapi.module.category.dto.CategoryRequest;
import org.springframework.beans.BeanUtils;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CATEGORY")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    public static Category of(CategoryRequest request){

        var category = new Category();
        BeanUtils.copyProperties(request, category);
        return category;
    }
}
