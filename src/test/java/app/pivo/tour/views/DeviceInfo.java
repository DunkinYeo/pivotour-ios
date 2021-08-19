package app.pivo.tour.views;

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

    public void setIOSVersion(String iOSVersion) {
        this.iOSVersion = iOSVersion;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public void setUdid(String udid) {
        this.udid = udid;
    }

    public void setHasLiDAR(boolean hasLiDAR) {
        this.hasLiDAR = hasLiDAR;
    }

    public String getIOSVersion() {
        return this.iOSVersion;
    }

    // public String getIOSVersionToString() {
    //     return Double.toString(this.iOSVersion);
    // }

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
