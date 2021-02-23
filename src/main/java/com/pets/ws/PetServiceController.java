package com.pets.ws;

import com.pets.repository.PetsRepository;
import io.pets.ws.search.Pet;
import io.pets.ws.search.PetSearchRequest;
import io.pets.ws.search.PetSearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class PetServiceController implements PetApiService {

    private PetsRepository petsRepository;

    @Autowired
    public PetServiceController(PetsRepository petsRepository) {
        this.petsRepository = petsRepository;
    }

    @PayloadRoot(namespace = PetServiceConstants.NAMESPACE_URI, localPart = "petSearchRequest")
    @ResponsePayload
    public PetSearchResponse search(@RequestPayload PetSearchRequest request) {
        PetSearchResponse response = new PetSearchResponse();
        List<Pet> petsOwner =  petsRepository.getPetsFromOwner(request.getPetOwner().getId());
        if (petsOwner != null && !petsOwner.isEmpty()) {
            response.getPets().addAll(petsOwner);
        }
        return response;
    }

}
