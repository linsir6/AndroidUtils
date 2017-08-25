package com.linsir.lutils.utils;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

/**
 * Created by linSir
 * date at 2017/8/21.
 * describe: 用来打印Log的工具类
 */

public class LogUtils {

    private static boolean DEBUG_ENABLE = false;

    private static String TAG = "lin";

    public static void logInit(boolean debug, String tag) {
        DEBUG_ENABLE = debug;
        TAG = tag;
        if (DEBUG_ENABLE) {
            Logger.init(TAG)
                    .methodCount(2)
                    .logLevel(LogLevel.FULL)
                    .methodOffset(0);
        } else {
            Logger.init()
                    .methodCount(3)
                    .hideThreadInfo()
                    .logLevel(LogLevel.NONE)
                    .methodOffset(2);
        }
    }

    public static void logd(String message) {
        if (DEBUG_ENABLE) {
            Logger.d(message);
        }
    }

    public static void logd(String tag, String message) {
        if (DEBUG_ENABLE) {
            Logger.d(tag, message);
        }
    }

    public static void loge(Throwable throwable, String message, Object... args) {
        if (DEBUG_ENABLE) {
            Logger.e(throwable, message, args);
        }
    }

    public static void loge(String message, Object... args) {
        if (DEBUG_ENABLE) {
            Logger.e(message, args);
        }
    }

    public static void logi(String message, Object... args) {
        if (DEBUG_ENABLE) {
            Logger.i(message, args);
        }
    }

    public static void logv(String message, Object... args) {
        if (DEBUG_ENABLE) {
            Logger.v(message, args);
        }
    }

    public static void logw(String message, Object... args) {
        if (DEBUG_ENABLE) {
            Logger.v(message, args);
        }
    }

    public static void logwtf(String message, Object... args) {
        if (DEBUG_ENABLE) {
            Logger.wtf(message, args);
        }
    }

    public static void logjson(String message) {
        if (DEBUG_ENABLE) {
            Logger.json(message);
        }
    }

    public static void logxml(String message) {
        if (DEBUG_ENABLE) {
            Logger.xml(message);
        }
    }

}




































