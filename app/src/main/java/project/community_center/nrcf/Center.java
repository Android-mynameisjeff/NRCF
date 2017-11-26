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
                    R.drawable.youthcentre),
            new Center("Queensborough Community Centre", "920 Ewen Avenue V3M 5C8",
                  "(604)527-7388",   "https://www.newwestcity.ca/parks-and-recreation/facilities/queensborough-community-centre",
                    "Library, Fitness Classes, Weight Room, Kolumbia Inn Daycare",
                    "Monday-Friday, 7:00 am - 9:30 pm, Saturday, 8:30 am - 5:30 pm, Sunday, 8:30 am - 8:30 pm",
                    R.drawable.queensborough),
            new Center("Queens Park Arena", "3rd Ave",
                    "(604) 777-5111", "https://www.newwestcity.ca/parks-and-recreation/facilities/queens-park-arena",
                    "Drop-In Hockey, Lacrosse, Ice Rental",
                    "Weekdays, 9:00 am - 4:00 pm",
                    R.drawable.queenpark),
            new Center("Moody Park Arena", "701 Eighth Avenue V3M 2R2",
                    "(604) 525-5301", "https://www.newwestcity.ca/parks-and-recreation/facilities/moody-park-arena",
                    " Ice Skating",
                    "Monday 8:30 am - 8:30 pm, Tuesday - Friday 8:30 am - 4:30 pm, Sunday 11:30 am - 3:30 pm",
                    R.drawable.moodypark),
            new Center("Century House", "620 Eighth Avenue V3M 2S2",
                    "(604) 519-1066", "https://www.newwestcity.ca/parks-and-recreation/facilities/century-house",
                    "Senior (+50) Activities, Exercise Room, Food Services, Peer Counselling ",
                    "Weekdays 9:00 am - 9:00 pm, Saturday 9:00 am - 4:00 pm, Sunday 12:00 pm - 4:00 pm",
                    R.drawable.centuryhouse),
            new Center("Centennial Community Centre", "65 East Sixth V3l 4G6",
                    "(604) 777-5100", "https://www.newwestcity.ca/parks-and-recreation/facilities/centennial-community-centre",
                    "Arts & Crafts, Cooking, Dance, Day Camps, Judo, Sports, Yoga, Fitness, Indoor Cycling, Child Mining",
                    "Monday-Thursday 9:00 am - 8:30 pm, Friday 9:00 am - 8:00 pm, Weekends 8:30 am - 1:00 pm",
                    R.drawable.centennial),
            new Center("Canada Pools Games", "65 East Sixth V3l 4G6",
                    "(604) 526-4281", "https://www.newwestcity.ca/parks-and-recreation/facilities/canada-games-pool",
                    "Swimming, Diving, Fitness, Aquafit, Green Thunder Waterslide",
                    "Weekdays 5:30 am - 9:30 pm, Saturday 8:00 am - 8:00 pm, Sunday 8:00 am - 9:30 pm",
                    R.drawable.canadagames)
    };

    public static final String[] nameslist = {"New Westminster Youth Centre", "Queensborough Community Centre",
    "Queens Park Arena", "Moody Park Arena", "Century House", "Centennial Community Centre", "Canada Pools Games"};

}
