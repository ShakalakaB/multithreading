package fun.aldora.multithreading.java.scenario;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreadJoin {
    public static void main(String[] args) {
        List<Long> inputNumberList = Arrays.asList(3333L, 2324L, 23L, 5566L);

        List<FactorialThread> threadList = new ArrayList<>();
        for (Long inputNumber : inputNumberList) {
            FactorialThread thread = new FactorialThread(inputNumber);
            threadList.add(thread);
        }

        for (Thread thread : threadList) {
            thread.start();
        }

        for (Thread thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (FactorialThread thread : threadList) {
            if (thread.isFinished()) {
                System.out.println("Fractorial of " + thread.getInputNumber() + " is " + thread.getResult());
            } else {
                System.out.println("Fractorial of " + thread.getInputNumber() + " unfinished");
            }
        }
    }
}

class FactorialThread extends Thread {
    private long inputNumber;
    private BigInteger result = BigInteger.ZERO;
    private boolean isFinished = false;

    public FactorialThread(long inputNumber) {
        this.inputNumber = inputNumber;
    }

    @Override
    public void run() {
        BigInteger tempResult = BigInteger.ONE;
        for (long i = inputNumber; i > 0; i--) {
            tempResult = tempResult.multiply(BigInteger.valueOf(i));
        }
        isFinished = true;
        result = tempResult;
    }

    public BigInteger getResult() {
        return result;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public long getInputNumber() {
        return inputNumber;
    }
}
