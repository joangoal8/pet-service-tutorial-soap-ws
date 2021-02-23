package com.pets.repository;

import com.pets.model.Pet;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository
public class PetRepositoryImpl implements PetRepository {

    private static final Map<String, List<Pet>> ownersPets = new HashMap<>();

    @PostConstruct
    public void initData() {
        Pet huskyDog = Pet.builder().setId("uuidDog1")
          .setAge(1).setName("Lyanna")
          .setBreed("Siberian Husky").build();

        Pet linx = Pet.builder()
          .setId("uuidCat1").setAge(2)
          .setName("Eren")
          .setBreed("Savannah cat").build();

        Pet malamuteDog = Pet.builder()
          .setId("uuidDog2").setAge(2)
          .setName("Ragnar")
          .setBreed("Alaskan Malamute").build();

        Pet cuteCat = Pet.builder()
          .setId("uuidCat1")
          .setAge(4).setName("Cati")
          .setBreed("Persian cat").build();

        List<Pet> petsOwner1 = Arrays.asList(huskyDog, linx);
        List<Pet> petsOwner2 = Arrays.asList(malamuteDog, cuteCat);

        ownersPets.put("8", petsOwner1);
        ownersPets.put("91", petsOwner2);
    }

    @Override
    public List<Pet> getPetsFromOwner(String uuid) {
         return ownersPets.get(uuid);
    }

    @Override
    public List<Pet> addPet(String uuid, Pet pet) {
        List<Pet> petsStored = new ArrayList<>(ownersPets.get(uuid));
        if (petsStored.isEmpty()) {
            ownersPets.put(uuid, Collections.singletonList(pet));
        } else {
            petsStored.add(pet);
            ownersPets.put(uuid, petsStored);
        }

        return ownersPets.get(uuid);
    }

    @Override
    public List<Pet> removePetOwner(String ownerUuid, String petUuid) {
        Set<Pet> pets = new HashSet<>(ownersPets.get(ownerUuid));
        if (!pets.isEmpty()) {
            ownersPets.get(ownerUuid).stream().filter(pet -> petUuid.equals(pet.getId()))
                    .findAny().ifPresent(pets::remove);
            ownersPets.put(ownerUuid, new ArrayList<>(pets));
        }
        return ownersPets.get(ownerUuid);
    }

}
