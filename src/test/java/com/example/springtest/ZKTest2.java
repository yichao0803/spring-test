package com.example.springtest;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.ACLProvider;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.curator.retry.RetryOneTime;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.ACL;


import java.util.Arrays;
import java.util.List;

/**
 * @className: Test1
 * @description: TODO
 * @author: zhangyichao
 * @date: 2022/8/5
 **/
public class ZKTest2 {
    private static String PATH = "/dsc/task";
    private static  CuratorFramework client = null;


    public static void main(String[] args)  {
        try {

            CuratorFrameworkFactory.Builder builder = CuratorFrameworkFactory.builder().connectString("192.168.13.110:2181")
                    .retryPolicy(new RetryOneTime(1000))
                    .connectionTimeoutMs(10000)
                    .sessionTimeoutMs(10000)
                    .namespace("kd_test");

            // builder.authorization("digest", "yanxuan_dsc".getBytes("utf-8"));
            builder.aclProvider(new ACLProvider() {

                        @Override
                        public List<ACL> getDefaultAcl() {
                            return ZooDefs.Ids.OPEN_ACL_UNSAFE;
                        }

                        @Override
                        public List<ACL> getAclForPath(final String path) {
                            return ZooDefs.Ids.OPEN_ACL_UNSAFE;
                        }
                    });

            client = builder.build();
            client.start();

            // prepareData();
            startWatch();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void prepareData() throws Exception {


        int childNum = 1024;
        char[] chars = new char[1024];
        Arrays.fill(chars, 'x');
        String nameSuffix = new String(chars);
        client.create().forPath(PATH);
        for (int i = 0; i < childNum; i++) {
            String childPath = PATH + "/_" + String.valueOf(i)+ "_" ;/*+ nameSuffix;*/
            client.create().forPath(childPath);
        }
    }

    private static void startWatch() throws Exception {
        PathChildrenCache watcher = new PathChildrenCache(client, PATH, true);
        watcher.getListenable().addListener(new PathChildrenCacheListener() {
                                                @Override
                                                public void childEvent(CuratorFramework client, PathChildrenCacheEvent event) throws Exception {
                                                    ChildData data = event.getData();
                                                    if (data == null) {
                                                        System.out.println("No data in event[" + event + "]");

                                                    } else {
                                                        System.out.println("Receive event: "
                                                                + "type=[" + event.getType() + "]"
                                                                + ", path=[" + data.getPath() + "]"
                                                                + ", data=[" + new String(data.getData()) + "]"
                                                                + ", stat=[" + data.getStat().toString().trim() + "]");
                                                    }
                                                }
                                            }

        );
        watcher.start(PathChildrenCache.StartMode.BUILD_INITIAL_CACHE);
    }
}
