package zecloud;

import base.Component;
import base.Factory;
import base.Composite;
import base.VirtualMachine;

/**
 * Created by mouna on 21/11/2016.
 */
public class ZComponent implements Component {

    private String name;
    private ComponentType type;
    private  boolean deployed ;
    private VirtualMachine vm;

    public ZComponent(String name, ComponentType type) {
        this.name = name;
        this.type = type;
        this.deployed = false;
        this.vm = null;
    }


    @Override
    public String name() {
        return name;
    }

    @Override
    public String type() {
        return type.name();
    }

    @Override
    public int ressources() {
        return type.ressources();
    }

    @Override
    public boolean deployed() {
        return deployed;
    }

    @Override
    public VirtualMachine vm() {
        return vm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return  true;
        if (o == null || getClass() != o.getClass())
            return  false;

        ZComponent that = (ZComponent) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
       return name.hashCode();
    }

    @Override
    public String toString() {
        return "\tcomponent " + name + " : " + type() + "\n";
    }

    public void deployed(VirtualMachine vm){
        if (!deployed){
            deployed = true;
            this.vm = vm;
        }
    }

    public void undployed(){
        if(deployed){
            deployed = false;
            this.vm = null;
        }
    }
}
