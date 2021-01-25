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
    Lead findByLeadId(String leadId);

    /**
     * Поиск идентификатора лида по leadId
     * @param leadId - идентификатор лида
     * @return - идентификатор лида
     */
    Long findIdByLeadId(String leadId);



}
