package com.example.hnk24cntt2_dotiendat008.repository;

import com.example.hnk24cntt2_dotiendat008.entity.MenuItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
    Page<MenuItem> findByNameContainingOrCategoryContaining(
            String name,
            String category,
            Pageable pageable);

    Long id(long id);
}
