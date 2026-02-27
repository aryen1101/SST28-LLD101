public class ClassroomController {
    private final DeviceRegistry reg;
    

    public ClassroomController(DeviceRegistry reg) { this.reg = reg; }

    public void startClass() {
        
        Powerable pj = reg.getFirstOfType(Powerable.class);
        pj.powerOn();

        for(Powerable powerable : reg.getAllOfType(Powerable.class)){
            powerable.powerOn();
        }

        Connectable connectable = reg.getFirstOfType(Connectable.class);
        connectable.connectInput("HDMI-1");

        BrightnessControllable lights = reg.getFirstOfType(BrightnessControllable.class);
        lights.setBrightness(60);

        TempControllable ac = reg.getFirstOfType(TempControllable.class);
        ac.setTemperatureC(24);

        Scanable scan = reg.getFirstOfType(Scanable.class);
        System.out.println("Attendance scanned: present=" + scan.scanAttendance());
    }

    public void endClass() {
        System.out.println("Shutdown sequence:");
        for(Powerable powerable : reg.getAllOfType(Powerable.class)){
            powerable.powerOff();
        }
        
    }
}
