package com.wondersgroup.framework.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class PageUtil {

    public static Map putPageParam(HttpServletRequest request) throws Exception {
        Map parms = new HashMap();

        parms.put("pageIndex", request.getParameter("pageIndex"));
        parms.put("pageSize", request.getParameter("pageSize"));

        parms.put("sortField", request.getParameter("sortField"));
        parms.put("sortOrder", request.getParameter("sortOrder"));

        int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));

        int start = pageIndex * pageSize, end = start + pageSize;

        parms.put("start", start + 1);
        parms.put("end", end);

        return parms;
    }
    
    
    public static Map<String, Object> putPageParam(Map<String, Object> params) throws Exception {
        

        int pageIndex = Integer.parseInt(params.get( "pageIndex").toString());
        int pageSize = Integer.parseInt(params.get( "pageSize").toString());

        int start = pageIndex * pageSize, end = start + pageSize;

        params.put("start", start + 1);
        params.put("end", end);

        return params;
    }
    
    

}
