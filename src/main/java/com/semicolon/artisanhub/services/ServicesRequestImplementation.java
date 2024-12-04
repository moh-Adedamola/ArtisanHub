package com.semicolon.artisanhub.services;

import com.semicolon.artisanhub.data.model.RolesUser;
import com.semicolon.artisanhub.data.model.ServicesRequesting;
import com.semicolon.artisanhub.data.model.SpecializationArea;
import com.semicolon.artisanhub.data.model.User;
import com.semicolon.artisanhub.data.repository.ServicesRequestRepository;
import com.semicolon.artisanhub.data.repository.SpecializationAreaRepository;
import com.semicolon.artisanhub.data.repository.UserRepository;
import com.semicolon.artisanhub.dto.request.ServicesRequestDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ServicesRequestImplementation implements ServicesRequestService{
    private final UserRepository userRepository;
    private final ServicesRequestRepository servicesRequestRepository;
    private final SpecializationServices specializationServices;



    @Override
    public ServicesRequesting RequestServices(ServicesRequestDTO servicesRequestDTO) {
        User requester = userRepository.findById(servicesRequestDTO.getRequesterId())
                .orElseThrow(() -> new RuntimeException("requester not found"));

        User workman = userRepository.findById(servicesRequestDTO.getWorkmanId())
                .orElseThrow(() -> new RuntimeException("Workman not found"));

        if (!workman.getRolesUser().equals(RolesUser.WORKMANSHIP)) {
            throw new RuntimeException("Selected user is not a workman");
        }

        if (!specializationServices.checkAvailability(workman.getId())) {
            throw new RuntimeException("The workman is not available at the moment");
        }

        ServicesRequesting servicesRequesting = ServicesRequestingResponse(servicesRequestDTO, requester, workman);

        return servicesRequestRepository.save(servicesRequesting);
    }

    private ServicesRequesting ServicesRequestingResponse(ServicesRequestDTO servicesRequestDTO, User requester, User workman) {
        ServicesRequesting servicesRequesting = new ServicesRequesting();
        servicesRequesting.setRequester(requester);
        servicesRequesting.setWorkman(workman);
        servicesRequesting.setLocation(servicesRequestDTO.getLocation());
        servicesRequesting.setDescription(servicesRequestDTO.getDescription());
        specializationServices.updateAvailability(workman.getId(), false);
        return servicesRequesting;
    }
}
