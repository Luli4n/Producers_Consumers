package Krabel.Julian.controller;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
public abstract class ThreadController {
    protected List<Thread> threads;

    public void startThreads()  {
        for(Thread t:threads)
        {
            t.start();
        }
    }

    public void joinThreads() throws InterruptedException {
        for(Thread t:threads)
        {
            t.join();
        }
    }
}
