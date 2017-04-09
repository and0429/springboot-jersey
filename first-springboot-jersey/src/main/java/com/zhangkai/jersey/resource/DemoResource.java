package com.zhangkai.jersey.resource;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * 
 * @author and0429
 *
 */
@Path("/hi")
public class DemoResource {

    /**
     * 
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> hi() {
        return Arrays.asList("hello spring boot", "second");
    }

}
