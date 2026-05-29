package com.example.hnk24cntt2_dotiendat008.service;

import com.example.hnk24cntt2_dotiendat008.dto.MenuItemRequest;
import com.example.hnk24cntt2_dotiendat008.entity.MenuItem;
import com.example.hnk24cntt2_dotiendat008.repository.MenuItemRepository;
import com.example.hnk24cntt2_dotiendat008.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class MenuItemService {

    private final MenuItemRepository repo;

    public MenuItem create(MenuItemRequest req) {

        MenuItem m = new MenuItem();

        m.setName(req.getName());
        m.setCategory(req.getCategory());
        m.setPrice(req.getPrice());
        m.setDeleted(false);

        return repo.save(m);
    }

    public Page<MenuItem> getAll(
            String keyword,
            Pageable pageable
    ) {

        if (keyword == null) {
            keyword = "";
        }

        return repo.findByNameContainingOrCategoryContaining(
                keyword,
                keyword,
                pageable
        );
    }

    public MenuItem update(Long id, MenuItemRequest req) {

        MenuItem m = repo.findById(id)
                .orElseThrow(() ->
                        new NotFoundException("Medication not found"));

        m.setName(req.getName());
        m.setCategory(req.getCategory());
        m.setPrice(req.getPrice());
        m.setStatus(req.getStatus());

        return repo.save(m);
    }

    public MenuItem patch(
            Long id,
            Map<String, Object> data
    ) {

        MenuItem m = repo.findById(id)
                .orElseThrow(() ->
                        new NotFoundException("Medication not found"));

        if (data.containsKey("name")) {
            m.setName((String) data.get("name"));
        }

        if (data.containsKey("price")) {
            m.setPrice(Double.valueOf(
                    data.get("price").toString()
            ));
        }

        return repo.save(m);
    }

    public void delete(Long id) {

        MenuItem m = repo.findById(id)
                .orElseThrow(() ->
                               new NotFoundException("Menu item not found"));   m.setDeleted(true);

        repo.save(m);
    }
}