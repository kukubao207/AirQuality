package nju.edu.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import nju.edu.web.vo.ResultData;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class LocationUtil {
    private final static String TENCENT_DISTRICT_URL = "http://apis.map.qq.com/ws/district/v1/list";

    private final static String TENCENT_GEO_URL = "http://apis.map.qq.com/ws/geocoder/v1/";

    private final static String TENCENT_IP_URL = "https://apis.map.qq.com/ws/location/v1/ip";

    private final static String TENCENT_MAP_KEY = "3MJBZ-663WV-YVQPB-U42RP-6QBUK-NPFQE";

    public static ResultData ip2address(String ip) {
        ResultData result = new ResultData();
        if (StringUtils.isEmpty(ip)) {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription("Please make sure the ip is correct");
            return result;
        }
        String url = new StringBuffer(TENCENT_IP_URL).append("?ip=").append(ip).append("&key=").append(TENCENT_MAP_KEY).toString();
        JSONObject response = JSON.parseObject(HttpClientUtil.getResponse(url));
        return process(response);
    }

    //根据地址解析经纬度
    @RequestMapping(method = RequestMethod.POST, value = "/address/resolve")
    public static ResultData geocoder(String address) {
        ResultData result = new ResultData();
        if (StringUtils.isEmpty(address)) {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription("The address cannot be empty");
            return result;
        }
        String url = new StringBuffer(TENCENT_GEO_URL).append("?key=").append(TENCENT_MAP_KEY).append("&address=").append(address.trim()).toString();
        JSONObject response = JSON.parseObject(HttpClientUtil.getResponse(url));
        return process(response);
    }

    private static ResultData process(JSONObject response) {
        ResultData result = new ResultData();
        if (!StringUtils.isEmpty(response) && response.getInteger("status") == 0) {
            result.setResponseCode(ResponseCode.RESPONSE_OK);
            result.setData(response.getJSONObject("result"));
        } else {
            result.setResponseCode(ResponseCode.RESPONSE_NULL);
            result.setDescription("Cannot process the result at the moment");
        }
        return result;
    }
}
