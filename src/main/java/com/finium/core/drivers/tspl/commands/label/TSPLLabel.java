/*
 * Copyright © 2017, Finium Solutions, All Rights Reserved
 * 
 * TSPLLabel.java
 * Modification History
 * *************************************************************
 * Date				Author		Comment
 * Feb 11, 2017		Venkaiah Chowdary Koneru		Created
 * *************************************************************
 */
package com.finium.core.drivers.tspl.commands.label;

import java.util.Map;

import static java.nio.charset.StandardCharsets.US_ASCII;

/**
 * @author Venkaiah Chowdary Koneru
 */
public final class TSPLLabel {


    /**
     *
     */
    private TSPLLabel() {
    }

    /**
     * @param labelTemplate
     * @param parameters
     * @return
     */
    public static byte[] parseAndGetLabelContent(String labelTemplate, Map<String, String> parameters) {

        String localTemplate = labelTemplate;
        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            localTemplate = localTemplate.replaceAll("<<<" + entry.getKey() + ">>>", entry.getValue());
        }

        return localTemplate.getBytes(US_ASCII);
    }
}
