package com.example.mockserver.service;


import com.example.mockserver.model.Lead;
import com.example.mockserver.model.Status;

import java.util.ArrayList;

public interface ILeadService {
    Lead save (Lead lead);
    Lead findById(Long id);

    /**
     * Возвращает данные последнего запроса
     * @return - запросы
     */

    Lead readPast();

    /**
     * Обновляет значение идентификатора лида,
     * в соответствии с переданным значением
     * @param presetLeadId - предустановленный идентификатор лида
     */
    void update(String presetLeadId);

    /**
     * Поиск лида по leadId
     * @param leadId - идентификатор лида
     * @return - лид
     */
    Lead findLeadByLeadId(String leadId);

    void upsertLead(Long id, String comment, String interectionType, String sourceManagerTabel,
                    String sourceManagerEmail, String sourceManagerPhoneNumber, String sourceManagerPhoneNumber2,
                    String sourceManagerName, String assisstantPhoneNumber, String assistantName, String contactId,
                    String actionId);



}
