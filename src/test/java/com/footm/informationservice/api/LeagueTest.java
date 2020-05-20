package com.footm.informationservice.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import org.junit.jupiter.api.Test;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.assertj.core.api.Assertions.assertThat;

class LeagueTest {

    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
    void serializeToJson() throws Exception {
        final League league = new League("Argentina Primera División");

        final String expected = MAPPER.writeValueAsString(MAPPER.readValue(fixture("fixtures/League.json"), League.class));

        assertThat(MAPPER.writeValueAsString(league)).isEqualTo(expected);
    }

    @Test
    void deserializesFromJSON() throws Exception {
        final League league = new League("Argentina Primera División");

        assertThat(MAPPER.readValue(fixture("fixtures/League.json"), League.class))
                .isEqualTo(league);
    }
}
