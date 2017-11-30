package project.community_center.nrcf;

import java.io.Serializable;

/**
 * defines a Center
 */
public class Center implements Serializable {
    private int _id;
    private String _name;
    private String _address;
    private String _phone;
    private String _website;
    private String _activities;
    private String _hours;
    private int _picture;

    public Center() { }

    public Center(String name, String address, String phone, String website,
                  String activities, String hours, int picture) {
        _name = name;
        _address = address;
        _phone = phone;
        _website = website;
        _activities = activities;
        _hours = hours;
        _picture = picture;
    }

    public Center(int id, String name, String address, String phone, String website,
                   String activities, String hours, int picture) {
        _id = id;
        _name = name;
        _address = address;
        _phone = phone;
        _website = website;
        _activities = activities;
        _hours = hours;
        _picture = picture;
    }

    public String getName() {
        return _name;
    }

    public String getAddress() {
        return _address;
    }

    public String getPhone() {
        return _phone;
    }

    public String getWebsite() {
        return _website;
    }

    public String getActivities() {
        return _activities;
    }

    public String getHours() {
        return _hours;
    }

    public int getPicture() {
        return _picture;
    }


}
