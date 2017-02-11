/*
 * Copyright © 2017, Finium Solutions, All Rights Reserved
 * 
 * Gap.java
 * Modification History
 * *************************************************************
 * Date				Author		Comment
 * Feb 11, 2017		Venkaiah Chowdary Koneru		Created
 * *************************************************************
 */
package com.finium.core.drivers.tspl.commands.system;

import com.finium.core.drivers.tspl.commands.TSPLCommand;
import com.finium.core.drivers.tspl.exceptions.LabelParserException;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.UnsupportedEncodingException;

import static java.nio.charset.StandardCharsets.US_ASCII;

/**
 * Defines the gap distance between two labels.<br>
 * <p>
 * <b>Syntax</b><br>
 * English system (inch): GAP m,n <br>
 * Metric system (mm): GAP m mm,n mm <br>
 * Dot measurement: GAP m dot,n dot <br>
 *
 * @author Venkaiah Chowdary Koneru
 */
@NoArgsConstructor
@Data
public class Gap implements TSPLCommand<byte[]> {

    /**
     * The gap distance between two labels
     */
    private Integer labelDistance;

    /**
     * The offset distance of the gap
     */
    private Integer labelOffsetDistance;

    /**
     * @param labelDistance
     * @param labelOffsetDistance
     */
    public Gap(Integer labelDistance, Integer labelOffsetDistance) {
        if (labelDistance == null || labelOffsetDistance == null) {
            throw new LabelParserException("ParseException GAP Command: label distance and label offset should be specified");
        }

        this.labelDistance = labelDistance;
        this.labelOffsetDistance = labelOffsetDistance;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte[] getCommand() throws UnsupportedEncodingException {
        if (labelDistance == null && labelOffsetDistance != null) {
            throw new LabelParserException("ParseException GAP Command: label distance and label offset should be specified");
        }

        return (SystemCommand.GAP.name() + " "
                + labelDistance + " mm," + labelOffsetDistance
                + " mm").getBytes(US_ASCII);
    }
}