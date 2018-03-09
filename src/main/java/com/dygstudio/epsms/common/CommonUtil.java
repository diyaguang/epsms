package com.dygstudio.epsms.common;

import java.util.UUID;

/**
 * @author: diyaguang
 * @date: 2018/03/09 上午10:32
 * @description: com.dygstudio.epsms.common
 */
public class CommonUtil {
    public static String getNewGuid(Boolean removeSymbols){
        String guidStr = UUID.randomUUID().toString();
        if(removeSymbols)
            return guidStr.replaceAll("-","");
        return guidStr;
    }
}
