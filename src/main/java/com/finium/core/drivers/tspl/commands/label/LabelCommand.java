/*
 * Copyright © 2017, Finium Solutions, All Rights Reserved
 * 
 * LabelCommand.java
 * Modification History
 * *************************************************************
 * Date				Author		Comment
 * Feb 11, 2017		Venkaiah Chowdary Koneru		Created
 * *************************************************************
 */
package com.finium.core.drivers.tspl.commands.label;

/**
 * @author Venkaiah Chowdary Koneru
 */
public enum LabelCommand {

    /**
     * barcode
     */
    BAR,

    /**
     * 1D barcodes.
     */
    BARCODE,

    /**
     * to draw rectangles on the label.
     */
    BOX,

    /**
     * to draw circle on the label.
     */
    CIRCLE,

    /**
     * to draw an ellipse on the label.
     */
    ELLIPSE,

    /**
     * DataMatrix 2D bar code
     */
    DMATRIX
}
