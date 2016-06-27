/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camel.mycart;

import org.apache.camel.CamelContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Hardik Upadhyay
 */
public class Application {
    public static void main(String args[]) throws InterruptedException, Exception
    {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Thread.currentThread().sleep(160000);
        CamelContext camelCotext = (CamelContext) ctx.getBean("camel_context");
        camelCotext.stop();
    }
}
