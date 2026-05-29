package com.example.hnk24cntt2_dotiendat008.controller;

import com.example.hnk24cntt2_dotiendat008.dto.MenuItemRequest;
import com.example.hnk24cntt2_dotiendat008.entity.MenuItem;
import com.example.hnk24cntt2_dotiendat008.service.MenuItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/menu-items")
@RequiredArgsConstructor
public class MenuItemController {

    private final MenuItemService service;

    @PostMapping
    public MenuItem create(
            @Valid @RequestBody MenuItemRequest req
    ) {

        return service.create(req);
    }

    @GetMapping
    public Page<MenuItem> getAll(
            @RequestParam(required = false) String keyword,
            @PageableDefault(size = 5) Pageable pageable
    ) {

        return service.getAll(keyword, pageable);
    }

    @PutMapping("/{id}")
    public MenuItem update(
            @PathVariable Long id,
            @Valid @RequestBody MenuItemRequest req
    ) {

        return service.update(id, req);
    }

    @PatchMapping("/{id}")
    public MenuItem patch(
            @PathVariable Long id,
            @RequestBody Map<String, Object> data
    ) {

        return service.patch(id, data);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {

        service.delete(id);

        return "Deleted successfully";
    }
}