package com.zhangkai.jersey.application;

import javax.inject.Named;

import org.glassfish.jersey.server.ResourceConfig;

import com.zhangkai.jersey.resource.DemoResource;

/**
 * 
 * @author and0429
 *
 */
@Named
public class JerseyConfig extends ResourceConfig {

    /**
     * 加載資源
     */
    /*
     * public JerseyConfig() { packages("com.zhangkai.jersey.resource"); }
     */
    /*
     * (non-Javadoc)
     * 
     * @see org.glassfish.jersey.server.ResourceConfig#register(java.lang.Class)
     */

    public JerseyConfig() {
        register(DemoResource.class);
    }

}
