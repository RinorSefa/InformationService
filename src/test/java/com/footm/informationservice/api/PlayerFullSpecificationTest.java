package com.footm.informationservice.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import org.junit.jupiter.api.Test;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.assertj.core.api.Assertions.assertThat;

class PlayerFullSpecificationTest {
    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
    void serializeToJson() throws Exception {
        final PlayerFullSpecification playerFullSpecification = new PlayerFullSpecification(41, "Iniesta",
                34, "https://cdn.sofifa.org/players/4/19/41.png", "Spain", 86, "Vissel Kobe",
                21500000, 21000, 26900000, "Right", 4, "High",
                "LF", 8, "5'7", 150, 74, 74, 74, 82, 81, 81,
                81, 82, 85, 85, 85, 82, 83, 83, 83, 82, 71, 73,
                73, 73, 71, 68, 63, 63, 63, 68, 77, 70,
                54, 90, 74, 90, 80, 70, 85,
                92, 70, 67, 79, 86, 84, 65,
                47, 55, 58, 71, 58, 66, 81,
                93, 71, 89, 67, 57, 56, 6,
                13, 6, 13, 7);

        final String expected = MAPPER.writeValueAsString(MAPPER.readValue(fixture("fixtures/PlayerFullSpecification.json"), PlayerFullSpecification.class));

        assertThat(MAPPER.writeValueAsString(playerFullSpecification)).isEqualTo(expected);
    }

    @Test
    void deserializesFromJSON() throws Exception {
        final PlayerFullSpecification playerFullSpecification = new PlayerFullSpecification(41, "Iniesta",
                34, "https://cdn.sofifa.org/players/4/19/41.png", "Spain", 86, "Vissel Kobe",
                21500000, 21000, 26900000, "Right", 4, "High",
                "LF", 8, "5'7", 150, 74, 74, 74, 82, 81, 81,
                81, 82, 85, 85, 85, 82, 83, 83, 83, 82, 71, 73,
                73, 73, 71, 68, 63, 63, 63, 68, 77, 70,
                54, 90, 74, 90, 80, 70, 85,
                92, 70, 67, 79, 86, 84, 65,
                47, 55, 58, 71, 58, 66, 81,
                93, 71, 89, 67, 57, 56, 6,
                13, 6, 13, 7);

        assertThat(MAPPER.readValue(fixture("fixtures/PlayerFullSpecification.json"), PlayerFullSpecification.class))
                .isEqualTo(playerFullSpecification);
    }
}
