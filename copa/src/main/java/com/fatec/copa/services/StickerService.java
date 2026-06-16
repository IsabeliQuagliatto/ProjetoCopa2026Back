package com.fatec.copa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.copa.dtos.StickerRequest;
import com.fatec.copa.dtos.StickerResponse;
import com.fatec.copa.entities.Sticker;
import com.fatec.copa.mappers.StickerMapper;
import com.fatec.copa.repositories.StickerRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class StickerService {

    @Autowired
    private StickerRepository repository;

    // Get all
    public List<StickerResponse> findAll() {

        return repository.findAll()
                .stream()
                .map(StickerMapper::toDTO)
                .toList();
    }

    // Get by Id
    public StickerResponse findById(Long id) {

        return repository.findById(id)
                .map(StickerMapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("Figurinha nao cadastrada"));
    }

    // delete
    public void deleteById(Long id) {

        // Verificando se existe
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Figurinha não cadastrada");
        }
    }

    // save
    public StickerResponse save(StickerRequest sticker) {

        Sticker s = repository.save(StickerMapper.toEntity(sticker));
        return StickerMapper.toDTO(s);
    }

    // update
    public void update(StickerRequest sticker, Long id) {
        Sticker s = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Figutinha nao cadastrada"));

        s.setName(sticker.name());
        s.setTeam(sticker.team());
        s.setType(sticker.type());
        s.setNumber(sticker.number());
        s.setDoubles(sticker.doubles());

        repository.save(s);
    }

}
