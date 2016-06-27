package org.camel.mycart;

import org.apache.camel.builder.RouteBuilder;

public class TestRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {        
        from("jms:orders").to("mock:orders");        
    }

}
