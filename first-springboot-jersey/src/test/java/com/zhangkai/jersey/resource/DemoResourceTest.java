package com.zhangkai.jersey.resource;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.apache.connector.ApacheConnectorProvider;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author and0429
 *
 */
public class DemoResourceTest {

    private static final String BASE_URI = "http://localhost/";
    private HttpServer server;
    private WebTarget target;

    @Before
    public void setUp() throws IOException {
        final ResourceConfig rc = new ResourceConfig().register(DemoResource.class);
        URI uri = URI.create(BASE_URI);
        server = GrizzlyHttpServerFactory.createHttpServer(uri , rc);
        server.start();

        ClientConfig config = new ClientConfig();
        config.connectorProvider(new ApacheConnectorProvider());

        Client client = ClientBuilder.newClient(config);
        target = client.target(BASE_URI).path("hi");
    }

    @After
    public void tearDown() {
        if (server != null) {
            server.shutdownNow();
        }
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testHi() {
        List<String> list = target.request(MediaType.APPLICATION_JSON).get(List.class);
        Assert.assertNotNull(list);
        Assert.assertNotNull("hello spring boot", list.get(0));
    }

}
