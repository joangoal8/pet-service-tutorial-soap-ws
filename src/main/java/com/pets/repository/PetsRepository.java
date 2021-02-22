package com.pets.repository;

import io.pets.ws.search.Pet;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class PetsRepository {

    private static final Map<String, List<Pet>> ownersPets = new HashMap<>();

    @PostConstruct
    public void initData() {
        Pet huskyDog = new Pet();
        huskyDog.setId("uuidDog1");
        huskyDog.setAge(1);
        huskyDog.setName("Lyanna");
        huskyDog.setBreed("Siberian Husky");

        Pet linx = new Pet();
        linx.setId("uuidCat1");
        linx.setAge(2);
        linx.setName("Eren");
        linx.setBreed("Savannah cat");

        Pet malamuteDog = new Pet();
        malamuteDog.setId("uuidDog2");
        malamuteDog.setAge(2);
        malamuteDog.setName("Ragnar");
        malamuteDog.setBreed("Alaskan Malamute");

        Pet cuteCat = new Pet();
        cuteCat.setId("uuidCat1");
        cuteCat.setAge(4);
        cuteCat.setName("Cati");
        cuteCat.setBreed("Persian cat");

        List<Pet> petsOwner1 = Arrays.asList(huskyDog, linx);
        List<Pet> petsOwner2 = Arrays.asList(malamuteDog, cuteCat);

        ownersPets.put("8", petsOwner1);
        ownersPets.put("91", petsOwner2);
    }

    public List<Pet> getPetsFromOwner(String uuid) {
         return ownersPets.get(uuid);
    }

}
