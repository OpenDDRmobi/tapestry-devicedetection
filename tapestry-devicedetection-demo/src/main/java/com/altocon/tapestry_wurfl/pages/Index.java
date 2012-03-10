package com.altocon.tapestry_wurfl.pages;

import java.util.Date;

import net.sourceforge.wurfl.core.Device;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Start page of application tapestry-wurfl-demo.
 */
public class Index {

    private final Logger logger = LoggerFactory.getLogger(Index.class);

    @Inject
    private Device _device;

    public Date getCurrentTime() {
        return new Date();
    }

    public String getDeviceID() {
        logger.debug("Device: {}", _device.getId());

        return _device.getId();
    }
}
