package com.mydomain.example.delivery.module;

import com.softicar.platform.core.module.test.fixture.CoreModuleTestFixture;
import com.softicar.platform.core.module.web.service.test.HotWebServiceTestServer;
import com.softicar.platform.core.module.web.service.test.WebServiceTestService;

public class TestService extends WebServiceTestService {
 
    public TestService() {

        database.apply(() -> {
        	new CoreModuleTestFixture().apply();
        });
    }

    public static void main(String[] args) {

        new HotWebServiceTestServer(TestService.class)//
                .setPort(8000).startAndJoin();
    }
}
