package com.cg.drinkanddelight.service;

import com.cg.drinkanddelight.bean.Supplier;
import com.cg.drinkanddelight.dao.SupplierDaoImpl;

public class SupplierService {
    SupplierDaoImpl supplierDao;

    public SupplierService() {
        supplierDao = new SupplierDaoImpl();
    }
    public void addSupplier(Supplier s){
        supplierDao.save(s);
    }

    public Supplier getSupplierById(long supplierId){
        return supplierDao.findById(supplierId);
    }

}
