package com.hwt.turntable.controller;

import com.hwt.turntable.entity.ConnectionInfo;
import com.hwt.turntable.service.CommonService;
import com.hwt.turntable.service.TurntableService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class TurntableController {
    @Resource
    TurntableService turntableService;

    @Resource
    CommonService commonService;

    @ResponseBody
    @RequestMapping("/result")
    @CrossOrigin("*")
    public int getResult(HttpServletRequest request){
        ConnectionInfo connectionInfo = commonService.getConnectionInfo(request);
        return turntableService.getResult(connectionInfo);

    }

    @ResponseBody
    @RequestMapping("/prizes")
    @CrossOrigin("*")
    public String[] getPrizes(){
        return turntableService.getPrizes();
    }

    @RequestMapping("/test")
    public void getString(HttpServletResponse response) {
        response.setStatus(200);
        response.setHeader("Content-type","text/html");
        try {
            PrintWriter writer = response.getWriter();
//            writer.write("{\"a\":1,\"b\":2}");
            writer.write("<html><header></header>" +
                    "<body>fasdfasdfds</body></html>");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
