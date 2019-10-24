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

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

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

//    private final static Logger LOG = LoggerFactory.getLogger(RibbonClientManager.class);

    private static RandomRule chooseRule = new RandomRule();

    private static EurekaClient eurekaClient = EurekaClientManager.getInstance();

    private static RibbonClientManager manager;

    private static IClientConfig clientConfig;

    private static Provider<EurekaClient> eurekaClientProvider;

    private static RibbonClient ribbonClient;

    static {
//        clientConfig = new DefaultClientConfigImpl();
//        clientConfig.loadDefaultValues();

        eurekaClientProvider = new Provider<EurekaClient>() {
            public EurekaClient get() {
                return eurekaClient;
            }
        };

    }

//    public static RibbonClientManager getManager() {
//        if (manager == null) {
//            synchronized (RibbonClientManager.class) {
//                if (manager == null) {
//                    manager = new RibbonClientManager();
//                }
//            }
//        }
//        return manager;
//    }

    public static RibbonClient instance() {
        if (ribbonClient == null) {
            synchronized (RibbonClientManager.class) {
                if (ribbonClient == null) {
                    ribbonClient = RibbonClient.builder().lbClientFactory(new LBClientFactory() {

                        @Override
                        public LBClient create(String clientName) {
                            IClientConfig config = ClientFactory.getNamedConfig(clientName);
                            ILoadBalancer lb = getLoadBalancer("demo-feign-service");
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

    public String getAvailableServerUrl(String serviceName) {

//        clientConfig.set(CommonClientConfigKey.DeploymentContextBasedVipAddresses, serviceName);

        /**
         * step1：服务提供者列表
         */
//        DiscoveryEnabledNIWSServerList discoveryEnabledNIWSServerList = new DiscoveryEnabledNIWSServerList(clientConfig, eurekaClientProvider);
        ServerList<DiscoveryEnabledServer> discoveryEnabledNIWSServerList = new DiscoveryEnabledNIWSServerList(serviceName, eurekaClientProvider);

//        @SuppressWarnings({"rawtypes", "unchecked"})
//        ILoadBalancer loadBalancer = new DynamicServerListLoadBalancer(clientConfig, new ZoneAvoidanceRule(), new NIWSDiscoveryPing(),
//                discoveryEnabledNIWSServerList, new DefaultNIWSServerListFilter(), new EurekaNotificationServerListUpdater(eurekaClientProvider));
//
//        Server chooseServer = chooseRule.choose(loadBalancer, null);
//        if (chooseServer == null) {
////            LOG.error("the service {} no available server url!", serviceName);
//            return null;
//        }

        /**
         * step2：负载均衡算法
         */
        IRule rule = new AvailabilityFilteringRule();
//        ServerListFilter<DiscoveryEnabledServer> filter = new ZoneAffinityServerListFilter<DiscoveryEnabledServer>();

        /**
         * 负载均衡器
         */
        ZoneAwareLoadBalancer<DiscoveryEnabledServer> lb = LoadBalancerBuilder.<DiscoveryEnabledServer>newBuilder()
                .withDynamicServerList(discoveryEnabledNIWSServerList)
                .withRule(rule)
//                .withServerListFilter(filter)
                .buildDynamicServerListLoadBalancer();
        DiscoveryEnabledServer chooseServer = (DiscoveryEnabledServer) lb.chooseServer();

        StringBuilder sb = new StringBuilder();
        sb.append("http://").append(chooseServer.getHostPort());
        return sb.toString();
    }

    public static ILoadBalancer getLoadBalancer(String serviceName) {

//        clientConfig.set(CommonClientConfigKey.DeploymentContextBasedVipAddresses, serviceName);

        /**
         * step1：服务提供者列表
         */
//        DiscoveryEnabledNIWSServerList discoveryEnabledNIWSServerList = new DiscoveryEnabledNIWSServerList(clientConfig, eurekaClientProvider);
        ServerList<DiscoveryEnabledServer> discoveryEnabledNIWSServerList = new DiscoveryEnabledNIWSServerList(serviceName, eurekaClientProvider);

//        @SuppressWarnings({"rawtypes", "unchecked"})
//        ILoadBalancer loadBalancer = new DynamicServerListLoadBalancer(clientConfig, new ZoneAvoidanceRule(), new NIWSDiscoveryPing(),
//                discoveryEnabledNIWSServerList, new DefaultNIWSServerListFilter(), new EurekaNotificationServerListUpdater(eurekaClientProvider));
//
//        Server chooseServer = chooseRule.choose(loadBalancer, null);
//        if (chooseServer == null) {
////            LOG.error("the service {} no available server url!", serviceName);
//            return null;
//        }

        /**
         * step2：负载均衡算法
         */
        IRule rule = new AvailabilityFilteringRule();
//        ServerListFilter<DiscoveryEnabledServer> filter = new ZoneAffinityServerListFilter<DiscoveryEnabledServer>();

        /**
         * 负载均衡器
         */
        return LoadBalancerBuilder.<DiscoveryEnabledServer>newBuilder()
                .withDynamicServerList(discoveryEnabledNIWSServerList)
                .withRule(rule)
//                .withServerListFilter(filter)
                .buildDynamicServerListLoadBalancer();
//        DiscoveryEnabledServer chooseServer = (DiscoveryEnabledServer) lb.chooseServer();
//
//        StringBuilder sb = new StringBuilder();
//        sb.append("http://").append(chooseServer.getHostPort());
//        return sb.toString();
    }


    public static void main(String[] args) throws Exception {

//        System.out.println(RibbonClientManager.getManager().getAvailableServerUrl(MicroServiceNameEnum.MICRO_DATA_PLATFORM_CRM.getName()));
//        System.out.println(RibbonClientManager.getManager().getAvailableServerUrl(MicroServiceNameEnum.MICRO_DATA_PLATFORM_REPORT.getName()));

    }

}