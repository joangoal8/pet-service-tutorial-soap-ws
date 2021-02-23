package com.pets.ws;

import io.pets.ws.addpet.AddPetRequest;
import io.pets.ws.addpet.AddPetResponse;
import io.pets.ws.removepetowner.RemovePetOwnerRequest;
import io.pets.ws.removepetowner.RemovePetOwnerResponse;
import io.pets.ws.search.PetSearchRequest;
import io.pets.ws.search.PetSearchResponse;

public interface PetApiService {

    PetSearchResponse search(PetSearchRequest request);

    AddPetResponse add(AddPetRequest request);

    RemovePetOwnerResponse removePetOwner(RemovePetOwnerRequest request);
}
