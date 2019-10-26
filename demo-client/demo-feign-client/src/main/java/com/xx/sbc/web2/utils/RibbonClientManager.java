package com.xx.sbc.web2.utils;

import com.netflix.client.ClientFactory;
import com.netflix.client.config.IClientConfig;
import com.netflix.discovery.EurekaClient;
import com.netflix.loadbalancer.*;
import com.netflix.niws.loadbalancer.DiscoveryEnabledNIWSServerList;
import com.netflix.niws.loadbalancer.DiscoveryEnabledServer;
import feign.ribbon.LBClient;
import feign.ribbon.LBClientFactory;
import feign.ribbon.RibbonClient;

import javax.inject.Provider;

/**
 * 1.IRule - 规则模式
 * 2.Iping - 管路
 * 3.ServerList - 服务列表
 * 4.ServerListFilter - 过滤服务列表
 * 5.ServerListUpdater - 动态更新服务列表
 * 6.IClientConfig - 配置信息
 * 7.ILoadBalancer - 负载平衡器
 */
public class RibbonClientManager {

    private static RibbonClient ribbonClient;

    public static RibbonClient instance(final String applicationName) {
        if (ribbonClient == null) {
            synchronized (RibbonClientManager.class) {
                if (ribbonClient == null) {
                    ribbonClient = RibbonClient.builder().lbClientFactory(new LBClientFactory() {

                        @Override
                        public LBClient create(String clientName) {
                            IClientConfig config = ClientFactory.getNamedConfig(clientName);
                            ILoadBalancer lb = getLoadBalancer(applicationName);
                            ZoneAwareLoadBalancer zb = (ZoneAwareLoadBalancer) lb;
                            zb.setRule(new ZoneAvoidanceRule());
                            return LBClient.create(lb, config);
                        }
                    }).build();
                }
            }
        }
        return ribbonClient;
    }


    public static ILoadBalancer getLoadBalancer(String serviceName) {
        Provider<EurekaClient> eurekaClientProvider = new Provider<EurekaClient>() {
            @Override
            public EurekaClient get() {
                return EurekaClientManager.getInstance();
            }
        };

        return LoadBalancerBuilder.<DiscoveryEnabledServer>newBuilder()
                .withDynamicServerList(new DiscoveryEnabledNIWSServerList(serviceName, eurekaClientProvider))
                .withRule(new AvailabilityFilteringRule())
                .buildDynamicServerListLoadBalancer();
    }
}