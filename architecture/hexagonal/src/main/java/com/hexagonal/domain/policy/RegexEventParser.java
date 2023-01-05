package com.hexagonal.domain.policy;

import com.hexagonal.domain.entity.Event;
import com.hexagonal.domain.vo.Activity;
import com.hexagonal.domain.vo.EventId;
import com.hexagonal.domain.vo.Protocol;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexEventParser implements EventParser {

    @Override
    public Event parseEvent(String event) {
        final String regex = "(\\\"[^\\\"]+\\\")|\\S+";
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);

        final Matcher matcher = pattern.matcher(event);
        var fields = new ArrayList<>();

        while (matcher.find()) {
            fields.add(matcher.group(0));
        }

        var timestamp = LocalDateTime.parse(matcher.group(0), formatter).atOffset(ZoneOffset.UTC);
        var id = EventId.of(matcher.group(2));
        var protocol = Protocol.valueOf(matcher.group(2));
        var activity = new Activity(matcher.group(3), matcher.group(5));
        return new Event(timestamp, id, protocol, activity);
    }
}
