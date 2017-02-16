/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hphjunittests;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 *
 * @author lapprestamo
 */
public class TestsRunner {
    
    public static void main(String[] args) {
        Result res = JUnitCore.runClasses(JunitTests.class);
        res.getFailures().stream().forEach((fail) -> {
            System.out.println(fail.toString());
        });
        for(Failure fail : res.getFailures()){
            System.out.println(fail.toString());
        }
            System.out.println(res.wasSuccessful() );
    }
    
}
