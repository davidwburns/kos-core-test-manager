package com.kondra.kos.tester;


import com.tccc.kos.core.service.app.BaseAppConfig;
import com.tccc.kos.core.service.app.SystemApplication;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TesterApp extends SystemApplication<BaseAppConfig> {

    @Override
    public void load() {
        getCtx().add(new TestController());
    }

    @Override
    public void start() {

    }

    /**
     * Used as a fake entry point required when debugging.
     */
    public static void main(String[] args) {
    }
}
