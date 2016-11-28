package client;

import base.CloudFactory;
import base.Component;
import base.Factory;
import base.VirtualMachine;
import zecloud.ComponentType;
import zecloud.ZCloudFactory;

/**
 * Created by mouna on 21/11/2016.
 */
public class Main1 {

    public static void main(String[] args){

        CloudFactory f = new ZCloudFactory("nuage");

        ComponentType apache = f.createType("apache", 10);
        ComponentType tomcat = f.createType("tomcat", 20);
        ComponentType mysql = f.createType("mysql", 15);
        ComponentType postgres = f.createType("postgres", 20);

        VirtualMachine vm1 = f.createVM("vm1", 50);
        VirtualMachine vm2 = f.createVM("vm2", 15);

        Component c1 = f.createComponent("c1", apache);
        Component c2 = f.createComponent("c2", tomcat);
        Component c3 = f.createComponent("c3", mysql);
        Component c4 = f.createComponent("c4", postgres);

        f.deploy(c1, vm1);
        f.deploy(c2, vm1);
        f.deploy(c3, vm1);
        f.deploy(c4, vm1);
        f.deploy(c3, vm2);
        System.out.println(f);
        f.undeploy(c3);
        f.deploy(c3, vm2);
        f.deploy(c4, vm1);
        System.out.println(f);

    }
}
