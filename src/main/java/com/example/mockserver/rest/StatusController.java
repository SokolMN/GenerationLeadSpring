package com.example.mockserver.rest;

import com.example.mockserver.model.Status;
import com.example.mockserver.service.IStatusService;
import com.example.mockserver.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class StatusController {

    @Autowired
    IStatusService statusService;

    @PostMapping(value = "/sendStatus")
    public ResponseEntity<?> create(@RequestBody Status status) {
        if (StatusService.flagOK.equals("true")) {
            statusService.save(status);
            return new ResponseEntity<>(statusService.sendResponse(status), HttpStatus.CREATED);
        }
        else
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping(value = "/response")
    public ResponseEntity<?> sendResponse(@RequestBody Status status) {
        statusService.save(status);
        HashMap<String, String> map = statusService.sendResponse(status);
        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }

    @PostMapping(value = "setFlag")
    public ResponseEntity<?> updateErrorFlg(@RequestBody Status status){
        statusService.update(status.getFlag());
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @GetMapping(value = "/requests/productOrderId/{productOrderId}")
    public ResponseEntity<Status> read(@PathVariable(name = "productOrderId") String productOrderId) {
        Status status = statusService.getByProductOrderId(productOrderId);

        return status != null
                ? new ResponseEntity<>(status, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/requests/{id}")
    public ResponseEntity<List<Status>> readPart(@PathVariable(name = "id") int id) {
        ArrayList<Status> arrayList = statusService.readPart(id);

        return arrayList != null
                ? new ResponseEntity<>(arrayList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/requests")
    public ResponseEntity<List<Status>> readAll() {
        final List<Status> lids = statusService.readAll();
        return lids != null &&  !lids.isEmpty()
                ? new ResponseEntity<>(lids, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<?> delete() {
        statusService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
