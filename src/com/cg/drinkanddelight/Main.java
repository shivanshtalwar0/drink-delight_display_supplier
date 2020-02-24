package com.cg.drinkanddelight;

import com.cg.drinkanddelight.exceptions.InvalidUserIdException;
import com.cg.drinkanddelight.ui.AppUi;

import java.io.IOException;

public class Main {
    public static void main(String[] args)throws IOException, InvalidUserIdException {
        new AppUi();
    }
}
