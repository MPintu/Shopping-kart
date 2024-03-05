package org.jsp.ecommerce.service;

import org.jsp.ecommerce.dao.MerchantDao;
import org.jsp.ecommerce.dto.ResponseStructure;
import org.jsp.ecommerce.model.Merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MerchantService {
    @Autowired
    private MerchantDao merchantDao;

    public ResponseEntity<ResponseStructure<Merchant>> saveMerchant(Merchant merchant) {
        ResponseStructure<Merchant> structure = new ResponseStructure<>();
        structure.setData(merchantDao.savMerchant(merchant));
        structure.setMessage("Merchant Saved");
        structure.setStatusCode(HttpStatus.CREATED.value());
        return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.CREATED);
    }

    public ResponseEntity<ResponseStructure<Merchant>> updateMerchant(Merchant merchant) {
        ResponseStructure<Merchant> structure = new ResponseStructure<>();
        structure.setData(merchantDao.updateMerchant(merchant));
        structure.setMessage("Merchant updated successfully...");
        structure.setStatusCode(HttpStatus.ACCEPTED.value());
        return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.ACCEPTED);
    }
}
