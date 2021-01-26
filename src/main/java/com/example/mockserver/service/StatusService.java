package com.example.mockserver.service;

import com.example.mockserver.model.Status;
import com.example.mockserver.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class StatusService implements IStatusService {

    public static String flagOK = "true";

    @Autowired
    private StatusRepository statusRepository;

    @Override
    public void save(Status status) {
        statusRepository.save(status);
    }

    @Override
    public HashMap<String, String> sendResponse(Status status) {
        String productOrderId = status.getProductOrderId();
        Integer leadId = status.getLeadId();
        HashMap<String, String> map = new HashMap();
        map.put("productOrderId", productOrderId);
        map.put("leadId", String.valueOf(leadId));
        if(flagOK.equals("true")) {
            map.put("code", "0");
            map.put("textCode", "Операция выполнена успешно");
        }
        else {
            map.put("code", "01");
            map.put("textCode", "Ошибка при валидации входящего сообщения");
        }
        return map;
    }

    @Override
    public void update(String flag) {
        flagOK = flag;
    }

    //@Override
    public Status getByProductOrderId(String productOrderId) {
        Status status = statusRepository.findByProductOrderId(productOrderId);
        return status;
    }

    @Override
    public ArrayList<Status> readPart(int resentRqustNumber) {
        ArrayList<Status> st = new ArrayList<>();
        int allRequests = statusRepository.findAll().size();
        for (int i = allRequests - 1; i >= allRequests - resentRqustNumber; i--) {
            List<Status> s = statusRepository.findAll();
            st.add(s.get(i));
        }
        return st;
    }

    @Override
    public List<Status> readAll() {
        return statusRepository.findAll();
    }

    @Override
    public void deleteAll() {
        statusRepository.deleteAll();
    }

}
