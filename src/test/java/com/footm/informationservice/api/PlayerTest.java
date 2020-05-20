package com.footm.informationservice.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import org.junit.jupiter.api.Test;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {

    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
    void serializeToJson() throws Exception {
        final Player player = new Player(41, "Iniesta", 34, "https://cdn.sofifa.org/players/4/19/41.png", "Spain", 86, "Vissel Kobe", 21500000, 21000, 26900000, "Right", 4, "High", "LF", 8, "5'7", 150);

        final String expected = MAPPER.writeValueAsString(MAPPER.readValue(fixture("fixtures/Player.json"), Player.class));

        assertThat(MAPPER.writeValueAsString(player)).isEqualTo(expected);
    }

    @Test
    void deserializesFromJSON() throws Exception {
        final Player player = new Player(41, "Iniesta", 34, "https://cdn.sofifa.org/players/4/19/41.png", "Spain", 86, "Vissel Kobe", 21500000, 21000, 26900000, "Right", 4, "High", "LF", 8, "5'7", 150);
        assertThat(MAPPER.readValue(fixture("fixtures/Player.json"), Player.class))
                .isEqualTo(player);
    }
}
