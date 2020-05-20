package com.footm.informationservice.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import org.junit.jupiter.api.Test;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.assertj.core.api.Assertions.assertThat;

class PlayerPositionsTest {
    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
    void serializeToJson() throws Exception {
        final PlayerPositions playerPositions = new PlayerPositions(41, "Iniesta", 74, 74, 74,
                82, 81, 81, 81, 82, 85, 85, 85, 82, 83, 83, 83,
                82, 71, 73, 73, 73, 71, 68, 63, 63, 63, 68);

        final String expected = MAPPER.writeValueAsString(MAPPER.readValue(fixture("fixtures/PlayerPositions.json"), PlayerPositions.class));

        assertThat(MAPPER.writeValueAsString(playerPositions)).isEqualTo(expected);
    }

    @Test
    void deserializesFromJSON() throws Exception {
        final PlayerPositions playerPositions = new PlayerPositions(41, "Iniesta", 74, 74, 74,
                82, 81, 81, 81, 82, 85, 85, 85, 82, 83, 83, 83,
                82, 71, 73, 73, 73, 71, 68, 63, 63, 63, 68);

        assertThat(MAPPER.readValue(fixture("fixtures/PlayerPositions.json"), PlayerPositions.class))
                .isEqualTo(playerPositions);
    }
}
