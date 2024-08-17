package com.example.rps;

import java.util.Random;
import java.util.Scanner;

public class GameScannerProcessor {
    private Scanner scanner;
    private GameProcessor processor;
    private final Random random = new Random();

    public GameScannerProcessor(Scanner scanner, GameProcessor processor) {
        this.setScanner(scanner);
        this.setProcessor(processor);
    }

    public void setScanner(Scanner scanner) {
        if (scanner == null) {
            throw new IllegalArgumentException();
        }
        this.scanner = scanner;
    }

    public void setProcessor(GameProcessor processor) {
        if (processor == null) {
            throw new IllegalArgumentException();
        }
        this.processor = processor;
    }

    public void computeGameResult() {
        GameObject computerObject = GameObject.values()[this.random.nextInt(3)];
        GameObject playerObject = GameObject.valueOf(this.scanner.nextLine());

        this.processor.computeGameResult(playerObject, computerObject);
    }

    public Scanner getScanner() {
        return this.scanner;
    }

    public GameProcessor getProcessor() {
        return this.processor;
    }
}
