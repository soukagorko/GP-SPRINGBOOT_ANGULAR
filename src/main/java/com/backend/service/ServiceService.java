package com.backend.service;

//import com.Backend.entities.Service;
import com.backend.entities.Service;
import com.backend.repositories.ServiceRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ServiceService {
    //
    private final ServiceRepository serviceRepository;

    public Service addService(Service service){
        return  serviceRepository.save(service);
    }
    //
    public List<Service> getAllServices(){
        return serviceRepository.findAll();
    }
    //
    public void deleteService(Long id){
        serviceRepository.deleteById(id);
    }
    //
    public Service getServiceById(Long id){
        return serviceRepository.findById(id).orElse(null);
    }
    //
    public Service updateService(Long id, Service service){
        Optional<Service> optionalService = serviceRepository.findById(id);
        if(optionalService.isPresent()){
            Service existingService = optionalService.get();
            existingService.setNomService(service.getNomService());
            existingService.setSigleService(service.getSigleService());
            existingService.setDescService(service.getDescService());
            existingService.setContactService(service.getContactService());
            return serviceRepository.save(existingService);
        }
        return null;
    }
    //
}
