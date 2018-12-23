package nju.edu.util;

import nju.edu.web.vo.ResultData;

public class ServiceHelpUtil {
    public static ResultData helpReturn(Object o) {
        ResultData resultData = new ResultData();
        if (o == null) {
            resultData.setResponseCode(ResponseCode.RESPONSE_NULL);
            return resultData;
        } else {
            resultData.setData(o);
            return resultData;
        }
    }
}
