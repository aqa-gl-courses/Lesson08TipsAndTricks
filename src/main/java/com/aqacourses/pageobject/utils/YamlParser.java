package com.aqacourses.pageobject.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.File;
import java.io.IOException;

public class YamlParser {

    /**
     * Parse yaml configuration file
     *
     * @return YamlFile that represents content from yaml file
     */
    public static YamlFile getYamlData() throws IOException {
        YamlFile yamlFile = null;
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        yamlFile =
                objectMapper.readValue(
                        new File("src/main/resources/configuration.yaml"), YamlFile.class);
        return yamlFile;
    }
}
