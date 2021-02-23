package com.pets.service;

import com.pets.model.Pet;
import com.pets.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetService {

    private PetRepository petRepository;

    @Autowired
    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public List<Pet> getPetsFromOwner(String uuid) {
        return petRepository.getPetsFromOwner(uuid);
    }

    @Override
    public List<Pet> addPet(String uuid, Pet pet) {
        return petRepository.addPet(uuid, pet);
    }

    @Override
    public List<Pet> removePetOwner(String ownerUuid, String petUuid) {
        return petRepository.removePetOwner(ownerUuid, petUuid);
    }
}
