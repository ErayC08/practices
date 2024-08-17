package com.example.game.controller;

import com.example.game.object.RPSGameObject;
import com.example.game.processor.RPSGameProcessor;

import java.util.Random;
import java.util.Scanner;

public class RPSGameController {
    private Scanner scanner;
    private RPSGameProcessor processor;
    private final Random random = new Random();

    public RPSGameController(Scanner scanner, RPSGameProcessor processor) {
        this.setScanner(scanner);
        this.setProcessor(processor);
    }

    public void setScanner(Scanner scanner) {
        if (scanner == null) {
            throw new IllegalArgumentException();
        }
        this.scanner = scanner;
    }

    public void setProcessor(RPSGameProcessor processor) {
        if (processor == null) {
            throw new IllegalArgumentException();
        }
        this.processor = processor;
    }

    public void computeGameResult() {
        RPSGameObject computerObject = RPSGameObject.values()[this.random.nextInt(3)];
        RPSGameObject playerObject = RPSGameObject.valueOf(this.scanner.nextLine());

        this.processor.computeResult(playerObject, computerObject);
    }

    public Scanner getScanner() {
        return this.scanner;
    }

    public RPSGameProcessor getProcessor() {
        return this.processor;
    }
}
