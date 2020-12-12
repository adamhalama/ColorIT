package model;

import java.io.Serializable;
import java.util.ArrayList;

public class TrackTimeList implements Serializable
{
    private ArrayList<TrackTime> trackTimeList;

    public TrackTimeList()
    {
        this.trackTimeList = new ArrayList<TrackTime>();
    }

    public void setTimeWorked(TeamMember teamMember, int time)
    {
        for (TrackTime trackTime : this.trackTimeList)
        {
            if (trackTime.getTeamMember().equals(teamMember))
            {
                trackTime.setTimeWorked(time);
                return;
            }
        }
        this.trackTimeList.add(new TrackTime(teamMember, time));
    }

    public ArrayList<TrackTime> getTrackTime()
    {
        return this.trackTimeList;
    }

    public int getTimeOfMember(TeamMember teamMember)
    {
        for (TrackTime trackTime : this.trackTimeList)
        {
            if (trackTime.getTeamMember().equals(teamMember)) {
                return trackTime.getTime();
            }
        }
        return 0;
    }

    public int getTotalTime()
    {
        int totalTime = 0;
        for (TrackTime trackTime : this.trackTimeList)
        {
            totalTime+=trackTime.getTime();
        }
        return totalTime;
    }
}
