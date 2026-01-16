package com.kaisar.gym;
import com.kaisar.gym.menu.*;

public class Main {
    public static void main(String[] args) {
        Menu menu = new GymManagementMenu();
        menu.run();
    }
}