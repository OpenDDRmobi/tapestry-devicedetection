package com.altocon.tapestry_wurfl.services;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import net.sourceforge.wurfl.core.Device;
import net.sourceforge.wurfl.core.WURFLHolder;
import net.sourceforge.wurfl.core.WURFLManager;

import org.apache.tapestry5.ioc.Configuration;
import org.apache.tapestry5.ioc.annotations.Scope;
import org.apache.tapestry5.services.ApplicationGlobals;
import org.apache.tapestry5.services.LibraryMapping;

public class TapestryWurflModule {

    public static void contributeComponentClassResolver(final Configuration<LibraryMapping> configuration) {
        configuration.add(new LibraryMapping("tapestry-wurfl", "com.altocon.tapestry_wurfl"));
    }

    /**
     * This service builder extracts the wurfl device from the current request
     * and makes it available to component classes, so you can inject it into
     * your classes directly.
     * @param applicationGlobals contains the needed servlet context that holds
     * the wurfl manager
     * @param request to get the device information from the user agent request
     * header
     * @return net.sourceforge.wurfl.core.Device - the wurfl device
     */
    @Scope(value = "perthread")
    public static Device buildDevice(final ApplicationGlobals applicationGlobals, final HttpServletRequest request) {
        final ServletContext servletContext = applicationGlobals.getServletContext();

        final WURFLHolder wurflHolder = (WURFLHolder) servletContext
                .getAttribute("net.sourceforge.wurfl.core.WURFLHolder");

        final WURFLManager wurfl = wurflHolder.getWURFLManager();

        return wurfl.getDeviceForRequest(request);
    }

}
