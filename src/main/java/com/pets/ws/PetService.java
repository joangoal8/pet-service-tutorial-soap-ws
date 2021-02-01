package com.pets.ws;

import io.pets.ws.search.PetSearchRequest;
import io.pets.ws.search.PetSearchResponse;

public interface PetService {

    PetSearchResponse search(PetSearchRequest request);
}
