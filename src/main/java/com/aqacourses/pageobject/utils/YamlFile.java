package com.aqacourses.pageobject.utils;

import java.util.Map;

public class YamlFile {

    private String url;
    private String email;
    private String password;
    private Map<String, String> test;
    private String[] anotherTestKeys;

    /**
     * Get URL from yaml file
     *
     * @return String represents URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * Get email from yaml file
     *
     * @return String represents email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Get password from yaml file
     *
     * @return String represents password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Get test from yaml file
     *
     * @return Map represents test
     */
    public Map<String, String> getTest() {
        return test;
    }

    /**
     * Get anotherTestKeys from yaml file
     *
     * @return array that contains string values
     */
    public String[] getAnotherTestKeys() {
        return anotherTestKeys;
    }
}
