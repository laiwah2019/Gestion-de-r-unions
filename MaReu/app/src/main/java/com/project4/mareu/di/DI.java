package com.project4.mareu.di;

import com.project4.mareu.service.DummyMeetingApiServices;
import com.project4.mareu.service.ReunionApi;
import com.project4.mareu.service.ReunionListService;

/**
        * Dependency injector to get instance of services
        */
public class DI {

    private static ReunionApi service = new DummyMeetingApiServices();

    /**
     * Get an instance on @{@link ReunionListService}
     * @return
     */
    public static ReunionApi getReunionApi() {
        return service;
    }

    /**
     * Get always a new instance on @{@link ReunionApi}. Useful for tests, so we ensure the context is clean.
     * @return
     */
    public static ReunionApi getNewInstanceApiService() {
        return new DummyMeetingApiServices();
    }
}
