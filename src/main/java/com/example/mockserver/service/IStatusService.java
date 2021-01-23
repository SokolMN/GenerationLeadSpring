package com.example.mockserver.service;

import com.example.mockserver.model.Status;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface IStatusService {

    /**
     * Сохраняется запрос, в котором передается статус задачи
     * @param status - статус для создания
     */

    void save(Status status);

    /**
     * Создание респонса
     * @param status
     */
    HashMap<String, String> sendResponse(Status status);

    /**
     * Обновляет значение флага,
     * в соответствии с переданным значением
     * @param flag - флаг, который определяет будет ли отправляться статус OK или будет возвращаться ошибка
     */
    void update(String flag);

    /**
     * Возвращает запросы по уникальному идентификатору заявки в ПКБ
     * @param productOrderId - заявка из ПКБ
     * @return - запрос с заданным productOrderId
     */

    Status getByProductOrderId(String productOrderId);

    /**
     * Возвращает X список запросов
     * @param requestNumber - список запросов
     * @return - запросы
     */

    ArrayList<Status> readPart(int requestNumber);


    /**
     * Возвращает список всех имеющихся запросов
     * @return список запросов
     */

    List<Status> readAll();

    /**
     * Удаляет все запросы, полученные из СУБО
     * @return - true если клиент был удален, иначе false
     */

    void deleteAll();
}
