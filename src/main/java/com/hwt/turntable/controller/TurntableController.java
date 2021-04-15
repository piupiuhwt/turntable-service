package com.hwt.turntable.controller;

import com.hwt.turntable.service.TurntableService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class TurntableController {
    @Resource
    TurntableService turntableService;

    @ResponseBody
    @RequestMapping("/result")
    @CrossOrigin("*")
    public int getResult(){
        return turntableService.getResult();
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
