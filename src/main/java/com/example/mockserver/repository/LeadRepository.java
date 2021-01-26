package com.example.mockserver.repository;


import com.example.mockserver.model.Lead;
import org.hibernate.annotations.SQLUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LeadRepository extends JpaRepository<Lead, Long> {

    Lead findByLeadId(String leadId);

/*    @Query("select id from Lead l where l.leadId = :leadId")
    Long findIdByLeadId(@Param("leadId") String leadId);*/

    @Modifying
    @Query("UPDATE Lead l SET l.comment = :comment, l.interectionType = :interectionType, l.sourceManagerTabel = " +
            ":sourceManagerTabel, l.sourceManagerEmail = :sourceManagerEmail, l.sourceManagerPhoneNumber = " +
            ":sourceManagerPhoneNumber, l.sourceManagerPhoneNumber2 = :sourceManagerPhoneNumber2, " +
            "l.sourceManagerName = :sourceManagerName, l.assisstantPhoneNumber = :assisstantPhoneNumber, " +
            "l.assistantName = :assistantName, l.contactId = :contactId, l.actionId = :actionId " +
            "where l.id = :id")
    void upsertLead(@Param("id") Long id, @Param("comment") String comment, @Param("interectionType") String interectionType,
                    @Param("sourceManagerTabel") String sourceManagerTabel, @Param("sourceManagerEmail") String sourceManagerEmail,
                    @Param("sourceManagerPhoneNumber") String sourceManagerPhoneNumber, @Param("sourceManagerPhoneNumber2") String sourceManagerPhoneNumber2,
                    @Param("sourceManagerName") String sourceManagerName, @Param("assisstantPhoneNumber") String assisstantPhoneNumber,
                    @Param("assistantName") String assistantName, @Param("contactId") String contactId, @Param("actionId")
                    String actionId);
}
