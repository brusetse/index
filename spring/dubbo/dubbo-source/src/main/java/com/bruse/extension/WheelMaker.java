package com.bruse.extension;

import org.apache.dubbo.common.URL;

public interface WheelMaker {
    Wheel makeWheel(URL url);
}
