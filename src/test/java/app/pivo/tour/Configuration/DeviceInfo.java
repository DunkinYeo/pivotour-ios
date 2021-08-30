package app.pivo.tour.configuration;

public class DeviceInfo {
    private String iOSVersion;
    private String deviceName;
    private String udid;
    private boolean hasLiDAR;

    public DeviceInfo(String iOSVersion, String deviceName, String udid, boolean hasLiDAR) {
        this.iOSVersion = iOSVersion;
        this.deviceName = deviceName;
        this.udid = udid;
        this.hasLiDAR = hasLiDAR;
    }
    public String getIOSVersion() {
        return this.iOSVersion;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public String getUdid() {
        return this.udid;
    }

    public boolean getHasLiDAR() {
        return this.hasLiDAR;
    }
}
