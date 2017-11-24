package project.community_center.nrcf;

import java.io.Serializable;

public class Center implements Serializable {

    private String _name;
    private String _address;
    private String _phone;
    private String _website;
    private String _activities;
    private String _hours;
    private int _picture;

    private Center() { }

    private Center(String name, String address, String phone, String website,
                   String activities, String hours, int picture) {
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

    //String name, String address, String phone, String website,
   // String activities, String hours, int picture
    //

    public static final Center[] list = {
            new Center("New Westminster Youth Centre", "620 Eighth Street V3M 3S2",
                "(604)515-3801", "http://www.newwestpcr.ca/recreation/youth_centre.php",
                  "Drop-in Basketball, Cooking Program, Computer lab, Fitness Facility, Pool Table, Multi-Purpose Room",
                   "Monday-Thursday, 3:15 pm - 9:00 pm, Friday-Saturday, 3:15pm-11:00pm",
                    R.drawable.youthcentre)
    };

    public static final String[] nameslist = {"New Westminster Youth Centre", "Queensborough Community Centre",
    "Queens Park Arena", "Moody Park Arena", "Century House"};

}
