package com.example.mockserver.repository;


import com.example.mockserver.model.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LeadRepository extends JpaRepository<Lead, Long> {

    @Query("select l from Lead l where l.leadId = :leadId")
    Lead findByLeadId(@Param("leadId") String leadId);

    @Query("select id from Lead l where l.leadId = :leadId")
    Long findIdByLeadId(@Param("leadId") String leadId);

/*    @Query("merge into Lead l key (id) values (l.id = :id, l.comment = :comment, l.interectionType = :interectionType," +
            "l.sourceManagerTabel = :sourceManagerTabel, l.sourceManagerEmail = :sourceManagerEmail, " +
            "l.sourceManagerPhoneNumber = :sourceManagerPhoneNumber, l.sourceManagerPhoneNumber2 = " +
            ":sourceManagerPhoneNumber2, l.sourceManagerName = :sourceManagerName, l.assisstantPhoneNumber = " +
            ":assisstantPhoneNumber, l.assistantName = :assistantName, l.contactId = :contactId, " +
            "l.actionId = :actionId)")
    void upsertLead(@Param("id") Long id, String comment, String interectionType, String sourceManagerTabel,
                    String sourceManagerEmail, String sourceManagerPhoneNumber, String sourceManagerPhoneNumber2,
                    String sourceManagerName, String assisstantPhoneNumber, String assistantName, String contactId,
                    String actionId);*/
}
