package com.xx.sbc.web2.utils;

import com.netflix.appinfo.ApplicationInfoManager;
import com.netflix.appinfo.EurekaInstanceConfig;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.appinfo.MyDataCenterInstanceConfig;
import com.netflix.appinfo.providers.EurekaConfigBasedInstanceInfoProvider;
import com.netflix.discovery.DefaultEurekaClientConfig;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.EurekaClient;

public class EurekaClientManager {

    private static EurekaClient eurekaClient;

    public static EurekaClient getInstance() {
        if (eurekaClient == null) {
            synchronized (EurekaClientManager.class) {
                if (eurekaClient == null) {
                    EurekaInstanceConfig instanceConfig = new MyDataCenterInstanceConfig();
                    InstanceInfo instanceInfo = new EurekaConfigBasedInstanceInfoProvider(instanceConfig).get();
                    ApplicationInfoManager applicationInfoManager = new ApplicationInfoManager(instanceConfig, instanceInfo);

                    eurekaClient = new DiscoveryClient(applicationInfoManager, new DefaultEurekaClientConfig());
                }
            }
        }
        return eurekaClient;
    }

    public static void shutdown() {
        if (eurekaClient != null) {
            eurekaClient.shutdown();
        }
    }
}