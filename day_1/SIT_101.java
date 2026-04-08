//Q1. Diamond problem

//java doesn't support multiple inheritance of classes, but it does support multiple inheritance of interfaces. 

//Q: A smart home system has DeviceA and DeviceB, both systems have same operation ie turnOn()
//A: SmartDevice implements both method/interfaces.

interface DeviceA_SIT{
    default void turnOn(){
        System.out.println("DeviceA is turned on.");
    }
}
interface DeviceB_SIT{
    default void turnOn(){
        System.out.println("DeviceB is turned on.");
    }
}
class SmartDevice implements DeviceA_SIT, DeviceB_SIT{
    @Override
    public void turnOn(){
        DeviceA_SIT.super.turnOn();
        DeviceB_SIT.super.turnOn();
    }
}
public class SIT_101 {
    public static void main(String[] args){
        SmartDevice op=new SmartDevice();
        op.turnOn();
        
    }
}