package com.bruse.websocket.controller;

import com.bruse.websocket.server.WebSocketServer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
@RequestMapping("/center")
public class CenterController {

    /**
     * 页面请求
     */
    @GetMapping("/socket/{cid}")
    public ModelAndView socket(ModelMap map, @PathVariable String cid) {
        map.put("cid", cid);
        return new ModelAndView("/socket", map);
    }

    /**
     * 服务端推送
     */
    @RequestMapping("/send/{cid}")
    @ResponseBody
    public Object send(@PathVariable String cid, String message) {
        try {
            WebSocketServer.sendInfo(message, cid);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }
}
