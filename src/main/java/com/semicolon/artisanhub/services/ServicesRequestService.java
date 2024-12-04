package com.semicolon.artisanhub.services;

import com.semicolon.artisanhub.data.model.ServicesRequesting;
import com.semicolon.artisanhub.dto.request.ServicesRequestDTO;

public interface ServicesRequestService {
    ServicesRequesting RequestServices(ServicesRequestDTO servicesRequestDTO);
}
