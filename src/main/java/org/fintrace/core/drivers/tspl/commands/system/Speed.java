/*
 * Copyright 2017 fintrace (https://fintrace.org/)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.fintrace.core.drivers.tspl.commands.system;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.fintrace.core.drivers.tspl.commands.TSPLCommand;
import org.fintrace.core.drivers.tspl.exceptions.LabelParserException;

import static java.nio.charset.StandardCharsets.US_ASCII;

/**
 * This command defines the print speed.<br>
 * <p>
 * <b>Syntax</b><br>
 * SPEED n<br>
 * <blockquote><i>n Printing speed in inch per second</i></blockquote>
 *
 * @author Venkaiah Chowdary Koneru
 */
@NoArgsConstructor
@Data
public class Speed implements TSPLCommand<byte[]> {

    /**
     * Printing speed in inch per second
     */
    private Double printSpeed;

    /**
     * @param printSpeed Printing speed in inch per second
     */
    public Speed(Double printSpeed) {
        if (printSpeed == null) {
            throw new LabelParserException("ParseException SPEED Command: speed can't be empty");
        }
        this.printSpeed = printSpeed;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte[] getCommand() {
        if (printSpeed == null) {
            throw new LabelParserException("ParseException SPEED Command: speed can't be empty");
        }

        return (SystemCommand.SPEED.name() + " " + printSpeed + "\n").getBytes(US_ASCII);
    }
}
