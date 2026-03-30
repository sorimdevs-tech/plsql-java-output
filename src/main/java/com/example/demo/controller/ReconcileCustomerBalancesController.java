package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.service.ReconcileCustomerBalancesService;

@RestController
@RequestMapping("/api/reconcilecustomerbalances")
public class ReconcileCustomerBalancesController {

    @Autowired
    private ReconcileCustomerBalancesService reconcileCustomerBalancesService;

    /**
     * Action-dispatch endpoint.
     * Pass a JSON body with an "action" field (INSERT / UPDATE / DELETE / SELECT)
     * plus the procedure parameters.
     */
    @PostMapping("/action")
    public ResponseEntity<?> executeAction(@RequestBody ReconcileCustomerBalancesActionRequest request) {
        reconcileCustomerBalancesService.reconcileCustomerBalances(request.getBatchSize(), request.getRunMode());
        return ResponseEntity.ok().build();
    }

    /**
     * Request DTO for action-dispatch.
     */
    public static class ReconcileCustomerBalancesActionRequest {
        private Long batchSize;
        private String runMode;

        public Long getBatchSize() { return batchSize; }
        public void setBatchSize(Long batchSize) { this.batchSize = batchSize; }
        public String getRunMode() { return runMode; }
        public void setRunMode(String runMode) { this.runMode = runMode; }
    }
}
