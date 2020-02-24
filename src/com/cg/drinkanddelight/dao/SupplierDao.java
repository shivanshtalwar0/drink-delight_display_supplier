package com.cg.drinkanddelight.dao;

import com.cg.drinkanddelight.bean.Supplier;

public interface SupplierDao {
    Supplier findById(long supplierId);
    void save(Supplier s);

}
