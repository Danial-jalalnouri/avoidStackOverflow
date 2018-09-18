package com.jndanial;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        System.out.println(rSumNumbers(100000));
        System.out.println(sumNumbers(100000));
    }


    public static int rSumNumbers(int n){
        if(n>0){
            int sum = n + rSumNumbers(n-1);
            return sum;
        }
        return 0;
    }

    public static int sumNumbers(int n){
        int returnVal = 0;

        Stack<SnapShotObject> snapShotObjectStack = new Stack<>();

        SnapShotObject currentSnapShot = new SnapShotObject();
        currentSnapShot.n = n;
        currentSnapShot.sum = 0;
        currentSnapShot.stage = 0;
        snapShotObjectStack.push(currentSnapShot);

        while(!snapShotObjectStack.empty()){
            currentSnapShot = snapShotObjectStack.pop();

            switch (currentSnapShot.stage){
                case 0:
                    if(currentSnapShot.n > 0){
                        currentSnapShot.stage = 1;
                        snapShotObjectStack.push(currentSnapShot);
                        SnapShotObject newSnapShot = new SnapShotObject();
                        newSnapShot.n = currentSnapShot.n -1;
                        newSnapShot.sum = 0;
                        newSnapShot.stage = 0;
                        snapShotObjectStack.push(newSnapShot);
                    }
                    returnVal = 0;
                    continue;
                    //break;
                case 1:
                    currentSnapShot.sum = returnVal;
                    currentSnapShot.sum = currentSnapShot.sum + currentSnapShot.n;
                    returnVal = currentSnapShot.sum;
                    continue;
                    //break;
            }
        }

        return returnVal;
    }

    static class SnapShotObject{
        int n;
        int sum;
        int stage;
    }
}
