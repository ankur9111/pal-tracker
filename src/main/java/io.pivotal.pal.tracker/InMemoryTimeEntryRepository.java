package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.time.LocalDate;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

private HashMap<Long,TimeEntry> timeEntryHashMap = new HashMap<>();

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        long id = timeEntryHashMap.size()+1L;
        TimeEntry currentTimeEntry = new TimeEntry(id,timeEntry.getProjectId(),timeEntry.getUserId(),timeEntry.getDate(),timeEntry.getHours());
        timeEntryHashMap.put(id,currentTimeEntry);
        return currentTimeEntry;
    }

    @Override
    public TimeEntry find(long id) {
        TimeEntry responseTimeEntry =  timeEntryHashMap.get(id);
        return responseTimeEntry;
    }

    @Override
    public void delete(long id) {
     timeEntryHashMap.remove(id);
    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {
        TimeEntry timeEntryUpdate = new TimeEntry(id, timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours());
        timeEntryHashMap.replace(id, timeEntryUpdate);
        return timeEntryUpdate;
    }

    @Override
    public ArrayList list() {
        return new ArrayList<>(timeEntryHashMap.values());
    }
}
