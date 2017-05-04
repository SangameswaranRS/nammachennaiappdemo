package com.example.sangameswaran.nammachennai;

/**
 * Created by Sangameswaran on 25-03-2017.
 */

public class EventModelClass  {
    String venue,eventname,time,entry,contactmail,contactphone,category;
   public   EventModelClass(String venue,String eventname,String time,String entry,String contactmail,String contactphone,String category)
    {
        this.venue=venue;
        this.eventname=eventname;
        this.time=time;
        this.entry=entry;
        this.contactmail=contactmail;
        this.contactphone=contactphone;
        this.category=category;
    }
    public EventModelClass()
    {

    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public String getContactmail() {
        return contactmail;
    }

    public void setContactmail(String contactmail) {
        this.contactmail = contactmail;
    }

    public String getContactphone() {
        return contactphone;
    }

    public void setContactphone(String contactphone) {
        this.contactphone = contactphone;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
