package com.pets.service;

import com.pets.model.Pet;

import java.util.List;

public interface PetService {

    List<Pet> getPetsFromOwner(String uuid);

    List<Pet> addPet(String uuid, Pet pet);

    List<Pet> removePetOwner(String ownerUuid, String petUuid);
}
