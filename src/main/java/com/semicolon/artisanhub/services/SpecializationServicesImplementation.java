package com.semicolon.artisanhub.services;

import com.semicolon.artisanhub.data.model.SpecializationArea;
import com.semicolon.artisanhub.data.repository.SpecializationAreaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SpecializationServicesImplementation implements SpecializationServices {
    private SpecializationAreaRepository specializationAreaRepository;





    @Override
    public boolean checkAvailability(Long userId) {
        SpecializationArea specializationArea = getSpecializationAreaByUserId(userId);
        return specializationArea.isAvailable();

    }

    @Override
    public void updateAvailability(Long userId, boolean isAvailable) {
        SpecializationArea specializationArea = getSpecializationAreaByUserId(userId);
        specializationArea.setAvailable(isAvailable);
        specializationAreaRepository.save(specializationArea);

    }

    private SpecializationArea getSpecializationAreaByUserId(Long userId) {
        return specializationAreaRepository.findByUser_Id(userId)
                .orElseThrow(() -> new RuntimeException("Specialization details not found for the user"));
    }
}
