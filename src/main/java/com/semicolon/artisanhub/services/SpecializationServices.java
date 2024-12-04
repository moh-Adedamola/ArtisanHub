package com.semicolon.artisanhub.services;

import com.semicolon.artisanhub.data.model.SpecializationArea;

public interface SpecializationServices {

    boolean checkAvailability(Long userId);
    void updateAvailability(Long userId, boolean isAvailable);
}
