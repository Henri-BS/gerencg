package com.altercode.gerencg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.altercode.gerencg.dto.ProductDTO;
import com.altercode.gerencg.entity.Category;
import com.altercode.gerencg.entity.Measure;
import com.altercode.gerencg.service.ProductService;
import com.altercode.gerencg.service.SmsService;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @Autowired
    private SmsService smsService;

    @GetMapping("/search")
    public ResponseEntity<Page<ProductDTO>> findByDescription(Pageable pageable, @RequestParam(defaultValue = "") String description) {
        Page<ProductDTO> page = service.findByDescription(pageable, description);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/list")
    public ResponseEntity<Page<ProductDTO>> findAllProducts(Pageable pageable) {
        Page<ProductDTO> page = service.findAllProducts(pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/validate")
    public ResponseEntity<Page<ProductDTO>> findAllByValidate(
            @RequestParam(value = "minValidate", defaultValue = "") String minValidate,
            @RequestParam(value = "maxValidate", defaultValue = "") String maxValidate,
            Pageable pageable) {

        Page<ProductDTO> list = service.findAllByValidate(minValidate, maxValidate, pageable);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<Page<ProductDTO>> findByCategory(Pageable pageable, @PathVariable Category categoryId) {
        Page<ProductDTO> list = service.findByCategory(pageable, categoryId);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/measure/{measureId}")
    public ResponseEntity<Page<ProductDTO>> findByMeasure(Pageable pageable, @PathVariable Measure measureId) {
        Page<ProductDTO> list = service.findByMeasure(pageable, measureId);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
        ProductDTO findProduct = service.findById(id);
        return ResponseEntity.ok(findProduct);
    }

    @GetMapping("/description/{description}")
    public ResponseEntity<ProductDTO> findByDescription(@PathVariable String description) {
        ProductDTO findProduct = service.findByDescription(description);
        return ResponseEntity.ok(findProduct);
    }

    @GetMapping("/{id}/notification")
    public void notifySms(@PathVariable Long id) {
        smsService.sendSms(id);
    }

    @PostMapping("/add")
    public ResponseEntity<ProductDTO> saveProduct(@RequestBody ProductDTO product) {
        ProductDTO newProduct = service.saveProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @PutMapping("/edit")
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO product) {
        ProductDTO updatedProduct = service.updateProduct(product);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable Long id) {
        this.service.deleteProduct(id);
    }
}
