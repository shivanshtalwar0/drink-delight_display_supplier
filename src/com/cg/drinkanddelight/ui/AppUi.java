package com.cg.drinkanddelight.ui;

import com.cg.drinkanddelight.bean.Supplier;
import com.cg.drinkanddelight.exceptions.InvalidInputException;
import com.cg.drinkanddelight.exceptions.InvalidUserIdException;
import com.cg.drinkanddelight.service.SupplierService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AppUi {
    SupplierService supplierService;
    BufferedReader buff;
    InputStreamReader isr;

    public AppUi() throws IOException, InvalidUserIdException {
        supplierService = new SupplierService();
        isr = new InputStreamReader(System.in);
        buff = new BufferedReader(isr);
        initUi();
    }

    public void initUi() throws IOException, InvalidUserIdException {

        boolean loopControl = true;
        long supplierId;
        int choice;
        try {
            while (loopControl) {
                System.out.println("1) Add supplier\n2)Find supplier by Id\n3)Exit");
                try {
                    choice = Integer.parseInt(buff.readLine());
                } catch (NumberFormatException e) {
                    throw new InvalidInputException("Input Can't be Empty!");
                }

                switch (choice) {
                    case 1:
                        System.out.println("Enter Supplier Id");
                        try {
                            supplierId = Long.parseLong(buff.readLine());
                        } catch (NumberFormatException e) {
                            throw new InvalidUserIdException("Invalid UserId it must be Numeric");
                        }

                        System.out.println("Enter Supplier Name");
                        String name = buff.readLine();
                        System.out.println("Enter Supplier Address");
                        String address = buff.readLine();
                        System.out.println("Enter Supplier Phone");
                        String phoneNo = buff.readLine();
                        supplierService.addSupplier(new Supplier(supplierId, name, address, phoneNo));
                        break;
                    case 2:
                        System.out.println("Enter Supplier Id");
                        try {
                            supplierId = Long.parseLong(buff.readLine());
                        } catch (NumberFormatException e) {
                            throw new InvalidUserIdException("Invalid UserId it must be Numeric");
                        }
                        System.out.println(supplierService.getSupplierById(supplierId).toString());
                        break;
                    case 3:
                        loopControl = false;
                }
            }
        } catch (InvalidUserIdException e) {
            System.out.println(e.toString());
        } catch (InvalidInputException e) {
            System.out.println(e.toString());
        } finally {
            try {
                buff.close();
                isr.close();
            } catch (IOException e) {

            }
        }


    }


}
