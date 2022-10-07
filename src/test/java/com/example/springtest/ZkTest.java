package com.example.springtest;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @className: ZkTest
 * @description: TODO
 * @author: zhangyichao
 * @date: 2022/8/5
 **/
public class ZkTest {
    public static final String serverAddress = "192.168.13.110:2181";
    public static final int timeout = 15000;


    /**
     * @param
     * @description:
     * @return: org.apache.zookeeper.ZooKeeper
     * @author: 李若白
     * @time: 4/5/2022 5:32 PM
     */
    public static ZooKeeper connect() {
        System.out.println("开始获取zookeeper连接...");
        ZooKeeper zk = null;
        try {
            zk = new ZooKeeper(serverAddress, timeout, null);
            System.out.println("获取连接成功!");
            return zk;
        } catch (IOException e) {
            System.out.println("获取连接时出现异常，请重试...");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @param zkConnect zookeeper连接
     * @param node      我们选定的zookeeper节点
     * @param data      我们想要插入的数据
     * @description:
     * @return: void
     * @author: 李若白
     * @time: 4/5/2022 5:57 PM
     */
    public static void create(ZooKeeper zkConnect, String node, String data) {

        System.out.println("开始创建节点：" + node + "，节点数据为：" + data);
        List<ACL> acl = ZooDefs.Ids.OPEN_ACL_UNSAFE;//这个参数是节点权限，在Zookeeper中每个节点有各自的权限，我们使用acl并变量存储权限
        CreateMode createMode = CreateMode.PERSISTENT;//这个参数是节点类型
        try {
            zkConnect.create(node, data.getBytes(), acl, createMode);
            System.out.println("创建成功!");
        } catch (KeeperException e) {
            System.out.println("创建失败!");
            e.printStackTrace();

        } catch (InterruptedException e) {
            System.out.println("创建失败!");
            e.printStackTrace();
        }
    }

    /**
     * @param zkConnect
     * @param node
     * @description:
     * @return: void
     * @author: 李若白
     * @time: 4/5/2022 10:14 PM
     */
    public static void delete(ZooKeeper zkConnect, String node) {

        try {
            Stat stat = zkConnect.exists(node, false);
            System.out.println("开始删除节点：" + node);
            zkConnect.delete(node, stat.getVersion());
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param zkConnect
     * @param node
     * @param data
     * @description:
     * @return: void
     * @author: 李若白
     * @time: 4/5/2022 10:19 PM
     */
    public static void setNode(ZooKeeper zkConnect, String node, String data) throws InterruptedException, KeeperException {
        Stat stat = zkConnect.exists(node, false);
        zkConnect.setData(node, data.getBytes(), stat.getVersion());
        System.out.println("新值设定成功!");
    }

    /**
     * @param zooKeeper
     * @param node
     * @description:
     * @return: void
     * @author: 李若白
     * @time: 4/5/2022 10:23 PM
     */
    public static void getNode(ZooKeeper zooKeeper, String node) throws InterruptedException, KeeperException {

        Stat stat = zooKeeper.exists(node, false);
        String info = new String(zooKeeper.getData(node, false, stat));
    }


    public static void main(String[] args) {
        ZooKeeper connect = connect();
        int childNum = 1024;
        char[] chars = new char[1024];
        Arrays.fill(chars, 'x');
        String nameSuffix = new String(chars);
        // create(connect, "/kd_test", "{\"id\":1,\"name\":\"zhangsan\"}");
        //create(connect, "/kd_test/dsc/task", "{\"id\":1,\"name\":\"zhangsan\"}");
        for (int i = 0; i < childNum; i++) {
            create(connect, "/kd_test/dsc/task/_" + i + "_" + nameSuffix, "{\"id\":1,\"name\":\"zhangsan\"}");
        }
    }
}
