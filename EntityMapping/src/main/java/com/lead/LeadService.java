package com.lead;

import java.util.List;

public interface LeadService {

    Lead createLead(Lead lead);

    Lead getLead(Long id);

    List<Lead> getAllLeads();

    Lead updateLead(Long id, Lead updated);

    void deleteLead(Long id);
}
