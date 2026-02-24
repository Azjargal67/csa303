package com.lab02.task2;

public class PartnerService {
    private final PartnerRepository partnerRepository;
    private final EmailValidator validator;

    public PartnerService(PartnerRepository partnerRepository, EmailValidator validator) {
        this.partnerRepository = partnerRepository;
        this.validator = validator;
    }

    public void addPartner(String companyEmail, String companyName) {
        validator.validate(companyEmail);
        partnerRepository.save(new Partner(companyEmail, companyName));
    }
}