package com.cg.drinkanddelight.dao;

import com.cg.drinkanddelight.bean.Supplier;

import java.util.*;
import java.util.stream.Collectors;

public class SupplierDaoImpl implements SupplierDao {
    public static final Map<String, Supplier> database = new HashMap<>();

    @Override
    public Supplier findById(long supplierId) {
        Optional<Map.Entry<String, Supplier>> result = database.entrySet().stream().filter(entry -> entry.getValue().getSupplierId() == supplierId).findFirst();
        if (result.isPresent()) {
            Supplier supplier = result.get().getValue();
            if (supplier.getSupplierId() == supplierId) {
                return supplier;
            }
        }
        return null;
    }

    @Override
    public void save(Supplier s) {
        database.put(UUID.randomUUID().toString(), s);
    }
}
