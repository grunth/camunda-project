package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.Random;

public class ChechWeatherDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        Random rnd = new Random();

        execution.setVariable("name", "Petra");
        execution.setVariable("weatherOk", rnd.nextBoolean());
    }
}
