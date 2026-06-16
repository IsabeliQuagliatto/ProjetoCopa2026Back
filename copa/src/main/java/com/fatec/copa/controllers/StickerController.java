package com.fatec.copa.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fatec.copa.dtos.StickerRequest;
import com.fatec.copa.dtos.StickerResponse;
import com.fatec.copa.services.StickerService;

import jakarta.validation.Valid;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/stickers")
@CrossOrigin(origins = "http://localhost:4200")
public class StickerController {

    @Autowired
    private StickerService service;

    // GET
    @GetMapping
    public ResponseEntity<List<StickerResponse>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // GET ID
    @GetMapping("{id}")
    public ResponseEntity<StickerResponse> getById(@PathVariable long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    // DELETE
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // salvar pelo id
    @PostMapping
    public ResponseEntity<StickerResponse> save(@Valid @RequestBody StickerRequest sticker) {

        StickerResponse s = service.save(sticker);

        // location
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(s.id())
                .toUri();

        return ResponseEntity.created(location).body(s);
    }

    // update
    @PutMapping("{id}")
    public ResponseEntity<Void> update(@Valid @PathVariable long id, @RequestBody StickerRequest sticker) {

        service.update(sticker, id);

        return ResponseEntity.noContent().build();
    }

}
