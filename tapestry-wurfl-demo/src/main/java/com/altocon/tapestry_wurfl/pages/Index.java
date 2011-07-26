package com.altocon.tapestry_wurfl.pages;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import net.sourceforge.wurfl.core.Device;
import net.sourceforge.wurfl.core.WURFLHolder;
import net.sourceforge.wurfl.core.WURFLManager;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.ApplicationGlobals;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Start page of application tapestry-wurfl-demo.
 */
public class Index {

    private final Logger logger = LoggerFactory.getLogger(Index.class);

    @Inject
    private ApplicationGlobals _applicationGlobals;

    @Inject
    private HttpServletRequest _request;

    public Date getCurrentTime() {
        return new Date();
    }

    public String getDeviceID() {
        final ServletContext servletContext = _applicationGlobals.getServletContext();

        final WURFLHolder wurflHolder = (WURFLHolder) servletContext
                .getAttribute("net.sourceforge.wurfl.core.WURFLHolder");

        final WURFLManager wurfl = wurflHolder.getWURFLManager();

        final Device device = wurfl.getDeviceForRequest(_request);

        logger.debug("Device: {}", device.getId());

        return device.getId();
    }
}
