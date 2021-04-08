package com.cssl.controller;

import com.cssl.pojo.Flower;
import com.cssl.service.FlowerService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class FlowerController {
    @Autowired
    private FlowerService fs;

    @RequestMapping("/index.action")
    @ResponseBody
    public List<Flower> index(int pageIndex){
        int pageSize=3;
        Page<Flower> flowers = fs.showAll(pageIndex,pageSize);
        return flowers;
    }

    @RequestMapping("/show.action")
    public String show(Model model,Integer pageIndex){
        if(pageIndex==null || pageIndex<=0){
            pageIndex=1;
        }
        int pageSize=3;
        Page<Flower> flowers = fs.showAll(pageIndex,pageSize);
        System.out.println(flowers);
        int pages = flowers.getPages();
        if(pageIndex>pages){
            pageIndex=pages;
            flowers=fs.showAll(pageIndex,pageSize);
        }
        model.addAttribute("flowers",flowers);
        model.addAttribute("pageIndex",pageIndex);
        model.addAttribute("pages",pages);
        return "show";
    }

    @RequestMapping("/add.action")
    public String add(HttpServletResponse response,Flower flower) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        System.out.println(flower);
        int i = fs.addFlower(flower);
        if(i>0){
            out.print("<script>alert('添加成功');</script>");
            return "redirect:/show.action";
        }else {
            out.print("<script>alert('添加失败');</script>");
            return "add.html";
        }
    }



}
