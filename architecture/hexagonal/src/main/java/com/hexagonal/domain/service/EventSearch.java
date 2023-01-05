package com.hexagonal.domain.service;

import com.hexagonal.domain.entity.Event;
import com.hexagonal.domain.vo.ParsePolicyType;

import java.util.ArrayList;
import java.util.List;

public class EventSearch {

    public List<Event> retrieveEvents(List<String> unparsedEvents, ParsePolicyType policyType) {
        var parsedEvents = new ArrayList<Event>();
        unparsedEvents.stream().forEach(event -> {
            parsedEvents.add(Event.parsedEvent(event, policyType));
        });
        return parsedEvents;
    }
}
