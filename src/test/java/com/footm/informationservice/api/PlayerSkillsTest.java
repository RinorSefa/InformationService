package com.footm.informationservice.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import org.junit.jupiter.api.Test;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.assertj.core.api.Assertions.assertThat;

public class PlayerSkillsTest {

    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
    public void serializeToJson() throws Exception {
        final PlayerSkills playerSkills = new PlayerSkills(41, "Iniesta", 77, 70,
                54, 90, 74, 90, 80, 70, 85,
                92, 70, 67, 79, 86, 84, 65,
                47, 55, 58, 71, 58, 66, 81,
                93, 71, 89, 67, 57, 56, 6,
                13, 6, 13, 7);

        final String expected = MAPPER.writeValueAsString(MAPPER.readValue(fixture("fixtures/playerSkills.json"), PlayerSkills.class));

        assertThat(MAPPER.writeValueAsString(playerSkills)).isEqualTo(expected);
    }

    @Test
    public void deserializesFromJSON() throws Exception {
        final PlayerSkills playerSkills = new PlayerSkills(41, "Iniesta", 77, 70,
                54, 90, 74, 90, 80, 70, 85,
                92, 70, 67, 79, 86, 84, 65,
                47, 55, 58, 71, 58, 66, 81,
                93, 71, 89, 67, 57, 56, 6,
                13, 6, 13, 7);

        assertThat(MAPPER.readValue(fixture("fixtures/playerSkills.json"), PlayerSkills.class))
                .isEqualTo(playerSkills);
    }
}